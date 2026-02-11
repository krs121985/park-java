package array2;

public class Test03선택정렬2 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {10, 50, 20, 30, 40};//1회차 완료 시점의 데이터
		
		//선택 정렬(selection sort)
		//- 2회차 : [1~4] 사이의 최소값을 [1]과 교체
		
		//최소값 위치 찾기
		int index = 1;//가장 작은 위치를 [1]이라고 생각
		for(int i=2 ; i <= 4 ; i++) {//남은 범위를 탐색하여
			//System.out.println("data[index] = " + data[index] + " , data[i] = " + data[i] + " , index = " + index);
			if(data[index] > data[i]) {//더 작은 값이 발견되었다면
				index = i;//위치를 수정
			}
		}
		
		//데이터 교체
		int backup = data[index];
		data[index] = data[1];
		data[1] = backup;
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
