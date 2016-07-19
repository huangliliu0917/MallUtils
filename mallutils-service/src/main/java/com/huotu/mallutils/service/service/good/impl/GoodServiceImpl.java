/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.service.service.good.impl;

import com.alibaba.fastjson.JSON;
import com.hot.datacenter.entity.client.UserLevel;
import com.hot.datacenter.entity.good.Good;
import com.hot.datacenter.entity.good.GoodLvPrice;
import com.hot.datacenter.entity.good.Product;
import com.hot.datacenter.model.good.DisRebateDesc;
import com.hot.datacenter.model.good.PriceLevelDesc;
import com.hot.datacenter.search.GoodSearch;
import com.hot.datacenter.service.AbstractCusCrudService;
import com.huotu.mallutils.service.repository.good.CusGoodRepository;
import com.huotu.mallutils.service.service.good.GoodService;
import com.huotu.mallutils.service.service.good.ProductService;
import com.huotu.mallutils.service.service.user.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.persistence.criteria.Predicate;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by allan on 5/16/16.
 */
@Service
public class GoodServiceImpl extends AbstractCusCrudService<Good, Long, GoodSearch> implements GoodService {
    @Autowired
    private CusGoodRepository goodRepository;
    @Autowired
    private LevelService levelService;
    @Autowired
    private ProductService productService;

    @PostConstruct
    private void init() {
        initRepository(Good.class);
    }

    @Override
    @Transactional
    public void batchSetUserPrice(Map<Integer, String> levelsToSet, List<Good> goods, int customerId) throws ScriptException {
//        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
//
//        List<Level> levels = levelService.findByCustomerId(customerId);
//        for (Good good : goods) {
//            double minPrice = 0, maxPrice = 0;
//            for (Product product : good.getProducts()) {
//                String userPriceInfo = "";
//                if (product.getGoodLvPriceList() == null || product.getGoodLvPriceList().size() == 0) {
//                    List<GoodLvPrice> goodLvPriceList = new ArrayList<>();
//                    for (Level level : levels) {
//                        String eval = levelsToSet.get(level.getId());
//                        double resultPrice = -1; //默认的价格
//                        if (!StringUtils.isEmpty(eval)) {
//                            resultPrice = getResultPrice(eval, product.getCost(), product.getPrice(), product.getMarketPrice(), scriptEngine);
//                        }
//                        GoodLvPrice goodLvPrice = new GoodLvPrice();
//                        goodLvPrice.setPrice(resultPrice);
//                        goodLvPrice.setCustomerId(good.getCustomerId());
//                        goodLvPrice.setGoodsId(good.getGoodId());
//                        goodLvPrice.setLevelId(level.getId());
//                        goodLvPriceList.add(goodLvPrice);
//                        //货品冗余字段
//
//                        userPriceInfo += level.getId() + ":" + resultPrice + ":" + goodLvPrice.getMaxIntegral() + "|";
//                        if (resultPrice > 0) {
//                            if (minPrice == 0 || minPrice >= resultPrice) {
//                                minPrice = resultPrice;
//                            }
//                            if (resultPrice >= maxPrice) {
//                                maxPrice = resultPrice;
//                            }
//                        }
//                    }
//                    product.setGoodLvPriceList(goodLvPriceList);
//                } else {
//                    for (GoodLvPrice goodLvPrice : product.getGoodLvPriceList()) {
//                        String eval = levelsToSet.get(goodLvPrice.getLevelId());
//                        double resultPrice = -1;
//                        if (!StringUtils.isEmpty(eval)) {
//                            resultPrice = getResultPrice(eval, product.getCost(), product.getPrice(), product.getMarketPrice(), scriptEngine);
//                            goodLvPrice.setPrice(resultPrice);
//                        }
//                        //货品冗余字段
//                        userPriceInfo += goodLvPrice.getLevelId() + ":" + resultPrice + ":" + goodLvPrice.getMaxIntegral() + "|";
//                        if (resultPrice > 0) {
//                            if (minPrice == 0 || minPrice >= resultPrice) {
//                                minPrice = resultPrice;
//                            }
//                            if (resultPrice >= maxPrice) {
//                                maxPrice = resultPrice;
//                            }
//                        }
//
//                    }
//                }
//                //处理冗余字段
//                product.setUserPriceInfo(userPriceInfo.substring(0, userPriceInfo.length() - 1));
//            }
//
//            productService.batchSave(good.getProducts());
//            //处理商品冗余字段
//            if (StringUtils.isEmpty(good.getPriceLevelDesc())) {
//                good.setPriceLevelDesc("[]");
//            }
//            List<PriceLevelDesc> priceLevelDescList = JSON.parseArray(good.getPriceLevelDesc(), PriceLevelDesc.class);
//            if (priceLevelDescList.size() > 0) {
//                for (PriceLevelDesc priceLevelDesc : priceLevelDescList) {
//                    priceLevelDesc.setMinPrice(minPrice);
//                    priceLevelDesc.setMaxPrice(maxPrice);
//                }
//            } else {
//                priceLevelDescList = new ArrayList<>();
//                for (Level level : levels) {
//                    PriceLevelDesc priceLevelDesc = new PriceLevelDesc();
//                    priceLevelDesc.setLevelId(level.getId());
//                    priceLevelDesc.setMinPrice(minPrice);
//                    priceLevelDesc.setMaxPrice(maxPrice);
//                    priceLevelDescList.add(priceLevelDesc);
//                }
//            }
//            good.setPriceLevelDesc(JSON.toJSONString(priceLevelDescList));
//            goodRepository.save(good);
//        }
    }

    @Override
    @Transactional
    public void batchSetUserPriceV2(Map<Long, String[]> levelsToSet, List<Good> goods, int customerId) throws Exception {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        List<UserLevel> levels = levelService.findByCustomerId(customerId);
        for (Good good : goods) {
            Map<Long, PriceLevelDesc> priceLevelDescMap = new HashMap<>();
            for (Product product : good.getProducts()) {
                String userPriceInfo = "";

                Map<Long, GoodLvPrice> goodLvPriceMap = new HashMap<>();
                for (UserLevel level : levels) {
                    double resultPrice = -1;
                    int resultIntegral = 0;

                    String[] evalInfo = levelsToSet.get(level.getId());
                    GoodLvPrice goodLvPrice = product.getGoodLvPriceMap().get(level.getId());
                    if (goodLvPrice == null) {
                        goodLvPrice = new GoodLvPrice();
                        goodLvPrice.setLevelId(level.getId());
                        goodLvPrice.setGoodsId(good.getGoodId());
                        goodLvPrice.setCustomerId(customerId);
                        goodLvPrice.setPrice(resultPrice);
                    }

                    if (evalInfo != null) {
                        String priceEval = evalInfo[0];
                        String integralEval = evalInfo[1];
                        if (!StringUtils.isEmpty(priceEval) && !priceEval.equalsIgnoreCase("none")) {
                            resultPrice = getResultPrice(priceEval, product.getCost(), product.getPrice(), product.getMarketPrice(), null, scriptEngine);
                            if (resultPrice < 0) {
                                throw new Exception("不可将会员价设置为负数,请检查输入的公式或值");
                            }
                            goodLvPrice.setPrice(resultPrice);
                        }
                        goodLvPrice.setPrice(resultPrice);
                        if (!StringUtils.isEmpty(integralEval) && !integralEval.equalsIgnoreCase("none")) {
                            resultIntegral = (int) getResultPrice(integralEval, product.getCost(), product.getPrice(), product.getMarketPrice(), null, scriptEngine);
                            if (resultIntegral < 0) {
                                throw new Exception("不可将最高可抵用积分设置为负数,请检查输入的公式或值");
                            }
                            goodLvPrice.setMaxIntegral(resultIntegral);
                        }
                        goodLvPrice.setMaxIntegral(resultIntegral);
                    }

                    goodLvPriceMap.put(level.getId(), goodLvPrice);

                    userPriceInfo += level.getId() + ":" + goodLvPrice.getPrice() + ":" + goodLvPrice.getMaxIntegral() + "|";

                    //处理商品冗余
                    PriceLevelDesc priceLevelDesc = priceLevelDescMap.get(level.getId());
                    if (priceLevelDesc == null) {
                        priceLevelDesc = new PriceLevelDesc();
                        priceLevelDesc.setLevelId(level.getId());
//                        priceLevelDesc.setMinPrice(goodLvPrice.getPrice());
//                        priceLevelDesc.setMaxPrice(goodLvPrice.getPrice());
//                        priceLevelDesc.setMinIntegral(goodLvPrice.getMaxIntegral());
//                        priceLevelDesc.setMaxIntegral(goodLvPrice.getMaxIntegral());
                    }
                    if (goodLvPrice.getPrice() > 0) {
                        if (priceLevelDesc.getMinPrice() <= 0 || priceLevelDesc.getMinPrice() >= goodLvPrice.getPrice()) {
                            priceLevelDesc.setMinPrice(goodLvPrice.getPrice());
                        }
                        if (goodLvPrice.getPrice() >= priceLevelDesc.getMaxPrice()) {
                            priceLevelDesc.setMaxPrice(goodLvPrice.getPrice());
                        }
                    }
                    if (goodLvPrice.getMaxIntegral() > 0) {
                        if (priceLevelDesc.getMinIntegral() <= 0 || priceLevelDesc.getMinIntegral() >= goodLvPrice.getMaxIntegral()) {
                            priceLevelDesc.setMinIntegral(goodLvPrice.getMaxIntegral());
                        }
                        if (goodLvPrice.getMaxIntegral() >= priceLevelDesc.getMaxIntegral()) {
                            priceLevelDesc.setMaxIntegral(goodLvPrice.getMaxIntegral());
                        }
                    }
                    if (goodLvPrice.getPrice() > 0 || goodLvPrice.getMaxIntegral() > 0) {
                        priceLevelDescMap.put(level.getId(), priceLevelDesc);
                    }
                }
                //等级货品价格关联表
                product.setGoodLvPriceMap(goodLvPriceMap);
                //货品会员价冗余
                product.setUserPriceInfo(userPriceInfo.substring(0, userPriceInfo.length() - 1));

                productService.save(product);
            }
            good.setPriceLevelDesc(JSON.toJSONString(priceLevelDescMap.values()));
            //保存商品冗余
            save(good);
        }
    }

    @Override
    public List<Good> findByCatIdExceptAct(String catId, int goodScenes) {
        return goodRepository.findByGoodCatAndGoodScenes(catId, goodScenes);
    }

    @Override
    public Page<Good> findAll(int pageIndex, int pageSize, GoodSearch goodSearch) {
        return findAll(goodSearch, new PageRequest(pageIndex - 1, pageSize, new Sort(Sort.Direction.DESC, "goodId")));
    }

    @Override
    public List<Good> findByIdIn(List<Long> goodIdList) {
        return goodRepository.findByGoodIdIn(goodIdList);
    }

    @Override
    public List<Good> findByBrandIdExceptAct(long brandId, int goodScenes) {
        return goodRepository.findByBrandIdAndGoodScenes(brandId, goodScenes);
    }

    @Override
    @Transactional
    public void batchSetRebate(String eval, List<Good> goods, int customerId) throws Exception {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        for (Good good : goods) {
            if (good.getRebateQuatoRatio() > 0) {
                List<DisRebateDesc> disRebateDescList = new ArrayList<>();
                for (Product product : good.getProducts()) {
                    double minUserPrice = 0;
                    //得到最低的会员价
                    if (product.getGoodLvPriceMap() != null) {
                        for (Map.Entry<Long, GoodLvPrice> entry : product.getGoodLvPriceMap().entrySet()) {
                            GoodLvPrice goodLvPrice = entry.getValue();
                            if (goodLvPrice.getPrice() > 0) {
                                if (minUserPrice == 0 || goodLvPrice.getPrice() < minUserPrice) {
                                    minUserPrice = goodLvPrice.getPrice();
                                }
                            }
                        }
                    }
                    //如果minUserPrice不大于0,则会员价就是销售价
                    minUserPrice = minUserPrice <= 0 ? product.getPrice() : minUserPrice;
                    double resultValue = getResultPrice(eval, product.getCost(), product.getPrice(), product.getMarketPrice(), minUserPrice, scriptEngine);
                    if (resultValue < 0) {
                        throw new Exception("不可将返利设置为负数,请检查输入的公式或值");
                    }
                    product.setDisRebateMode(0);
                    product.setDisUnifiedRebate(resultValue);
                    productService.save(product);

                    //商品冗余序列化字段
                    DisRebateDesc disRebateDesc = new DisRebateDesc();
                    disRebateDesc.setIsCustom(0);
                    disRebateDesc.setAmount(resultValue);
                    disRebateDesc.setProId(product.getProductId());
                    disRebateDescList.add(disRebateDesc);
                }
                good.setDisRebateDescList(disRebateDescList);
                this.save(good);
            }
        }
    }

    @Override
    public Specification<Good> specification(GoodSearch goodSearch) {
        Specification<Good> specification = ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.equal(root.get("customerId").as(Integer.class), goodSearch.getCustomerId()));
            predicates.add(cb.isFalse(root.get("disabled").as(Boolean.class)));
            if (!StringUtils.isEmpty(goodSearch.getGoodName())) {
                predicates.add(cb.like(root.get("name").as(String.class), "%" + goodSearch.getGoodName() + "%"));
            }
            if (goodSearch.getCatId() > 0) {
                predicates.add(cb.like(root.get("goodCat").get("catPath").as(String.class), "%|" + goodSearch.getCatId() + "|%"));
            }
            if (!StringUtils.isEmpty(goodSearch.getGoodBn())) {
                predicates.add(cb.like(root.get("barcode").as(String.class), "%" + goodSearch.getGoodBn() + "%"));
            }
            if (goodSearch.getBrand() > 0) {
                predicates.add(cb.equal(root.get("brandId").as(Integer.class), goodSearch.getBrand()));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        });
        return specification;
    }

    /**
     * 根据公式得到目标价格
     *
     * @param eval
     * @param cost        成本价
     * @param price       销售价
     * @param marketPrice 市场价
     * @param userPrice   会员价（设置返利的时候有效）
     * @return
     */
    private double getResultPrice(String eval, double cost, double price, double marketPrice, Double userPrice, ScriptEngine scriptEngine) throws ScriptException {
        eval = eval.replaceAll("a", String.valueOf(price));
        eval = eval.replaceAll("b", String.valueOf(cost));
        eval = eval.replaceAll("c", String.valueOf(marketPrice));
        if (userPrice != null) {
            eval = eval.replaceAll("d", String.valueOf(userPrice));
        }
        double resultPrice = Double.parseDouble(scriptEngine.eval(eval).toString());
        resultPrice = BigDecimal.valueOf(resultPrice).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); //目标价格

        return resultPrice;
    }
}
