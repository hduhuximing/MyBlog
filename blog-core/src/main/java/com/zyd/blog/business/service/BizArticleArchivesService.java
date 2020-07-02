package com.zyd.blog.business.service;

import java.util.List;
import java.util.Map;

/**
 * 归档目录
 *

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
public interface BizArticleArchivesService {

    /**
     * 获取归档目录列表
     *
     * @return
     */
    Map<String, List> listArchives();
}
