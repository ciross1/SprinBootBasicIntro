package com.sluiters.second.video.suilerSecondVideo.models;


//OrderEntity is based on OrderModel
// Its purpose is to connect the OrderModel to the Orders table in the database


import jakarta.persistence.*;


@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;

    @Column(name="ORDER_NUMBER")
  private  String orderNumber = "";
    @Column(name="PRODUCT_NAME")
    private  String productName = "";
    @Column(name="PRICE")
    private  float price =  0;
    @Column(name="QTY")
    private int quantity = 0;



    //We need a constructor without parameters in this case
    public OrderEntity() {
    }

    public OrderEntity(Long id, String orderNumber, String productName, float price, int quantity) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", orderNo='" + orderNumber + '\'' +
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
