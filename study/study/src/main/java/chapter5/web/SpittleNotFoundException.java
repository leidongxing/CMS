package chapter5.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="spittle not found")
public class SpittleNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4231287418683053114L;
    
	private long spittleId;
	public SpittleNotFoundException(long spittleId) {
		this.spittleId = spittleId;
	}
	public long getSpittleId() {
		return spittleId;
	}
}
