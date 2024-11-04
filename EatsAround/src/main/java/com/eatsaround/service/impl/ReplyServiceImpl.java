package com.eatsaround.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatsaround.dao.ReplyDAO;
import com.eatsaround.service.ReplyService;
import com.eatsaround.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO dao;
	
	@Override
	public List<ReplyVO> list(int blgContSeq) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return dao.list(blgContSeq);
	}

	@Override
	public void write(ReplyVO vo) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		dao.write(vo);
	}

	@Override
	public ReplyVO replySelect(ReplyVO vo) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return dao.replySelect(vo);
	}

	@Override
	public void modify(ReplyVO vo) throws Exception {
		dao.modify(vo);
		
	}

	@Override
	public void delete(ReplyVO vo) throws Exception {
		dao.delete(vo);
		
	}

}
