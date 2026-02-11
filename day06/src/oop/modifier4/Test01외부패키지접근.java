package oop.modifier4;

import oop.modifier3.Student;

public class Test01외부패키지접근 {
	public static void main(String[] args) {
		//다른 패키지(oop.modifier3)에 있는 Student를 이용할 수 있나?
		Student stu = new Student("피카츄", 50, 60, 70);
		stu.setKorean(90);
		stu.show();
	}
}
