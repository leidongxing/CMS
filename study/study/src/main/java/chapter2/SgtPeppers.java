package chapter2;

import org.springframework.stereotype.Component;

//@Component("lonelyHeartsClub")
public class SgtPeppers implements CompactDisc {
    
	private String title = "the truth";
	private String artist = "leidx";

	public void play() {
		System.out.println("Playing "+ title+" by "+artist);
		
	}
	
}
