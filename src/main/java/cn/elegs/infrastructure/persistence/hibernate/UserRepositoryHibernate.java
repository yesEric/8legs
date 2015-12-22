package cn.elegs.infrastructure.persistence.hibernate;

import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository 的Hibernate实现.
 */
@Repository("userRepository")
public class UserRepositoryHibernate extends GenericRepositoryHibernate<User, String> implements UserRepository {
    public UserRepositoryHibernate() {
        super(User.class);
    }
}
