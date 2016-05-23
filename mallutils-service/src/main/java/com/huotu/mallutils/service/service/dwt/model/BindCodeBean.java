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
public class BindCodeBean {
    //        BrandCode	品牌代码	必填
//        TradeType	业务类型	必填，固定字符串，"AuthenticateWechatRequest"
//        MessageID	要检查的微信ID	必填
//        MemberCode	会员卡号	有则填
//        MobilePhone	手机号	必填
/*                返回结果
        返回值key	说明
        ERRORCODE	错误码。为0时，表示正常返回
        ERRORMSG	错误消息体。本系统提供的最原始的错误消息，调用方可根据ERRORCODE再包装
        ResultMap	形式为加密后的JSON字符串
        Key	说明
        MemberID	会员ID
        CouponCode	验证码
        MemberPassword	会员密码*/
    /**
     * BrandCode	品牌代码	必填
     */
    private String brandcode;

    /**
     * TradeType	业务类型	必填，固定字符串，"AuthenticateWechatRequest"
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
}
