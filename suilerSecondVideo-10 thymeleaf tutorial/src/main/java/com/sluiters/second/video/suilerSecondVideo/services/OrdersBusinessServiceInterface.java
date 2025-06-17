package com.sluiters.second.video.suilerSecondVideo.services;

import com.sluiters.second.video.suilerSecondVideo.models.OrderModel;

import java.util.List;

/*An interface in Java is like a contract or blueprint that says:
“Any class that wants to implement me must provide certain methods.
An interface defines what a class should do, but not how it does it.”*/

public interface OrdersBusinessServiceInterface {

    public void test();
    public void init();
    public void destroy();


    // future methods:
    //SearchOrders(String searchTerm)
    // addOrders (new OrderModel)
    // deleteOrder(Long id)
    //Update order
    //GetOneOrder(Long id)

    public OrderModel getById(long id);
    public List<OrderModel> getOrders();
    public List<OrderModel>searchOrders(String searchTerm); //We need this parameter as a string to search it on the List
    public long addOne(OrderModel newOrderModel);  //It will return a number if we added the new Order
    public boolean deleteOrder(long id );
    public OrderModel updateOne(long idToUpdate, OrderModel updatedOrder);
}
