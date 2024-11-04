package com.eatsaround.dao.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.eatsaround.dao.ReplyDAO;
import com.eatsaround.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession sql;
	
	@Inject
	private static String namespace = "com.eatsaround.Easql.ReplyMapper";
	
	@Override
	public List<ReplyVO> list(int blgContSeq) throws Exception {
		
		return sql.selectList(namespace+".replyList",blgContSeq);
	}

	@Override
	public void write(ReplyVO vo) throws Exception {
		sql.insert(namespace+".replyWrite",vo);
		
	}

	@Override
	public ReplyVO replySelect(ReplyVO vo) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return sql.selectOne(namespace + ".replySelect", vo);
	}

	@Override
	public void modify(ReplyVO vo) throws Exception {
		sql.update(namespace+".replyModify",vo);
		
	}

	@Override
	public void delete(ReplyVO vo) throws Exception {
		sql.delete(namespace+".replyDelete",vo);
		
	}

}
