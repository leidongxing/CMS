package chapter5.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import chapter5.pojo.Order;

public class OrderRepositoryImpl implements OrderOperations  {
    @Autowired
	private MongoOperations mongo;
	
    public List<Order> findOrderByType(String t) {
		String type=t.equals("NET")? "WEB":t;
		Criteria where = Criteria.where("type").is(t);
		Query query = Query.query(where);
		return mongo.find(query, Order.class);
	}

}
