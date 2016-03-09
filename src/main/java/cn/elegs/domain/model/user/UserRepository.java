package cn.elegs.domain.model.user;

import cn.elegs.domain.shared.GenericRepository;

import java.util.List;

/**
 * User模型的Repository.
 */
public interface UserRepository extends GenericRepository<User, String> {

    /**
     * 通过用户名找到用户
     *
     * @param username 用户名
     * @return 用户对象
     */
    public User getUserByName(String username);

    /**
     * 查询用户信息
     *
     * @param username 用户名称
     * @return
     */
    public List<User> search(String username);



}
