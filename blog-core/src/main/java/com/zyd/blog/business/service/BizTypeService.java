package com.zyd.blog.business.service;


import com.github.pagehelper.PageInfo;
import com.zyd.blog.business.entity.Type;
import com.zyd.blog.business.vo.TypeConditionVO;
import com.zyd.blog.framework.object.AbstractService;

import java.util.List;

/**
 * 分类
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
public interface BizTypeService extends AbstractService<Type, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<Type> findPageBreakByCondition(TypeConditionVO vo);

    List<Type> listParent();

    List<Type> listTypeForMenu();
}
