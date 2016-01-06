package cn.elegs.interfaces.shiro;

import cn.elegs.domain.model.role.Resource;
import cn.elegs.domain.model.role.Role;
import cn.elegs.domain.model.user.User;
import cn.elegs.domain.model.user.UserRepository;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户权限验证Shiro.
 */
@Service
public class UserAuthorityRealm extends AuthorizingRealm {
    @Autowired
    UserRepository userRepository;

    /**
     * 权限验证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名
        String loginUsername = (String) principalCollection.fromRealm(this.getName()).iterator().next();
        //到数据库查找是否有这个用户
        User user = userRepository.getUserByName(loginUsername);
        //权限对象info用来存放查找出的用户的所有角色(role)和权限(permission)
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> perms = new HashSet<String>();
        if (user != null) {
//            //设置用户的角色集合
//            info.setRoles(user.getRoleIds());
            //增加用户角色对应的权限
            for (Role role : user.getRoleSet()) {
                for (Resource resource : role.getResourceSet()) {
                    String resourceId = resource.getId();
                    perms.add(resourceId);
                }
            }
        }
        info.setStringPermissions(perms);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        //UsernamePasswordToken存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //检查是否有此用户
        User user = userRepository.getUserByName(token.getUsername());
        if (user == null) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
    }
}
