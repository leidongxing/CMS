package chapter5.data;

import java.util.List;

import chapter5.pojo.Order;

public interface OrderOperations {
     List<Order> findOrderByType(String t);
}
