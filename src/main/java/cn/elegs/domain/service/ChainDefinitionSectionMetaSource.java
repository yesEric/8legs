package cn.elegs.domain.service;

import cn.elegs.domain.model.role.Resource;
import cn.elegs.domain.model.role.ResourceRepository;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.config.IniFilterChainResolverFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Shiro 权限元数据.
 */
@Service
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
    public Section getObject() throws Exception {
        Ini ini = new Ini();
        ini.load(filterChainDefinitions);
        Section section = ini.getSection(IniFilterChainResolverFactory.URLS);
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
        }
        List<Resource> resources = resourceRepository.getAll();
        for (Resource resource : resources) {
            section.put(resource.getAction(), resource.getId());
        }
        return section;
    }

    @Override
    public Class<?> getObjectType() {
        return Section.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
