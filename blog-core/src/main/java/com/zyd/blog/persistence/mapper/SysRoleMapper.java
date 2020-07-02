package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.RoleConditionVO;
import com.zyd.blog.persistence.beans.SysRole;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**


 * @version 1.0
 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<SysRole> findPageBreakByCondition(RoleConditionVO vo);

    List<SysRole> queryRoleListWithSelected(Integer userId);

    List<SysRole> listRolesByUserId(Long userId);
}
