package home.beans;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MemberDto {
	private String memberId;
	private String memberPw;
	private String memberEmail;
	private String memberNickname;
	private String memberBirth;
	private String memberPost;
	private String memberAddress1;
	private String memberAddress2;
	private String memberLevel;
	private int memberPoint;
	private Date memberJoin;
	private Date memberLogin;
	private Date memberChange;
	private String memberBlock;
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberEmail=" + memberEmail + ", memberNickname=" + memberNickname
				+ ", memberBirth=" + memberBirth + ", memberPost=" + memberPost + ", memberAddress1=" + memberAddress1
				+ ", memberAddress2=" + memberAddress2 + ", memberLevel=" + memberLevel + ", memberPoint=" + memberPoint
				+ ", memberJoin=" + memberJoin + ", memberLogin=" + memberLogin + ", memberChange=" + memberChange
				+ ", memberBlock=" + memberBlock + "]";
	}
	public MemberDto() {
		super();
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	public String getMemberPost() {
		return memberPost;
	}
	public void setMemberPost(String memberPost) {
		this.memberPost = memberPost;
	}
	public String getMemberAddress1() {
		return memberAddress1;
	}
	public void setMemberAddress1(String memberAddress1) {
		this.memberAddress1 = memberAddress1;
	}
	public String getMemberAddress2() {
		return memberAddress2;
	}
	public void setMemberAddress2(String memberAddress2) {
		this.memberAddress2 = memberAddress2;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		this.memberPoint = memberPoint;
	}
	public Date getMemberJoin() {
		return memberJoin;
	}
	public String getMemberJoinFormat() {
		//java.util.Date로 바꿔서 SimpleDateFormat으로 형식을 설정한 뒤 반환
		java.util.Date d = new java.util.Date(memberJoin.getTime());
		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E a h시 m분 s초");
		return fmt.format(d);
	}
	public void setMemberJoin(Date memberJoin) {
		this.memberJoin = memberJoin;
	}
	public Date getMemberLogin() {
		return memberLogin;
	}
	public String getMemberLoginFormat() {
		if(memberLogin == null) return null;
		java.util.Date d = new java.util.Date(memberLogin.getTime());
		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E a h시 m분 s초");
		return fmt.format(d);
	}
	public void setMemberLogin(Date memberLogin) {
		this.memberLogin = memberLogin;
	}
	public Date getMemberChange() {
		return memberChange;
	}
	public String getMemberChangeFormat() {
		if(memberChange == null) return null;
		java.util.Date d = new java.util.Date(memberChange.getTime());
		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E a h시 m분 s초");
		return fmt.format(d);
	}
	public void setMemberChange(Date memberChange) {
		this.memberChange = memberChange;
	}
	public String getMemberBlock() {
		return memberBlock;
	}
	public void setMemberBlock(String memberBlock) {
		this.memberBlock = memberBlock;
	}
}
