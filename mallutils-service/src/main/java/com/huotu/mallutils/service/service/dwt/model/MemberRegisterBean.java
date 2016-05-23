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
 * Created by admin on 2016/5/20.
 */
@Getter
@Setter
public class MemberRegisterBean {
//        BrandCode	品牌代码	必填
//        TradeType	业务类型	必填，固定字符串，"WechatBindCreate"
//        OpenID	微信ID	必填
//        MobilePhone	手机号	必填
//        MemberName	会员姓名	选填，在新增会员时，如果姓名为空，则使用手机号作为姓名
//        MemberCode	会员卡号	选填，在新增会员时，如果卡号为空，则按照品牌要求的规则生成卡号，默认为手机号做卡号
//        Gender	性别	选填，1:男 2:女
//        Birthday	生日	必填，yyyy-MM-dd,如果收集到的信息中没有年份，则需要和品牌约定一个固定的年份值。
//        CounterCode	开卡柜台代号	选填
//        Email	邮箱地址	选填
//        MemberLevelCode	会员等级代码	选填
//        OriginalWechatCode	微信公众号的原始ID	选填，如果填了此项，则意味着要做多公众号的对应。
//        BindTime	绑定时间	选填，Mulberry中的系统时间，\\\\\\yyyy-MM-dd HH:mm:ss
//        RewardPoints	奖励积分规则	选填， JSON格式，{"等级代码1"：积分，"等级代码2"：积分...}
//        Referee	推荐人手机号	选填，填写正确的推荐人手机号
//        AuthFlag	是否需要验证码	必填，微信注册时是否需要短信验证码，"0":不需要，"1":需要，默认为0
//        CouponCode	验证码	选填，但当需要短信验证码时为必填。
    /**
     * BrandCode	品牌代码	必填
     */
    private String brandCode;
    /**
     * TradeType	业务类型	必填，固定字符串，"WechatBindCreate"
     */
    private String tradeType;
    /**
     * OpenID	微信ID	必填
     */
    private String openID;
    /**
     * MobilePhone	手机号	必填
     */
    private String mobilePhone;
    /**
     * MemberName	会员姓名	选填，在新增会员时，如果姓名为空，则使用手机号作为姓名
     */
    private String memberName;
    /**
     * MemberCode	会员卡号	选填，在新增会员时，如果卡号为空，则按照品牌要求的规则生成卡号，默认为手机号做卡号
     */
    private String memberCode;
    /**
     * Gender	性别	选填，1:男 2:女
     */
    private String gender;
    /**
     * Birthday	生日	必填，yyyy-MM-dd,如果收集到的信息中没有年份，则需要和品牌约定一个固定的年份值。
     */
    private String birthday;
    /**
     * CounterCode	开卡柜台代号	选填
     */
    private String counterCode;
    /**
     * Email	邮箱地址	选填
     */
    private String email;
    /**
     * MemberLevelCode	会员等级代码	选填
     */
    private String memberLevelCode;
    /**
     * OriginalWechatCode	微信公众号的原始ID	选填，如果填了此项，则意味着要做多公众号的对应。
     */
    private String originalWechatCode;
    /**
     * BindTime	绑定时间	选填，Mulberry中的系统时间，\\\\\\yyyy-MM-dd HH:mm:ss
     */
    private String bindTime;
    /**
     * RewardPoints	奖励积分规则	选填， JSON格式，{"等级代码1"：积分，"等级代码2"：积分...}
     */
    private String rewardPoints;
    /**
     * Referee	推荐人手机号	选填，填写正确的推荐人手机号
     */
    private String referee;
    /**
     * AuthFlag	是否需要验证码	必填，微信注册时是否需要短信验证码，"0":不需要，"1":需要，默认为0
     */
    private String authFlag;
    /**
     * CouponCode	验证码	选填，但当需要短信验证码时为必填。
     */
    private String couponCode;


}
