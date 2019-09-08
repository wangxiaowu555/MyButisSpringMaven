package com.lovo.sh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="t_product")
public class ProductEntity {
    @GenericGenerator(name = "uuPId",strategy = "uuid")
    @GeneratedValue(generator = "uuPId")
    @Column(length = 32,name = "p_id")
    @Id
    private String productId;
    @Column(length = 32,name = "p_num")
    private String productNum;
    @Column(length = 32,name = "p_name")
    private String productName;
    @Column(length = 32,name = "p_type")
    private String productType;
    @Column(name = "p_inPrice")
    private int productInPrice;
    @Column(name = "p_outPrice")
    private int productOutPrice;
    @Column(name = "p_inTime")
    private String productInTime;
    @Column(name = "p_state")
    private int productState =1;

    public ProductEntity() {
    }

    public ProductEntity(String productNum, String productName, String productType, int productInPrice, int productOutPrice, String productInTime, int productState) {
        this.productNum = productNum;
        this.productName = productName;
        this.productType = productType;
        this.productInPrice = productInPrice;
        this.productOutPrice = productOutPrice;
        this.productInTime = productInTime;
        this.productState = productState;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getProductInPrice() {
        return productInPrice;
    }

    public void setProductInPrice(int productInPrice) {
        this.productInPrice = productInPrice;
    }

    public int getProductOutPrice() {
        return productOutPrice;
    }

    public void setProductOutPrice(int productOutPrice) {
        this.productOutPrice = productOutPrice;
    }

    public String getProductInTime() {
        return productInTime;
    }

    public void setProductInTime(String productInTime) {
        this.productInTime = productInTime;
    }

    public int getProductState() {
        return productState;
    }

    public void setProductState(int productState) {
        this.productState = productState;
    }
}
