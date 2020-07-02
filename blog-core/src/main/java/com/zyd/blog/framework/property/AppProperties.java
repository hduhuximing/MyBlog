package com.zyd.blog.framework.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppProperties {

    /**
     * 是否启用验证码
     */
    public boolean enableKaptcha = false;

}
