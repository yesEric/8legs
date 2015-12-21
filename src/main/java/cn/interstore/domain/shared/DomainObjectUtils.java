package cn.interstore.domain.shared;

/**
 * 领域对象的助手方法.
 */
public class DomainObjectUtils {

    /**
     * 判断值是否为空
     * @param actual 实际值
     * @param safe a null-safe value
     * @param <T> type
     * @return actual value, if it's not null, or safe value if the actual value is null.
     */
    public static <T> T nullSafe(T actual, T safe) {
        return actual == null ? safe : actual;
    }

    /**
     * 避免被实例化.
     */
    private DomainObjectUtils() {
    }
}
