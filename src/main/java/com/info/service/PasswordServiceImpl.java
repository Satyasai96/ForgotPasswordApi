package com.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.entity.UserEntity;
import com.info.repository.UserRepository;
import com.info.utill.EmailUtil;

@Service
public class PasswordServiceImpl implements ForgotPasswordService {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private EmailUtil emailUtills;

	@Override
	public String forgotPwd(String userEmail) {
		UserEntity user = repo.findByUserEmail(userEmail);
		if(user==null) {
			return "No  record found with given email";
		}
		
		return null;
	}
	
	public boolean sendForgotPwdEmail(UserEntity user) {
		String fname = user.getUserFirstName();
		String to = user.getUserEmail();
		String userPwd = user.getUserPwd();
		String subject="";
		String body="";
		emailUtills.sendEmail(subject, body, to);
		return false;
		
	}

}
