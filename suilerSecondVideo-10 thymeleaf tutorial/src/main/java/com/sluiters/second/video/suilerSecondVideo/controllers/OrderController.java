package com.sluiters.second.video.suilerSecondVideo.controllers;

import com.sluiters.second.video.suilerSecondVideo.models.OrderModel;
import com.sluiters.second.video.suilerSecondVideo.models.SearchModel;
import com.sluiters.second.video.suilerSecondVideo.services.OrdersBusinessServiceInterface;
import jakarta.validation.Valid;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {


    OrdersBusinessServiceInterface service;

    @Autowired
    public OrderController(OrdersBusinessServiceInterface service){
        this.service = service;
    }



    @GetMapping("/")
    public String showAllOrders(Model model){


       List<OrderModel> orders = service.getOrders();


        //here we are going to set the title: It will replace the title from the template with the text/value
        model.addAttribute("title", "Here is what I want to do this summer");
        //here very similar, it will replace the orders from the template with our list of orders
        //Remember that for iterating through each field of the class we have to use for example
        //  <tr th:each="order : ${orders}"> and ${order.id}. This time we are not using *{id} because
        // *{...} — Form-Binding Expression (Object field binding)
        model.addAttribute("orders", orders);


        return "orders";
    }

    @GetMapping("/showNewOrderForm")
    public String showNewOrderForm(Model model){
        //model.addAttribute() //we need a model so we can pass data to this form

        model.addAttribute("order", new OrderModel());


        return "addNewOrderForm";
    }

    @PostMapping("/addNew")
    public String addNew(@Valid OrderModel newOrder, BindingResult bindingResult, Model model){

        //In the parameter, we have to check if the inputs are valid from the order
        //Then binding means, im going to bind all the inputs on my form to the newOrder (relation has to be connected)
        //Then we also need a Model so we can send more data to the next page

        //processing here:

        // add to the database
        service.addOne(newOrder);

        //show all the orders
        List<OrderModel> orders = service.getOrders();
        model.addAttribute("orders", orders);

        return "orders";
    }


    @GetMapping("/showSearchForm")
    public String showNewForm(Model model){

        model.addAttribute("searchModel", new SearchModel());

        return  "searchForm";
    }

    //PostMapping because its responding to the form
    @PostMapping("/search")
    public String search(@Valid SearchModel searchModel, BindingResult bindingResult, Model model){

        //Im going to save the result in a string .So it should contain the search wherever the user typed in that form
        String searchTerm = searchModel.getSearchTerm();

        //Now let us use the service which help us to get the  search orders:
        List<OrderModel> orders = service.searchOrders(searchTerm);

        // And finally the model:
        model.addAttribute("orders", orders );


        return "orders";
    }


    @GetMapping("/admin")
    public String showAdminPage(Model model){


        List<OrderModel> orders = service.getOrders();
        model.addAttribute("orders", orders);

        return  "ordersAdmin";

    }

    @PostMapping("/editForm")
    public String editForm(OrderModel orderModel, Model model){

        model.addAttribute("orderModel",orderModel );
        model.addAttribute("title", "Edit order");

        return "editForm";


    }



    @PostMapping("/doUpdate")
    public String updateOrder(@Valid OrderModel order, BindingResult bindingResult, Model model){

        //Update the order:
        service.updateOne(order.getId(), order);

        // get updated list of al the orders
        List<OrderModel> orders = service.getOrders();

        //display all orders
        model.addAttribute("orders", orders);


                return "ordersAdmin";
    }


    @PostMapping("/delete")
    public String deleteOrder(OrderModel orderModel, Model model){

        //In this case we do not really need @Valid or binding... in a delete operation, you usually only need the ID —
        // and there's not much to validate. You're not collecting or validating form input like name, quantity, etc.



        //delete Order:
        service.deleteOrder(orderModel.getId());

        //get Updated list of all orders
        List<OrderModel> orders = service.getOrders();

        // display the list of orders:
        model.addAttribute("orders", orders);

        return "ordersAdmin";

    }








}
