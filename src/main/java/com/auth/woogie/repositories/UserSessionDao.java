package com.auth.woogie.repositories;

// import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.auth.woogie.models.UserSessionVO;


@Repository
public class UserSessionDao {

//	▼ 변수 ===============================================================

	@Autowired
	private final SqlSession sqlSession;

	public UserSessionDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
//	▼ 메소드 ===============================================================

	// public UserSessionVO selectUserSessionVOById(String memId) {
	// 	return this.sqlSession.selectOne("selectUserSessionVOById", memId);
	// }
	
	// public List<UserSessionVO> getAllUserSessionVOs(){
	// 	return this.sqlSession.selectList("getAllUserSessionVOs");
	// }
	
	public int insertUserSession(UserSessionVO userSession) {
		System.out.println("UserSessionDao====================");
		System.out.println(userSession);
		System.out.println("====================");
		return this.sqlSession.insert("insertUserSession", userSession);
	}
	
	
}
