package data2;

public class Test03논리연산 {
	public static void main(String[] args) {
		//(Q) 어떤 사람의 나이로 "청소년"인지 판정해서 출력
		// - 청소년은 14세 이상 19세 이하의 나이를 가진 사람을 의미
		
		int age = 22;
		
		boolean up14 = age >= 14;//(Q) 14세 이상인가요?
		boolean down19 = age <= 19;//(Q) 19세 이하인가요?
		System.out.println("up14 = " + up14);
		System.out.println("down19 = " + down19);
		
		//up14와 down19가 모두 true인 경우만 true로 간주 (and 연산)
		boolean teen = up14 && down19;
		System.out.println("청소년 = " + teen);
		
		//만약에 한줄로 쓴다면...
		//boolean teen = age >= 14 && age <= 19;
	}
}





