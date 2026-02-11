package oop.basic1;

public class Test01객체지향 {
	public static void main(String[] args) {
		//카톡메세지 만들기
		//- String, int 한 개로는 표현할 수 없다
		//- 표현은 개발자가 정하기 나름
		//- 참조형 데이터
		
		//미리 정의해둔 메세지(Message) 클래스를 이용해서 "진짜 메세지"를 생성
		
		Message a = new Message();//메세지 1개를 생성해서 a라는 리모컨으로 제어하겠다
		//a -------> { sender : "임방실" , content : "안녕하세요" , time : "오후 7:29" , count : 0 }
		
		//a = "임방실";//a는 리모컨
		a.sender = "임방실";
		a.content = "안녕하세요";
		a.time = "오후 7:29";
		a.count = 0;
		
		//System.out.println(a);//리모컨 출력
		System.out.println(a.sender);//a에 연결된 객체의 sender 정보를 불러와서 출력하세요!
		System.out.println(a.content);//a에 연결된 객체의 content 정보를 불러와서 출력하세요!
		System.out.println(a.time);//a에 연결된 객체의 time 정보를 불러와서 출력하세요!
		System.out.println(a.count);//a에 연결된 객체의 count 정보를 불러와서 출력하세요!
		
		Message b = new Message();//메세지 1개를 생성해서 b라는 리모컨으로 제어하겠다
		//b -------> { sender : "임방실" , content : "카톡은 처음이에요" , time : "오후 7:39" , count : 0 }
		
		b.sender = "임방실";
		b.content = "카톡은 처음이에요";
		b.time = "오후 7:39";
		b.count = 0;
		
		System.out.println(b.sender);
		System.out.println(b.content);
		System.out.println(b.time);
		System.out.println(b.count);
		
		Message c = new Message();
		//c ----> { ... }
		
		c.sender = "임방실";
		c.content = "오늘 시간 있어요?";
		c.time = "오후 7:40";
		c.count = 0;
		
		System.out.println(c.sender);
		System.out.println(c.content);
		System.out.println(c.time);
		System.out.println(c.count);
	}
}









