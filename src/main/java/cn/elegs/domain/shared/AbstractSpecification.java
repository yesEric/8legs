package cn.elegs.domain.shared;

/**
 * 规范{@Link Specification} 接口的基类抽象实现。其提供了 {@code and}， .
 * {@code and}，{@code and} 的默认实现.
 */
public abstract class AbstractSpecification <T> implements Specification<T>{

    /**
     * {@inheritDoc}
     */
    public abstract boolean isSatisfiedBy(T t);

    /**
     * {@inheritDoc}
     */

    public Specification<T> and(final Specification<T> specification) {
        return new AndSpecification<T>(this, specification);
    }

    /**
     * {@inheritDoc}
     */
    public Specification<T> or(final Specification<T> specification) {
        return new OrSpecification<T>(this, specification);
    }

    /**
     * {@inheritDoc}
     */
    public Specification<T> not(final Specification<T> specification) {
        return new NotSpecification<T>(specification);
    }
}
