package zarazio.travel.android;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;


@Controller
public class TravelLogController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	
	@RequestMapping("insertLog")
	public String inserLog(HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List items= null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator itr = items.iterator();
	    while (itr.hasNext()) {
	        FileItem item = (FileItem) itr.next();
	        System.out.println(item.isFormField());
	        if (item.isFormField()) { // ������ �ƴ� ���ʵ忡 �Է��� ������ ������.
	          if(item!=null && item.getFieldName().equals("log_Title")) {
	            String name = item.getString("KSC5601");//form field �ȿ� �Է��� �����͸� ������
	            System.out.println("�α� ����:"+name+"<br>"); 
	          }else if(item!=null && item.getFieldName().equals("log_Content")) {
	            String desc = item.getString("KSC5601");
	            System.out.println("�α� ����:"+desc+"<br>");
	          }
	        }
	        else{ // �� �ʵ尡 �ƴϰ� ������ ���
	            try {
	                String itemName = item.getName();//���� �ý��� ���� ���ϰ�� �� ���� �̸� ����
	                if(itemName==null || itemName.equals("") ) continue;
	                String fileName = FilenameUtils.getName(itemName);// ��ξ��� �����̸��� ������
	                if(fileName.equals("null")) continue;
	                // ���۵� ������ ������ �����ϱ� ���� ����
	                //String rootPath = getServletContext().getRealPath("/");
	                File savedFile = new File("C:/Return_andserver/TravelLogAndroid/src/main/webapp/resources/upload/"+System.currentTimeMillis()+"Travel_log_"+fileName); 
	                item.write(savedFile);// ���� ��ο� ������ ������
	              
	                System.out.println("<tr><td><b>�������� ���:</b></td></tr><tr><td><b>"+savedFile+"</td></tr>");
	                System.out.println("<tr><td><b><a href=\"DownloadServlet?file="+fileName+"\">"+fileName+"</a></td></tr>");
	             } catch (Exception e) {
	            	 System.out.println("������ ���� ������ ����: "+e);
	               }
	        }
	    }
		System.out.println("success");
		return "success";
	}
	

}
