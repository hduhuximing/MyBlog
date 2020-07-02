package com.zyd.blog.business.service;

import me.zhyd.hunter.config.HunterConfig;

import java.io.PrintWriter;

/**

 * @version 1.0

 * @date 2019/8/21 15:35
 * @since 1.8
 */
public interface RemoverService {

    void run(Long typeId, HunterConfig config, PrintWriter writer);

    void stop();

    void crawlSingle(Long typeId, String[] url, boolean convertImg, PrintWriter writer);
}
