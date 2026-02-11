package api.lang.string2;

public class Test04생년월일검사3 {
	public static void main(String[] args) {
//		날짜 검사를 하려면 범위를 검사할 수 있어야 한다
//		- 월은 00부터 99까지가 아니라 01~12까지이다
//		- 정규표현식은 오직 문자열을 대상으로 하기 때문에 범위가 아니라 "자리"별로 파악하여 처리
//		- OR연산을 이용해서 "큰달", "작은달", "2월"로 구분하여 날짜수를 각각 31일, 30일, 28일로 처리
//		- 프로그래밍으로 연도를 잘라낸 다음 숫자로 바꿔 윤년을 계산하여 2월의 날짜수만 조정(28 or 29일)
//		String date = "2026-03-31";//true
//		String date = "2026-03-32";//false
//		String date = "2026-04-30";//true
		String date = "2026-04-31";//false
		
//		date에서 연도부분을 자른 뒤 정수로 변환해서 윤년 판정
//		- 문자열을 자르는 메소드 : substring(시작, 종료) , 커서 위치 기준으로 계산
//		- 문자열을 정수로 바꾸는 메소드 : Integer.parseInt(문자열)
		String yearStr = date.substring(0, 4);
		int year = Integer.parseInt(yearStr);
		
		boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
		
		String monthStr = date.substring(5, 7);
		int month = Integer.parseInt(monthStr);
		
		String regex;
		switch(month) {
		case 2:
			if(leap) {
				regex = "^(19[0-9]{2}|20[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-9])$";
			}
			else {
				regex = "^(19[0-9]{2}|20[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8])$";
			}
			break;
		case 4,6,9,11:
			regex = "^(19[0-9]{2}|20[0-9]{2})-(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)$";
			break;
		default:
			regex = "^(19[0-9]{2}|20[0-9]{2})-(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";
			break;
		}
		System.out.println(date.matches(regex));
	}
}






