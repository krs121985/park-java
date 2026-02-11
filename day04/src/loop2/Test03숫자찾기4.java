package loop2;

public class Test03숫자찾기4 {
	public static void main(String[] args) {
		
		int number = 137841723;
		
		for(int i=number; i > 0; i /= 10) {
			System.out.println(i % 10);
		}
		
	}
}
