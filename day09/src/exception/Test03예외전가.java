package exception;

import java.io.IOException;

public class Test03예외전가 {
	public static void main(String[] args) {
		
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec(new String[] {"cmd", "/c", "start", "https://www.naver.com"});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
