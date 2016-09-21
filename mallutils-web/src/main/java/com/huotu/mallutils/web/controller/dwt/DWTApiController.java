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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

/**
 * Created by allan on 5/23/16.
 */
@Controller
@RequestMapping("/dwt")
public class DWTApiController {
    private static final Log log = LogFactory.getLog(DWTApiController.class);

    @PostConstruct
    public void initSysData() {
        DWTSysData.BASIS_URL = "http://202.107.243.44:60080/Cherry/webservice/cherryws";
        DWTSysData.REGISTER_URL = "http://202.107.243.44:60080/CherryBatch/webservice/cherryws";
        DWTSysData.GET_MEMBER_INFO_URL = "http://202.107.243.44:60080/Cherry/webservice/cherryws";
        DWTSysData.appID = "weshop";
        DWTSysData.brandCode = "ply";
        DWTSysData.AESKey = "KwBHRgqFEygN1VZC2TR7Qw==";
    }

    /**
     * @param tradeType 方法类型
     * @param infoJson  json格式信息
     * @return
     */

    @RequestMapping(value = "/dwtApi", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult dwtApi(String tradeType, String infoJson) {
        switch (tradeType) {
            case "SendMobileMessage"://注册验证码
                RegisterCodeBean registerCodeBean = JSON.parseObject(infoJson, RegisterCodeBean.class);
                registerCodeBean.setTradeType("SendMobileMessage");
                try {
                    ReturnData data = new SapConnector().GetRegisterCode(registerCodeBean);
                    if ("0".equals(data.getERRORCODE())) {
                        return ApiResult.resultWith(ResultCode.SUCCESS, data.getData());
                    }
                } catch (Exception e) {
                    return ApiResult.resultWith(ResultCode.ERROR, e.getMessage());
                }
                break;
            case "WechatBindCreate"://注册
                MemberRegisterBean memberRegisterBean = JSON.parseObject(infoJson, MemberRegisterBean.class);
                memberRegisterBean.setTradeType("WechatBindCreate");
                try {
                    ReturnData data = new SapConnector().Memberregister(memberRegisterBean);
                    if ("0".equals(data.getERRORCODE())) {
                        return ApiResult.resultWith(ResultCode.SUCCESS, data.getData());
                    }
                } catch (Exception e) {
                    return ApiResult.resultWith(ResultCode.ERROR, e.getMessage());
                }
                break;
            case "AuthenticateWechatRequest"://绑定验证码
                BindCodeBean bindCodeBean = JSON.parseObject(infoJson, BindCodeBean.class);
                bindCodeBean.setTradeType("AuthenticateWechatRequest");
                try {
                    ReturnData data = new SapConnector().GetbindCode(bindCodeBean);
                    if ("0".equals(data.getERRORCODE())) {
                        return ApiResult.resultWith(ResultCode.SUCCESS, data.getData());
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
                    if ("0".equals(data.getERRORCODE())) {
                        return ApiResult.resultWith(ResultCode.SUCCESS, data.getData());
                    }
                } catch (Exception e) {
                    return ApiResult.resultWith(ResultCode.ERROR, e.getMessage());
                }
                break;
            case "PointMaintenance": //积分维护
                MaintainPoint maintainPoint = JSON.parseObject(infoJson, MaintainPoint.class);
                maintainPoint.setTradeType("PointMaintenance");
                try {
                    ReturnData data = new SapConnector().MaintainPoint(maintainPoint);
                    if ("0".equals(data.getERRORCODE())) {
                        return ApiResult.resultWith(ResultCode.SUCCESS, data.getData());
                    }
                } catch (Exception e) {
                    return ApiResult.resultWith(ResultCode.ERROR, e.getMessage());
                }
                break;
            case "GetMemberInfo"://会员信息查询（包括现有积分）
                GetMemberInfoBean memberInfoBean = JSON.parseObject(infoJson, GetMemberInfoBean.class);
                memberInfoBean.setTradeType("GetMemberInfo");
                try {
                    ReturnData data = new SapConnector().getMemberInfo(memberInfoBean);
                    if ("0".equals(data.getERRORCODE())) {
                        return ApiResult.resultWith(ResultCode.SUCCESS, data.getData().getJSONArray("ResultContent").get(0));
                    } else {

                        log.info("url:" + DWTSysData.GET_MEMBER_INFO_URL + "&returndata:" + JSON.toJSONString(data));
                    }
                } catch (Exception e) {
                    return ApiResult.resultWith(ResultCode.ERROR, e.getMessage());
                }
                break;
            case "FansManage"://关注和取消关注
                FansBean fansBean = JSON.parseObject(infoJson, FansBean.class);
                try {
                    ReturnData data = new SapConnector().fansManage(fansBean);
                    return ApiResult.resultWith(ResultCode.SUCCESS, data);
                } catch (Exception e) {
                    return ApiResult.resultWith(ResultCode.ERROR, e.getMessage());
                }
            default:
                return ApiResult.resultWith(ResultCode.ERROR);
        }
        return ApiResult.resultWith(ResultCode.ERROR);
    }


}
