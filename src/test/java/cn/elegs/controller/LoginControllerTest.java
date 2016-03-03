package cn.elegs.controller;

import cn.elegs.interfaces.HomeController;
import cn.elegs.interfaces.user.facade.dto.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * 用户登录测试.
 */

public class LoginControllerTest extends BaseControllerTestCase {

    private MockMvc mockMvc;


    @Autowired
    private HomeController homeController;


    @Before
    public void setup() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");

        mockMvc = MockMvcBuilders.standaloneSetup(homeController).setViewResolvers(viewResolver).build();
    }

    @Test
    public void testLogin() throws Exception {
        log.debug("test login..");

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("Eric");
        ;
        userDTO.setPassword("111111");
//        BindingResult errors=new DataBinder(userDTO).getBindingResult();

        // 构造http请求及期待响应行为
        mockMvc.perform(post("/login").param("username", "Eric").param("password", "123456"))
                .andDo(print()) // 输出请求和响应信息
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/index.jsp"));

    }

}
