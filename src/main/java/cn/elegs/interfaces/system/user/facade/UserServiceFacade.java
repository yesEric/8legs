package cn.elegs.interfaces.system.user.facade;

import cn.elegs.domain.shared.DomainException;
import cn.elegs.interfaces.system.user.facade.dto.RoleDTO;
import cn.elegs.interfaces.system.user.facade.dto.UserDTO;

import java.util.List;

/**
 * 用户管理应用服务Facade.
 */
public interface UserServiceFacade {

    /**
     * 创建新的用户
     *
     * @param username
     * @param password
     * @return
     * @throws DomainException
     */
    UserDTO createNewUser(String username, String password, String fullName) throws DomainException;

    /**
     * 查找所有用户
     * @return
     */
    List<UserDTO> findAll();

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    UserDTO getUserByName(String username);

    /**
     * 通过用户ID查找用户
     * @param userId
     * @return
     * @throws DomainException
     */
    UserDTO getUserById(String userId) throws DomainException;

    /**
     * 删除用户
     * @param userId
     * @throws DomainException
     */
    void removeUser(String userId) throws DomainException;

    /**
     * 为用户授权
     * @param user
     * @param roleId
     * @return
     * @throws DomainException
     */
    UserDTO assignRoleToUser(UserDTO user, String roleId[]) throws DomainException;

    /**
     * 查找所有的角色
     * @return
     */
    List<RoleDTO> findAllRoles();

    /**
     * 更新用户信息
     *
     * @param userDTO
     * @return
     * @throws DomainException
     */
    UserDTO saveUser(UserDTO userDTO) throws DomainException;

    /**
     * 查询用户信息
     *
     * @param userDTO 包含用户参数的DTO
     * @return
     */
    List<UserDTO> searchUser(UserDTO userDTO);
}
