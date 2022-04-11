package com.auth.woogie.services;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.woogie.models.UserSessionVO;
import com.auth.woogie.repositories.UserSessionDao;


@Service
public class UserSessionService {

//	▼ 변수 ===============================================================

	@Autowired
	private UserSessionDao userSessionDao;


//	▼ 메소드 ===============================================================	

	// public UserSessionVO selectUserSessionById(String memId) {
	// 	return this.memberDao.selectUserSessionById(memId);
	// }
	
	// public List<UserSessionVO> getAllUserSessions(){
	// 	return this.memberDao.getAllUserSessions();
	// }
	
	public int insertUserSession(UserSessionVO userSession) {
		System.out.println("UserSessionService====================");
		System.out.println(userSession);
		System.out.println("====================");
		return this.userSessionDao.insertUserSession(userSession);
	}
	
}
