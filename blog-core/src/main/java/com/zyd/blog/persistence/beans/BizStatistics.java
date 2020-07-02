package com.zyd.blog.persistence.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Transient;

/**
 * 统计
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizStatistics {
    @Transient
    private String name;
    @Transient
    private Integer value;
}
