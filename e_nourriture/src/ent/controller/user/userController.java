package ent.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ent.model.dto.User;
import ent.model.service.UserService;

/**
 * Servlet implementation class Controller
 */
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		System.out.println(action);
		
		switch(action){
		case "login":
			login(request,response);
			break;
		case "join":
			join(request,response);
			break;
			
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		
		
		if(id.indexOf(" ")!=-1||id==null||password==null||password.indexOf(" ")!=-1){
			System.out.println("잘못 입력하셨습니다.");
			request.getRequestDispatcher("error/error.html").forward(request, response);
			return;
		} else {
			System.out.println(id+","+password);
			
			 UserService us = new UserService();
			 boolean isLogin = us.login(id, password);
			 
			 if(isLogin) {
				 System.out.println("로그인 요청 성공");
				 HttpSession session = request.getSession();
				 session.setAttribute("ID", id);
				 request.getRequestDispatcher("index.jsp").forward(request,response);
			 }
			
		}
	
	}
	
	protected void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		String password_chk = request.getParameter("password_chk");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		
		System.out.println(id+","+password+","+password_chk+","+name+","+phone+","+mail);
		
		if(password.equals(password_chk)){
			
			User user = new User(id,password,name,phone, mail);
			UserService ms = new UserService();
			int result=ms.join(user);
			if(result==0){
				System.out.println("실패!");
			} else {
				System.out.println("성공!");
			}
			
			request.getRequestDispatcher("loginView.jsp").forward(request, response);
		} else {
			System.out.println("정보 조회에 실패하였습니다.");
			request.setAttribute("message","정보 조회에 실패하였습니다." );
			request.getRequestDispatcher("error/error.jsp").forward(request,response);
		}
		
		
		
	}
	
	
	

}
