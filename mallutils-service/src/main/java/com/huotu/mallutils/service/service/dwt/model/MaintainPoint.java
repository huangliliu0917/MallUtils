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
public class MaintainPoint {

    //        BrandCode 	品牌代码 	必填
//        TradeType 	业务类型 	必填。固定字符串，"PointMaintenance"
//        MemberCode 	会员号 	必填。
//        MaintType 	维护类型 	必填。1：修改积分总值，2：修改积分差值
//        MaintPoint 	维护的分数 	必填。和ModifyType配合使用，区分正负号，正数为增加，负数为减少
//        MaintainType 	积分类型 	"有则填。
//        0：维护积分
//        1：奖励积分
//        4：初始积分
//        8：微信绑定送积分
//        9：微信签到送积分"
//        CounterCode 	关联的柜台号 	有则填。
//        EmployeeCode 	关联的员工代号 	有则填。
//        BusinessTime 	业务时间 	必填。格式为YYYY-MM-DD HH:mm:SS
//        Sourse 	数据来源 	"必填。
//                          Wechat:微信
//                          OfficialWebsite:官网 "
//        Comment 	备注信息 	有则填。

    /**
     * BrandCode 	品牌代码 	必填
     */
    private String brandCode;
    /**
     * TradeType 	业务类型 	必填。固定字符串，"PointMaintenance"
     */
    private String tradeType;
    /**
     * MemberCode 	会员号 	必填。
     */
    private String memberCode;
    /**
     * MaintType 	维护类型 	必填。1：修改积分总值，2：修改积分差值
     */
    private String maintType;
    /**
     * MaintPoint 	维护的分数 	必填。和ModifyType配合使用，区分正负号，正数为增加，负数为减少
     */
    private String maintPoint;
    /**
     * MaintainType 	积分类型 	"有则填。
     * 0：维护积分
     * 1：奖励积分
     * 4：初始积分
     * 8：微信绑定送积分
     * 9：微信签到送积分"
     */
    private String maintainType;
    /**
     * CounterCode 	关联的柜台号 	有则填。
     */
    private String counterCode;
    /**
     * EmployeeCode 	关联的员工代号 	有则填。
     */
    private String employeeCode;
    /**
     * BusinessTime 	业务时间 	必填。格式为yyyy-MM-dd HH:mm:ss
     */
    private String businessTime;
    /**
     * Sourse 	数据来源 	"必填。
     * Wechat:微信
     * OfficialWebsite:官网 "
     */
    private String sourse;
    /**
     * Comment 	备注信息 	有则填。
     */
    private String comment;
}
