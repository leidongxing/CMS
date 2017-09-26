package chapter5.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="")
public class MongoConfig  extends AbstractMongoConfiguration{
//	 @Bean
//     public MongoClientFactoryBean mongo() {
//    	 MongoClientFactoryBean mongo = new MongoClientFactoryBean();
//    	 mongo.setHost("localhosts");
//    	 return mongo;
//     }
//	 
//	 @Bean 
//	 public MongoOperations mongoTemplate(Mongo mongo) {
//		 return new MongoTemplate(mongo,"malordb");
//	 }

	@Override
	protected String getDatabaseName() {
		return "malordb";
	}
	
	@Override
	public Mongo mongo() throws Exception{
		return new MongoClient();
	}
}
