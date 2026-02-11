package api.lang.etc;

public class Test01문자열합성기 {
	public static void main(String[] args) {
		//문자열을 계속 더해야 하는 경우?
		//- (ex) 파일에 글자가 너무 많아서 한 번에 읽을 수 없는 경우
		//- (ex) 네트워크 통신으로 대량의 업로드가 발생하는 경우
		
		//- 문자열은 불변이기 때문에 매번 새롭게 자리를 만들어서 덧셈을 하므로 양이 많아질수록 성능이 나락으로 간다
		String str = "";
		
		for(int i=0; i < 10000000; i++) {
			str += "더조은아카데미";
		}
		
		System.out.println(str);
	}
}
