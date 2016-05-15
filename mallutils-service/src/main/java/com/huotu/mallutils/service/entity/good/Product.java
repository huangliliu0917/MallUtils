package com.huotu.mallutils.service.entity.good;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by allan on 5/15/16.
 */
@Entity
@Table(name = "Mall_Products")
@Setter
@Getter
@Cacheable(false)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_Id")
    private Integer productId;
    @ManyToOne
    @JoinColumn(name = "Goods_Id")
    private Good good;

    /**
     * 规格
     */
    @Column(name = "Pdt_Desc")
    private String standard;

    /**
     * 成本价
     */
    @Column(name = "Cost")
    private double cost;
    /**
     * 销售价
     */
    @Column(name = "Price")
    private double price;
    @Column(name = "Mktprice")
    private double marketPrice;
    @Column(name = "Name")
    private String name;

    /**
     * 用户会员价信息
     */
    @Column(name = "UserPriceInfo")
    private String userPriceInfo;
    /**
     * 用户返利信息
     */
    @Column(name = "UserIntegralInfo")
    private String userIntegralInfo;
    
    @ElementCollection
    @CollectionTable(
            name = "Mall_Goods_Lv_Price",
            joinColumns = @JoinColumn(name = "Product_Id")
    )
    private List<GoodLvPrice> goodLvPriceList;
}
