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

	public int saveSession(UserSessionVO userSession) {
		this.userSessionDao.deleteUserSession(userSession);
		return this.userSessionDao.insertUserSession(userSession);
	}
	
}
