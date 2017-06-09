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
	        if (item.isFormField()) { // 파일이 아닌 폼필드에 입력한 내용을 가져옴.
	          if(item!=null && item.getFieldName().equals("log_Title")) {
	            String name = item.getString("KSC5601");//form field 안에 입력한 데이터를 가져옴
	            System.out.println("로그 제목:"+name+"<br>"); 
	          }else if(item!=null && item.getFieldName().equals("log_Content")) {
	            String desc = item.getString("KSC5601");
	            System.out.println("로그 내용:"+desc+"<br>");
	          }
	        }
	        else{ // 폼 필드가 아니고 파일인 경우
	            try {
	                String itemName = item.getName();//로컬 시스템 상의 파일경로 및 파일 이름 포함
	                if(itemName==null || itemName.equals("") ) continue;
	                String fileName = FilenameUtils.getName(itemName);// 경로없이 파일이름만 추출함
	                if(fileName.equals("null")) continue;
	                // 전송된 파일을 서버에 저장하기 위한 절차
	                //String rootPath = getServletContext().getRealPath("/");
	                File savedFile = new File("C:/Return_andserver/TravelLogAndroid/src/main/webapp/resources/upload/"+System.currentTimeMillis()+"Travel_log_"+fileName); 
	                item.write(savedFile);// 지정 경로에 파일을 저장함
	              
	                System.out.println("<tr><td><b>파일저장 경로:</b></td></tr><tr><td><b>"+savedFile+"</td></tr>");
	                System.out.println("<tr><td><b><a href=\"DownloadServlet?file="+fileName+"\">"+fileName+"</a></td></tr>");
	             } catch (Exception e) {
	            	 System.out.println("서버에 파일 저장중 에러: "+e);
	               }
	        }
	    }
		System.out.println("success");
		return "success";
	}
	

}
