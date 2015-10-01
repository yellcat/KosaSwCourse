package com.mycompany.myapp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Member {
	private String memberId;
	private String memberName;
	private String memberPw;
	@DateTimeFormat(pattern="yyyy=MM-dd")
	private Date memberBirth;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
}
