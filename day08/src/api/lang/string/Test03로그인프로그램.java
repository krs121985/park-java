package api.lang.string;

public class Test03로그인프로그램 {
	public static void main(String[] args) {
		
		//입력
		String id = "thejoeun";
		String password = "THE1234";
		
		//처리
		//boolean valid = 아이디와 비밀번호가 같나요?;
		boolean valid = id == "thejoeun" && password == "THE1234";
		
		//출력
		if(valid) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
		
	}
}
