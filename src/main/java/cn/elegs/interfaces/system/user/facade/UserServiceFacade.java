package cn.elegs.interfaces.system.user.facade;

import cn.elegs.domain.shared.DomainException;
import cn.elegs.interfaces.system.user.facade.dto.UserDTO;

import java.util.List;

/**
 * 用户管理应用服务Facade.
 */
public interface UserServiceFacade {

    UserDTO createNewUser(String username, String password) throws DomainException;

    List<UserDTO> findAll();

    UserDTO getUserByName(String username);

    UserDTO getUserById(String userId) throws DomainException;

    void removeUser(String userId) throws DomainException;

    UserDTO assignRoleToUser(UserDTO user, String roleId[]) throws DomainException;
}
