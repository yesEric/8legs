package cn.elegs.application.impl;

import cn.elegs.application.UserService;
import cn.elegs.application.util.MessageUtil;
import cn.elegs.domain.model.operationLog.OperationLogRepository;
import cn.elegs.domain.model.role.Role;
import cn.elegs.domain.model.role.RoleRepository;
import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserRepository;
import cn.elegs.domain.shared.DomainException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理服务实现.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OperationLogRepository operationLogRepository;

    @Autowired
    RoleRepository roleRepository;



    @Override
    public User createNewUser(String username, String password, String fullName) throws DomainException {

        User user = new User(username, new SimpleHash("md5", password).toHex(), fullName);
        return userRepository.save(user);
    }

    @Override
    public void removeUser(String userId) throws DomainException {
        User user = null;
        try {
            user = userRepository.get(userId);
        } catch (DomainException e) {
            throw new DomainException("User is not exist!");
        }
        if (user != null) {
            //用户存在操作日志，则不能删除
            if (operationLogRepository.userHasLog(user.getUsername())) {
                throw new DomainException("User cannot be removed, since there is some operations relate to!");
            }

        }
        String currentLoginUsername = SecurityUtils.getSubject().getPrincipal().toString();
        if (currentLoginUsername.equals(user.getUsername())) {
            MessageUtil mu = new MessageUtil();

            throw new DomainException(mu.getText("error.delete.currentUser"));
        }
        userRepository.remove(userId);
    }

    @Override
    public User saveUser(User user) throws DomainException {
        return userRepository.save(user);
    }

    @Override
    public User assignRoleToUser(User user, String[] roleIds) throws DomainException {
        List<Role> roleList = roleRepository.findRolesByRoleIds(roleIds);
        user.assignRoles(roleList);
        return userRepository.save(user);
    }
}
