package data3;

public class Test02주차요금계산기2 {
	public static void main(String[] args) {
		//입력
		//- 매번 달라지는 값
		int inHour = 10 , inMinute = 30;//입차시각
		int outHour = 12 , outMinute = 10;//출차시각
		//- 어쩌다 달라지는 값
		int limit = 30;//회차 제한시간(분)
		int period = 10;//기준간격
		int periodPrice = 1000;//기준시간당 요금
		
		//처리
		//- 입차시각과 출차시각을 분으로 환산 (시간계산은 가장 작은 단위로 바꿔서 한번에 계산)
		int in = inHour * 60 + inMinute;
		int out = outHour * 60 + outMinute;
		int time = out - in;//주차시간(분)
		
		boolean free = time <= limit;
		int price = time / period * periodPrice;
		
		//출력
		System.out.println("주차요금 : " + price + "원");
		System.out.println("회차여부 : " + free);
	}
}
