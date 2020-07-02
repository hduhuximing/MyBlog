package com.zyd.blog.business.service;


import com.github.pagehelper.PageInfo;
import com.zyd.blog.business.entity.UpdateRecorde;
import com.zyd.blog.business.vo.UpdateRecordeConditionVO;
import com.zyd.blog.framework.object.AbstractService;

/**
 * 更新记录
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
public interface SysUpdateRecordeService extends AbstractService<UpdateRecorde, Long> {

    PageInfo<UpdateRecorde> findPageBreakByCondition(UpdateRecordeConditionVO vo);
}
