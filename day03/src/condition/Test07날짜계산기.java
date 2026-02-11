package condition;

public class Test07날짜계산기 {
	public static void main(String[] args) {
		
		//입력
		int year = 2025;
		int month = 12;
		
		//처리
		//int count = 31 or 30 or 29 or 28;
		int count;
		//if(큰달이면) {
		//if(1, 3, 5, 7, 8, 10, 12월이면) {
		if(month == 1 || month == 3 || month == 5 || month == 7 
				|| month == 8 || month == 10 || month == 12) {	
			count = 31;
		}
		//else if(작은달이면) {
		//else if(4, 6, 9, 11월이면) {
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			count = 30;
		}
		else {
			count = 28;
		}
		
		//출력
		System.out.println(year+"년 "+month+"월은 "+count+"일까지 있습니다");
		
	}
}
