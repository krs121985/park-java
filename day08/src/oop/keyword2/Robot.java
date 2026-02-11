package oop.keyword2;

public class Robot {
	//계산에 사용한 데이터를 계속 유지할 필요가 없으므로 필드를 제거한다
	
	//일회용 메소드로 변환 (전달받은 데이터를 바로 계산해서 반환)
	public int plus(int left, int right) {
		return left + right;
	}
	public int minus(int left, int right) {
		if(left > right) 
			return left - right;
		else
			return right - left;
	}
	public int multiple(int left, int right) {
		return left * right;
	}
	public double divide(int left, int right) {
		return (double)left / right;
	}
	
}








