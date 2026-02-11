package array;

public class Test01배열3 {
	public static void main(String[] args) {
		//배열(Array)
		//- 공통 프로그래밍(기초)의 마지막 개념
		//- 다량의 동일 데이터를 효율적으로 저장 및 처리하기 위한 저장 방식
		//- 반복문과 결합하여 사용(특히 for)
		//- 참조형 데이터 (리모컨과 본체가 나눠진 복잡한 형태)
		
		//배열 생성 (3개의 정수를 저장할 수 있는 배열)
		
		int[] arr = new int[] {10, 20, 30, 40};
		//arr -----> [ 10 ] [ 20 ] [ 30 ] [ 40 ]
		
		System.out.println(arr);//리모컨을 출력 (일련번호... 의미없음)
		System.out.println(arr.length);//리모컨의 칸수 확인 버튼 (데이터 개수)
		
		//각 데이터 호출
		//for(int i=0; i <= 3; i++) {//0부터 3까지
		//for(int i=0; i < 4; i++) {//0부터 3까지
		for(int i=0; i < arr.length; i++) {//0부터 마지막까지 (배열 전체 반복)
			System.out.println(arr[i]);
		}
		
		
	}
}
