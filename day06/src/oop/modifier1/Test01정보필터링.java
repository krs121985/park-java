package oop.modifier1;

public class Test01정보필터링 {
	public static void main(String[] args) {
//		Student stu = new Student("피카츄", 50, 60, 70);//정상 데이터
		Student stu = new Student("피카츄", -50, 99, 200);//이상 데이터
		stu.show();
		
//		데이터는 사용중에 변경될 수 있다
//		stu.english = 50;//정상 데이터(잘못된 접근방법)
//		stu.english = -50;//이상 데이터(잘못된 접근방법, 차단안됨)
//		stu.setEnglish(50);//정상 데이터(올바른 접근방법)
		stu.setEnglish(-50);//이상 데이터(올바른 접근방법, 차단됨)
		stu.show();
	}
}
