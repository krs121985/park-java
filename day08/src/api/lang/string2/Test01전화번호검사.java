package api.lang.string2;

public class Test01전화번호검사 {
	public static void main(String[] args) {
		
		String number = "010-1234-5678";
		
//		String regex = "^010-[123456789][0123456789][0123456789][0123456789]-[0123456789][0123456789][0123456789][0123456789]$";
//		String regex = "^010-[1-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$";
		String regex = "^010-[1-9][0-9]{3}-[0-9]{4}$";
		
//		System.out.println(number.matches(regex));//number의 글자가 regex와 매칭됩니까?
		if(number.matches(regex)) {//매칭된다면
			System.out.println("올바른 전화번호 형식입니다");
		}
		else {//매칭되지 않았다면
			System.out.println("잘못된 전화번호 형식입니다");
		}
		
	}
}