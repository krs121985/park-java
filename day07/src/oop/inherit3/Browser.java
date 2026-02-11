package oop.inherit3;

public class Browser {
	//필드
	private String url;

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	//메소드
	public void refresh() {
		System.out.println("새로고침 기능");
	}
	public void move() {
		if(this.url == null) {
			System.out.println("주소를 먼저 설정하세요");
		}
		else {
			System.out.println("주소 이동 : " + this.url);
		}
	}
	
	//생성자(생략)
}
