package oop.inherit4;

//상속 시 주의사항(상위클래스 편)
//- 이 클래스의 목적은 "물려주는 것"이기 때문에 어떻게 물려줄 것인지에 대한 고민을 해봐야 한다
//  - 멤버 필드 : 접근 제한을 어디까지 설정할 것인지
//  - 멤버 메소드 : 재정의 허용 여부를 설정할 것인지
//  - 생성자 : 필수로 설정해야 할 항목에 대해서 지정
public class IPhone {
//	필드 (ex : 전화번호)
//	- 만약 한국 휴대폰 번호 양식으로만 설정 가능하며 변경이 불가능하다면..? private으로 강력하게 차단
//	private String number;//상속 관계여도 접근을 못함
//	public String getNumber() {
//		return number;
//	}
//	public void setNumber(String number) {
//		this.number = number;
//	}
	
//	- 만약 다양한 국가에서 쓰일 수 있고 각자의 기준에 따라서 번호가 달라지는 경우라면...
//	- 지금 확정하기 어렵기 때문에 접근을 강력하게 막을 필요가 없다 (하위 클래스에게는 관대해야함)
	protected String number;//상속 관계라면 자유롭게 접근 가능
	
	
//	메소드
//	- 앞으로 변경이 가능한지 불가능한지를 미리 고민해서 정해야 한다
//	- 변경은 용어로 메소드 재정의(override, 오버라이드)라고 부름. 오버로딩과는 다른 개념
	
//	(ex) 애플페이라는 기능을 만들건데 이건 시리즈와 무관하게 모두 다 똑같아야 한다!
	public final void applePay() {//절대로 재정의 불가
		System.out.println("애플페이 기능");
	}
	
//	(ex) 사진촬영 기능을 만들건데 이건 시리즈마다 달라질 수 있다!
	public void camera() {
		System.out.println("카메라 기능");
	}

	
	
//	생성자
//	- 필드 중에서 반드시 설정해야 하는 항목을 지정
//	- 앞으로 이 클래스를 상속받는 모든 클래스들도 이 규칙을 따라야 함
//	- 생성자를 만든다는건 "시리즈의 필수항목"을 만드는 것과 같음
	public IPhone(String number) {
		this.number = number;
	}
	
}


















