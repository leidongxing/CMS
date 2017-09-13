package chapter5.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {
	
	@ExceptionHandler(Exception.class)
     public String handleException(){
		 System.out.println("-------Error-------");
    	 return "error/duplicate";
     }
}
