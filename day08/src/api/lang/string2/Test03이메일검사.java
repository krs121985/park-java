package api.lang.string2;

public class Test03이메일검사 {
	public static void main(String[] args) {
		String email = "student@tjoeun.com";
		String regex = "^[a-z][a-z0-9]{4,19}@[a-z0-9]{1,}(\\.co\\.kr|\\.com|\\.net|\\.ac\\.kr|\\.go\\.kr|\\.org)$";
		System.out.println(email.matches(regex));
		//System.out.println(regex.matches(email));//안되는 명령
	}
}
