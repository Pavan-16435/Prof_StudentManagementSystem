package com.setterExample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


interface MusicPlayer{
	
	String audioType();
	
}

@Component("mp3")
@Qualifier

class mp3 implements MusicPlayer{
	
	@Override
	public String audioType() {
		
		return "The audio type is mp3";
		
	}
}

@Component("wav")
@Primary
class wav implements MusicPlayer{
	
	@Override
	public String audioType() {
		
		return "The audio type is wav";
		
	}
}