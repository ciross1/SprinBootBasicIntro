package com.sluiters.second.video.suilerSecondVideo.data;


import com.sluiters.second.video.suilerSecondVideo.models.OrderModel;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.List;

//Let's define here all the methods that we are going to implement later:
//That's why this is an interface

//<T> is a generic type parameter. It means that this interface can work with any type you specify when you use it.
public interface OrdersDataAccessInterface <T> {

    public T getById(long id);
    public List<T> getOrders();
    public List<T>searchOrders(String searchTerm); //We need this parameter as a string to search it on the List
    public long addOne(T newOrderModel);  //It will return a number if we added the new Order
    public boolean deleteOrder(long id );
    public T updateOne(long idToUpdate, T updatedOrder);


}
