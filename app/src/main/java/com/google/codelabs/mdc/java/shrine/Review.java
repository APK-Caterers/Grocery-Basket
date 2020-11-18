package com.google.codelabs.mdc.java.shrine;

public class Review {
    String orderNo, name, review;

    public Review() {
    }

    public Review(String orderNo, String name, String review) {
        this.orderNo = orderNo;
        this.name = name;
        this.review = review;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
