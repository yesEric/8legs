package cn.elegs.domain.model.user;

import cn.elegs.domain.shared.ValueObject;


/**
 * 锁定状态.
 */
public enum  LockStatus implements ValueObject<LockStatus>{
    LOCKED,UNLOCKED;
    public boolean sameIdentityAs(LockStatus other) {
        return this.equals(other);
    }
}
