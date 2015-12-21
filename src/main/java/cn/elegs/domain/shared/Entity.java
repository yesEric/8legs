package cn.elegs.domain.shared;

/**
 * DDD实体接口.
 */
public abstract class Entity<T> {

    /**
     * 实体的比较方法
     * @param other 要比较的另一个实体
     * @return true代表相同，false代表不同
     */
    public  abstract boolean sameIdentityAs(T other);


    /**
     *返回对象的键值对字符串.
     *
     * @return 对象的键值字符串.
     */
    public abstract String toString();

    /**
     * 比较对象是否相同，如果使用hibernate，id主键不能作为比较字符串
     *
     * @param o 要比较的对象
     * @return true/false
     */
    public abstract boolean equals(Object o);

    /**
     * 使用Hibernate时，hashCode非常重要，参考
     * http://www.hibernate.org/109.html .
     *
     * @return hashCode
     */
    public  abstract int hashCode();
}
