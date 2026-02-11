package api.lang.string2;

public class Test05비밀번호검사 {
	public static void main(String[] args) {
		//비밀번호 규칙
		//1. 알파벳 대문자, 소문자, 숫자, 특수문자로 구성된 8~16자
		//2. 반드시 알파벳 대문자가 1개 이상 포함되어야 한다
		//3. 반드시 알파벳 소문자가 1개 이상 포함되어야 한다
		//4. 반드시 숫자가 1개 이상 포함되어야 한다
		//5. 반드시 특수문자가 1개 이상 포함되어야 한다
		String password = "Testuser1!";//true
//		String password = "Testuser1";//false(특수문자 없음)
//		String password = "testuser1!";//false(대문자 없음)
		String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$])[A-Za-z0-9!@#$]{8,16}$";
		System.out.println(password.matches(regex));
	}
}
