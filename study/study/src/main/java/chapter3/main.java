package chapter3;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter2.BlankDisc;
public class main {
    public static void main(String[] args){
//    	ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
//    	DataSource d=(DataSource)context.getBean("DataSourceA");
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(ExpressiveConfig.class);
    	BlankDisc d=(BlankDisc)context.getBean("demo");
    	d.play();
    }
}
