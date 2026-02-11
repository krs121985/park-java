package home.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class CookieUtil {
	//사용자의 정보에서 원하는 이름의 쿠키가 존재하는지 확인하는 메소드
	public static String getValue(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();//사용자의 모든 쿠키를 가져와서
		if(cookies != null) {
			for(Cookie cookie : cookies) {//모든 쿠키를 순차적으로 조회하여
				if(cookie.getName().equals(cookieName)) {//원하는 쿠키이름을 발견했다면
					return cookie.getValue();//쿠키의 value를 반환하세요!
				}
			}
		}
		return null;
	}
}
