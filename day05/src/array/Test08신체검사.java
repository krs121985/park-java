package array;

public class Test08신체검사 {
	public static void main(String[] args) {
		
		//키 정보가 저장될 배열 생성
		int[] people = new int[]{174, 182, 168, 175, 171, 180, 177, 165, 173, 179};
		
		//처리
		int max = people[0];//맨 앞사람이 제일 크다고 치자!
		for(int i=1 ; i < people.length; i++) {//두번째 칸부터 마지막까지 (+1지점부터 length-1까지)
			if(max < people[i]) {//내가아는값 < 지금값
				max = people[i];//내가아는값 = 지금값;
			}
		}
		
		int min = people[0];//맨 앞사람이 제일 작다고 치자!
		for(int i=1 ; i < people.length; i++) {
			if(min > people[i]) {//내가아는값 > 지금값
				min = people[i];//내가아는값 = 지금값				
			}
		}
		
		int total = 0;
		for(int i=0; i < people.length; i++) {
			total += people[i];
		}
		float avg = (float)total / people.length;
		
		//출력
		System.out.println("가장 큰 키 = " + max);
		System.out.println("가장 작은 키 = " + min);
		System.out.println("평균 키 = " + avg);
		
	}
}
