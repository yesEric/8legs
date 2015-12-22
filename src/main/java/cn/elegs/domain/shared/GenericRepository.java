package cn.elegs.domain.shared;

import java.io.Serializable;
import java.util.List;

/**
 * Repository的抽象接口,提供一般的CRUD方法抽象.
 *
 * @param <T>  实体泛型对象
 * @param <PK> 实体泛型主键
 * @author Eric
 */
public interface GenericRepository<T, PK extends Serializable> {
    /**
     * @return 获得所有实体对象集合.
     */
    List<T> getAll();


    /**
     * @return 基于实体对象的equals和hashCode获得所有不重复的记录.
     */
    List<T> getAllDistinct();


    /**
     * @param id 对象主键
     * @return 根据对象主键获得的对象
     */
    T get(PK id);

    /**
     * 判断对象是否存在.
     *
     * @param id 对象id
     * @return true存在，否则为false
     */
    boolean exists(PK id);


    /**
     * 保存对象.
     *
     * @param object 要保存的实体对象
     * @return 保存后的实体对象
     */
    T save(T object);


    /**
     * 删除实体对象.
     *
     * @param object 实体对象
     */
    void remove(T object);

    /**
     * 根据主键删除实体对象
     *
     * @param id 实体对象主键
     */
    void remove(PK id);
}
