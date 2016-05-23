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
 * Created by allan on 5/23/16.
 */
@Setter
@Getter
public class DWTSysData {
    private String BASIS_URL = "http://180.168.134.198:8080/Cherry/webservice/cherryws";

    private String REGISTER_URL = "http://180.168.134.198:8080/CherryBatch/webservice/cherryws";
    private String appID = "weshop";
    private String brandCode = "OJM";
    private String AESKey = "KwBHRgqFEygN1VZC2TR7Qw==";
}
