package me.sunlight.sdk.common.network.api;

/**
 * Created by 戈传光 on 2017/7/25.
 * 邮箱：1944633835@qq.com
 */
public class Urls {
    /**
     * 139.196.5.194
     * http://www.sxpft.com.cn
     */
    private final static String baseUrl = "http://olive.sxpft.com.cn";
    // 注册
    public final static String registerUrl = baseUrl + "/account/register";
    // 登录
    public final static String loginUrl = baseUrl + "/account/login";
    // 发送验证码
    public final static String sendCodeUrl = baseUrl + "/account/mobile/send";
    // 忘记密码
    public final static String forgetPwdUrl = baseUrl + "/account/password/forget";

    // 首页
    public final static String homeUrl = baseUrl + "/home";

    // 庄园详情
    public final static String fincaDetailUrl = baseUrl + "/detail";
    // 评论列表
    public final static String commentUrl = baseUrl + "/comment/list";
    // 收藏or取消收藏
    public final static String collectUrl = baseUrl + "/collect";
    // 获取地址
    public final static String addressUrl = baseUrl + "/address";
    // 生成订单信息
    public final static String releaseOrderUrl = baseUrl + "/order/prefix";
    // 添加到购物车
    public final static String add2ShopCarUrl = baseUrl + "/order/save";
    // 我的收藏
    public final static String myColectListUrl = baseUrl + "/center/collect/list";
    // 个人信息接口（姓名，头像，认领数量）
    public final static String userInfoUrl = baseUrl + "/center/info";
    // 我的树列表
    public final static String myTreeListUrl = baseUrl + "/center/list";
    // 获取我的树详情
    public final static String myTreeDetailUrl = baseUrl + "/center/tree";
    // 申请度假
    public final static String supplyHolidayUrl = baseUrl + "/holiday";
    // 退出登陆
    public final static String logouturl = baseUrl + "/account/logout";

    // 获取用户的头像姓名邮箱收获地址
    public final static String userCardUrl = baseUrl + "/modify/info";

    //修改用户头像
    public final static String updatePortviewUrl = baseUrl + "/modify/profile";

    //修改用户名字
    public final static String updateUserNameUrl = baseUrl + "/modify/username";

    //修改用户邮箱
    public final static String updateEmailUrl = baseUrl + "/modify/email";

    //修改用户地址
    public final static String updateAddressUrl = baseUrl + "/modify/address";

    //修改用户手机
    public final static String updatePhoneUrl = baseUrl + "/modify/mobile";

    // 支付页面 生成订单信息
    public final  static String payOrderDetailUrl = baseUrl+"/order/detail";

    // 支付
    public final  static  String orderPayUrl=baseUrl+"/order/pay";


    public interface ApiContancts {

        String fromAndroid = "2";
//        String WxAppId="wx3212b369e83642fb";// 橄榄树


        String WxAppId="wxc928a55d7636ac4d";// 恰到
//        String WxAppId = "wx85bbb0f8e3382360"; // 瞬修

    }

}
