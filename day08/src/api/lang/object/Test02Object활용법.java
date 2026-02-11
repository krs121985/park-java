package api.lang.object;

import java.util.Scanner;

public class Test02Object활용법 {
	public static void main(String[] args) {
		//Object는 "아무거나"라는 의미로 쓰일 수 있다
		//= 설명에 의하면 Object는 모든 클래스의 상속관계 중 최상위를 차지한다고 했다
		//= 보관해야 하는 형태가 애매할 경우 사용
		
		Object a = 100;
		Object b = 3.14;
		Object c = "Hello";
		Object sc = new Scanner(System.in);
		Object data = new int[] {30, 50, 20, 10, 40};
		
		//혹시... 이런 배열을 만들면 무슨 뜻일까?
		Object[] list = new Object[10];//아무 데이터나 넣어도 되는 10개의 칸을 준비했다!
		
		//내가 만든 클래스는...? 안보이지만 Object를 상속받고 있다
		Object stu = new Student();
		
		
	}
}











