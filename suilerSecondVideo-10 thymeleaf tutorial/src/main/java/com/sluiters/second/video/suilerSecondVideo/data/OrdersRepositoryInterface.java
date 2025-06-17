package com.sluiters.second.video.suilerSecondVideo.data;

import com.sluiters.second.video.suilerSecondVideo.models.OrderEntity;
import com.sluiters.second.video.suilerSecondVideo.models.OrderModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//For our Repository we are going to have  an entity that is called OrderEntity and the next parameter
// is going to be the id which in this case is going to be a Long data type

public interface OrdersRepositoryInterface  extends CrudRepository<OrderEntity, Long>{

    //use the CrudRepository class in Spring to do the data operations on mysql
    // already implies that we will use save, findall, findbyid, deletebid etc

    List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);




}
