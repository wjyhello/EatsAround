package com.eatsaround.dao.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.eatsaround.dao.AdminDAO;
import com.eatsaround.vo.MemberVO;

@Repository
public class AdminDAOImpl implements AdminDAO{

    private static final Logger logger = LoggerFactory.getLogger(AdminDAOImpl.class);
    
    @Inject
    private SqlSession sql;
    
    // mapper
    private static String namespace = "com.eatsaround.EaSql.adminMapper";


	@Override
	public List<MemberVO> getMemberList() throws Exception {
		return sql.selectList(namespace + ".getMemberList");
	}
	
	@Override
	public void deleteMember(String userId) throws Exception {
	    sql.delete(namespace + ".deleteMember", userId);
	}

	@Override
	public int getMemberCount() throws Exception {
		return sql.selectOne(namespace + ".getMemberCount");
	}

	@Override
	public int getBlogCount() throws Exception {
		return sql.selectOne(namespace + ".getBlogCount");
	}
	
	@Override
	public List<Map<String, Object>> getLoginHistory() throws Exception {
	    return sql.selectList(namespace + ".getLoginHistory");
	}


}
