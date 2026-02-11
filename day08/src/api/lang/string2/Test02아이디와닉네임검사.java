package api.lang.string2;

import java.util.Scanner;

public class Test02아이디와닉네임검사 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//아이디 입력 및 검사
		System.out.print("아이디 : ");
		String id = sc.next();
		
		String idRegex = "^[a-z][a-z0-9]{4,19}$";
		if(id.matches(idRegex)) {
			System.out.println("올바른 형식의 아이디입니다");
		}
		else {
			System.out.println("아이디는 영문 소문자로 시작하며 숫자를 포함한 5~20자로 작성하세요");
		}
		
		//닉네임 입력 및 검사
		System.out.print("닉네임 : ");
		String nickname = sc.next();
		
//		String nicknameRegex = "^[ㄱ-ㅎㅏ-ㅣ가-힣0-9]{2,10}$";//자음과 모음까지 모두 포함
		String nicknameRegex = "^[가-힣0-9]{2,10}$";//온전한 글자만 포함
		if(nickname.matches(nicknameRegex)) {
			System.out.println("올바른 형식의 닉네임입니다");
		}
		else {
			System.out.println("닉네임은 한글 또는 숫자 2~10자로 작성하세요");
		}
		
	}
}








