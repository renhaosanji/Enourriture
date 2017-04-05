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

/**
 * Servlet implementation class Controller
 */
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 1. 로그인 2. 로그아웃 3. 회원가입 4. 회원탈퇴 5. 내 정보 조회 6. 내 정보 변경 7. 주문
	 * 
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		System.out.println(action);
		if (action != null) {
			switch (action) {
			case "login":
				login(request, response);
				break;
			case "logout":
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
			case "following":
				following(request, response);
				break;
			default:
				System.out.println("해당 요청이 없습니다.");
				break;
			}
		} else {
			System.out.println("해당 요청이 없습니다.");
		}
	}
	//  1. 로그인 
	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청 데이터 추출
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		System.out.println(id + "," + password);

		// 2. 요청 데이터 검증
		if (id == null || password == null) {
			System.out.println("입력이 잘못 되었습니다.");
			request.setAttribute("message", "입력이 잘못 되었습니다.");
			request.getRequestDispatcher("error/error.html").forward(request, response);
			return;
		} else if (id.trim().length() == 0 || password.trim().length() == 0) {
			System.out.println("입력이 잘못 되었습니다.");
			response.sendRedirect("login.html");
			return;

		}
		// 3. Model 요청 의뢰
		UserService us = new UserService();
		FollowService fs = new FollowService();
		
		boolean isLogin = us.login(id, password);

		// 4. 요청결과 받아서 응답위한 설정
		if (isLogin) {
			System.out.println("로그인 요청 성공");
			// HttpSession 신규 객체
			HttpSession session = request.getSession();

			// 세션 객체에 사용자 로그인 인증 필요 정보들 설정
			session.setAttribute("ID", id);

			// 로그인 성공 페이지 이동
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			for (int i = 0; i < fs.usersFollowingContentsLoading(id).size(); i++) {
				System.out.println(fs.usersFollowingContentsLoading(id).get(i).toString()+"++++++++++");
			}
		
			
		} else {
			System.out.println("로그인 요청 실패");
			request.setAttribute("message", "로그인 정보를 확인하시기 바랍니다.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		// 5. 응답페이지 이동
	}

	// 2. 로그아웃
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("ID") != null) {
			session.removeAttribute("ID");
			session.invalidate();
			response.sendRedirect("index.jsp");
		} else {
			System.out.println("로그아웃에 실패하였습니다.");
			request.setAttribute("message", "로그아웃에 실패하였습니다.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}

	// 3. 회원가입
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
				System.out.println("회원가입에 실패했습니다.");
			} else {
				System.out.println("회원가입에 성공했습니다.");
			}

			request.getRequestDispatcher("loginView.jsp").forward(request, response);
		} else {
			System.out.println("회원가입에 실패했습니다.");
			request.setAttribute("message", "회원가입에 실패했습니다.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
	// 4. 회원탈퇴
	protected void userLeave(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		System.out.println(id + "," + password);

		// 2. 요청 데이터 검증
		if (id == null || password == null) {
			System.out.println("입력이 잘못 되었습니다.");
			request.setAttribute("message", "입력이 잘못 되었습니다.");
			request.getRequestDispatcher("error/error.html").forward(request, response);
			return;
		} else if (id.trim().length() == 0 || password.trim().length() == 0) {
			System.out.println("입력이 잘못 되었습니다.");
			response.sendRedirect("login.html");
			return;

		}
		// 3. Model 요청 의뢰
		UserService us = new UserService();
		int isLeave = us.userLeave(id, password);

		// 4. 요청결과 받아서 응답위한 설정
		if (isLeave != 0) {
			// HttpSession 신규 객체
			System.out.println("탈퇴 성공했습니다.");
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("ID") != null) {
				session.removeAttribute("ID");
				session.invalidate();
			} else {
				System.out.println("회원탈퇴부분 session관련 에러 입니다.");		
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			}
		}
	}
	//   5. 내 정보 조회
	protected void userInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("ID") != null) {

			String id = (String) session.getAttribute("ID");
			UserService us = new UserService();
			User user = us.selectOne(id);

			if (user != null) {
				System.out.println(user);
				request.setAttribute("user", user);
				request.getRequestDispatcher("userInfo.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			System.out.println("정보 조회에 실패하였습니다.");
			request.setAttribute("message", "정보 조회에 실패하였습니다.");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
	// 6. 내 정보 변경 
	private void userInfoChange(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		request.setCharacterEncoding("euc-kr");
		String id = request.getParameter("userId");
		String password = request.getParameter("userPw");
		String phoneNumber = request.getParameter("phoneNumber");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");

	    
		if (id == null || password == null) {
			System.out.println("아이디랑 비밀번호 null");

			// 요청 결과 받아서 응답 위한 설정
			request.setAttribute("message", "아이디랑 비밀번호 null");
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		} else if (id.trim().length() == 0 || password.trim().length() == 0) {
			System.out.println("다시 입력");
			// response.sendRedirect("login.jsp");
		} else {
				User newMember = new User(id,password,nickname,phoneNumber,email);
				UserService us = new UserService();
			  			
			if (us.update(newMember) != 0) {
				System.out.println("변경 성공");
				request.setAttribute("message", "변경 성공");
				request.getRequestDispatcher("changeSuccess.jsp").forward(request, response);
			} else {
				System.out.println("없음");
				request.setAttribute("message", "없음");
				request.getRequestDispatcher("error/error.jsp").forward(request, response);
			}
		}

	}
	//7. 주문
	protected void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String OrderNumber = request.getParameter("OrderNumber"); // 주문 번호
		String userId= request.getParameter("userId"); // ID
		String productName= request.getParameter("productName");// 주문 물품 이름
		String orderCount= request.getParameter("orderCount");// 주문 수량
		String orderTime= request.getParameter("orderTime");// 주문 시간
		String Address= request.getParameter("Address"); // 주소
		System.out.println(OrderNumber + "," + userId + "," + productName + "," + orderCount + "," + orderTime + "," + Address);

		
			Order order=new Order(OrderNumber,userId,productName,orderCount,orderTime,Address);
		
			UserService or = new UserService();
			int result = or.purchase(order);
			if (result == 0) {
				System.out.println("주문에 실패했습니다.");
			} else {
				System.out.println("주문에 성공했습니다.");
			}

			request.getRequestDispatcher("loginView.jsp").forward(request, response);
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
