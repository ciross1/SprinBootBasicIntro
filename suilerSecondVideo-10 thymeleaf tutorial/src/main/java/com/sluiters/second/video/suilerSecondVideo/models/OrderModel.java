package com.sluiters.second.video.suilerSecondVideo.models;

public class OrderModel {

    private Long id = 0L;
    private String orderNumber = "";
    private    String productName = "";
    private float price =  0;
    private  int quantity = 0;


    public OrderModel() {
    }

    public OrderModel(Long id, String orderNumber, String productName, float price, int quantity) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }



    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
