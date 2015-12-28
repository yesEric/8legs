package cn.elegs.domain.model.role;

import cn.elegs.domain.shared.GenericRepository;

import java.util.List;

/**
 * 用户角色Repository.
 */
public interface RoleRepository extends GenericRepository<Role, String> {
    /**
     * 查找一组用户角色
     *
     * @param roleIds 用户角色ID数组
     * @return
     */
    List<Role> findRolesByRoleIds(String roleIds[]);
}
