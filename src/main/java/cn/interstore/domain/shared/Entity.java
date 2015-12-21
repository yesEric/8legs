package cn.interstore.domain.shared;

/**
 * DDD实体接口.
 */
public interface Entity<T> {

    /**
     * 实体的比较方法
     * @param other 要比较的另一个实体
     * @return true代表相同，false代表不同
     */
    boolean sameIdentityAs(T other);
}
