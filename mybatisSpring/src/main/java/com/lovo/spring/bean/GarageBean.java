package com.lovo.spring.bean;

public class GarageBean {
    private int id;
//    总车位
    private int stallNum;
//    剩余车位
    private int surplusStallNum;

    public GarageBean() {
    }

    public GarageBean(int stallNum, int surplusStallNum) {
        this.stallNum = stallNum;
        this.surplusStallNum = surplusStallNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStallNum() {
        return stallNum;
    }

    public void setStallNum(int stallNum) {
        this.stallNum = stallNum;
    }

    public int getSurplusStallNum() {
        return surplusStallNum;
    }

    public void setSurplusStallNum(int surplusStallNum) {
        this.surplusStallNum = surplusStallNum;
    }
}
