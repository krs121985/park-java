package loop2;

import java.util.Scanner;

public class Test02약수개수세기6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int number = sc.nextInt();
		
		int counter = 0;
		
		for(int i=1; i <= number; i++) {//1부터 number까지의 범위에서
			if(number % i == 0) {//나머지가 0인 경우만
				//System.out.println(number % i);
				counter++;
			}
		}
		
		System.out.println("약수 개수 = " + counter);
		
	}
}



