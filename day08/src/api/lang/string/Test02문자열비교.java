package api.lang.string;

public class Test02문자열비교 {
	public static void main(String[] args) {
		
		//문자열의 생성 방식에 따른 비교 차이
		//- 문자열은 한 번 생성되면 절대로 변하지 않는다 (불변, Immutable)
		
		String a = "hello";
		String b = "hello";
		String c = new String("hello");
		String d = new String("hello"); 
		
		//비교 연산은 "완벽하게 동일한" 객체인지를 판정해준다
		//= 기준이 너무 타이트해서 같은 경우가 거의 없다 
		//= 객체환경에서는 부적합한 연산이다
		System.out.println(a == b);//true
		System.out.println(b == c);//false
		System.out.println(c == d);//false
		
		//실제와 유사하게 비교하려면 별도의 비교 명령을 써야 한다 (equals)
		System.out.println(a.equals(b));//true
		System.out.println(b.equals(c));//true
		System.out.println(c.equals(d));//true
	}
}










