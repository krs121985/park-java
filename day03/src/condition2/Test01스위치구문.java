package condition2;

public class Test01스위치구문 {
	public static void main(String[] args) {
		//switch-case 구문
		
		//월별 날짜수 계산 프로그램
		int month = 1;
		
		switch(month) {//month 보고 판단해!
		case 1:
			System.out.println("31일");
			break;//그만하고 나가! (탈출 키워드)
		case 2:
			System.out.println("28일");
			break;//그만하고 나가! (탈출 키워드)
		case 3:
			System.out.println("31일");
			break;//그만하고 나가! (탈출 키워드)
		//이런식으로 12개의 case를 만들어야 한다....
		}
	}
}
