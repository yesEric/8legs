package cn.elegs.application;

import cn.elegs.domain.model.user.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * 用户管理应用服务测试.
 */
public class UserServiceTest extends BaseApplicationTestCase {

    @Autowired
    UserService userService;

    @Test
    public void testCreateUser() throws Exception {

        User user = userService.createNewUser("Bobo", "11111");
        assertNotNull(user.getId());

    }
}
