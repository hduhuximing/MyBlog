package com.zyd.blog.framework.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import com.zyd.blog.business.service.SysConfigService;
import com.zyd.blog.framework.tag.ArticleTags;
import com.zyd.blog.framework.tag.CustomTags;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * freemarker配置类

 * @version 1.0

 * @date 2019/4/16 16:26
 * @since 1.0
 */
@Configuration
public class FreeMarkerConfig {

    @Autowired
    protected freemarker.template.Configuration configuration;
    @Autowired
    protected CustomTags customTags;
    @Autowired
    protected ArticleTags articleTags;
    @Autowired
    private SysConfigService configService;

    /**
     * 添加自定义标签
     */
    @PostConstruct
    public void setSharedVariable() {
        //freeMaker特有￿自定义标签
        configuration.setSharedVariable("zhydTag", customTags);
        configuration.setSharedVariable("articleTag", articleTags);
        try {
            configuration.setSharedVariable("config", configService.getConfigs());
            //shiro标签
            configuration.setSharedVariable("shiro", new ShiroTags());
        } catch (TemplateModelException e) {
            e.printStackTrace();
        }
    }
}
