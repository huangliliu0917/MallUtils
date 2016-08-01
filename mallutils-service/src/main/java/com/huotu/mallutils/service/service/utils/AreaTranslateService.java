/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hot.datacenter.entity.MallAreaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by allan on 8/1/16.
 */
@Service
public class AreaTranslateService {
    @Autowired
    private MallAreaService areaService;

    public List<TaobaoArea> taobaoAreas() throws IOException {
        InputStream inputStream = AreaTranslateService.class.getClassLoader().getResourceAsStream("taobao_area.txt");

        String taobaoAreaStr = StreamUtils.copyToString(inputStream, Charset.forName("utf-8"));

        JSONObject jsonObject = JSON.parseObject(taobaoAreaStr);

        JSONArray jsonArray = jsonObject.getJSONObject("areas_get_response").getJSONObject("areas").getJSONArray("area");

        return JSON.parseArray(jsonArray.toJSONString(), TaobaoArea.class);
    }

    private List<TaobaoArea> getAreasByParentId(List<TaobaoArea> taobaoAreas, String parentId) {
        List<TaobaoArea> subAreas = taobaoAreas.stream()
                .filter(taobaoArea -> parentId.equals(taobaoArea.getParentId()))
                .collect(Collectors.toList());
        subAreas.sort((p1, p2) -> p1.getId().compareTo(p2.getId()));

        return subAreas;
    }

    /**
     * 转换淘宝的地区（前段）
     *
     * @throws IOException
     */
    public void translateArea() throws IOException {
        List<TaobaoArea> taobaoAreas = taobaoAreas();

        //得到省和直辖市
        List<TaobaoArea> provinces = getAreasByParentId(taobaoAreas, "1");
        JSONArray pJsonArray = new JSONArray();
        for (TaobaoArea province : provinces) {
            JSONObject pJsonObject = new JSONObject();
            pJsonObject.put("id", province.getId());
            pJsonObject.put("p", province.getName());

            //得到市
            List<TaobaoArea> cities = getAreasByParentId(taobaoAreas, province.getId());

            JSONArray cJsonArray = new JSONArray();
            for (TaobaoArea city : cities) {
                JSONObject cJsonObject = new JSONObject();
                cJsonObject.put("id", city.getId());
                cJsonObject.put("n", city.getName());

                //得到区
                List<TaobaoArea> districts = getAreasByParentId(taobaoAreas, city.getId());
                if (districts.size() > 0) {
                    JSONArray dJsonArray = new JSONArray();
                    for (TaobaoArea district : districts) {
                        JSONObject dJsonObject = new JSONObject();
                        dJsonObject.put("id", district.getId());
                        dJsonObject.put("s", district.getName());
                        dJsonArray.add(dJsonObject);
                    }
                    cJsonObject.put("a", dJsonArray);
                }
                cJsonArray.add(cJsonObject);
            }
            pJsonObject.put("c", cJsonArray);
            pJsonArray.add(pJsonObject);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("citylist", pJsonArray);
        String newAreaStr = jsonObject.toJSONString();
        String file = "/Users/allan/Desktop/taobao_area.js";
        createJs(file, newAreaStr);
    }

    /**
     * 转换淘宝地区到火图的格式
     *
     * @throws IOException
     */
    public void translateRegionNode() throws IOException {
        List<TaobaoArea> taobaoAreas = taobaoAreas();
        List<HotArea> hotAreas = new ArrayList<>();
        setSubRegion(hotAreas, taobaoAreas, "1");

        String newAreaStr = JSON.toJSONString(hotAreas);
        String file = "/Users/allan/Desktop/regionNode.js";
        newAreaStr = "var _znodes = " + newAreaStr;
        createJs(file, newAreaStr);
    }

    /**
     * 转换到数据库
     *
     * @throws IOException
     */
    public void translateAreaToDatabase() throws IOException {
        List<TaobaoArea> taobaoAreas = taobaoAreas();

        List<HotArea> hotAreas = new ArrayList<>();
        setSubRegion(hotAreas, taobaoAreas, "1");

        List<MallAreaData> areaDatas = new ArrayList<>();
        hotAreas.forEach(area -> {
            MallAreaData areaData = new MallAreaData();
            areaData.setId(area.getId());
            areaData.setName(area.getName());

            if (!"0".equals(area.getPId())) {
                areaData.setParentId(area.getPId());
            }
            areaData.setLevel(area.getDepth());
            areaDatas.add(areaData);
        });
        areaService.save(areaDatas);
    }

    private void setSubRegion(List<HotArea> hotAreas, List<TaobaoArea> taobaoAreas, String parentId) {
        List<TaobaoArea> subAreas = getAreasByParentId(taobaoAreas, parentId);
        if (subAreas.size() > 0) {
            subAreas.forEach(subArea -> {
                HotArea hotArea = new HotArea();
                hotArea.setId(subArea.getId());
                hotArea.setName(subArea.getName());
                hotArea.setPId(subArea.getParentId());
                if ("1".equals(parentId)) {
                    hotArea.setPId("0");
                }
                hotArea.setDepth(subArea.getType() - 1);
                hotAreas.add(hotArea);

                setSubRegion(hotAreas, taobaoAreas, subArea.getId());
            });
        }
    }

    private void createJs(String filePath, String content) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file);
        StreamUtils.copy(content.getBytes("utf-8"), outputStream);
    }
}
