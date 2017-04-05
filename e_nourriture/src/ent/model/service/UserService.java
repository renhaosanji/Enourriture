package ent.model.service;

import ent.model.dto.User;
import ent.model.dao.UserDAO;
import ent.model.dto.Order;
import ent.model.dao.OrderDAO;
import ent.model.dto.Communication;
import ent.model.dao.CommunicationDAO;
public class UserService {
	
	private UserDAO udao=new UserDAO();
	private OrderDAO odao=new OrderDAO();
	private CommunicationDAO cdao=new CommunicationDAO();;
	
	public UserService(){

	}
	public String login(String userid, String userpw) {
		String loginid = udao.login(userid, userpw);
		System.out.println("3"+loginid);
		return loginid;
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
		System.out.println("4");
		return odao.purchase(dto);
	}
	public int cancellation(String orderNumber, String userId){

		return odao.cancellation(orderNumber,userId );
	}
	public int insertComSender(Communication dto){
		return cdao.insertComSender(dto);
	}
	public int insertComReciver(Communication dto){
		return cdao.insertComReciver(dto);
	}
	
	
}
