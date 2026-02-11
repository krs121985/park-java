package oop.modifier5;

public class Test01인강정보 {
	public static void main(String[] args) {
		Lecture a = new Lecture("자바 프로그래밍 기초", "이론", 60, 500000, "온라인");
//		Lecture b = new Lecture("파이썬 프로그래밍 기초", "이론", 90, 1000000, "오프라인");	
		Lecture b = new Lecture("파이썬 프로그래밍 기초", "이론", 90, 1000000);
		Lecture c = new Lecture("정보처리기사 필기", "시험", 30, 300000, "혼합");
		Lecture d = new Lecture("빅데이터 분석기사 실기", "시험", 120, 850000, "혼합");
		
		a.show();
		b.show();
		c.show();
		d.show();
	}
}
