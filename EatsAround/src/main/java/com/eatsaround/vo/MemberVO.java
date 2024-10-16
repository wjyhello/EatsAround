package com.eatsaround.vo;

import java.util.Date;

public class MemberVO {
    private String userId;
    private String userPass;
    private String userPassRe;
    private String userName;
    private String userEmail;
    private String userGender;
    private String userPhone;      
    private String userAdd1;
    private String userAdd2;
    private String userAdd3;
    private int verify;
    private Date regDate;

	
	//getter
	public String getUserId() {return userId;}
	public String getUserPass() {return userPass;}
	public String getUserPassRe() {return userPassRe;}
	public String getUserName() {return userName;}
	public String getUserEmail() {return userEmail;}
	public String getUserGender() {return userGender;}
	public String getUserPhone() {return userPhone;}
	public String getUserAdd1() {return userAdd1;}
	public String getUserAdd2() {return userAdd2;}
	public String getUserAdd3() {return userAdd3;}
	public int getVerify() {return verify;}
	public Date getRegDate() {return regDate;}

	//setter
	public void setUserId(String userId) {this.userId = userId;}
	public void setUserPass(String userPass) {this.userPass = userPass;}
	public void setUserPassRe(String userPassRe) {this.userPassRe = userPassRe;}	
	public void setUserName(String userName) {this.userName = userName;}
	public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
	public void setUserGender(String userGender) {this.userGender = userGender;}
	public void setUserPhone(String userPhone) {this.userPhone = userPhone;}
	public void setUserAdd1(String userAddr1) {this.userAdd1 = userAddr1;}
	public void setUserAdd2(String userAddr2) {this.userAdd2 = userAddr2;}
	public void setUserAdd3(String userAddr3) {this.userAdd3 = userAddr3;}
	public void setVerify(int verify) {this.verify = verify;}
	public void setRegDate(Date regDate) {this.regDate = regDate;}
	
}

