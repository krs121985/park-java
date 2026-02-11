package oop.keyword5;

//static과 final을 같이쓰면 어떻게 될까?
//- static : 객체 안만들고 아무데서나 편하게 접근 (일회성 데이터)
//- final : 변하지 않도록 처리
//- static + final : 아무데서나 객체 안만들고 편하게 접근할 수 있는 변하지 않는 값 (= 상수 , constant)
//- 일반적인 값이 아니므로 구분을 위해 가급적 대문자만으로 작성
public class Month {
	public static final int JANUARY = 1;
	public static final int FEBRUARY = 2;
	public static final int MARCH = 3;
	//생략...
}
