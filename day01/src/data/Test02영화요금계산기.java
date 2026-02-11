package data;

public class Test02영화요금계산기 {
	public static void main(String[] args) {
		//입력 - 주어진 데이터들을 변수에 저장
		int adultPrice = 15000;//성인 요금
		int teenPrice = 9000;//청소년 요금
		int childPrice = 5000;//어린이 요금
		int adultCount = 2;//성인 인원 수
		int teenCount = 1;//청소년 인원 수
		int childCount = 2;//어린이 인원 수
		
		//처리 - 입력을 이용해서 원하는 결과를 계산
		//int total = 15000 * 2 + 9000 * 1 + 5000 * 2;//한 번에 계산하지 않음
		int adultTotal = adultPrice * adultCount;//성인 요금 합계
		int teenTotal = teenPrice * teenCount;//청소년 요금 합계
		int childTotal = childPrice * childCount;//어린이 요금 합계
		
		int total = adultTotal + teenTotal + childTotal;
		
		//출력 - 처리에서 계산한 결과 중 목적에 부합하는 것을 선택하여 출력
		System.out.println(total);
	}
}
