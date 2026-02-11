package array2;

public class Test03선택정렬3 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {10, 20, 50, 30, 40};//2회차 완료 시점의 데이터
		
		//선택 정렬(selection sort)
		//- 3회차 : [2~4] 사이의 최소값을 [2]과 교체
		
		//최소값 위치 찾기
		int index = 2;//가장 작은 위치를 [2]이라고 생각
		for(int i=3 ; i <= 4 ; i++) {//남은 범위를 탐색하여
			//System.out.println("data[index] = " + data[index] + " , data[i] = " + data[i] + " , index = " + index);
			if(data[index] > data[i]) {//더 작은 값이 발견되었다면
				index = i;//위치를 수정
			}
		}
		
		//데이터 교체
		int backup = data[index];
		data[index] = data[2];
		data[2] = backup;
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
