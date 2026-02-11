package oop.basic4;

public class Test01메달리스트정보 {
	public static void main(String[] args) {
		//객체(인스턴스) 생성
		Medalist a = new Medalist();
		Medalist b = new Medalist();
		Medalist c = new Medalist();
		
		//데이터 설정(초기화)
		a.init("진종오", "사격", "하계", 4, 2, 0);
		b.init("김수녕", "양궁", "하계", 4, 1, 1);
		c.init("전이경", "쇼트트랙", "동계", 4, 0, 1);
		
		//출력
		a.show();
		System.out.println();
		b.show();
		System.out.println();
		c.show();
	}
}
