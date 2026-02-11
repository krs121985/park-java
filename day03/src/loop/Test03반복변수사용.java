package loop;

public class Test03반복변수사용 {
	public static void main(String[] args) {
		
		for(int i=1 ; i <= 10 ; i++) {
			//반복을 위해 만든 변수 i를 쓸 수 있는가?
			System.out.println("i = " + i);
		}
		
		//System.out.println("i = " + i);//외부에서는 사용 불가
		
		System.out.println("------");
		
		//(응용) 1부터 10까지의 홀수를 출력 (1, 3, 5, 7, 9)
		for(int i=1 ; i <= 9 ; i+=2) {
			System.out.println("홀수 = " + i);
		}
		
		System.out.println("------");
		
		for(int i=1 ; i <= 10 ; i++) {//1부터 10까지의 범위에서
			if(i % 2 == 1) {//i가 홀수면
				System.out.println("홀수 = " + i);
			}
		}
		
	}
}










