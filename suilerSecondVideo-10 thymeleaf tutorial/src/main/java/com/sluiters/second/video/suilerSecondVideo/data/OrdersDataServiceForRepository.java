package com.sluiters.second.video.suilerSecondVideo.data;

import com.sluiters.second.video.suilerSecondVideo.models.OrderEntity;
import com.sluiters.second.video.suilerSecondVideo.models.OrderModel;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class OrdersDataServiceForRepository implements OrdersDataAccessInterface<OrderModel> {


    //Need a data source
    @Autowired
    OrdersRepositoryInterface ordersRepository;

    //And then JDBC that isa going to allow us to write queries:
    private JdbcTemplate jdbcTemplate;


    /*It initializes the JdbcTemplate with a DataSource — which is a factory for database connections.
Spring will automatically inject the DataSource bean here if configured properly.
*/
    public OrdersDataServiceForRepository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }


    ModelMapper modelMapper = new ModelMapper();

    @Override
    public OrderModel getById(long id) {
        //Optional means it can be null or not null. If its null that means the repository didnt find any id
      OrderEntity orderEntity =  ordersRepository.findById(id).orElse(null);

        // Since we want to return an OrderModel and we already have all the necessary data
// in the OrderEntity object, we can simply create a new OrderModel by passing the
// fields from OrderEntity into its constructor.

      /*OrderModel orderModel = new OrderModel(
              orderEntity.getId(),
              orderEntity.getOrderNo(),
              orderEntity.getProductName(),
              orderEntity.getPrice(),
              orderEntity.getQuantity()
      );*/

      //Or we can do this way, but in order to do different and with less code we need the dependency of ModelMapper.
        //This is just mapping all the different fields from the Entity into the orderModel
        OrderModel orderModel = modelMapper.map(orderEntity, OrderModel.class);


      return  orderModel;
    }

    @Override
    public List<OrderModel> getOrders() {
        //findAll() returns Iterable because of how CrudRepository is designed
        Iterable<OrderEntity> orderEntity= ordersRepository.findAll();

        List<OrderModel> orderModels = new ArrayList<>();
        for(OrderEntity item : orderEntity){
            orderModels.add(modelMapper.map(item, OrderModel.class));
        }

        return orderModels;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        List<OrderEntity> orderEntity= ordersRepository.findByProductNameContainingIgnoreCase(searchTerm);

        List<OrderModel> orderModels = new ArrayList<>();

        for(OrderEntity item : orderEntity){
            orderModels.add(modelMapper.map(item, OrderModel.class));
        }

        return orderModels;

    }

    @Override
    public long addOne(OrderModel newOrderModel) {

        OrderEntity orderEntity = modelMapper.map(newOrderModel, OrderEntity.class);
        orderEntity.setId(null); // VERY IMPORTANT to set this null for new inserts. If the id does not exist yet it will cause errors
        // So the best practice is to set it to null the id

        OrderEntity savedEntity = ordersRepository.save(orderEntity);

        return savedEntity.getId();
    }



    @Override
    public boolean deleteOrder(long id) {
        if(ordersRepository.existsById(id)){
            ordersRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {

        OrderEntity orderEntity = modelMapper.map(updateOrder, OrderEntity.class);
        OrderEntity result = ordersRepository.save(orderEntity);


        //We do again another conversion:
        OrderModel orderModelSaved = modelMapper.map(result, OrderModel.class);

        if(ordersRepository.existsById(idToUpdate)){
            return orderModelSaved;
        }else{
            return null;
        }




    }
}
