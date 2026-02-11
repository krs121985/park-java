package array2;

public class Test03선택정렬6 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {3, 5, 4, 2, 6, 8, 1, 9, 10};
		
		//선택 정렬(selection sort)
		
		for(int k=0; k < data.length-1; k++) {
			//최소값 위치 찾기
			int index = k;
			for(int i=k+1 ; i < data.length ; i++) {//남은 범위를 탐색하여
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
