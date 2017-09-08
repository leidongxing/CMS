package chapter4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Chapter4Main {
	 public static void main(String[]args){
		 ApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
		 Performance p =(Performance) context.getBean("p");  
		 p.perform();
		 
	 }
}
