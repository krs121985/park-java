package api.lang.string;

public class Test01문자열분석 {
	public static void main(String[] args) {
		
//		1. 세 개의 변수(a, b, c)를 만들어서 각각 Hello, hello, hello를 저장해보세요
		String a = new String("Hello");
		String b = new String("hello");
		char[] ch = new char[] {'h','e','l','l','o'};
		String c = new String(ch);
		
//		2. 각 변수에 저장된 문자열 데이터를 출력하세요
//		System.out.println("a = " + a.toString());
//		System.out.println("b = " + b.toString());
//		System.out.println("c = " + c.toString());
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		
//		3. 각 변수에 저장된 문자열의 글자수를 구하여 출력하세요
		System.out.println("a의 글자수 = " + a.length());
		System.out.println("b의 글자수 = " + b.length());
		System.out.println("c의 글자수 = " + c.length());
		
//		4. b 문자열의 세 번째 글자를 구하여 출력하세요
		System.out.println(b.charAt(2));//문자열도 글자위치가 0부터 시작
		
//		5. c를 5번 반복하여 출력하세요
		System.out.println(c.repeat(5));
		
//		6. a와 b가 같은지 판정하여 출력하세요
//		System.out.println(a == b);
		System.out.println(a.equals(b));
	}
}









