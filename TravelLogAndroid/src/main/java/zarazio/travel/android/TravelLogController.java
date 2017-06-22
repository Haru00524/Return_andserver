package zarazio.travel.android;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import zarazio.travel.android.bean.ARFilterDTo;
import zarazio.travel.android.bean.attachedFileDTO;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.hashTagDTO;
import zarazio.travel.android.service.ARDataService;
import zarazio.travel.android.service.StepService;
import zarazio.travel.android.service.boardService;

@Controller
public class TravelLogController {

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Inject
	private boardService service;
	
	@RequestMapping(value="/boardList")
	public ResponseEntity<String> ARDataList(ARFilterDTo arFilter) throws Exception {
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");
		List<boardDTO> List = null;
		
		
		if(arFilter.getHashTag().equals("없음") && arFilter.getOrder_DB().equals("1")){
			List = service.boardList();
		}else if(!(arFilter.getHashTag().equals("없음")) && arFilter.getOrder_DB().equals("1")){
			List = service.boardList(arFilter.getHashTag());
		}else if(arFilter.getHashTag().equals("없음") && arFilter.getOrder_DB().equals("2")){
			
		}else if(!(arFilter.getHashTag().equals("없음")) && arFilter.getOrder_DB().equals("2")){
			
		}
		Gson gson = new Gson();
		String data =  gson.toJson(List);

		return new ResponseEntity<String>(data,resHeaders,HttpStatus.CREATED);
		
	}

	@RequestMapping(value="/picture")
	public ResponseEntity<String> selPicture(int board_code) throws Exception {
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");

		System.out.println(board_code+"출력");
		List<attachedFileDTO> List = service.selPicture(board_code);

		Gson gson = new Gson();
		String data =  gson.toJson(List);
		
		if(data.equals("[]")){
			data="failed";
		}
		System.out.println(data);
		return new ResponseEntity<String>(data,resHeaders,HttpStatus.CREATED);
		
	}

	@RequestMapping(value="/insertLog")
	public ResponseEntity<String> inserLog(HttpServletRequest request) throws UnsupportedEncodingException{

		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=EUC_KR");
		
		int board_Type_Code = 0 ;
		int share_Type = 0;
		String board_Title = null;
		String board_Content = null;
		String hash_Tag = null;
		double log_longtitude = 0;
		double log_latitude = 0;
		String user_id = null;
		String originalName = "";
		int file_Type=0;
		int step_code = 0;
		int write_type= 1;
		
		HttpStatus a=HttpStatus.BAD_REQUEST;
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List items= null;
		
		try {
			items = upload.parseRequest(request);
			a = HttpStatus.OK;
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		Iterator itr = null;
		if(items!=null){
		 itr= items.iterator();
		}
	    while (itr.hasNext()) {
	        FileItem item = (FileItem) itr.next();
	        System.out.println(item.isFormField());
	        if (item.isFormField()) { // 파일이 아닌 폼필드에 입력한 내용을 가져옴.
	          if(item!=null && item.getFieldName().equals("log_Title")) {
	        	  board_Title = item.getString("EUC_KR");//form field 안에 입력한 데이터를 가져옴
	        	  System.out.println("로그 제목:"+board_Title+"<br>"); 
	          }else if(item!=null && item.getFieldName().equals("log_Content")) {
	        	  board_Content = item.getString("EUC_KR");
	        	  System.out.println("로그 내용:"+board_Content+"<br>");
	          }else if(item!=null && item.getFieldName().equals("hash_tag")) {
		          hash_Tag = "#"+item.getString("EUC_KR");
		          System.out.println("해시태그 내용:"+hash_Tag+"<br>");
		      }else if(item!=null && item.getFieldName().equals("log_longtitude")) {
		          log_longtitude = Double.parseDouble(item.getString("EUC_KR"));
		          System.out.println("경도 내용:"+log_longtitude+"<br>");
		      }else if(item!=null && item.getFieldName().equals("log_latitude")) {
		          log_latitude = Double.parseDouble(item.getString("EUC_KR"));
		          System.out.println("위도 내용:"+log_latitude+"<br>");
		      }else if(item!=null && item.getFieldName().equals("share_type")) {
		    	  share_Type = Integer.parseInt(item.getString("EUC_KR"));
		          System.out.println("공유 여부 :"+share_Type+"<br>");
		      }else if(item!=null && item.getFieldName().equals("board_type")) {
		    	  board_Type_Code = Integer.parseInt(item.getString("EUC_KR"));
		          System.out.println("게시판 타입 내용:"+board_Type_Code+"<br>");
		      }else if(item!=null && item.getFieldName().equals("user_id")) {
		          user_id = item.getString("EUC_KR");
		          System.out.println("유저아이디:"+user_id+"<br>");
		      }else if(item!=null && item.getFieldName().equals("file_Type")) {
		          file_Type = Integer.parseInt(item.getString("EUC_KR"));
		          System.out.println("파일 타입:"+file_Type+"<br>");
		      }else if(item!=null && item.getFieldName().equals("step_log")) {
		          step_code = Integer.parseInt(item.getString("EUC_KR"));
		          System.out.println("step_Log_Code:"+step_code+"<br>");
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
	                originalName = System.currentTimeMillis()+"Travel_log_";
	                File savedFile = new File("C:/Return_andserver/TravelLogAndroid/src/main/webapp/resources/upload/"+ originalName+fileName); 
	                item.write(savedFile);// 지정 경로에 파일을 저장함
	                originalName += fileName;
	                System.out.println("<tr><td><b>파일저장 경로:</b></td></tr><tr><td><b>"+savedFile+"</td></tr>");
	                System.out.println("<tr><td><b><a href=\"DownloadServlet?file="+fileName+"\">"+originalName+"</a></td></tr>");
	             } catch (Exception e) {
	            	 System.out.println("서버에 파일 저장중 에러: "+e);
	               }
	        }
	    }

	    int maxboardCode= 0;
		try {
			maxboardCode = (service.maxboard_Code()+1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       boardDTO board = new boardDTO();
        
       	int randomViewY = (int)(Math.random()*1500)-700;
       	
        board.setBoard_code(maxboardCode);
        board.setBoard_title(board_Title);
        board.setBoard_content(board_Content);
        board.setBoard_type_code(board_Type_Code);
        board.setLog_latitude(log_latitude);
        board.setLog_longtitude(log_longtitude);
        board.setShare_type(share_Type);
        board.setUser_id(user_id);
        board.setRandomViewY(randomViewY);
        board.setStep_log_code(step_code);
        board.setWrite_type(write_type);
	    
        hashTagDTO hash = new hashTagDTO();
        hash.setBoard_code(maxboardCode);
        hash.setHash_tag_content(hash_Tag);
        
        attachedFileDTO file = new attachedFileDTO();
        file.setBoard_code(maxboardCode);
        file.setFile_content(originalName);
        file.setFile_type(file_Type);
        
        try {
			service.insertBoard(board);
        	if(!hash_Tag.equals("")){
        		service.insertHash(hash);
        	}
			if(!originalName.equals("")){
				service.insertFile(file);
			}
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return new ResponseEntity<String>("success", resHeaders, a);
	}

}