package array;

import java.util.Random;

public class Test03배열생성방법 {
	public static void main(String[] args) {
		//(Q) 만약 배열에 랜덤한 정수 5개를 넣는다면? (ex : 주사위)
		Random r = new Random();
		
		int[] data = new int[] {
			r.nextInt(6) + 1, 
			r.nextInt(6) + 1,
			r.nextInt(6) + 1,
			r.nextInt(6) + 1,
			r.nextInt(6) + 1
		};
		
		for(int i=0 ; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}







