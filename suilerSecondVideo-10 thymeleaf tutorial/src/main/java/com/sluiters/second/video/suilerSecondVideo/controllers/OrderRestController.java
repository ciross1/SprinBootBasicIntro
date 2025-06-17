package com.sluiters.second.video.suilerSecondVideo.controllers;

import com.sluiters.second.video.suilerSecondVideo.models.OrderModel;
import com.sluiters.second.video.suilerSecondVideo.services.OrdersBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //We have to change to RestController because we are just going to work with data
@RequestMapping("/api/orders")
public class OrderRestController {


    OrdersBusinessServiceInterface service;

    @Autowired
    public OrderRestController(OrdersBusinessServiceInterface service){
        this.service = service;
    }



    @GetMapping("/")
    public List<OrderModel> showAllOrders(Model model){


       List<OrderModel> orders = service.getOrders();

       //In ths case we are just going to retun the list itself. We are not working anymore with models or Thymeleaf
        return  orders;
    }

    @GetMapping("/search/{searchTerm}")
    public List<OrderModel>showSearchedTerm(@PathVariable(name="searchTerm") String term){
        List<OrderModel> showSearchedOrder = service.searchOrders(term);

        return showSearchedOrder;
    }

    @PostMapping("/")  //Post is when we are trying something to the database
    /*The annotation @RequestBody tells Spring to:
Convert the incoming HTTP request's JSON body into a Java object.*/
    public long addOrder(@RequestBody  OrderModel model){

        //Remember to use post to add a new model.
        return service.addOne(model);
    }


    @GetMapping("/{id}")
    public OrderModel getOrderById(@PathVariable(name = "id") long id){
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public  boolean deleteOrderById(@PathVariable(name="id") long id){
        return service.deleteOrder(id);
    }

    @PutMapping("/update/{id}")
    //Put is for modifying.In postman is the same
    public OrderModel update(@RequestBody OrderModel orderModel, @PathVariable long id){
        return service.updateOne(id, orderModel);
    }



}
