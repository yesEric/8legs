package cn.interstore.domain.model.user;

import cn.interstore.domain.shared.ValueObject;


/**
 * 锁定状态.
 */
public enum  LockStatus implements ValueObject<LockStatus>{
    LOCKED,UNLOCKED;
    public boolean sameIdentityAs(LockStatus other) {
        return this.equals(other);
    }
}
