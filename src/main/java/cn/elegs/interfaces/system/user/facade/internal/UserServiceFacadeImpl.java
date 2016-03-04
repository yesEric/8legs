package cn.elegs.interfaces.system.user.facade.internal;

import cn.elegs.application.UserService;
import cn.elegs.domain.model.role.Role;
import cn.elegs.domain.model.role.RoleRepository;
import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserRepository;
import cn.elegs.domain.shared.DomainException;
import cn.elegs.interfaces.system.user.facade.UserServiceFacade;
import cn.elegs.interfaces.system.user.facade.dto.RoleDTO;
import cn.elegs.interfaces.system.user.facade.dto.UserDTO;
import cn.elegs.interfaces.system.user.facade.internal.assembler.RoleDTOAssembler;
import cn.elegs.interfaces.system.user.facade.internal.assembler.UserDTOAssembler;
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

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDTO createNewUser(String username, String password) throws DomainException {
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
    public UserDTO getUserById(String userId) throws DomainException {
        final User user = userRepository.get(userId);
        final UserDTOAssembler assembler = new UserDTOAssembler();
        return assembler.toDTO(user);
    }

    @Override
    public void removeUser(String userId) throws DomainException {

        userService.removeUser(userId);
    }

    @Override
    public UserDTO assignRoleToUser(UserDTO userDTO, String[] roleIds) throws DomainException {
        User user = userRepository.get(userDTO.getId());
        user = userService.assignRoleToUser(user, roleIds);
        final UserDTOAssembler assembler = new UserDTOAssembler();
        return assembler.toDTO(user);
    }

    @Override
    public List<RoleDTO> findAllRoles() {
        List<Role> roleList = roleRepository.getAll();
        List<RoleDTO> roleDTOList = new ArrayList<>();
        final RoleDTOAssembler assembler = new RoleDTOAssembler();
        for (Role role : roleList) {
            roleDTOList.add(assembler.toDTO(role));
        }
        return roleDTOList;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) throws DomainException {
        User user = userRepository.get(userDTO.getId());
        user.setFullName(userDTO.getFullName());
        user.setPassword(userDTO.getPassword());
        user = userRepository.save(user);
        UserDTOAssembler assembler = new UserDTOAssembler();
        return assembler.toDTO(user);
    }
}
