package com.zyd.blog.business.service;

import me.zhyd.oauth.model.AuthCallback;

/**

 * @version 1.0

 * @date 2019/5/25 14:32
 * @since 1.8
 */
public interface AuthService {

    boolean login(String source, AuthCallback callback);

    boolean revoke(String source, Long userId);

    void logout();
}
