package cn.elegs.domain.model.role;

import cn.elegs.domain.shared.ValueObject;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色资源对象.
 */
public class Resource extends ValueObject<Resource> {
    /**
     * 资源名称
     */
    String name;
    /**
     * 资源描述
     */
    String description;
    /**
     * 资源请求动作，如:URL
     */
    String action;
    /**
     * 排序
     */
    int sortOrder;
    /**
     * 级别
     */
    int level;

    /**
     * 父辈资源
     */
    Resource parent;
    /**
     * 子元素
     */
    Set<Resource> children = new HashSet<>();

    Set<Role> roleSet = new HashSet<>();


    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public Resource() {
    }

    public Resource(String name) {
        this.name = name;
    }

    public Set getChildren() {
        return children;
    }

    public void setChildren(Set children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (!name.equals(resource.name)) return false;
        return action != null ? action.equals(resource.action) : resource.action == null;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", action='" + action + '\'' +
                ", sortOrder=" + sortOrder +
                ", level=" + level +
                ", parent=" + parent +
                '}';
    }

    @Override
    protected boolean sameIdentityAs(Resource other) {
        return other != null && other.getId().equals(getId());
    }
}
