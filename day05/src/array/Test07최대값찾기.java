package array;

public class Test07최대값찾기 {
	public static void main(String[] args) {
		//최대, 최소 찾기
		//배열로 할 수 있는 주요 알고리즘 중 하나
		
		//(Q) 다음 중 가장 큰 금액은 얼마이며 어디 있나요? 
		//(A) 21000, +2지점
		int[] money = new int[] {7700, 15000, 21000, 18200, 20200};
		
		int index = 0;//최대값의 위치정보를 저장
		int value = money[0];//최대값 자체를 저장
		
		for(int i=1 ; i < money.length; i++) {
			//System.out.println("value = " + value + " , 현재값 = " + money[i]);
			if(value < money[i]) {//내가 알고있는 값보다 더 큰 값이 나타났다면
				index = i;//index 덮어쓰기
				value = money[i];//value 덮어쓰기
			}
		}
		
		System.out.println("가장 큰 금액 : " + value);
		System.out.println("위치 : " + index);
	}
}










