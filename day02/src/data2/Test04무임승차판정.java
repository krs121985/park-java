package data2;

public class Test04무임승차판정 {
	public static void main(String[] args) {
		//입력
		int age = 65;
		
		//처리
		boolean under7 = age <= 7;
		boolean over65 = age >= 65;
		//boolean free = under7 && over65;//절대 이루어질 수 없음(7세이하이고 65세 이상..?)
		boolean free = under7 || over65;
		
		//출력
		System.out.println("무임승차 = " + free);
	}
}
