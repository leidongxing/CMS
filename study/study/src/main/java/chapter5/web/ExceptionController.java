package chapter5.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionController {
	
	
	@ExceptionHandler(SpittleNotFoundException.class)
    public ResponseEntity<Error> spittleNotFound(SpittleNotFoundException e){
    	long spittleId = e.getSpittleId();
        Error error = new Error(4,"Spittle [" +spittleId+"] not found");
        return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
    }
}
