package com.mamahome360.mamaaps.model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginModel {


    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("wardAssigned")
    @Expose
    private String wardAssigned;
    @SerializedName("order_project_id")
    @Expose
    private String orderProjectId;
    @SerializedName("sub_category")
    @Expose
    private String subCategory;
    @SerializedName("order_id")
    @Expose
    private String orderId;
    @SerializedName("logistic_sub_ward")
    @Expose
    private String logisticSubWard;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWardAssigned() {
        return wardAssigned;
    }

    public void setWardAssigned(String wardAssigned) {
        this.wardAssigned = wardAssigned;
    }

    public String getOrderProjectId() {
        return orderProjectId;
    }

    public void setOrderProjectId(String orderProjectId) {
        this.orderProjectId = orderProjectId;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getLogisticSubWard() {
        return logisticSubWard;
    }

    public void setLogisticSubWard(String logisticSubWard) {
        this.logisticSubWard = logisticSubWard;
    }
}