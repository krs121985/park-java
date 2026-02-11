package array2;

import java.util.Arrays;

public class Test04버블정렬5 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {50, 50, 50, 10, 40};
		
		//버블 정렬
		//- 인접한 두 개를 비교해서 원하는 순서대로 재배치하는 정렬
		for(int k=3 ; k >= 0; k--) {
			for(int i=0 ; i <= k; i++) {
				System.out.println(i + " vs " + (i+1));
				System.out.println(" → " + data[i] + " vs " + data[i+1]);
				if(data[i] > data[i+1]) {//앞 데이터가 뒤 데이터보다 크다면
					//두 데이터를 교체
					int backup = data[i];
					data[i] = data[i+1];
					data[i+1] = backup;
				}
			}
		}
		
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}




