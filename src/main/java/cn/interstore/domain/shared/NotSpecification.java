package cn.interstore.domain.shared;

/**
 * “非”操作规范,用于创建一个将两个规范对象进行“非”操作后的新的规范对象.
 */
public class NotSpecification<T> extends AbstractSpecification<T> {
    private Specification<T> spec1;


    /**
     * 利用两个规范对象，创建一个新的“非”操作对象.
     *
     * @param spec1 规范对象1.
     *
     */
    public NotSpecification(final Specification<T> spec1) {
        this.spec1 = spec1;
    }


    /**
     * {@inheritDoc}
     */
    public boolean isSatisfiedBy(final T t) {
        return !spec1.isSatisfiedBy(t);
    }
}
