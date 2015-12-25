package cn.elegs.interfaces.user.web;

import cn.elegs.interfaces.shared.BaseController;
import cn.elegs.interfaces.user.facade.UserServiceFacade;
import cn.elegs.interfaces.user.facade.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户管理控制器.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserServiceFacade userServiceFacade;

    /**
     * 显示注册用户的页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show")
    public String show(@RequestParam("id") String id, Model model) throws Exception {

        UserDTO user = userServiceFacade.getUserById(id);
        model.addAttribute("user", user);
        return "userForm";
    }

    @RequestMapping(value = "/save")
    public String save(@ModelAttribute("user") final UserDTO userDTO, final BindingResult errors,
                       final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        userServiceFacade.createNewUser(userDTO.getUsername(), userDTO.getPassword());

        return "userForm";
    }


}
