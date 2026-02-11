package oop.keyword5;

//회원
public class Member {
	//필드 - 회원의 정보
	private final String id;//아이디는 변경되면 안된다
	private String password;
	private String nickname;
	
	//만약에 필드에 final이 붙은 항목이 있으면 생성자에서 반드시 초기화가 이루어져야 한다
	public Member(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	
//	final 필드는 세터메소드를 만들 수 없다
//	public void setId(String id) {
//		this.id = id;
//	}
}
