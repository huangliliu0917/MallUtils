/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.controller.dwt;

import com.alibaba.fastjson.JSON;
import com.huotu.mallutils.common.ienum.ResultCode;
import com.huotu.mallutils.web.common.ApiResult;
import connector.SapConnector;
import entity.*;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by allan on 5/23/16.
 */
@RequestMapping("/dwt")
public class DWTApiController {
    /**
     * @param tradeType 方法类型
     * @param infoJson  json格式信息
     * @return
     */

    @RequestMapping("/dwtApi")
    public ApiResult dwtApi(String tradeType, String infoJson) {

        switch (tradeType){
            case "SendMobileMessage"://注册验证码
                RegisterCodeBean registerCodeBean = JSON.parseObject(infoJson, RegisterCodeBean.class);
                registerCodeBean.setTradeType("SendMobileMessage");
                try {
                    ReturnData data = new SapConnector().GetRegisterCode(registerCodeBean);
                    if("0".equals(data.getERRORCODE())){
                        return ApiResult.resultWith(ResultCode.SUCCESS);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "WechatBindCreate"://注册
                MemberRegisterBean memberRegisterBean = JSON.parseObject(infoJson, MemberRegisterBean.class);
                memberRegisterBean.setTradeType("WechatBindCreate");
                try {
                    ReturnData data = new SapConnector().Memberregister(memberRegisterBean);
                    if("0".equals(data.getERRORCODE())){
                        return ApiResult.resultWith(ResultCode.SUCCESS,data.getData());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "AuthenticateWechatRequest"://绑定验证码
                BindCodeBean bindCodeBean = JSON.parseObject(infoJson, BindCodeBean.class);
                bindCodeBean.setTradeType("AuthenticateWechatRequest");
                try {
                    ReturnData data = new SapConnector().GetbindCode(bindCodeBean);
                    if("0".equals(data.getERRORCODE())){
                        return ApiResult.resultWith(ResultCode.SUCCESS);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "BindWechat"://绑定
                MemberBindBean memberBindBean = JSON.parseObject(infoJson, MemberBindBean.class);
                memberBindBean.setTradeType("BindWechat");
                try {
                    ReturnData data = new SapConnector().Memberbind(memberBindBean);
                    if("0".equals(data.getERRORCODE())){
                        return ApiResult.resultWith(ResultCode.SUCCESS,data.getData());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "PointMaintenance": //积分查询
                MaintainPoint maintainPoint = new MaintainPoint();
                maintainPoint.setTradeType("PointMaintenance");
                try {
                    ReturnData data = new SapConnector().MaintainPoint(maintainPoint);
                    if("0".equals(data.getERRORCODE())){
                        return ApiResult.resultWith(ResultCode.SUCCESS,data.getData());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                return ApiResult.resultWith(ResultCode.ERROR);
        }
        // TODO: 5/23/16 会员信息
        return ApiResult.resultWith(ResultCode.ERROR);
    }




}
