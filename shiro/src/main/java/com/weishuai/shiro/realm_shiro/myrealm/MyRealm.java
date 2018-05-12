package com.weishuai.shiro.realm_shiro.myrealm;

import com.weishuai.shiro.realm_shiro.dao.UserDao;
import com.weishuai.shiro.realm_shiro.pojo.User;
import com.weishuai.shiro.realm_shiro.utils.DbUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.sql.Connection;

/**
 * Created by WS on 2018/5/11.
 */
public class MyRealm extends AuthorizingRealm {
    private UserDao userDao = new UserDao();
    private DbUtils dbUtils = new DbUtils();

    /**
     * 为当前登录成功的用户授予角色和权限
     * 从数据库读取，根据当前用户名读取用户角色和权限
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
        Connection conn = null;
        try{
            conn = dbUtils.getConn();
            authInfo.setRoles(userDao.getRoles(conn, userName));
            authInfo.setStringPermissions(userDao.getPermissions(conn, userName));
        }catch (Exception e){

        }finally {
            dbUtils.closeCon(conn);
        }
        return authInfo;
    }

    /**
     * 获取认证信息，验证当前登陆的用户
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();//通过token获取用户名,通过用户名去数据库查找关于这个用户名的信息，封装起来和提交的信息去比对。相同登陆成功，不同报错。
        Connection conn = null;
        try {
            conn = dbUtils.getConn();
            User user = userDao.getByUserName(conn, userName);
            if (user != null) {
                AuthenticationInfo authInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "xx");
                return authInfo;
            } else{
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
