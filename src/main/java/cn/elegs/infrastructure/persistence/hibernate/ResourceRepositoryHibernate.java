package cn.elegs.infrastructure.persistence.hibernate;

import cn.elegs.domain.model.role.Resource;
import cn.elegs.domain.model.role.ResourceRepository;
import org.springframework.stereotype.Repository;

/**
 * 资源对象Repository Hibernate实现.
 */
@Repository("resourceRepository")
public class ResourceRepositoryHibernate extends GenericRepositoryHibernate<Resource, String>
        implements ResourceRepository {
    public ResourceRepositoryHibernate() {
        super(Resource.class);
    }
}
