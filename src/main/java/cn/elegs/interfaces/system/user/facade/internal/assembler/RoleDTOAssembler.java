package cn.elegs.interfaces.system.user.facade.internal.assembler;

import cn.elegs.domain.model.role.Role;
import cn.elegs.interfaces.system.user.facade.dto.RoleDTO;

/**
 * UserDTO的Assembler.
 */
public class RoleDTOAssembler {


    public RoleDTO toDTO(final Role role) {
        final RoleDTO dto = new RoleDTO();
        dto.setId(role.getId());
        dto.setName(role.getName());
        dto.setDescription(role.getDescription());


        return dto;
    }
}
