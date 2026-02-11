package data2;

public class Test05윤년판정기 {
	public static void main(String[] args) {
		
		//입력
		int year = 2025;
		
		//처리
		boolean is4 = year % 4 == 0;//4의 배수인가?
		//System.out.println("is4 = " + is4);
		boolean is100 = year % 100 == 0;//100의 배수인가?
		//System.out.println("is100 = " + is100);
		boolean is400 = year % 400 == 0;//400의 배수인가?
		//System.out.println("is400 = " + is400);
		
		//boolean leap = is400 == true || (is100 == false && is4 == true);
		boolean leap = is400 || (!is100 && is4 );
		
		//(참고) 논리에서 true와 같다는 말은 숫자에서 +0, *1, -0, /1과 같은 표현 (하나마나한 말)
		
		//출력
		System.out.println("윤년 = " + leap);
		
	}
}






