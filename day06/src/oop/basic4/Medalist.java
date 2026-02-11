package oop.basic4;

public class Medalist {
	//멤버 필드 : 데이터 저장용 변수
	String name;//이름
	String event;//종목
	String type;//구분
	int gold;//금메달
	int silver;//은메달
	int bronze;//동메달
	
	//멤버 메소드 : 필드를 이용하는 기능(코드) 덩어리
	//- this : 다른 멤버필드 혹은 메소드를 지칭할 때 사용하는 키워드 (주인공 키워드)
	void init(String name, String event, String type, int gold, int silver, int bronze) {
		this.name = name;//주인공(this)의 name에 name을 설정하세요!
		this.event = event;
		this.type = type;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	void show() {
		System.out.println("이름 : " + this.name);
		System.out.println("종목 : " + this.event);
		System.out.println("구분 : " + this.type);
		System.out.println("금메달 : " + this.gold + "개");
		System.out.println("은메달 : " + this.silver + "개");
		System.out.println("동메달 : " + this.bronze + "개");
	}
}
