package loop2;

import java.util.Scanner;

public class Test03숫자찾기9 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("시작값 : ");
		int begin = sc.nextInt();
		System.out.print("종료값 : ");
		int end = sc.nextInt();
		
		int counter = 0;
		
		for(int i=begin; i <= end; i++) {
			int number = i;
			
			boolean seven = false;
			for(int k=number; k > 0; k /= 10) {
				if(k % 10 == 7) {
					seven = true;
					break;
				}
			}
			//System.out.println(number+"에 7이 있나요? = " + seven);
			if(seven) {
				//System.out.println(number);
				counter++;
			}
		}
		
		System.out.println("7이 들어간 숫자의 개수 = " + counter);
		
	}
}
