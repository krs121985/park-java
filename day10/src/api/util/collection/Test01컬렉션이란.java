package api.util.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test01컬렉션이란 {
	public static void main(String[] args) {
		//JCF(Java Collection Framework)
		//- 대용량 가변 저장 시스템
		//- 배열과 달리 데이터의 개수에 따라 크기가 자동 조정되는 저장소
		//- 자바에서 가장 많이 쓰는 도구들이며 저장방식에 따라 여러 종류로 나눠진다
		
		TreeSet contacts = new TreeSet();//전화번호부처럼 저장되는 저장소
		ArrayList history = new ArrayList();//통화기록처럼 저장되는 저장소
		
		contacts.add("피카츄");			history.add("피카츄");
		contacts.add("라이츄");			history.add("라이츄");
		contacts.add("파이리");			history.add("파이리");
		contacts.add("꼬부기");			history.add("꼬부기");
		contacts.add("버터플");			history.add("버터플");
		contacts.add("뽀로로");			history.add("뽀로로");
		
		System.out.println("전화번호부 = " + contacts);
		System.out.println("통화기록 = " + history);
		
	}
}












