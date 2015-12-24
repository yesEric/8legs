package cn.elegs.interfaces.user.facade;

import cn.elegs.interfaces.user.facade.dto.UserDTO;

import java.util.List;

/**
 * 用户管理应用服务Facade.
 */
public interface UserServiceFacade {

    UserDTO createNewUser(String username, String password);

    List<UserDTO> findAll();

    UserDTO getUserByName(String username);

    UserDTO getUserById(String userId);

    void removeUser(String userId);
}
