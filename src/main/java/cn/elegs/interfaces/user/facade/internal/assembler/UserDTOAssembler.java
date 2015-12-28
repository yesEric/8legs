package cn.elegs.interfaces.user.facade.internal.assembler;

import cn.elegs.domain.model.role.Role;
import cn.elegs.domain.model.user.User;
import cn.elegs.interfaces.user.facade.dto.RoleDTO;
import cn.elegs.interfaces.user.facade.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDTO的Assembler.
 */
public class UserDTOAssembler {


    public UserDTO toDTO(final User user) {
        final UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setFullName(user.getFullName());
        dto.setLocked(user.getLocked());
        dto.setPassword(user.getPassword());
        dto.setRoleSet(user.getRoleSet());
        dto.setStatus(user.getStatus());
        dto.setUsername(user.getUsername());

        List<RoleDTO> roleDTOs = new ArrayList<>();
        for (Role role : user.getRoleSet()) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(role.getId());
            roleDTO.setDescription(role.getDescription());
            roleDTO.setName(role.getName());
            roleDTOs.add(roleDTO);
        }
        dto.setRoleDTOs(roleDTOs);
        return dto;
    }
}
