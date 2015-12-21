package cn.elegs.domain.model.user;

import cn.elegs.domain.shared.ValueObject;

/**
 * 用户状态.
 */
public enum UserStatus implements ValueObject<UserStatus>{
    ACTIVATED,INACTIVATED;


    public boolean sameIdentityAs(UserStatus other) {
        return this.equals(other);
    }
}
