package home.util;

public class CompareUtil {
	//서로 다른 두 객체가 일치하는지 확인하는 메소드
	public static boolean equals(Object a, Object b) {
		if(a == null) return false;
		if(b == null) return false;
		return a.equals(b);
	}
}
