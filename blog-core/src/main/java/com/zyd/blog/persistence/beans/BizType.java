package com.zyd.blog.persistence.beans;

import com.zyd.blog.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;
import java.util.List;

/**

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizType extends AbstractDO {
    private Long pid;
    private String name;
    private String description;
    private Integer sort;
    private Boolean available;
    private String icon;


    @Transient
    private BizType parent;
    @Transient
    private List<BizType> nodes;
}
