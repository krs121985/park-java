package api.util.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 {
	public static void main(String[] args) {
		
		//저장소를 만들고 아이디와 비밀번호를 저장 (향후에는 데이터베이스가 될 것)
		Map<String, String> database = new HashMap<>();
		database.put("tjadmin", "admin1234");
		database.put("tjstudent", "student1234");
		database.put("tjteacher", "teacher1234");
		database.put("tjmanager", "manager1234");
		
		//아이디와 비밀번호를 준비
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		sc.close();
		
		//로그인이란?
		//- 프로그램에 저장된 아이디=비밀번호 와 동일한 아이디=비밀번호가 입력된 경우 성공하는 기능
		
		//boolean login = database.containsKey(id) && database.containsValue(password);//잘못된 코드
		boolean login = database.containsKey(id) && database.get(id).equals(password);//올바른 코드
		if(login) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 정보가 일치하지 않습니다");
		}
		
	}
}








