package ent.model.service;

import ent.model.dto.User;
import ent.model.dao.UserDAO;
import ent.model.dto.Order;
import ent.model.dao.OrderDAO;
import ent.model.dto.Communication;
import ent.model.dto.Contents;

import java.util.ArrayList;



import ent.model.dao.CommunicationDAO;
import ent.model.dao.ContentsDAO;
public class UserService {
	
	private static UserService service = new UserService();
	private UserDAO udao=new UserDAO();
	private OrderDAO odao=new OrderDAO();
	private CommunicationDAO cdao=new CommunicationDAO();
	private ContentsDAO condao = new ContentsDAO();
	
	public UserService(){

	}
	public static UserService getInstance() {
		return service;
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
	public ArrayList<Order> purchaseInfo(String userid){
		System.out.println("4");
		return odao.purchaseInfo(userid);
	}
	public int orderChange(Order dto) {
		return odao.orderChange(dto);
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
	public ArrayList<User> getList(){
		return udao.getList();
	} 
	public ArrayList<User> userContents(String userid){
		return udao.userContents(userid);
	}
	
	public Contents pageView(String contentsId){
		return condao.getContents(contentsId);
	}
}
