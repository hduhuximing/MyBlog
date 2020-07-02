package com.zyd.blog.plugin.oauth;

import me.zhyd.oauth.request.AuthRequest;

/**

 * @version 1.0

 * @date 2019/5/23 18:32
 * @since 1.8
 */
public interface OauthRequest {

    AuthRequest getRequest();
}
