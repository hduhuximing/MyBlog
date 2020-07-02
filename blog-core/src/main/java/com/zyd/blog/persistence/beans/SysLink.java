package com.zyd.blog.persistence.beans;

import com.zyd.blog.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**


 * @version 1.0
 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysLink extends AbstractDO {
    private String url;
    private String name;
    private String description;
    private String email;
    private String qq;
    private String favicon;
    private Boolean status;
    private Boolean homePageDisplay;
    private String remark;
    private String source;
}
