package com.eatsaround.vo;

import java.util.Date;

public class ReplyVO {
	private int blgContSeq;
	private int rno;
	private String writer;
	private String content;
	private Date replyDate;
	
	public int getBlgContSeq() {
		return blgContSeq;
	}
	public void setBlgContSeq(int blgContSeq) {
		this.blgContSeq = blgContSeq;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	
	

}
