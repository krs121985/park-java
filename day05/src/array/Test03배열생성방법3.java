package array;

import java.util.Random;

public class Test03배열생성방법3 {
	public static void main(String[] args) {
		//(Q) 만약 배열에 랜덤한 정수 5개를 넣는다면? (ex : 주사위)
		Random r = new Random();
		
		//만들면서 데이터를 넣으려고 하니 구문이 조잡해진다
		//→ 만들고 나서 넣으면 되지 않을까? (생성과 초기화를 분리)
		
		int[] data = new int[5];//다섯 칸 만들거야! (데이터는 몰라)
		
		for(int i=0 ; i < data.length; i++) {//전체 반복
			data[i] = r.nextInt(6) + 1;//+i 위치에 데이터 넣기
		}
		
		for(int i=0 ; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}







