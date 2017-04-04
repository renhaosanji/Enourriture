package ent.model.service;

import ent.model.dao.UserDAO;
import ent.model.dto.Order;
import ent.model.dto.User;
import ent.model.dao.OrderDAO;

public class UserService {
	
	private UserDAO udao=null;
	private OrderDAO odao=null;
	public UserService(){
		udao = new UserDAO();
	}
	public boolean login(String userId, String userPw){
		return udao.login(userId, userPw);
	}
	public int join(User user){
		return udao.join(user);
	}
	public User selectOne(String id){	
		return udao.selectOne(id);
		
	}
	public int userLeave(String userId, String userPw){
		return udao.delete(userId, userPw);
	}
	public int update(User dto){
		return udao.update(dto);
	}
	public int purchase(Order dto){
		return odao.purchase(dto);
		
	}
}
