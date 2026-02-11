package data;

public class Test01변수의필요성 {
	public static void main(String[] args) {
		//계산을 위한 데이터(data)
		//- 측정이 가능한 값을 데이터라고 부른다
		//- (ex) 10cm, 10g, 10원, 10L, 10달러, 10년, 10일
		//- 종류가 다른 데이터는 계산할 수 없다 (10g + 10일 = ?)
		//- 종류가 같으면 단위가 달라도 계산할 수 있다 (10kg + 10g = 10.01kg / 10010g)
		//- (주의) 프로그래밍 코드에서는 데이터에 단위를 쓰지 않는다
		System.out.println(10 + 20);//10일 + 20일 / 10g + 20g / 10L + 20L
		
		//데이터를 계산하려면 여러 가지 기호가 필요하다 (연산자, Operator)
		//- 연산마다 필요한 데이터의 개수가 다르며 그에 따라 불리는 이름이 다르다(1항, 2항, 3항 연산자)
		//- 기본적인 사칙연산(산술연산)부터 우리가 모르는 다양한 연산들도 존재
		
		//(Q) 떡볶이 1인분에 4000원 , 튀김 1인분에 2500원일 때 떡볶이 2인분과 튀김 1인분의 가격은?
		//System.out.println(10500);//프로그래밍으로 풀었다고 보기 어려움
		//System.out.println(8000 + 2500);//절반은 내 머리로 계산했음
		System.out.println((4000 * 2) + (2500 * 1) + "원");//완벽한 프로그래밍 계산
		
		//(Q) 자장면 한그릇 7천원, 짬뽕 한그릇 8천원일 때 자장면 3그릇과 짬뽕 2그릇 의 가격을 출력
		//단, 자장면 가격 합계 따로, 짬뽕 가격 합계 따로, 총 가격 합계 따로 출력하세요
		System.out.println(7000 * 3);
		System.out.println(8000 * 2);
		System.out.println(7000 * 3 + 8000 * 2);
		
		//중복되는 값들을 "변수"라는 임시 공간을 만들어 저장해두고 사용 (중복되는 코드들이 제거)
		int a = 7000 * 3;//a라는 임시 공간(변수)에 7000 * 3의 결과를 저장해두겠다
		int b = 8000 * 2;//b라는 임시 공간(변수)에 8000 * 2의 결과를 저장해두겠다
		System.out.println(a);//a라고 저장해둔 곳에 있는 값을 불러와서 출력하세요
		System.out.println(b);//b라고 저장해둔 곳에 있는 값을 불러와서 출력하세요
		System.out.println(a + b);
		
		//변수를 좀 더 체계적으로 만들어서 고치기도 쉽게 구현해보자!
		int zzajangPrice = 7000; 
		int zzajangCount = 3;
		int champonPrice = 8000;
		int champonCount = 2;
		
		int zzajangTotal = zzajangPrice * zzajangCount;
		int champonTotal = champonPrice * champonCount;
		
		int total = zzajangTotal + champonTotal;
		
		System.out.println(zzajangTotal);
		System.out.println(champonTotal);
		System.out.println(total);
		
	}
}











