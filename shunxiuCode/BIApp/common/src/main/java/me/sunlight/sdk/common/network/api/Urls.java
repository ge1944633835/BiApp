package me.sunlight.sdk.common.network.api;

/**
 * Created by 戈传光 on 2017/7/25.
 * 邮箱：1944633835@qq.com
 */
public interface Urls {
    /**
     * 139.196.5.194
     * http://www.sxpft.com.cn
     */
    String baseImUrl = "http://dev-bi-im.blockbi.com/"; // 聊天

    String baseUrl = "http://devapi.blockbi.com/"; // 普通接口

    // 注册
    String registerUrl = baseUrl + "api/user/register";
    // 登录
    String loginUrl = baseUrl + "api/user/login-check";
    // 发送验证码
    String sendCodeUrl = baseUrl + "/account/mobile/send";
    // 登出
    String logoutUrl = baseUrl + "api/user/logout";
}
