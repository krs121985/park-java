package oop.inherit3;

public class Test01브라우저정보 {
	public static void main(String[] args) {
		Chrome c = new Chrome();
		c.setUrl("https://www.google.com");
		c.move();
		c.refresh();
		c.chromeStore();
		c.develop();
		
		Edge e = new Edge();
		e.setUrl("https://www.microsoft.com");
		e.move();
		e.refresh();
		e.fullScreen();
		
		Whale w = new Whale();
		w.setUrl("https://www.naver.com");
		w.move();
		w.refresh();
		w.papago();
		w.naverSearch();
	}
}
