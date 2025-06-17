package com.sluiters.second.video.suilerSecondVideo;

import com.sluiters.second.video.suilerSecondVideo.data.OrdersDataAccessInterface;
import com.sluiters.second.video.suilerSecondVideo.data.OrdersDataServiceForRepository;
import com.sluiters.second.video.suilerSecondVideo.services.OrdersBusinessServiceInterface;
import com.sluiters.second.video.suilerSecondVideo.services.OrdersBusinessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean(name = "ordersBusinessService", initMethod = "init", destroyMethod = "destroy")
   // @RequestScope //This will call it and destroy it at the same time
    //@SessionScope // Create a separate instance of this bean for each HTTP session." it wil be called but not destroyed
    //Useful for shopping list

    @RequestScope
    public OrdersBusinessServiceInterface getOrdersBusiness(){
        //For selecting which class do we want. Remember to delete @Service on the class so this config would work
        return new OrdersBusinessService();
    }


DataSource dataSource;

    @Bean(name = "ordersDAO")
    @RequestScope
    public OrdersDataAccessInterface OrdersData( ){
        //For selecting which class do we want. Remember to delete @Service on the class so this config would work
        return new OrdersDataServiceForRepository(dataSource);

    }


}
