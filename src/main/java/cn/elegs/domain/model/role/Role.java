package cn.elegs.domain.model.role;

import cn.elegs.domain.shared.Entity;
import org.hibernate.validator.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户角色.
 */
public class Role extends Entity<Role> {

    /**
     * 角色名称
     */
    @NotBlank
    String name;
    /**
     * 角色描述
     */
    String description;

    RoleStatus roleStatus;


    Set<Resource> resourceSet = new HashSet<>();

    public Set<Resource> getResourceSet() {
        return resourceSet;
    }

    public void setResourceSet(Set<Resource> resourceSet) {
        this.resourceSet = resourceSet;
    }

    public RoleStatus getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(RoleStatus roleStatus) {
        this.roleStatus = roleStatus;
    }



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
    public boolean sameIdentityAs(Role other) {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
