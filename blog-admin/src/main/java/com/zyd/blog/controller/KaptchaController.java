package com.zyd.blog.controller;

import com.zyd.blog.plugin.kaptcha.Captcha;
import com.zyd.blog.plugin.kaptcha.GifCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@Slf4j
@Controller
public class KaptchaController {

    @GetMapping("/getKaptcha")
    @ResponseBody
    public void getKaptcha(HttpServletResponse response) {
        try {
            //设置响应
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /**
             * gif格式动画验证码
             * 宽，高，位数。
             */
            Captcha captcha = new GifCaptcha(146, 33, 4);
            /**
             * png图形格式验证码
             * 宽，高，位数
             */
//            Captcha captcha1 = new SpecCaptcha(146, 33, 4);
            //输出
            captcha.out(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取验证码异常：{}", e.getMessage());
        }
    }

}
