package loop3;

public class Test01누적합구하기 {
	public static void main(String[] args) {
		//(ex) 100을 10번 더하면 얼마에요?
		//int sum = 100 + 100 + 100 + 100 + 100 + 100 + 100 + 100 + 100 + 100;
		int sum = 0;
		for(int i=1 ; i <= 10 ; i++) {
			sum += 100;
		}
		System.out.println("100을 10번 더하면 = " + sum);
		
		//(ex) 1부터 10까지 더하면 얼마에요?
		//int sum2 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
		int sum2 = 0;
		for(int i=1; i <= 10; i++) {
			sum2 += i;
			//System.out.println("테스트 출력 = " + sum2);
		}
		System.out.println("1부터 10까지 더하면 = " + sum2);
	}
}











