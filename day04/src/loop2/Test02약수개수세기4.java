package loop2;

public class Test02약수개수세기4 {
	public static void main(String[] args) {
		
		int number = 6;
		
		for(int i=1; i <= number; i++) {//1부터 number까지의 범위에서
			if(number % i == 0) {//나머지가 0인 경우만
				System.out.println(number % i);
			}
		}
		
	}
}
