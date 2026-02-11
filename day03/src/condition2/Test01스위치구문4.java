package condition2;

public class Test01스위치구문4 {
	public static void main(String[] args) {
		//switch-case 구문
		
		//월별 날짜수 계산 프로그램
		int month = 1;
		
		switch(month) {//month 보고 판단해!
		//case 1,3,5,7,8,10,12://Java 13부터 가능한 기능(우리는 21을 사용중...회사는 대부분 8아니면 11)
		default://else역할을 하는 구문(해당되는 case가 없으면 실행됨)
			System.out.println("31일");
			break;//그만하고 나가! (탈출 키워드)
		case 4,6,9,11:
			System.out.println("30일");
			break;//그만하고 나가! (탈출 키워드)
		case 2:
			System.out.println("28일");
			break;//그만하고 나가! (탈출 키워드)
		}
	}
}






