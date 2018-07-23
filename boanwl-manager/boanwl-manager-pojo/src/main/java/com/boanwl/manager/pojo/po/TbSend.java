package com.boanwl.manager.pojo.po;

import java.util.Date;

public class TbSend {
    private String seId;

    private String senderName;

    private String senderIdNumber;

    private String senderPhone;

    private String senderAddress;

    private String senderAdderssDetail;

    private String receiverName;

    private String receiverPhone;

    private String receiverAddress;

    private String receiverAdderssDetail;

    private Double cargoWeight;

    private Date orderCrateData;

    private String senderRemarks;

    private Double totalPrice;

    private String seState;

    public String getSeId() {
        return seId;
    }

    public void setSeId(String seId) {
        this.seId = seId == null ? null : seId.trim();
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    public String getSenderIdNumber() {
        return senderIdNumber;
    }

    public void setSenderIdNumber(String senderIdNumber) {
        this.senderIdNumber = senderIdNumber == null ? null : senderIdNumber.trim();
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone == null ? null : senderPhone.trim();
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress == null ? null : senderAddress.trim();
    }

    public String getSenderAdderssDetail() {
        return senderAdderssDetail;
    }

    public void setSenderAdderssDetail(String senderAdderssDetail) {
        this.senderAdderssDetail = senderAdderssDetail == null ? null : senderAdderssDetail.trim();
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress == null ? null : receiverAddress.trim();
    }

    public String getReceiverAdderssDetail() {
        return receiverAdderssDetail;
    }

    public void setReceiverAdderssDetail(String receiverAdderssDetail) {
        this.receiverAdderssDetail = receiverAdderssDetail == null ? null : receiverAdderssDetail.trim();
    }

    public Double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public Date getOrderCrateData() {
        return orderCrateData;
    }

    public void setOrderCrateData(Date orderCrateData) {
        this.orderCrateData = orderCrateData;
    }

    public String getSenderRemarks() {
        return senderRemarks;
    }

    public void setSenderRemarks(String senderRemarks) {
        this.senderRemarks = senderRemarks == null ? null : senderRemarks.trim();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSeState() {
        return seState;
    }

    public void setSeState(String seState) {
        this.seState = seState == null ? null : seState.trim();
    }
}