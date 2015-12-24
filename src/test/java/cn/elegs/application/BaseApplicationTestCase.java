package cn.elegs.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * 应用服务成测试基类.
 */
@ContextConfiguration(locations = {
        "classpath:/spring/context-resources.xml",
        "classpath:/spring/context-persistence.xml",
        "classpath:/spring/context-application.xml"
})
public abstract class BaseApplicationTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    /**
     * A simple logger
     */
    protected final Log log = LogFactory.getLog(getClass());

}
