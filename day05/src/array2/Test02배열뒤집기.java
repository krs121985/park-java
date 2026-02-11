package array2;

public class Test02배열뒤집기 {
	public static void main(String[] args) {
		//배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};
		
		//뒤집는 코드
		//[0] <-----> [4]
		int backup = data[0];
		data[0] = data[4];
		data[4] = backup;
		
		//[1] <-----> [3]
		backup = data[1];
		data[1] = data[3];
		data[3] = backup;
		
		
		//출력
		for(int i=0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
