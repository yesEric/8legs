package cn.elegs.application;

import cn.elegs.domain.model.user.User;
import cn.elegs.domain.shared.DomainException;

/**
 * 用户管理服务.
 */
public interface UserService {

    /**
     * 创建新的用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 创建后的用户对象
     */
    public User createNewUser(String username, String password, String fullName) throws DomainException;

    /**
     * 删除用户
     *
     * @param userId 用户ID
     */
    public void removeUser(String userId) throws DomainException;

    /**
     * 修改并保存用户对象
     *
     * @param user 用户对象
     * @return 保存后的用户对象
     */
    public User saveUser(User user) throws DomainException;

    /**
     * 将角色分配给用户
     *
     * @param user   用户对象
     * @param roleId 角色ID
     * @return
     */
    public User assignRoleToUser(User user, String roleId[]) throws DomainException;


}
