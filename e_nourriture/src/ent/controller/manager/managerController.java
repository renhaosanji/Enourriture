package ent.controller.manager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import ent.model.dto.Contents;
import ent.model.dto.ProductInfo;
import sun.rmi.runtime.Log;

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
		 * 1. �� ���
		 * 2. �� ����
		 * 3. �� ����
		 * 4. �� �� ��ȸ
		 * 5. �ֹ� ���� Ȯ��
		 */
		switch(action){
		case "inputContent":
			System.out.println("inputContent");
			inputContent(request,response);
			break;
		case "updateContent":
			System.out.println("upload");
			upload(request,response);
			break;
		case "deleteContent":
			System.out.println("upload");
			upload(request,response);
			break;
		case "myContent":
			System.out.println("upload");
			upload(request,response);
			break;
		case "myOrder":
			System.out.println("upload");
			upload(request,response);
			break;
			
		
		}
	}
	
	protected void inputContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("ID");			//�ۼ���
		String text = (String)request.getAttribute("text");		//����
		String writeDate = (String)request.getAttribute("writeDate");
		
		Contents contents = new Contents();
		
		contents.setUserId(id);
		contents.setContents(text);
		contents.setWriteDate(writeDate);
		
		
		String product = (String)request.getAttribute("product");
		String productStore = (String)request.getAttribute("productStore");
		String productStoreAddr = (String)request.getAttribute("productStoreAddr");
		String price = (String)request.getAttribute("price");
		String evaluation = (String)request.getAttribute("evaluation");
		
		
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductName(product);
		productInfo.setProductStore(productStore);
		productInfo.setProductPrice(price);
		productInfo.setEvaluation(Integer.parseInt(evaluation));
		productInfo.setProductStoreAddr(productStoreAddr);
		
		System.out.println(id+","+text);
		
		
	}
	
	protected void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = (String)request.getAttribute("file");
		System.out.println(str);
		Part part = request.getPart("file");
     
		String[] fileName = part.getHeader("content-disposition").split(";");
		
		for(int i=0;i<fileName.length;i++){
			System.out.println(fileName[i]);
		}
	}
	/*
	protected void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssS"); //�ߺ����ϸ� ���ܸ� ���� ����

		//�⺻ ��� ����

		String path = "c:\\upload";

		//path �� �ӽ������� �����

		//�⺻���δ� File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir") ���� ���ؿ� ���� �����

		File repository = new File(path);
		factory.setRepository(repository);
		ServletFileUpload upload = new ServletFileUpload(factory);
	
		try {
			//parseRequest �ϴ� ���� upload ������ �ӽ����ϵ��� ����
			List<FileItem> item= new List<FileItem>();
		
			

			for(FileItem f : items) {

				if(f.getName() == null ) {

					continue;
				}
				
				String tmpFileNm = f.getName().split("\\.")[0];
				String tmpExtNm = "";
				if(f.getName().split("\\.").length > 1) {
					tmpExtNm = "." + f.getName().split("\\.")[1];
				}
				String uploadFileNm = tmpFileNm + "_" + sdf.format(new Date()) + tmpExtNm;
				//�ٷ� ���Ϸ� ����
				File uploadFile = new File(path + "\\" + uploadFileNm );

				if(f.isFormField() == false) { //file ��ü �ʵ�

					if(f.getName() != null && f.getName().equals("") == false) {

						//�ӽ�file ������ FileCleaner �� ���� �����Ǵµ� 

						//����� java.io.File ��ü�� �������÷��� �Ǹ� �۵��Ѵٰ� �ϴ� �� ����

						f.write(uploadFile);
						//��Ʈ�� ó��
						
						InputStream uploadStream = f.getInputStream();
						File uploadFile = new File(path + "\\" + f.getName());
						FileOutputStream outputStream = new FileOutputStream(uploadFile);
						byte[] buf = new byte[1024];
						int len;
						while( (len = uploadStream.read(buf)) > 0 ) {
							outputStream.write(buf);
						}
						outputStream.close();
						uploadStream.close();
																	
					} else { //f.getName() != null && f.getName().equals("") == false

					}
				} else { //�Ϲ� �ʵ�
				}

			}

			//���� �޽���

			request.setAttribute("logs", "�����Ͽ����ϴ�.");

			//ó�� �Ϸ� �� forwardó��

			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (FileUploadException e) {

			// TODO Auto-generated catch block

			//logger.error(e, e);

			e.printStackTrace();

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}



	}
*/	
}
