package home.beans;

//Book 테이블에 데이터를 주고받을 때 사용할 포장 상자
public class BookDto {
	private int bookNo;
	private String bookTitle;
	private String bookGenre;
	private int bookPagecount;
	private int bookPrice;
	private String bookStatus;
	@Override
	public String toString() {
		return "BookDto [bookNo=" + bookNo + ", bookTitle=" + bookTitle + ", bookGenre=" + bookGenre
				+ ", bookPagecount=" + bookPagecount + ", bookPrice=" + bookPrice + ", bookStatus=" + bookStatus + "]";
	}
	public BookDto() {
		super();
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public int getBookPagecount() {
		return bookPagecount;
	}
	public void setBookPagecount(int bookPagecount) {
		this.bookPagecount = bookPagecount;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
}
