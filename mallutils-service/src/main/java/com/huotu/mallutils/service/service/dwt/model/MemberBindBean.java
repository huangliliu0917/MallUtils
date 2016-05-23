/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.dwt.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by elvis on 2016/5/20.
 */
@Getter
@Setter
public class MemberBindBean {
    //        BrandCode	品牌代码	必填
//        TradeType	业务类型	必填，固定字符串，"BindWechat"
//        MessageID	要检查的微信ID	必填
//        MemberCode	会员卡号	有则填
//        MobilePhone	手机号	必填
//        CouponCode	验证码	必填
//        MemberPassword	会员密码	有则填
//        BindTime	绑定时间	Mulberry中的系统时间，yyyy-MM-dd HH:mm:ss
//        RewardPoints	奖励积分规则	选填，JSON格式，{"等级代码1"：积分，"等级代码2"：积分...}
//        OriginalWechatCode	微信公众号的原始ID	选填，如果填了此项，则意味着要做多公众号的对应。
    /**
     * BrandCode	品牌代码	必填
     */
    private String brandCode;
    /**
     * TradeType	业务类型	必填，固定字符串，"BindWechat"
     */
    private String tradeType;
    /**
     * MessageID	要检查的微信ID	必填
     */
    private String messageID;
    /**
     * MemberCode	会员卡号	有则填
     */
    private String memberCode;
    /**
     * MobilePhone	手机号	必填
     */
    private String mobilePhone;
    /**
     * CouponCode	验证码	必填
     */
    private String couponCode;
    /**
     * MemberPassword	会员密码	有则填
     */
    private String memberPassword;
    /**
     * BindTime	绑定时间	Mulberry中的系统时间，yyyy-MM-dd HH:mm:ss
     */
    private String bindTime;
    /**
     * RewardPoints	奖励积分规则	选填，JSON格式，{"等级代码1"：积分，"等级代码2"：积分...}
     */
    private String rewardPoints;
    /**
     * OriginalWechatCode	微信公众号的原始ID	选填，如果填了此项，则意味着要做多公众号的对应。
     */
    private String originalWechatCode;


}
