package cn.elegs.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Controller测试基类.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring/context-resources.xml",
        "classpath:/spring/context-persistence.xml",
        "classpath:/spring/context-application.xml",
        "classpath:/spring/context-interfaces.xml",
        "classpath:/spring/context-domain.xml",
        "classpath:/spring/context-shiro.xml"
})
public abstract class BaseControllerTestCase extends AbstractTransactionalJUnit4SpringContextTests {
    protected transient final Log log = LogFactory.getLog(getClass());

    /**
     * Convenience methods to make tests simpler
     *
     * @param url the URL to post to
     * @return a MockHttpServletRequest with a POST to the specified URL
     */
    public MockHttpServletRequest newPost(String url) {
        return new MockHttpServletRequest("POST", url);
    }

    public MockHttpServletRequest newGet(String url) {
        return new MockHttpServletRequest("GET", url);
    }
}
