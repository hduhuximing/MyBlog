package com.zyd.blog.business.vo;

import com.zyd.blog.business.entity.Article;
import com.zyd.blog.framework.object.BaseConditionVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ArticleConditionVO extends BaseConditionVO {
	private Article article;
	private Long typeId;
	private Long tagId;
	private Integer status;
	private Boolean top;
	private Boolean recommended;
	private Boolean original;
	private Boolean random;
	private List<Long> tagIds;
}

