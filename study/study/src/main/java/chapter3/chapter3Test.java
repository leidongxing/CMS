package chapter3;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles({"dev","prod"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DataSourceConfig.class)
public class chapter3Test  {
	
	@Autowired
	@Qualifier("DataSourceA")
	private DataSource db1;
	
	@Autowired 
	@Qualifier("DataSourceB")
	private DataSource db2;
	@Test
	public void dothis(){
	   System.out.println(db1);
	   System.out.println(db2);
	}
	
	
}
