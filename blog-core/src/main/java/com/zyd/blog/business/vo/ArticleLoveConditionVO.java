package com.zyd.blog.business.vo;

import com.zyd.blog.business.entity.ArticleLove;
import com.zyd.blog.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleLoveConditionVO extends BaseConditionVO {
	private ArticleLove articleLove;
}

