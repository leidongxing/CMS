package chapter5.data;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import chapter5.pojo.Order;

public interface OrderRepository extends MongoRepository<Order,String>{
    List<Order> findByCustomer(String c);
    List<Order> findByCustomerLike(String c);
    List<Order> findByCustomerAndType(String c,String t);
    List<Order> findByCustomerLikeAndType(String c,String t);
    
}
