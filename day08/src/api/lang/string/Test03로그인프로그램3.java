package api.lang.string;

import java.util.Scanner;

public class Test03로그인프로그램3 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		
		//처리
		//boolean valid = id.equals("thejoeun") && password.equals("THE1234");
		boolean valid = id.equalsIgnoreCase("thejoeun") && password.equals("THE1234");
		//boolean valid = id.toLowerCase().equals("thejoeun") && password.equals("THE1234");
		
		//출력
		if(valid) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
		
	}
}
