package cn.elegs.infrastructure.persistence.hibernate;

import cn.elegs.domain.model.role.Role;
import cn.elegs.domain.model.role.RoleRepository;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Role Repository的Hibernate实现.
 */
@Repository("roleRepository")
public class RoleRepositoryHibernate
        extends GenericRepositoryHibernate<Role, String> implements RoleRepository {

    public RoleRepositoryHibernate() {
        super(Role.class);
    }

    @Override
    public List<Role> findRolesByRoleIds(String[] roleIds) {
        List<Role> roles = this.getSession().createCriteria(Role.class)
                .add(Restrictions.in("id", roleIds)).list();
        return roles;
    }
}
