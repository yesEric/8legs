package cn.elegs.application.impl;

import cn.elegs.application.UserService;
import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户管理服务实现.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User createNewUser(String username, String password) {
        User user = new User(username, password);
        return userRepository.save(user);
    }

    @Override
    public void removeUser(String userId) {
        userRepository.remove(userId);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
