import com.weishuai.shiro.shiro03.Shiro03Util;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * 编程式授权，基于角色
 *
 * Created by WS on 2018/5/2.
 */
public class TestOfShiroRole {
    @Test
    public void hasRole(){
        Subject subject = Shiro03Util.login("classpath:shiro03.ini", "java1234", "123456");
        System.out.println(subject.hasRole("role1") ? "has role1这个权限！" : "hasn't role1这个权限！");

        boolean[] results = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        System.out.println(results[0] ? "has role1 permission!" : "hasn't role1 pernission!");
        System.out.println(results[1] ? "has role2 permission!" : "hasn't role2 pernission!");
        System.out.println(results[2] ? "has role3 permission!" : "hasn't role3 pernission!");

        System.out.println(subject.hasAllRoles(Arrays.asList("role1", "role2")) ? "role1, role2 have all" : "role1, role2 haven't all");
    }

    /**
     * 验证checkRole的值，只验证有没有权限，没有返回值
     */
    @Test
    public void checkRole(){
        Subject subject = Shiro03Util.login("classpath:shiro03.ini", "java1234", "123456");
        subject.checkRole("role1");

        /** 下面两个方法作用相同 */
        subject.checkRoles("role1", "role2");
        subject.checkRoles(Arrays.asList("role1", "role2"));

    }
}
