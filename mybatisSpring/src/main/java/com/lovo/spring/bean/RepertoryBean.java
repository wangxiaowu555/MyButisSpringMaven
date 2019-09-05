package com.lovo.spring.bean;

public class RepertoryBean {
    private int id;
    private String productName;
    private int productNum;

    public RepertoryBean(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public RepertoryBean(int id) {
        this.id = id;
    }

    public RepertoryBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
