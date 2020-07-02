package com.zyd.blog.business.service;


import com.zyd.blog.business.entity.RoleResources;
import com.zyd.blog.framework.object.AbstractService;

/**
 * 角色资源
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
public interface SysRoleResourcesService extends AbstractService<RoleResources, Long> {

    /**
     * 添加角色资源
     *
     * @param roleId
     * @param resourcesId
     */
    void addRoleResources(Long roleId, String resourcesId);

    /**
     * 通过角色id批量删除
     *
     * @param roleId
     */
    void removeByRoleId(Long roleId);
}
