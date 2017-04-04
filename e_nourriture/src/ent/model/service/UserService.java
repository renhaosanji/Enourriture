package ent.model.service;

import ent.model.dao.UserDAO;
import ent.model.dto.User;

public class UserService {
	
	private UserDAO udao=null;
	
	public UserService(){
		udao = new UserDAO();
	}
	
	public boolean login(String userId, String userPw){
		
		return udao.login(userId, userPw);
	}
	
	
	public int join(User user){
		return udao.join(user);
	}
	
	
}
