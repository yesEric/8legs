package cn.elegs.infrastructure.persistence.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Hibernate 的 Repository 测试基类.
 */
@ContextConfiguration(locations = {
        "classpath:/spring/application-resources.xml",
        "classpath:/spring/application-persistence.xml"
})
public abstract class BaseRepositoryTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    SessionFactory sessionFactory;

    protected final Log log = LogFactory.getLog(getClass());

    protected void flush() throws BeansException {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.flush();
    }
}
