package condition;

public class Test07날짜계산기3 {
	public static void main(String[] args) {
		
		//입력
		int year = 2025;
		int month = 2;
		
		//처리
		//int count = 31 or 30 or 29 or 28;
		int count;
		if(month == 2) {	
			//count = 28 or 29;
			//처리
			boolean leap = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
			if(leap) {
				count = 29;
			}
			else {
				count = 28;
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			count = 30;
		}
		else {
			count = 31;
		}
		
		//출력
		System.out.println(year+"년 "+month+"월은 "+count+"일까지 있습니다");
		
	}
}
