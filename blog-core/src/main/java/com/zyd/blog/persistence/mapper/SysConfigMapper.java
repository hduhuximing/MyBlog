package com.zyd.blog.persistence.mapper;

import com.zyd.blog.persistence.beans.SysConfig;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Repository
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    Map<String, Object> getSiteInfo();
}
