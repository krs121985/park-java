package oop.inherit5;

public class MP3 extends MediaFile {

	private int duration;//재생시간(초)
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		if(duration < 0) return;
		this.duration = duration;
	}
	
	public MP3() {
		super("새 오디오 파일.mp3");
		this.setDuration(0); 
	}
	public MP3(String filename) {
		super(filename);
		this.setDuration(0);
	}
	public MP3(String filename, long filesize) {
		super(filename, filesize);
		this.setDuration(0);
	}

}
