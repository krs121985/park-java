package array2;

public class Test01데이터교체 {
	public static void main(String[] args) {
		
		//샘플 배열 준비
		int[] data = new int[] {30, 50, 20, 10, 40};

		//(중요) 자바는 데이터의 맞교환이 불가능 (자바스크립트나 파이썬은 가능)
		//data[0] = data[3];
		//data[3] = data[0];
		
		//개선된 코드
		int backup = data[0];
		data[0] = data[3];
		data[3] = backup;
		
		//출력
		for(int i=0 ; i < data.length ; i++) {
			System.out.println(data[i]);
		}
		
	}
}
