package cn.elegs.interfaces.user.web;

import cn.elegs.domain.model.user.UserExistException;
import cn.elegs.domain.shared.DomainException;
import cn.elegs.interfaces.shared.BaseController;
import cn.elegs.interfaces.user.facade.UserServiceFacade;
import cn.elegs.interfaces.user.facade.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 用户管理控制器.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserServiceFacade userServiceFacade;

    final String FORM = "user/userForm";
    final String LIST = "user/list";

    public void initBinder(HttpServletRequest request,
                           ServletRequestDataBinder binder) {

        //添加一个spring自带的validator
        binder.setValidator(new UserValidator());
    }

    /**
     * 显示注册用户的页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show")
    public String show(@RequestParam("id") String id, Model model) {
        UserDTO user = new UserDTO();
        try {
            user = userServiceFacade.getUserById(id);
        } catch (DomainException e) {
            log.error("Cannot find user");
        }
        model.addAttribute("user", user);
        return FORM;
    }

    /**
     * 保存用户信息
     *
     * @param userDTO
     * @param errors
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save")
    public String save(@Valid @ModelAttribute("user") final UserDTO userDTO, final BindingResult errors,
                       Model model, @RequestParam(value = "roleId") String roleIds[]) {
        UserDTO user = null;
        try {
            user = userServiceFacade.createNewUser(userDTO.getUsername(), userDTO.getPassword());
            user = userServiceFacade.assignRoleToUser(user, roleIds);
        } catch (UserExistException e) {
            errors.rejectValue("username", "error.existing.user", new Object[]{user.getUsername()}, "");
            return FORM;
        } catch (DomainException de) {
            errors.reject(de.getMessage());
            return FORM;
        }

        model.addAttribute("user", user);
        return FORM;
    }

    /**
     * 显示用户列表
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<UserDTO> users = userServiceFacade.findAll();
        model.addAttribute("users", users);
        return LIST;
    }

    /**
     * 删除用户
     *
     * @param userId
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/remove")
    public String remove(@RequestParam(value = "id") String userId, Model model, final BindingResult errors) {
        try {
            userServiceFacade.removeUser(userId);
        } catch (DomainException e) {
            errors.reject(e.getMessage());
        }
        List<UserDTO> users = userServiceFacade.findAll();
        model.addAttribute("users", users);
        return LIST;
    }


}
