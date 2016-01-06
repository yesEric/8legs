package cn.elegs.interfaces;

import cn.elegs.interfaces.user.facade.UserServiceFacade;
import cn.elegs.interfaces.user.facade.dto.UserDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;

/**
 * 用户管理Facade测试.
 */
public class UserServiceFacadeTest extends BaseInterfacesTestCase {

    @Autowired
    UserServiceFacade userServiceFacade;

    @Test
    public void testCreateNewUser() throws Exception {
        UserDTO userDTO = userServiceFacade.createNewUser("Bobo", "111");
        assertNotNull(userDTO.getId());
    }
}
