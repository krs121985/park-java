package loop2;

public class Test03숫자찾기6 {
	public static void main(String[] args) {
		
		int number = 137841723;
		
		boolean seven = false;
		for(int i=number; i > 0; i /= 10) {
			if(i % 10 == 7) {
				seven = true;
				break;
			}
		}
		System.out.println("7이 있나요? = " + seven);
		
	}
}
