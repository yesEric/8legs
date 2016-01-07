package cn.elegs.interfaces.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;

/**
 * 实现权限的角色“或”关系.
 */
public class RolesAuthorizationOrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        String[] rolesArray = (String[]) mappedValue;
        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }

        List<String> roles = CollectionUtils.asList(rolesArray);
        boolean[] hasRoles = subject.hasRoles(roles);
        for (boolean hasRole : hasRoles) {
            if (hasRole) {
                return true;
            }
        }
        return false;

    }
}
