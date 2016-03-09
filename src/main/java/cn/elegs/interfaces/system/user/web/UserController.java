package cn.elegs.interfaces.system.user.web;

import cn.elegs.domain.model.user.UserExistException;
import cn.elegs.domain.shared.DomainException;
import cn.elegs.interfaces.shared.BaseController;
import cn.elegs.interfaces.system.user.facade.UserServiceFacade;
import cn.elegs.interfaces.system.user.facade.dto.RoleDTO;
import cn.elegs.interfaces.system.user.facade.dto.UserDTO;
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
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    UserServiceFacade userServiceFacade;

    final String FORM = "user/userForm";
    final String LIST = "user/userList";

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
            List<RoleDTO> roles = userServiceFacade.findAllRoles();
            model.addAttribute("roles", roles);
        } catch (DomainException e) {
            log.error(e.getMessage());
        }
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return FORM;
    }

    /**
     * 新增用户信息
     *
     * @param userDTO
     * @param errors
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save")
    public String save(@Valid @ModelAttribute("user") final UserDTO userDTO, final BindingResult errors,
                       Model model, @RequestParam(value = "roleId", required = false) String roleIds[], final HttpServletRequest request) {
        if (roleIds == null) {
            saveError(request, getText("user.roles.error.empty", request.getLocale()));
            return FORM;
        }
        UserDTO user = null;
        try {
            user = userServiceFacade.saveUser(userDTO);
            user = userServiceFacade.assignRoleToUser(user, roleIds);
        } catch (UserExistException e) {

            saveError(request, getText("user.error.existing", new Object[]{user.getUsername()}, request.getLocale()));

            return FORM;
        } catch (DomainException de) {

            saveError(request, de.getMessage());
            return FORM;
        }
        List<RoleDTO> roles = userServiceFacade.findAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);

        saveMessage(request, getText("user.saved", user.getFullName(), request.getLocale()));
        return FORM;
    }

    /**
     * 保存用户信息
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    public String add(Model model) {
        UserDTO user = new UserDTO();
        List<RoleDTO> roles = userServiceFacade.findAllRoles();
        model.addAttribute("roles", roles);
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
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
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

    @RequestMapping(value = "/search")
    public String search(@ModelAttribute("user") final UserDTO userDTO, Model model, final BindingResult errors) {

        List<UserDTO> users = userServiceFacade.searchUser(userDTO);
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        model.addAttribute("users", users);
        return LIST;
    }
}
