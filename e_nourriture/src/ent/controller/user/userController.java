package ent.controller.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ent.model.dto.Order;
import ent.model.dto.User;
import ent.model.service.FollowService;
import ent.model.service.UserService;
import ent.model.dto.Communication;
/**
 * Servlet implementation class Controller
 */
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 1. �α��� 2. �α׾ƿ� 3. ȸ������ 4. ȸ��Ż�� 5. �� ���� ��ȸ 6. �� ���� ���� 7. �ֹ�  8. �ֹ� ��� 9. ��� ��� 10. ��ۿ� ��� ���
	 * 
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		System.out.println(action);
		if (action != null) {
			switch (action) {
			case "login":
				System.out.println("�α��� ����");
				login(request, response);
				break;
			case "logout":
				System.out.println("�α׾ƿ� ����");
				logout(request, response);
				break;
			case "join":
				join(request, response);
				break;
			case "userLeave":
				userLeave(request, response);
				break;
			case "userInfo":
				userInfo(request, response);
				break;
			case "userInfoChange":
				userInfoChange(request, response);
				break;
			case "order":
				order(request, response);
				break;
			case "orderCancel":
				orderCancel(request, response);
				break;
			case "writeSendComment":
				writeSendCom(request, response);
				break;
			case "writeRevComment":
				writeRevCom(request, response);
				break;
			case "following":
				following(request, response);
				break;
			default:
				System.out.println("�ش� ��û�� �����ϴ�.");
				break;
			}
		} else {
			System.out.println("�ش� ��û�� �����ϴ�.");
		}
	}

	



	//  1. �α��� 
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. ��û ������ ����
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		System.out.println("1"+id + "," + password);
		
		// 2. ��û ������ ����
		if (id == null || password == null) {
			System.out.println("�Է��� �߸� �Ǿ����ϴ�.");
			request.setAttribute("message", "�Է��� �߸� �Ǿ����ϴ�.");
			request.getRequestDispatcher("error/error.html").forward(request, response);
			return;
		} else if (id.trim().length() == 0 || password.trim().length() == 0) {
			System.out.println("�Է��� �߸� �Ǿ����ϴ�.");
			response.sendRedirect("login.html");
			return;

		}
		// 3. Model ��û �Ƿ�
		UserService us = new UserService();
		String isLogin = us.login(id, password);
		System.out.println("isLogin :"+isLogin);
		// 4. ��û��� �޾Ƽ� �������� ����
		if (isLogin != null) {
			System.out.println("�α��� ��û ����");
			// HttpSession �ű� ��ü
			HttpSession session = request.getSession(true);

			// ���� ��ü�� ����� �α��� ���� �ʿ� ������ ����
			session.setAttribute("ID", id);
			session.setAttribute("password", password);	
			// �α��� ���� ������ �̵�
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			System.out.println("�α��� ��û ����");
			request.setAttribute("message", "�α��� ������ Ȯ���Ͻñ� �ٶ��ϴ�.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// 5. ���������� �̵�
	}

	// 2. �α׾ƿ�
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession(false);
		System.out.println("�ε�ƿ� ����");
		if (session != null && session.getAttribute("ID") != null) {
			System.out.println("�ε�ƿ� ����");
			session.removeAttribute("ID");
			session.invalidate();
			response.sendRedirect("loginView.jsp");
		} else {
			System.out.println("�α׾ƿ��� �����Ͽ����ϴ�.");
			request.setAttribute("message", "�α׾ƿ��� �����Ͽ����ϴ�.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}

	// 3. ȸ������
	protected void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		String password_chk = request.getParameter("password_chk");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");

		System.out.println(id + "," + password + "," + password_chk + "," + name + "," + phone + "," + mail);

		if (password.equals(password_chk)) {

			User user = new User(id, password, name, phone, mail);
			UserService us = new UserService();
			int result = us.join(user);
			if (result == 0) {
				System.out.println("ȸ�����Կ� �����߽��ϴ�.");
			} else {
				System.out.println("ȸ�����Կ� �����߽��ϴ�.");
			}

			request.getRequestDispatcher("loginView.jsp").forward(request, response);
		} else {
			System.out.println("ȸ�����Կ� �����߽��ϴ�.");
			request.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
	// 4. ȸ��Ż��
	protected void userLeave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ż�� �����մϴ�.");
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		System.out.println(id + "," + password);

		// 2. ��û ������ ����
		if (id == null || password == null) {
			System.out.println("�Է��� �߸� �Ǿ����ϴ�.");
			request.setAttribute("message", "�Է��� �߸� �Ǿ����ϴ�.");
			request.getRequestDispatcher("error/error.html").forward(request, response);
			return;
		} else if (id.trim().length() == 0 || password.trim().length() == 0) {
			System.out.println("�Է��� �߸� �Ǿ����ϴ�.");
			response.sendRedirect("login.html");
			return;

		}
		// 3. Model ��û �Ƿ�
		UserService us = new UserService();
		int isLeave = us.userLeave(id, password);
		System.out.println("isLeave :" + isLeave);
		// 4. ��û��� �޾Ƽ� �������� ����
		if (isLeave != 0) {
			// HttpSession �ű� ��ü
			System.out.println("Ż�� �����߽��ϴ�.");
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("ID") != null) {
				session.removeAttribute("ID");
				session.invalidate();
			} else {
				System.out.println("ȸ��Ż��κ� session���� ���� �Դϴ�.");		
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			}
		}
	}
	//   5. �� ���� ��ȸ
	protected void userInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("ID") != null) {

			String id = (String) session.getAttribute("ID");
			UserService us = new UserService();
			User user = us.selectOne(id);

			if (user != null) {
				System.out.println("1"+user.getUserId()+" "+user.getPhoneNumber()+" "+user.getUserPw());
				request.setAttribute("user", user);
				request.getRequestDispatcher("userInfo.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			System.out.println("���� ��ȸ�� �����Ͽ����ϴ�.");
			request.setAttribute("message", "���� ��ȸ�� �����Ͽ����ϴ�.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
	// 6. �� ���� ���� 
	private void userInfoChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		request.setCharacterEncoding("euc-kr");
		
		String passwordChange = request.getParameter("password");
		String phoneNumber = request.getParameter("phone");
		String email = request.getParameter("mail");
		String nickName = request.getParameter("nickname");
		String id=(String) session.getAttribute("ID");
		String password=(String) session.getAttribute("password");
		
		if (session != null && session.getAttribute("ID") != null) {
			System.out.println("1"+id+" "+passwordChange);
			if (id == null || password == null) {
				System.out.println("���̵�� ��й�ȣ null");

				// ��û ��� �޾Ƽ� ���� ���� ����
				request.setAttribute("message", "���̵�� ��й�ȣ null");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			} else if (id.trim().length() == 0 || password.trim().length() == 0) {
				System.out.println("�ٽ� �Է�");
				// response.sendRedirect("login.jsp");
			} else {
				User newMember = new User(id, passwordChange, nickName,phoneNumber, email);
				UserService us = new UserService();
				
				int update=us.update(newMember) ;
				System.out.println(update);

				if (us.update(newMember) != 0) {
					System.out.println("���� ����");
					request.setAttribute("message", "���� ����");
					request.getRequestDispatcher("changeSuccess.jsp").forward(request, response);
				} else {
					System.out.println("����");
					request.setAttribute("message", "����");
					request.getRequestDispatcher("error/error.jsp").forward(request, response);
				}
			}

		} else {
			System.out.println("session error �����������");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		
	}
	//7. �ֹ�
	protected void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�ֹ� ����");
		
		String userId= request.getParameter("userId"); // ID
		String productName= request.getParameter("productName");// �ֹ� ��ǰ �̸�
		String orderCount= request.getParameter("orderCount");// �ֹ� ����
		String orderTime= request.getParameter("orderTime");// �ֹ� �ð�
		String address= request.getParameter("address"); // �ּ�
		System.out.println( userId + "," + productName + "," + orderCount + "," + orderTime + "," + address);

		System.out.println("1");
			Order order=new Order(userId,productName,orderCount,address,orderTime);
			System.out.println("2");
			UserService or = new UserService();
			System.out.println("3");
			int result = or.purchase(order);
			System.out.println(result+"result");
			if (result == 0) {
				System.out.println("�ֹ��� �����߽��ϴ�.");
			} else {
				System.out.println("�ֹ��� �����߽��ϴ�.");
			}

			request.getRequestDispatcher("loginView.jsp").forward(request, response);
	}
	//8. �ֹ��ּ�
	private void orderCancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�ֹ� ��ҽ���");
		HttpSession session = request.getSession(false);
		String orderNumber = request.getParameter("orderNumber"); // �ֹ� ��ȣ
		String userId= request.getParameter("userId"); // ID
		Order order=new Order(orderNumber,userId);
		UserService or = new UserService();
		int result = or.cancellation(order.getOrderNumber(), order.getUserId());
		System.out.println(result);
		if (result == 0) {
			System.out.println("�ֹ���ҿ� �����߽��ϴ�.");
		} else {
			System.out.println("�ֹ���ҿ� �����߽��ϴ�.");
		}

//		System.out.println("1");
//		if (session != null && session.getAttribute("ID") != null) {
//			System.out.println("2");
//			UserService or = new UserService();
//			int result = or.cancellation(order.getOrderNumber(), order.getUserId());
//			if (result == 0) {
//				System.out.println("�ֹ���ҿ� �����߽��ϴ�.");
//			} else {
//				System.out.println("�ֹ���ҿ� �����߽��ϴ�.");
//			}
//
//			request.getRequestDispatcher("loginView.jsp").forward(request, response);
//		}else {
//			System.out.println("3");
//			System.out.println("session������ ���Ͽ� �ֹ� ��ҿ� �����Ͽ����ϴ�.");
//			request.setAttribute("message", "���� ��ȸ�� �����Ͽ����ϴ�.");
//			request.getRequestDispatcher("error/error.jsp").forward(request, response);
//		}
	}
	//8. ��۵��
	private void writeSendCom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("��۵�� ����");
		request.setCharacterEncoding("euc-kr");
	
		String contentsId = request.getParameter("contentsId");
		String comments = request.getParameter("comments");
		String senderId = request.getParameter("senderId");
		String commentTime = request.getParameter("commentTime");

		Communication com = new Communication(contentsId, comments, senderId, commentTime);
		UserService us = new UserService();
				
		if (us.insertComSender(com) != 0) {
			System.out.println("���� ����");
			request.setAttribute("message", "���� ����");
			request.getRequestDispatcher("changeSuccess.jsp").forward(request, response);
		} else {
			System.out.println("����");
			request.setAttribute("message", "����");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}

//		if (session != null && session.getAttribute("ID") != null) {
//					
//			Communication com = new Communication(contentsId, comments, senderId, commentTime);
//			UserService us = new UserService();
//					
//			if (us.insertComSender(com) != 0) {
//				System.out.println("���� ����");
//				request.setAttribute("message", "���� ����");
//				request.getRequestDispatcher("changeSuccess.jsp").forward(request, response);
//			} else {
//				System.out.println("����");
//				request.setAttribute("message", "����");
//				request.getRequestDispatcher("error/error.jsp").forward(request, response);
//			}
//			
//		}else {
//			System.out.println("session error �����������");
//			request.getRequestDispatcher("error/error.jsp").forward(request, response);
//		}

	}

	//9. ��۴� ��ۿ� �ٽ� ���
	
	private void writeRevCom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println("��۴� ��ۿ� ��� ����");
		request.setCharacterEncoding("euc-kr");
		
		String comments = request.getParameter("comments");
		String receiverId = request.getParameter("receiverId");
		String commentTime = request.getParameter("commentTime");

		Communication com = new Communication(comments, receiverId, commentTime);
		UserService us = new UserService();
				
		if (us.insertComReciver(com) != 0) {
			System.out.println("���� ����");
			request.setAttribute("message", "���� ����");
			request.getRequestDispatcher("changeSuccess.jsp").forward(request, response);
		} else {
			System.out.println("����");
			request.setAttribute("message", "����");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
//		if (session != null && session.getAttribute("ID") != null) {
//
//			Communication com = new Communication(contentsId, comments, senderId, commentTime);
//			UserService us = new UserService();
//
//			if (us.insertComReciver(com) != 0) {
//				System.out.println("���� ����");
//				request.setAttribute("message", "���� ����");
//				request.getRequestDispatcher("changeSuccess.jsp").forward(request, response);
//			} else {
//				System.out.println("����");
//				request.setAttribute("message", "����");
//				request.getRequestDispatcher("error/error.jsp").forward(request, response);
//			}
//
//		} else {
//			System.out.println("session error �����������");
//			request.getRequestDispatcher("error/error.jsp").forward(request, response);
//		}
		
	}
	protected void following(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		FollowService fs = new FollowService();
		
		fs.followingUser("id02", "id04");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}

}
