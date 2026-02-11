package oop.keyword1;

//객체지향의 불편한 진실
//- 객체지향은 모든 상황을 해결할 수 있는 만능 기술인가? (아니오)
//- 객체지향은 언제 사용하기 불편한가?
//- (ex) 정수 계산기(=사칙연산을 현실처럼)
public class Robot {
	//필드
	private int left;	//왼쪽 항
	private int right;	//오른쪽 항
	
	//세터메소드 & 게터메소드
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	//가상의 게터메소드 : 더하기, 빼기, 곱하기, 나누기 결과를 반환
	public int getPlus() {
		return this.left + this.right;
	}
	public int getMinus() {
		if(this.left > this.right) 
			return this.left - this.right;
		else
			return this.right - this.left;
	}
	public int getMultiple() {
		return this.left * this.right;
	}
	public double getDivide() {
		return (double)this.left / this.right;
	}
	
	//생성자
	public Robot(int left, int right) {
		this.setLeft(left);
		this.setRight(right);
	}
}








