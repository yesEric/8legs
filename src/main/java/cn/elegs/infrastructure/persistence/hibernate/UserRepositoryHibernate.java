package cn.elegs.infrastructure.persistence.hibernate;

import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserExistException;
import cn.elegs.domain.model.user.UserRepository;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public User save(User user) throws UserExistException {
        this.getSession().saveOrUpdate(user);
        try {
            getSession().flush();
        } catch (Exception de) {
            de.printStackTrace();
            throw new UserExistException();
        }

        return user;
    }

    @Override
    public List<User> search(String username) {
        List<User> users = getSession().createCriteria(User.class)
                .add(Restrictions.like("username", username, MatchMode.ANYWHERE)).list();
        return users;
    }
}
