package array2;

public class Test05삽입정렬4 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {10, 20, 30, 50, 40};
		
		//삽입정렬
		//- 각 자리를 백업한 뒤 좌측에 삽입할 지점을 찾아서 넣는 정렬
		
		//4회차
		int position = 4;
		int backup = data[position];
		for(int i=3; i >= 0; i--) {//앞자리 스캔
			if(backup < data[i]) {//더 큰 데이터라면
				data[i+1] = data[i];//우측으로 이동
				position--;//삽입 위치 조정
			}
		}
		data[position] = backup;//백업 데이터 삽입
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
