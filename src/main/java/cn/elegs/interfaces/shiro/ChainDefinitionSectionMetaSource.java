package cn.elegs.interfaces.shiro;

import cn.elegs.domain.model.role.Resource;
import cn.elegs.domain.model.role.ResourceRepository;
import cn.elegs.domain.model.role.Role;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Shiro 权限元数据.
 */
public class ChainDefinitionSectionMetaSource implements FactoryBean<Section> {

    @Autowired
    ResourceRepository resourceRepository;

    private String filterChainDefinitions;

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    /**
     * 获得权限对象
     *
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public Section getObject() throws Exception {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);
        Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (section == null || section.isEmpty()) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        List<Resource> resources = resourceRepository.getAll();
        for (Resource resource : resources) {
            //role["admin,user"]
            Set<Role> roleSet = resource.getRoleSet();
            if (!roleSet.isEmpty()) {
                section.put(resource.getAction(), buildRoleArray(roleSet));

            }
        }
        return section;
    }

    private String buildRoleArray(Set<Role> roles) {

        String preStr = "roles['";
        String postStr = "']";
        String roleStr = "";
        for (Role role : roles) {
            String roleId = role.getId();
            roleStr += roleId + ",";
        }

        if (roleStr.length() >= 1) {
            roleStr = roleStr.substring(0, roleStr.length() - 1);
        }

        roleStr = preStr + roleStr + postStr;
        return roleStr;

    }
    @Override
    public Class<Section> getObjectType() {
        return Section.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
