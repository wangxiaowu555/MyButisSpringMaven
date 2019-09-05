package com.lovo.spring.bean;

public class CarInfoBean {
    private int id;
    private String plateNumber;
    private String stopDate;
    private String outDate;
    private long stopTime;
    private long outTime;
    private int stopMoney;

    public CarInfoBean(String plateNumber, String stopDate, String outDate, long stopTime, long outTime, int stopMoney) {
        this.plateNumber = plateNumber;
        this.stopDate = stopDate;
        this.outDate = outDate;
        this.stopTime = stopTime;
        this.outTime = outTime;
        this.stopMoney = stopMoney;
    }

    public CarInfoBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public long getOutTime() {
        return outTime;
    }

    public void setOutTime(long outTime) {
        this.outTime = outTime;
    }

    public int getStopMoney() {
        return stopMoney;
    }

    public void setStopMoney(int stopMoney) {
        this.stopMoney = stopMoney;
    }
}
