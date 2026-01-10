package com.setterExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class AudioTypes {

	@Autowired
	private MusicPlayer musicPlayer;

	public void data() {
		System.out.println(musicPlayer.audioType());
	}
	
	
}
