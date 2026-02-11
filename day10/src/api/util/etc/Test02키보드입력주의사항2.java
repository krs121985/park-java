package api.util.etc;

import java.util.Scanner;

public class Test02키보드입력주의사항2 {
	public static void main(String[] args) {
		
		//line에 값이 들어가지 않는 이유
		//- next(), nextInt()와 nextLine()은 구분자(delimiter)가 다르다
		//- next(), nextInt()는 공백(\n, \t, space 등)을 기준으로 단어 또는 숫자를 구분
		//- (중요) 남은 공백은 제거하지 않음
		//- nextLine()은 오직 \n 하나만 기준으로 줄을 구분
		//- (중요) 남은 \n을 제거함
		
//		String str = "hello\n안녕하세요 반갑습니다\n10000\n";
//		Scanner sc = new Scanner(str);
		Scanner sc = new Scanner(System.in);
		
//		문제 : next(), nextInt() 뒤에 nextLine()을 쓰면 정상적인 입력이 안됨
//		해결 : 사이에 의미없는 nextLine()을 한번 더 사용
		System.out.println("입력하세요");
		String word = sc.next();//hello (\n 남음)
		sc.nextLine();//청소용 명령
		String line = sc.nextLine();//\n을 버리고 입력 끝
		int number = sc.nextInt();//100 (\n 남음)
		
		System.out.println("word = " + word);
		System.out.println("line = " + line);
		System.out.println("number = " + number);
		
//		끝나면 정리
		sc.close();
		
	}
}





