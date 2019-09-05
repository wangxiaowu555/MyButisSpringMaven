package com.lovo.spring.bean;

public class OrderBean {
    private int id;
    private int sellNum;
    private int sellPrice;
    private RepertoryBean repertory;
    private int sellAllMoney;

    public OrderBean() {
    }

    public OrderBean(int sellNum, int sellPrice, RepertoryBean repertory, int sellAllMoney) {
        this.sellNum = sellNum;
        this.sellPrice = sellPrice;
        this.repertory = repertory;
        this.sellAllMoney = sellAllMoney;
    }

    public int getSellAllMoney() {
        return sellAllMoney;
    }

    public void setSellAllMoney(int sellAllMoney) {
        this.sellAllMoney = sellAllMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public RepertoryBean getRepertory() {
        return repertory;
    }

    public void setRepertory(RepertoryBean repertory) {
        this.repertory = repertory;
    }
}
