package cn.elegs.domain.shared;

/**
 * 规范模式的接口.通过 {@link cn.elegs.domain.shared.AbstractSpecification} 基类实现.
 * 子类需要实现 {@link #isSatisfiedBy(Object)}
 */
public interface Specification<T> {
    /**
     * 检查 {@code t} 是否适用此规范.
     *
     * @param t 要检查的对象.
     * @return 如果{@code t}符合规范则返回 {@code true}.
     */
    boolean isSatisfiedBy(T t);

    /**
     * 规范 "与" 操作.
     * @param specification 要进行“与”操作的规范对象.
     * @return 执行“与”操作后的规范对象.
     */
    Specification<T> and(Specification<T> specification);

    /**
     * 规范 "或" 操作.
     * @param specification 要进行“或”操作的规范对象.
     * @return 执行“或”操作后的规范对象.
     */
    Specification<T> or(Specification<T> specification);

    /**
     * 规范 "非" 操作.
     * @param specification 要进行“非”操作的规范对象.
     * @return 执行“非”操作后的规范对象.
     */
    Specification<T> not(Specification<T> specification);
}
