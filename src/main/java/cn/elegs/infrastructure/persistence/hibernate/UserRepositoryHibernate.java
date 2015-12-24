package cn.elegs.infrastructure.persistence.hibernate;

import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserRepository;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * UserRepository 的Hibernate实现.
 */
@Repository("userRepository")
public class UserRepositoryHibernate extends GenericRepositoryHibernate<User, String> implements UserRepository {
    public UserRepositoryHibernate() {
        super(User.class);
    }

    @Override
    public User getUserByName(String username) {

        User user = (User) this.getSession().createCriteria(User.class)
                .add(Restrictions.eq("username", username)).uniqueResult();
        return user;
    }
}
