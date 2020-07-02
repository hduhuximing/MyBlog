package com.zyd.blog.framework.config;

import org.springframework.stereotype.Component;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Component
@MapperScan("com.zyd.blog.persistence.mapper")
public class MybatisConfig {
}
