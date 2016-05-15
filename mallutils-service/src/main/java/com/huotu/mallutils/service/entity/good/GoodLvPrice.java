package com.huotu.mallutils.service.entity.good;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by allan on 5/15/16.
 */
@Embeddable
@Setter
@Getter
public class GoodLvPrice {
    @Column(name = "Level_Id")
    private int levelId;
    @Column(name = "Goods_Id")
    private int goodsId;
    @Column(name = "Customer_Id")
    private int customerId;
    @Column(name = "Price")
    private double price;
    @Column(name = "MaxIntegral")
    private int maxIntegral;
}
