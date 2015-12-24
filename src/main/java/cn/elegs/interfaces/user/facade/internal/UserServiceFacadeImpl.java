package cn.elegs.interfaces.user.facade.internal;

import cn.elegs.application.UserService;
import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserRepository;
import cn.elegs.interfaces.user.facade.UserServiceFacade;
import cn.elegs.interfaces.user.facade.dto.UserDTO;
import cn.elegs.interfaces.user.facade.internal.assembler.UserDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户管理Facade的实现.
 */
@Service("userServiceFacade")
public class UserServiceFacadeImpl implements UserServiceFacade {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createNewUser(String username, String password) {
        final User user = userService.createNewUser(username, password);
        final UserDTOAssembler assembler = new UserDTOAssembler();
        return assembler.toDTO(user);
    }

    @Override
    public List<UserDTO> findAll() {

        final List<User> userList = userRepository.getAll();
        final List<UserDTO> userDTOList = new ArrayList<>();
        final UserDTOAssembler assembler = new UserDTOAssembler();
        for (User user : userList) {
            userDTOList.add(assembler.toDTO(user));
        }
        return userDTOList;
    }

    @Override
    public UserDTO getUserByName(String username) {
        final User user = userRepository.getUserByName(username);
        final UserDTOAssembler assembler = new UserDTOAssembler();
        return assembler.toDTO(user);
    }

    @Override
    public UserDTO getUserById(String userId) {
        final User user = userRepository.get(userId);
        final UserDTOAssembler assembler = new UserDTOAssembler();
        return assembler.toDTO(user);
    }

    @Override
    public void removeUser(String userId) {

        userRepository.remove(userId);
    }
}
