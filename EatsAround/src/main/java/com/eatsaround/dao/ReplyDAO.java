package com.eatsaround.dao;

import java.util.List;

import com.eatsaround.vo.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> list(int blgContSeq)throws Exception;
	
	public void write(ReplyVO vo)throws Exception;
	
	public ReplyVO replySelect(ReplyVO vo) throws Exception;
}
