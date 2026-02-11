package input;

public class Test03술값계산기 {
	public static void main(String[] args) {
		//입력
		int total = 100000;
		int people = 3;
		
		//처리
		int price = total / people;//몫
		int mod = total % people;//나머지
		
		//출력
		System.out.println("1인당 "+price+"원 계산하셔야 합니다");
		System.out.println("자투리 금액은 "+mod+"원 입니다");
	}
}
