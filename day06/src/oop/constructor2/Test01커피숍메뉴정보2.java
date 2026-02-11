package oop.constructor2;

public class Test01커피숍메뉴정보2 {
	public static void main(String[] args) {
		Menu m1 = new Menu("아메리카노", "음료", 2500, true);
//		Menu m2 = new Menu("모카라떼", "음료", 3500, false);
		Menu m2 = new Menu("모카라떼", "음료", 3500);
		Menu m3 = new Menu("치즈케이크", "디저트", 5000, true);
//		Menu m4 = new Menu("마카롱", "디저트", 3000, false);
		Menu m4 = new Menu("마카롱", "디저트", 3000);
		
		m1.customHeader();
		m1.customShow();
		m2.customShow();
		m3.customShow();
		m4.customShow();
	}
}
