package loop2;

public class Test03숫자찾기5 {
	public static void main(String[] args) {
		
		int number = 137841723;
		
		int counter = 0;
		for(int i=number; i > 0; i /= 10) {
			if(i % 10 == 7) {
				counter++;
			}
		}
		System.out.println("7이 몇개 있어요? = " + counter);
		
	}
}
