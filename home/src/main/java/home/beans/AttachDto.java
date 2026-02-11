package home.beans;

public class AttachDto {
	private int attachNo;
	private String attachName;
	private String attachType;
	private long attachSize;//(주의) 파일 크기는 long
	@Override
	public String toString() {
		return "AttachDto [attachNo=" + attachNo + ", attachName=" + attachName + ", attachType=" + attachType
				+ ", attachSize=" + attachSize + "]";
	}
	public AttachDto() {
		super();
	}
	public int getAttachNo() {
		return attachNo;
	}
	public void setAttachNo(int attachNo) {
		this.attachNo = attachNo;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public String getAttachType() {
		return attachType;
	}
	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}
	public long getAttachSize() {
		return attachSize;
	}
	public void setAttachSize(long attachSize) {
		this.attachSize = attachSize;
	}
}
