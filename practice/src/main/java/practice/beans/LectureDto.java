package practice.beans;

public class LectureDto {
	private int lectureNo;
	private String lectureSubject;
	private String lectureCategory;
	private int lectureDuration;
	private int lecturePrice;
	private String lectureType;
	@Override
	public String toString() {
		return "LectureDto [lectureNo=" + lectureNo + ", lectureSubject=" + lectureSubject + ", lectureCategory="
				+ lectureCategory + ", lectureDuration=" + lectureDuration + ", lecturePrice=" + lecturePrice
				+ ", lectureType=" + lectureType + "]";
	}
	public LectureDto() {
		super();
	}
	public int getLectureNo() {
		return lectureNo;
	}
	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}
	public String getLectureSubject() {
		return lectureSubject;
	}
	public void setLectureSubject(String lectureSubject) {
		this.lectureSubject = lectureSubject;
	}
	public String getLectureCategory() {
		return lectureCategory;
	}
	public void setLectureCategory(String lectureCategory) {
		this.lectureCategory = lectureCategory;
	}
	public int getLectureDuration() {
		return lectureDuration;
	}
	public void setLectureDuration(int lectureDuration) {
		this.lectureDuration = lectureDuration;
	}
	public int getLecturePrice() {
		return lecturePrice;
	}
	public void setLecturePrice(int lecturePrice) {
		this.lecturePrice = lecturePrice;
	}
	public String getLectureType() {
		return lectureType;
	}
	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}
	//필요한 메소드를 추가
	public int getLecturePricePerHour() {
		return this.lecturePrice / this.lectureDuration;
	}
}










