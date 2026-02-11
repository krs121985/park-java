package condition2;

public class Test01스위치구문2 {
	public static void main(String[] args) {
		//switch-case 구문
		
		//월별 날짜수 계산 프로그램
		int month = 1;
		
		switch(month) {//month 보고 판단해!
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31일");
			break;//그만하고 나가! (탈출 키워드)
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일");
			break;//그만하고 나가! (탈출 키워드)
		case 2:
			System.out.println("28일");
			break;//그만하고 나가! (탈출 키워드)
		}
	}
}
