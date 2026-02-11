package oop.modifier.practice;

//도서 클래스
public class Book {
	//멤버 필드
	private String title;
	private String genre;
	private int page;
	private int price;
	private boolean rental;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		switch(genre) {
		case "기술", "소설", "자기계발":
			this.genre = genre;
		}
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page < 50) return;
		this.page = page;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price % 500 != 0) return;
		this.price = price;
	}
	//boolean은 게터메소드가 get이 아닌 is로 시작
	public boolean isRental() {
		return rental;
	}
	public void setRental(boolean rental) {
		this.rental = rental;
	}
	//가상의 Getter
	public String getState() {
		if(this.rental) return "대여가능";
		else return "대여중";
	}
	public int getPriceWithVat() {
		return this.price * 110 / 100;
	}
	public int getPricePerDay() {
		return this.price * 24;
	}
	public int getPricePerDayWithVat() {
		return this.getPriceWithVat() * 24;
	}
	
	//생성자
	public Book(String title, String genre, int page, int price) {
		this.setTitle(title);
		this.setGenre(genre);
		this.setPage(page);
		this.setPrice(price);
		this.setRental(true);//대여상태 미설정시 "대여 가능"으로 설정
	}
	public Book(String title, String genre, int page, int price, boolean rental) {
		this.setTitle(title);
		this.setGenre(genre);
		this.setPage(page);
		this.setPrice(price);
		this.setRental(rental);
	}
	
	//출력 메소드
	public void show() {
		System.out.println("<도서 정보>");
		System.out.println("도서명 : " + this.getTitle());
		System.out.println("장르 : " + this.getGenre());
		System.out.println("페이지 : " + this.getPage() + " pages");
		System.out.println("대여료 : 시간당 " + this.getPrice() + "원 (1일당 "+this.getPricePerDay()+"원)");
		System.out.println("→ 부가세 포함 : 시간당 " + this.getPriceWithVat() + "원 (1일당 " + this.getPricePerDayWithVat()+"원)");
		System.out.println("대여 상태 : " + this.getState());
	}
	
}
