package oop.basic2;

public class Test01국가정보 {
	public static void main(String[] args) {
		//4개의 국가에 대한 객체(인스턴스) 생성
		Country c1 = new Country();
		Country c2 = new Country();
		Country c3 = new Country();
		Country c4 = new Country();
		
		//정보 초기화
		c1.name = "한국";
		c1.capital = "서울";
		c1.region = "아시아";
		c1.population = 50000000L;
		
		c2.name = "일본";
		c2.capital = "도쿄";
		c2.region = "아시아";
		c2.population = 120000000L;
		
		c3.name = "중국";
		c3.capital = "베이징";
		c3.region = "아시아";
		c3.population = 1400000000L;
		
		c4.name = "미국";
		c4.capital = "워싱턴";
		c4.region = "아메리카";
		c4.population = 250000000L;
		
		//정보 출력
		System.out.println("이름 : " + c1.name);
		System.out.println("수도 : " + c1.capital);
		System.out.println("지역 : " + c1.region);
		System.out.println("인구 : " + c1.population);
		
		System.out.println("이름 : " + c2.name);
		System.out.println("수도 : " + c2.capital);
		System.out.println("지역 : " + c2.region);
		System.out.println("인구 : " + c2.population);
	
		System.out.println("이름 : " + c3.name);
		System.out.println("수도 : " + c3.capital);
		System.out.println("지역 : " + c3.region);
		System.out.println("인구 : " + c3.population);
		
		System.out.println("이름 : " + c4.name);
		System.out.println("수도 : " + c4.capital);
		System.out.println("지역 : " + c4.region);
		System.out.println("인구 : " + c4.population);
		
	}
}











