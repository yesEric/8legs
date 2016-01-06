package cn.elegs.infrastructure.persistence.hibernate;


import cn.elegs.domain.model.user.LockStatus;
import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends BaseRepositoryTestCase {

    @Autowired
    UserRepository userRepository;


    /**
     * 测试增加用户
     *
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {
        User user = new User("Bobo", "111111");
        user = userRepository.save(user);
        log.debug(user);
        Assert.assertNotNull(user.getId());


        user.lock();
        user = userRepository.save(user);
        Assert.assertEquals(user.getLocked(), LockStatus.LOCKED);
    }
}

