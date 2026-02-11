package api.util.collection;

public class Test07끝말잇기게임 {
	public static void main(String[] args) {
		
		//가장 쉬운건 단어가 서로 이어지는지 확인하는 것
		String given = "자바";
		String input = "바나나";
		
		//[1] given의 마지막글자를 꺼내고 input의 첫글자를 꺼내서 같은지 비교 (char끼리의 비교)
		char last = given.charAt(given.length()-1);//given의 마지막 글자
		char first = input.charAt(0);
		System.out.println("이어지나요? " + (last == first));
		
		//[2] 글자를 char가 아니라 문자열로 짤라내서 비교
		String last2 = given.substring(given.length()-1);
		String first2 = input.substring(0, 1);
		System.out.println("이어지나요? " + last2.equals(first2));
		
		//[3] 시작 검사 활용
		String last3 = given.substring(given.length()-1);
		System.out.println("이어지나요? " + input.startsWith(last3));
		
	}
}








