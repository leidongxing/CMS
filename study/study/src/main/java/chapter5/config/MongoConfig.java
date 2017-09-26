package chapter5.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoConfig extends AbstractMongoConfiguration {

	@Autowired
	private Environment env;

	@Override
	protected String getDatabaseName() {
		return "testdb";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoCredential credential = MongoCredential.createMongoCRCredential(
				env.getProperty("mongo.username"),
				env.getProperty("mongo.database"),
				env.getProperty("mongo.password").toCharArray());
		return new MongoClient(new ServerAddress(
				env.getProperty("mongo.server"), Integer.parseInt(env.getProperty("port"))), 
				Arrays.asList(credential));
	}
	
	@Bean
	public MongoOperations mongoTemplate(Mongo mongo){
		return new MongoTemplate(mongo,env.getProperty("mongo.database"));
	}

}
