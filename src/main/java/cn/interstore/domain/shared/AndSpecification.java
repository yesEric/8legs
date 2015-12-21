package cn.interstore.domain.shared;

/**
 * “与”操作规范,用于创建一个将两个规范对象进行与操作后的新的规范对象.
 */
public class AndSpecification<T> extends AbstractSpecification<T>{
    private Specification<T> spec1;
    private Specification<T> spec2;

    /**
     * 利用两个规范对象，创建一个新的“与”操作对象.
     *
     * @param spec1 规范对象1.
     * @param spec2 规范对象2.
     */
    public AndSpecification(final Specification<T> spec1, final Specification<T> spec2) {
        this.spec1 = spec1;
        this.spec2 = spec2;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isSatisfiedBy(final T t) {
        return spec1.isSatisfiedBy(t) && spec2.isSatisfiedBy(t);
    }
}
