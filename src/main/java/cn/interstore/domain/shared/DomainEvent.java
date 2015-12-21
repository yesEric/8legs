package cn.interstore.domain.shared;

/**
 * 领域事件是那些唯一的业务逻辑，但是没有生命周期的东西.
 * 比如产生一个支付业务的序列号，或者什么时候、在哪里、做什么事情等（被触发的事件）
 */
public interface DomainEvent<T> {

    /**
     * 判断当前对象是否与另一个对象相同
     * @param other 另一个领域事件.
     * @return 相同返回 true，否认返回false..
     */
    boolean sameEventAs(T other);
}
