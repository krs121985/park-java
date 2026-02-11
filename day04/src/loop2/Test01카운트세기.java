package loop2;

public class Test01카운트세기 {
	public static void main(String[] args) {
		//카운트 측정
		//- loop 패키지에서 1부터 10 사이의 짝수를 출력하라고 했다면 (2, 4, 6, 8, 10)
		//- loop2 패키지에서는 1부터 10 사이의 짝수가 몇 개냐고 물어봅니다 (5개)
		
		int counter = 0;
		
		for(int i=1 ; i <= 10 ; i++) {//1~10
			if(i % 2 == 0) {//짝수
				//System.out.println("짝수 = " + i);
				counter++;
			}
		}
		
		System.out.println("짝수 개수 = " + counter);
		
	}
}
