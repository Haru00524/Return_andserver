package zarazio.travel.android;

import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import zarazio.travel.android.bean.ARDataInfo;
import zarazio.travel.android.bean.Member;
import zarazio.travel.android.dao.MemberDAO;
import zarazio.travel.android.service.ARDataService;
import zarazio.travel.android.service.MemberService;

@Controller
public class TravelLogController {
	
	
	@RequestMapping("insertLog")
	@ResponseBody
	public String insertLog() throws Exception{
	
	    String result= "success";
	    System.out.println("©сю╫");
		return result;	    
	}
}
