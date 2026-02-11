package condition;

public class Test05성적분석기2 {
	public static void main(String[] args) {
		//입력
		int kor = 50;
		int eng = 60;
		int mat = 70;
		
		//처리
		int tot = kor + eng + mat;//총점
		double avg = (double)tot / 3;//평균
		System.out.println("avg = " + avg);
		
		//출력
		if(avg >= 90) {
			System.out.println("당신의 내신등급은 A등급입니다");
		}
		else if(avg >= 80) {
			System.out.println("당신의 내신등급은 B등급입니다");
		}
		else {
			System.out.println("당신의 내신등급은 C등급입니다");
		}
	}
}



