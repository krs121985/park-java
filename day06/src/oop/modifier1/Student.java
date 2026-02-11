package oop.modifier1;

public class Student {
//	멤버 필드
//	- 직접 접근하면 매우 위험함 (원치 않는 데이터가 들어갈 수 있음)
//	- 외부의 접근을 차단하여 안전성을 확보 (private 키워드를 사용)
	private String name;//이름 (클래스 외부의 접근 불가)
	private int korean;//국어점수 (클래스 외부의 접근 불가)
	private int english;//영어점수 (클래스 외부의 접근 불가)
	private int math;//수학점수 (클래스 외부의 접근 불가)
	
//	생성자 - 최초 생성 시에 딱 한번만 부를 수 있다
	Student(String name, int korean, int english, int math) {
		this.setName(name);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}

//	세터메소드 - 필드에 값을 설정하는 전용 메소드
//	이름만 설정하는 메소드 (set + name = setName)
	void setName(String name) { 
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
	void setKorean(int korean) {
		//메소드 실행을 중지시키는 키워드(break의 메소드 버전)
		if(korean < 0) return;
		if(korean > 100) return;
		this.korean = korean;
	}
	
//	영어점수만 설정하는 메소드 (set + english = setEnglish)
	void setEnglish(int english) {
		if(english < 0 || english > 100) return;
		this.english = english;
	}
//	수학점수만 설정하는 메소드 (set + math = setMath)
	void setMath(int math) {
		if(math < 0 || math > 100) return;
		this.math = math;
	}
	
	
//	메소드 - 생성 후 원할 때마다 부를 수 있다
	void show() {
		System.out.println("<학생 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("국어 : " + this.korean);
		System.out.println("영어 : " + this.english);
		System.out.println("수학 : " + this.math);
	}
}




