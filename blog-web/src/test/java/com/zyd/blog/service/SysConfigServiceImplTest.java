package com.zyd.blog.service;

import com.alibaba.fastjson.JSON;
import com.zyd.blog.BaseJunitTest;
import com.zyd.blog.business.service.SysConfigService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class SysConfigServiceImplTest extends BaseJunitTest {

    @Autowired
    private SysConfigService configService;

    @Test
    public void comment() throws InterruptedException {
        System.out.println(JSON.toJSONString(configService.getConfigs()));
    }
}
