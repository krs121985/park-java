package loop;

public class Test04숫자찾기 {
	public static void main(String[] args) {
//		[1] 1~100 사이의 3의 배수

//		- 3, 6, 9, 12, 15, ...., 96, 99 = 3부터 99까지 3씩 증가
//		for(int i=3; i <= 99; i+=3) {
//			System.out.println("1번문제(홀수) = " + i);
//		}
		
		for(int i=1; i <= 100; i++) {
			if(i % 3 == 0) {//i가 3의 배수라면
				System.out.println("1번문제(홀수) = " + i);
			}
		}
		
		
		
		
//		[2] 1~100 사이의 5가 포함된 숫자
		
//		- 5, 15, 25, 35, 45, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 65, 75, 85, 95
//		for(int i=5; i <= 45; i+=10) {
//			System.out.println("2번문제(5가들어간수) = " + i);
//		}
//		for(int i=50; i <= 59; i++) {
//			System.out.println("2번문제(5가들어간수) = " + i);
//		}
//		for(int i=65; i <= 95; i+=10) {
//			System.out.println("2번문제(5가들어간수) = " + i);
//		}
		
		for(int i=1; i<=100; i++) {
			boolean ten = i / 10 == 5;
			boolean one = i % 10 == 5;
			if(ten || one) {//5가 들어간 숫자라면 (십의자리 5 or 일의자리 5)
				System.out.println("2번문제(5가들어간수) = " + i);
			}
		}
		
		
//		[3] 1~100 사이의 3, 6, 9의 박수치는 숫자
		for(int i=1; i <= 100; i++) {
			boolean ten = i / 10 == 3 || i / 10 == 6 || i / 10 == 9;//십의자리check
			boolean one = i % 10 == 3 || i % 10 == 6 || i % 10 == 9;//일의자리check
			if(ten || one) {//3, 6, 9중 하나가 포함되었다면
				System.out.println("3번문제(369게임 박수치는수) = " + i);
			}
		}
		
		System.out.println("---");
		for(int i=1; i <= 100; i++) {
			boolean ten = i / 10 == 3 || i / 10 == 6 || i / 10 == 9;//십의자리check
			boolean one = i % 10 == 3 || i % 10 == 6 || i % 10 == 9;//일의자리check
			if(ten && one) {
				System.out.println("짝짝");
			}
			else if(ten || one) {
				System.out.println("짝");
			}
			else {
				System.out.println(i);
			}
		}
		
	}
}














