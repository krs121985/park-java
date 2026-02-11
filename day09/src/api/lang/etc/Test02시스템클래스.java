package api.lang.etc;

public class Test02시스템클래스 {
	public static void main(String[] args) {
		//System 클래스
		//- 외부 시스템(운영체제)의 정보를 읽거나 연결하여 작업을 실행하기 위한 클래스
		//- (주의) 생성자가 존재하지 않는 클래스
		//	1. 모든 필드 및 메소드가 static인 경우 : 빠르고 편하게 아무데서나 쓸 수 있도록 구현된 클래스
		//	2. static이 아닌 필드나 메소드가 있는 경우 : 생성 제한이 걸린 경우 (정해진 방식으로만 생성 및 대여)
		
		//System s = new System();//불가능
		
		//System.out - 표준 출력 통로, System 클래스에 있는 static 필드
		System.out.println("일반 출력 메세지");
		//System.err - 표준 오류 통로, System 클래스에 있는 static 필드 (System.out 과 다른 통로)
		System.err.println("오류 출력 메세지");		
		
		//알아두면 유용한 메소드들
		//1. 현재 시각 구하는 메소드 (시간차를 구할 때 사용, 1970년 1월 1일 이후에 흘러간 밀리초를 반환)
		long current = System.currentTimeMillis();
		System.out.println("current = " + current);
		
		//2. 외부 환경 정보를 읽을 수 있음
		System.out.println(System.getProperties());
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("os.name"));
		
		//boolean windows = System.getProperty("os.name").startsWith("Windows");
		boolean windows = System.getProperty("os.name").toLowerCase().startsWith("windows");
		System.out.println("윈도우 운영체제를 사용중인가요? " + windows);
		
		System.out.println(System.getProperty("os.arch"));
	}
}











