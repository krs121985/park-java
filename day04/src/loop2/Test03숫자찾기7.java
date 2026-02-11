package loop2;

public class Test03숫자찾기7 {
	public static void main(String[] args) {
		
		for(int i=1; i <= 999; i++) {
			int number = i;
			
			boolean seven = false;
			for(int k=number; k > 0; k /= 10) {
				if(k % 10 == 7) {
					seven = true;
					break;
				}
			}
			System.out.println(number+"에 7이 있나요? = " + seven);
		}
		
	}
}
