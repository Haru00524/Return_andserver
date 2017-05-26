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
public class ARDataTestController {
	
	@Inject
	private ARDataService service ;

	
	
	@RequestMapping("ardata")
	@ResponseBody
	public ResponseEntity<String> ARDataList() throws Exception{
		
		HttpHeaders resHeaders = new HttpHeaders();
	    resHeaders.add("Content-Type", "application/json;charset=UTF-8");

		List<ARDataInfo> ar = service.ARDatalist();
		
		Gson gson = new Gson();
		
		
		String data =  gson.toJson(ar);
		return new ResponseEntity<String>(data, resHeaders, HttpStatus.CREATED);	    
	}
}
