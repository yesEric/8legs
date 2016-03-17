package cn.elegs.interfaces;

import cn.elegs.interfaces.shared.BaseController;
import cn.elegs.interfaces.system.user.facade.dto.UserDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 主页.
 */
@Controller
public class HomeController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid UserDTO user, @RequestParam(value = "rememberMe", required = false) boolean rememberMe, BindingResult bindingResult, RedirectAttributes redirectAttributes, final HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "/login";
        }
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            token.setRememberMe(rememberMe);
            SecurityUtils.getSubject().login(token);

            return "redirect:/index.jsp";
        } catch (AuthenticationException e) {
            saveError(request, getText("login.error.mismatch", request.getLocale()));
            return "redirect:/login";
        }


    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes) {
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("messages", "You have security log out!");
        return "redirect:/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        return "/403";
    }


}
