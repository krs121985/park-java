package input;

import java.util.Scanner;//내가 사용할 Scanner의 위치를 알려주겠다!

public class Test01표준입력코드 {
	public static void main(String[] args) {
		//사용자가 프로그램 시작 이후에 값을 직접 입력하게 하는 방법
		
		//입력 도구 생성 (프로그램이 아니라 사용자가 하기 때문에 처리를 안전하고 편하게 하는 보조도구를 사용)
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();//사용자가 입력한 int 하나 가져와서 넣어!
		System.out.println("a = " + a);
		
		float b = sc.nextFloat();//사용자가 입력한 float 하나 가져와서 넣어!
		System.out.println("b = " + b);
		
	}
}






