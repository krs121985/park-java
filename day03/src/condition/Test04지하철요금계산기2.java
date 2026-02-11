package condition;

public class Test04지하철요금계산기2 {
	public static void main(String[] args) {
		//입력
		int birth = 2000;
		
		//처리
		
		//출력
		if(birth <= 1960 || birth >= 2018) {
			System.out.println("무료입니다");
		}
		else if(birth <= 2005 && birth >= 1961) {
			System.out.println("1550원입니다");
		}
		else if(birth <= 2006 && birth >= 2011) {
			System.out.println("900원입니다");
		}
		else {
			System.out.println("550원입니다");
		}
	}
}


