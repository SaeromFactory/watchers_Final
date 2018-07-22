package com.watchers.business.login.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watchers.business.login.mapper.LoginMapper;
import com.watchers.business.login.model.UserVo;
import com.watchers.common.exception.WatchersBizException;

import net.sf.json.JSONObject;

@Service
public class LoginServiceImpl implements LoginService{
	
	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	LoginMapper loginMapper;
	
	@Override
	public JSONObject getUser(UserVo user) {
		
		UserVo userInfo = loginMapper.getUser(user);
		
		if(userInfo == null) {
			throw new WatchersBizException("아이디 또는 비밀번호를 확인해주세요.");
		} else {
			return JSONObject.fromObject(userInfo);
		}
	}
}
