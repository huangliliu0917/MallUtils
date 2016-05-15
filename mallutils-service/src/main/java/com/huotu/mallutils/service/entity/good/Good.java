package com.huotu.mallutils.service.entity.good;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by allan on 5/15/16.
 */
@Entity
@Table(name = "Mall_Goods")
@Setter
@Getter
@Cacheable(false)
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Goods_Id")
    private Integer goodId;
    @ManyToOne
    @JoinColumn(name = "Cat_Id", referencedColumnName = "Cat_Id")
    private GoodCat goodCat;
    /**
     * 商品简介
     */
    @Column(name = "Brief")
    private String brief;
    @OneToMany(mappedBy = "good")
    private List<Product> products;
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
    @Column(name = "Customer_Id")
    private Integer customerId;
    @Column(name = "Supplier_Id")
    private Integer supplierId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Disabled")
    private boolean disabled;
    /**
     * 价格等级描述
     */
    @Column(name = "Price_LevelDesc")
    private String priceLevelDesc;
}
