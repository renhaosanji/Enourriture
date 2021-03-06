package ent.controller.manager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ent.model.dto.Contents;
import ent.model.dto.ProductInfo;
import ent.model.service.FollowService;
import ent.model.service.ManagerService;

public class managerController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	// com test
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		process(request, response);		
	}
	
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		System.out.println(action);
		/*
		 * 1. 글 등록
		 * 2. 글 변경
		 * 3. 글 삭제
		 * 4. 내 글 조회
		 * 5. 주문 정보 확인
		 * 6. 좋아요
		 */
		switch(action){
		case "inputContent":
			System.out.println("inputContent");
			inputContent(request,response);
			break;
		case "updateContent":
			System.out.println("upload");
//			inputContent(request,response);
			break;
		case "deleteContent":
			System.out.println("upload");
//			inputContent(request,response);
			break;
		case "myContent":
			System.out.println("myContent");
			myContent(request,response);
			break;
		case "myOrder":
			System.out.println("upload");
//			inputContent(request,response);
			break;
		case "likeCountPlus":
			System.out.println("upload");
//			likeCountPlus(request,response);
			break;
			
		}
	}
	
	
	
	// 1. 글 등록
	protected void inputContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 작성자
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");			
		
		// 작성일
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String writeDate = sdf.format(new Date());
		
		// 이미지
		Contents contents = new Contents();
		ServletContext context = getServletContext();
		String addr = (String)request.getRealPath("image");
		System.out.println(addr);
		String imgURL = addr.substring(addr.indexOf("WebContent")+11, addr.length());
		System.out.println(imgURL);
		MultipartRequest multi = new MultipartRequest(request, addr, 5 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());
		String name = multi.getFilesystemName("imgfile");
		System.out.println(name);
		
		// 내용
		String text = (String)multi.getParameter("contents");
		
		contents.setUserId(id);
		contents.setContents(text);
		contents.setWriteDate(writeDate);
		contents.setImgURL(imgURL+"\\"+name);
		
		System.out.println(contents.toString());
		
		ManagerService ms = new ManagerService();
		int result_inputcontents = ms.inputContents(contents);
		int contentsid=0;
		if(result_inputcontents!=0){
			contentsid = ms.findID(contents);
		} else {
			return;
		}
		
		// 상품 정보 추출
		String product = (String)multi.getParameter("product");
		String productStore = (String)multi.getParameter("productStore");
		String productStoreAddr = (String)multi.getParameter("productStoreAddr");
		String price = (String)multi.getParameter("price");
		int evaluation=0;
		
		for(int i=0;i<5;i++) {
			
			if(((String)multi.getParameter("like"+(i+1)))!=null&&((String)multi.getParameter("like"+(i+1))).equals("on")){
				evaluation=i+1;
				break;
			}
		}
		evaluation=6-evaluation;
		System.out.println(evaluation);
		// 상품 정보 등록
		ProductInfo productInfo = new ProductInfo();
		
		productInfo.setUserId(id);
		productInfo.setProductName(product);
		productInfo.setProductStore(productStore);
		productInfo.setProductPrice(price);
		productInfo.setEvaluation(evaluation);
		productInfo.setProductStoreAddr(productStoreAddr);
		productInfo.setContentsId(contentsid);
		
		contents.setProductInfo(productInfo);
		System.out.println(productInfo.toString());
		
		
		int result_productInfo=ms.inputProductInfo(productInfo);
		if(result_productInfo!=0){
			System.out.println("성공");
		} else { 
			System.out.println("실패");
		}

	}
	
	// 4. 글 조회
	protected void myContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			// 작성자
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("ID");
			System.out.println(id);
			
			ManagerService ms = new ManagerService();
			
			ArrayList<Contents> list = ms.myContents(id);
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getContentId());
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("myContents.jsp").forward(request, response);
	}
	
	public ArrayList<Contents> getList(HttpServletRequest request) throws ServletException, IOException {
		
		ManagerService ms = new ManagerService();
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("ID");
		
		
		return ms.getList(userid);
			
	}
	
	public ArrayList<Contents> getMyList(HttpServletRequest request) throws ServletException, IOException {
		
		ManagerService ms = new ManagerService();
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("ID");
		
		
		return ms.myContents(userid);
			
	}
	
	
	public ArrayList<Contents> getFollowContents(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");
		
		FollowService fs = new FollowService();
		
		return fs.usersFollowingContentsLoading(id);
			
	}
	
	
	
	protected void updateContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String contentsid = (String)request.getAttribute("contentsid");
				// 작성자
				HttpSession session = request.getSession();
				String id = (String)session.getAttribute("ID");			
				
				// 작성일
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String writeDate = sdf.format(new Date());
				
				// 이미지
				Contents contents = new Contents();
				ServletContext context = getServletContext();
				String addr = (String)request.getRealPath("image");
				System.out.println(addr);
				String imgURL = addr.substring(addr.indexOf("WebContent")+11, addr.length());
				System.out.println(imgURL);
				MultipartRequest multi = new MultipartRequest(request, addr, 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
				String name = multi.getFilesystemName("imgfile");
				System.out.println(name);
				
				// 내용
				String text = (String)multi.getParameter("contents");
				
				contents.setUserId(id);
				contents.setContents(text);
				contents.setWriteDate(writeDate);
				contents.setImgURL(imgURL+"\\"+name);
				
				System.out.println(contents.toString());
				
				ManagerService ms = new ManagerService();
				int result_inputcontents = ms.updateContents(contents);
				
				if(result_inputcontents==0){
					return;
				} 
				
				// 상품 정보 추출
				String product = (String)multi.getParameter("product");
				String productStore = (String)multi.getParameter("productStore");
				String productStoreAddr = (String)multi.getParameter("productStoreAddr");
				String price = (String)multi.getParameter("price");
				String evaluation = (String)multi.getParameter("like");
				
				// 상품 정보 등록
				ProductInfo productInfo = new ProductInfo();
				
				productInfo.setUserId(id);
				productInfo.setProductName(product);
				productInfo.setProductStore(productStore);
				productInfo.setProductPrice(price);
				productInfo.setEvaluation(Integer.parseInt(evaluation));
				productInfo.setProductStoreAddr(productStoreAddr);
				productInfo.setContentsId(Integer.parseInt(contentsid));
				
				contents.setProductInfo(productInfo);
				System.out.println(productInfo.toString());
				
				
				int result_productInfo=ms.updateProductInfo(productInfo);
				if(result_productInfo!=0){
					System.out.println("성공");
				} else { 
					System.out.println("실패");
				}
	}
	
	
	
}
