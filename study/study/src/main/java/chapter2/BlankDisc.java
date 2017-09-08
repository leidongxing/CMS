package chapter2;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("blankdisc")
public class BlankDisc implements CompactDisc {
    
	private String title;
	private String artist;
	private List<String> tracks;
	
    
	
	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

	public BlankDisc(
			@Value("#{systemProperties['disc.title']}") String title,
			@Value("#{systemProperties['disc.artist']}") String artist){
		this.title=title;
		this.artist=artist;
	}
	
	public void play() {
		System.out.println("Playing "+title+" by "+artist);	
		for(String track:tracks){
			System.out.println("-Track: " + track);
		}
	}

}
