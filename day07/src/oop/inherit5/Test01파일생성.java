package oop.inherit5;

public class Test01파일생성 {
	public static void main(String[] args) {
		MP4 mp4 = new MP4();
		mp4.information();
		mp4.execute();
		mp4.forward();
		mp4.rewind();
		
		MP3 mp3 = new MP3("학교종.mp3");
		mp3.information();
		mp3.execute();
		mp3.forward();
		mp3.rewind();
		
		HWP hwp = new HWP();
		hwp.information();
		hwp.execute();
		hwp.preview();
		
		PPT ppt = new PPT("학습자료.pptx");
		ppt.information();
		ppt.execute();
		ppt.slideShow();
	}
}
