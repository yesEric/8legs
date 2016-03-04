package cn.elegs.interfaces.system.user.facade.dto;

import cn.elegs.interfaces.shared.BaseDTO;

/**
 * 用户角色DTO.
 */
public class RoleDTO extends BaseDTO {

    /**
     * 角色名称
     */
    String name;
    /**
     * 角色描述
     */
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleDTO roleDTO = (RoleDTO) o;

        return name.equals(roleDTO.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
