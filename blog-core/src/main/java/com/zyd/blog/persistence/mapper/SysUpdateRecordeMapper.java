package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.UpdateRecordeConditionVO;
import com.zyd.blog.persistence.beans.SysUpdateRecorde;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**


 * @version 1.0
 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Repository
public interface SysUpdateRecordeMapper extends BaseMapper<SysUpdateRecorde>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<SysUpdateRecorde> findPageBreakByCondition(UpdateRecordeConditionVO vo);
}
