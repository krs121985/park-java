package array2;

public class Test03선택정렬5 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//선택 정렬(selection sort)
		
		for(int k=0; k <= 3; k++) {
			//최소값 위치 찾기
			int index = k;
			for(int i=k+1 ; i <= 4 ; i++) {//남은 범위를 탐색하여
				if(data[index] > data[i]) {//더 작은 값이 발견되었다면
					index = i;//위치를 수정
				}
			}
			
			//데이터 교체
			int backup = data[index];
			data[index] = data[k];
			data[k] = backup;
		}
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		
	}
}
