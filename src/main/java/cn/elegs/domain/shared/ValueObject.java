package cn.elegs.domain.shared;

import java.io.Serializable;

/**
 * DDD的值对象接口.
 */
public interface ValueObject<T> extends Serializable {

    /**
     * 值对象的比较方法
     * @param other 要比较的另一个值对象
     * @return true代表相同，false代表不同
     */
    boolean sameIdentityAs(T other);
}
