package cn.interstore.domain.model.user;

import cn.interstore.domain.shared.ValueObject;

/**
 * 用户状态.
 */
public enum UserStatus implements ValueObject<UserStatus>{
    ACTIVATED,INACTIVATED;


    public boolean sameIdentityAs(UserStatus other) {
        return this.equals(other);
    }
}
