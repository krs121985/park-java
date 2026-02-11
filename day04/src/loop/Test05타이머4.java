package loop;

import java.awt.Toolkit;
import java.util.Scanner;

public class Test05타이머4 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("분 입력 : ");
		int min = sc.nextInt();
		System.out.print("초 입력 : ");
		int sec = sc.nextInt();
		
		int time = min * 60 + sec;
		
		for(int i=time ; i >= 0; i--) {
			int minute = i / 60;
			int second = i % 60;
			System.out.println(minute+"분 "+second+"초 남았습니다");
			
			// --- [추가 부분] 1초 대기 로직 ---
            try {
                // Thread.sleep(밀리초) : 프로그램의 실행을 잠시 멈춥니다.
                // 1000밀리초 = 1초 입니다.
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                // 일시 정지 중 오류 발생 시 처리 (보통 흐름상 비워둡니다)
                e.printStackTrace();
            }
            // -----------------------------
		}
		
		
		// --- [추가 부분] 종료 알람 ---
        System.out.println("시간이 다 되었습니다! 삐빅!");
        
        // Toolkit을 이용한 시스템 기본 비프음 출력 (간단한 음악/소리 역할)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int j = 0; j < 5; j++) { // 알림음을 5번 반복
            toolkit.beep();
            try { Thread.sleep(500); } catch (Exception e) {} // 소리 간 간격
        }
        // --------------------------
        
        sc.close();
		
	}
}
