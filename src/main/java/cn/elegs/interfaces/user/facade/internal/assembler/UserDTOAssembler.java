package cn.elegs.interfaces.user.facade.internal.assembler;

import cn.elegs.domain.model.user.User;
import cn.elegs.interfaces.user.facade.dto.UserDTO;

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

        return dto;
    }
}
