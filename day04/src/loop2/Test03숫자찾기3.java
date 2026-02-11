package loop2;

public class Test03숫자찾기3 {
	public static void main(String[] args) {
		
		//1부터 999 사이의 7이 포함된 숫자의 카운트 세기
		int counter = 0;
		
		for(int i=1; i <= 999; i++) {
			int hund = i / 100;
			int ten = i / 10 % 10;
			int one = i % 10;
			if(hund == 7 || ten == 7 || one == 7) {
				//System.out.println("7이 포함된 숫자 = " + i);
				counter++;
			}
		}
		
		System.out.println("7이 포함된 숫자 개수 = " + counter);
		
	}
}
