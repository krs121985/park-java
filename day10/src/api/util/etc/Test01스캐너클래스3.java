package api.util.etc;

import java.util.Scanner;

public class Test01스캐너클래스3 {
	public static void main(String[] args) {
		//스캐너는 원래 입력도구라기보다 패턴 분석기이다 (입력 기능도 있을 뿐)
		
		String song = "떳다떳다 비행기 날아라 날아라\n떳다떳다 비행기 우리비행기";
		
		Scanner sc = new Scanner(song);
		
		//줄이 존재한다면 지속적으로 이를 읽어서 출력하세요
		//- 줄은 \n이 나오기 전까지이다
		while(sc.hasNextLine()) {
			String line = sc.nextLine();//다음 줄을 가져오세요
			System.out.println("line = " + line);
		}
		
		//역할을 다 하고 나면 사용 중지를 해줘야 함 (안하면 메모리를 계속 점
		sc.close();
	}
}












