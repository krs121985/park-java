package home.beans;

import java.sql.Date;

public class HistoryDto {
	private int historyNo;
	private Date historyTime;
	private String historyMember;
	private String historyOrigin;
	private String historyAgent;
	public HistoryDto() {
		super();
	}
	public int getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	public Date getHistoryTime() {
		return historyTime;
	}
	public void setHistoryTime(Date historyTime) {
		this.historyTime = historyTime;
	}
	public String getHistoryMember() {
		return historyMember;
	}
	public void setHistoryMember(String historyMember) {
		this.historyMember = historyMember;
	}
	public String getHistoryOrigin() {
		return historyOrigin;
	}
	public void setHistoryOrigin(String historyOrigin) {
		this.historyOrigin = historyOrigin;
	}
	public String getHistoryAgent() {
		return historyAgent;
	}
	public void setHistoryAgent(String historyAgent) {
		this.historyAgent = historyAgent;
	}
	@Override
	public String toString() {
		return "HistoryDto [historyNo=" + historyNo + ", historyTime=" + historyTime + ", historyMember="
				+ historyMember + ", historyOrigin=" + historyOrigin + ", historyAgent=" + historyAgent + "]";
	}
}
