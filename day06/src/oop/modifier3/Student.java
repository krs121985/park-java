package oop.modifier3;

public class Student {
//	멤버 필드
//	- 직접 접근하면 매우 위험함 (원치 않는 데이터가 들어갈 수 있음)
//	- 외부의 접근을 차단하여 안전성을 확보 (private 키워드를 사용)
	private String name;//이름 (클래스 외부의 접근 불가)
	private int korean;//국어점수 (클래스 외부의 접근 불가)
	private int english;//영어점수 (클래스 외부의 접근 불가)
	private int math;//수학점수 (클래스 외부의 접근 불가)
	
//	생성자 - 최초 생성 시에 딱 한번만 부를 수 있다
	public Student(String name, int korean, int english, int math) {
		this.setName(name);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}

//	세터메소드 - 필드에 값을 설정하는 전용 메소드
//	이름만 설정하는 메소드 (set + name = setName)
	public void setName(String name) { 
		this.name = name;
	}
//	국어점수만 설정하는 메소드 (set + korean = setKorean)
//	[1] 설정 조건을 명시하는 경우 (0점 이상 그리고 100점 이하인 경우만 설정하세요)
//	void setKorean(int korean) {
//		if(korean >= 0 && korean <= 100) {
//			this.korean = korean;
//		}
//	}
//	[2] 차단 조건을 명시하는 경우 (0점 미만 또는 100점 초과인 경우는 설정하지 마세요)
	public void setKorean(int korean) {
		//메소드 실행을 중지시키는 키워드(break의 메소드 버전)
		if(korean < 0) return;
		if(korean > 100) return;
		this.korean = korean;
	}
	
//	영어점수만 설정하는 메소드 (set + english = setEnglish)
	public void setEnglish(int english) {
		if(english < 0 || english > 100) return;
		this.english = english;
	}
//	수학점수만 설정하는 메소드 (set + math = setMath)
	public void setMath(int math) {
		if(math < 0 || math > 100) return;
		this.math = math;
	}
	
//	게터(Getter) 메소드
//	- 값을 가져다가 쓸 수 있도록 반환(return)하는 메소드
//	- 값에 대한 검사는 세터메소드가 하기 때문에 따로 처리하지 않음
//	- 존재하지 않는 필드도 이름 형식을 빌려 게터메소드처럼 만들어 사용
//	- 메소드에 "반환 자료형(return type)"을 설정해서 반환될 형태를 명시 (참고로 void는 반환 데이터 없음이란 뜻)
	public String getName() {//이름을 가져다가 쓸 수 있도록 반환하는 메소드 (get + name = getName)
		return this.name;//이름 가져가세요!
	}
	public int getKorean() {//국어점수를 가져다가 쓸 수 있도록 반환하는 메소드 (get + korean = getKorean)
		return this.korean;//국어점수 가져가세요!
	}
	public int getEnglish() {
		return this.english;
	}
	public int getMath() {
		return this.math;
	}
	public int getTotal() {//마치 total이라는 변수가 있는 것처럼 가상의 게터메소드를 생성
		return this.korean + this.english + this.math;
	}
	public float getAverage() {//마치 average라는 변수가 있는 것처럼 가상의 게터메소드를 생성
		return this.getTotal() / 3f;
	}
	
	
//	메소드 - 생성 후 원할 때마다 부를 수 있다
	public void show() {
		System.out.println("<학생 정보>");
		System.out.println("이름 : " + this.getName());
		System.out.println("국어 : " + this.getKorean());
		System.out.println("영어 : " + this.getEnglish());
		System.out.println("수학 : " + this.getMath());
		//(+추가) 총점과 평균을 출력하세요
		System.out.println("총점 : " + this.getTotal());
		System.out.println("평균 : " + this.getAverage());
	}
}
















