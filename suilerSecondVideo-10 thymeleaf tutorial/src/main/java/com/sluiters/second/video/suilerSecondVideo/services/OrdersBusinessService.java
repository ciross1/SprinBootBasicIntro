package com.sluiters.second.video.suilerSecondVideo.services;

import com.sluiters.second.video.suilerSecondVideo.data.OrdersDataAccessInterface;
import com.sluiters.second.video.suilerSecondVideo.models.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class OrdersBusinessService  implements OrdersBusinessServiceInterface {


    @Autowired
    OrdersDataAccessInterface<OrderModel>  ordersDAO;


    @Override
    public void test() {

    }

    @Override
    public List<OrderModel> getOrders() {
        return ordersDAO.getOrders();
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return ordersDAO.searchOrders(searchTerm);
    }

    @Override
    public long addOne(OrderModel newOrderModel) {
        return ordersDAO.addOne(newOrderModel);
    }

    @Override
    public boolean deleteOrder(long id) {
        return ordersDAO.deleteOrder(id);
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updatedOrder) {
        return ordersDAO.updateOne(idToUpdate, updatedOrder);
    }

    @Override
    public OrderModel getById(long id) {
        return ordersDAO.getById(id);
    }


    @Override
    public void init() {
        System.out.println("Initial method has been called");
        ordersDAO.getOrders();
    }

    @Override
    public void destroy() {
        System.out.println("Initial method has been destroyed");

    }


}
