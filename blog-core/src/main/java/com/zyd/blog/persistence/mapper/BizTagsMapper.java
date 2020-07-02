package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.TagsConditionVO;
import com.zyd.blog.persistence.beans.BizTags;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**


 * @version 1.0
 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Repository
public interface BizTagsMapper extends BaseMapper<BizTags>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizTags> findPageBreakByCondition(TagsConditionVO vo);
}
