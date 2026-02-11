package oop.keyword3;

//어차피 일회용 메소드만 보관할거 같으니까 객체 생성 못하게 하고 아무데서나 쉽게 부르게 처리해보자!
//= static(정적)이라는 키워드를 사용해서 객체 지향을 포기!
public class Robot {
	//생성을 못하게 하려면? 잠금(private) 처리하면 된다!
	private Robot() {}
	
	//일회용 메소드로 변환 (전달받은 데이터를 바로 계산해서 반환)
	public static int plus(int left, int right) {
		return left + right;
	}
	public static int minus(int left, int right) {
		if(left > right) 
			return left - right;
		else
			return right - left;
	}
	public static int multiple(int left, int right) {
		return left * right;
	}
	public static double divide(int left, int right) {
		return (double)left / right;
	}
	
}








