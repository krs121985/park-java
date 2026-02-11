package array2;

public class Test02배열뒤집기2 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//뒤집는 코드
		//- 반복문으로 자동화하려면 "규칙"을 알아야 한다
		//- 반복 횟수는 "데이터개수/2"
		
		for(int i=0 ; i < data.length/2 ; i++) {
			//int k = 4 - i;
			int k = data.length - 1 - i;
			//System.out.println(i + " vs " + k);			
			int backup = data[i];
			data[i] = data[k];
			data[k] = backup;
		}
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
