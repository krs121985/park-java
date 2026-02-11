package array2;

public class Test02배열뒤집기3 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//뒤집는 코드
		//- 반복문으로 자동화하려면 "규칙"을 알아야 한다
		//- 반복 횟수는 "데이터개수/2"
		
		int left = 0;//왼쪽 시작점(처음)
		int right = data.length-1;//오른쪽 시작점(마지막)
		
		for(int i=0 ; i < data.length/2 ; i++) {
			//System.out.println(i + " vs " + k);			
			int backup = data[left];
			data[left] = data[right];
			data[right] = backup;
			
			left++;//좌측을 +1칸 이동
			right--;//우측을 -1칸 이동
		}
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
