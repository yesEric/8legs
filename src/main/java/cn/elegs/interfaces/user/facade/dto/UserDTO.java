package cn.elegs.interfaces.user.facade.dto;

import cn.elegs.domain.model.role.Role;
import cn.elegs.domain.model.user.LockStatus;
import cn.elegs.domain.model.user.UserStatus;
import cn.elegs.interfaces.shared.BaseDTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户对象DTO.
 */
public final class UserDTO extends BaseDTO {
    String username;

    String fullName;
    String password;

    /**
     * 用户状态:0-正常,1-无效
     */
    UserStatus status;
    /**
     * 用户锁定状态:1-锁定;0-未锁定
     */
    LockStatus locked;

    Date createdAt;

    Set<Role> roleSet = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public LockStatus getLocked() {
        return locked;
    }

    public void setLocked(LockStatus locked) {
        this.locked = locked;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}
