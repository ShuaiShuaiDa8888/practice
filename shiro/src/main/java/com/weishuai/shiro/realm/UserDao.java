package com.weishuai.shiro.realm;

import com.weishuai.shiro.realm.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by WS on 2018/5/11.
 */
public class UserDao {
    public User getByUserName(Connection conn, String userName) throws SQLException {
        User resultUser = null;
        String sql = "select * from t_user where userName=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            resultUser = new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;

    }

    public Set<String> getRoles(Connection conn, String userName) throws Exception {
        Set<String> roles = new HashSet<>();
        String sql = "select * from t_user u, t_role r where u.roleId = r.id and u.userName = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            roles.add(rs.getString("roleName"));
        }
        return roles;
    }

    public Set<String> getPermissions(Connection conn, String userName) throws Exception {
        Set<String> permissions = new HashSet<>();
        String sql = "select * from t_user u, t_role r, t_permission p where u.roleId = r.id and p.roleId = r.id and userName =  ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            permissions.add(rs.getString("pName"));
        }
        return permissions;
    }
}
