package com.zyd.blog.business.service;


import com.github.pagehelper.PageInfo;
import com.zyd.blog.business.entity.Tags;
import com.zyd.blog.business.vo.TagsConditionVO;
import com.zyd.blog.framework.object.AbstractService;

/**
 * 标签
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
public interface BizTagsService extends AbstractService<Tags, Long> {

    PageInfo<Tags> findPageBreakByCondition(TagsConditionVO vo);

    Tags getByName(String name);
}
