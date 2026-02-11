package api.util.etc;

import java.util.Scanner;

public class Test01스캐너클래스 {
	public static void main(String[] args) {
		//스캐너는 원래 입력도구라기보다 패턴 분석기이다 (입력 기능도 있을 뿐)
		
		String song = "떳다떳다 비행기 날아라 날아라\n떳다떳다 비행기 우리비행기";
		
		//Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(song);
		
		//단어가 존재한다면 지속적으로 이를 읽어서 출력하세요
		while(true) {
			//System.out.println("next = " + sc.hasNext());//다음 단어가 있나요?
			if(sc.hasNext() == false) break;
			String word = sc.next();//다음 단어를 가져오세요
			System.out.println("word = " + word);
		}
	}
}












