package com.eatsaround.service;

import java.util.List;

import com.eatsaround.vo.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> list(int blgContSeq) throws Exception;
	
	public void write(ReplyVO vo)throws Exception;

	public ReplyVO replySelect(ReplyVO vo) throws Exception;
}
