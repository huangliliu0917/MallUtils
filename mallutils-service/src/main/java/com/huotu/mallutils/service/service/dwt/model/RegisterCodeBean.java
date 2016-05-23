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
public class RegisterCodeBean {
//        BrandCode	品牌代码	必填
//        TradeType	业务类型	必填，固定字符串，"SendMobileMessage"
//        EventType	事件类型	必填。由POS系统指定类型，验证码事件为：14
//        MobilePhone	手机号	必填
//        CouponCode	验证码	有则填。如果是外部系统生成的验证码，则填写，否则POS系统会生成验证码（前提是这一个验证码短信，不是普通短信，可根据EventType判断）
//        CouponExpireTime	验证码的过期时间	有则填。两种形式，一种是绝对时间，格式"YYYY-MM-DD HH:mm:SS"；一种是相对时间，整数型，单位秒，意思是指从POS系统收到该数据时，过x秒后过期
//        MessageBody	短信正文	有则填。如果外部系统提供，则POS系统原样照发，不做任何处理。否则需要在POS系统中设置消息模板


    /**
     * BrandCode	品牌代码	必填
     */
    private String brandCode;
    /**
     * TradeType	业务类型	必填，固定字符串，"SendMobileMessage"
     */
    private String tradeType;
    /**
     * EventType	事件类型	必填。由POS系统指定类型，验证码事件为：14
     */
    private String eventType;
    /**
     * MobilePhone	手机号	必填
     */
    private String mobilePhone;
    /**
     * CouponCode	验证码	有则填。如果是外部系统生成的验证码，则填写，否则POS系统会生成验证码（前提是这一个验证码短信，不是普通短信，可根据EventType判断）
     */
    private String couponCode;
    /**
     * CouponExpireTime	验证码的过期时间	有则填。两种形式，一种是绝对时间，格式"YYYY-MM-DD HH:mm:SS"；一种是相对时间，整数型，单位秒，意思是指从POS系统收到该数据时，过x秒后过期
     */
    private String couponExpireTime;
    /**
     * MessageBody	短信正文	有则填。如果外部系统提供，则POS系统原样照发，不做任何处理。否则需要在POS系统中设置消息模板
     */
    private String messageBody;


}
