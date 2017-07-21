package zarazio.travel.android;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import zarazio.travel.android.bean.ARDataInfo;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.boardLIstDTO;
import zarazio.travel.android.service.ARDataService;
import zarazio.travel.android.service.ListViewService;
import zarazio.travel.android.service.StepService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainViewController {
	
	@Inject
	private ListViewService service ;
	@Inject
	private StepService stepService;
	
	@RequestMapping(value="/main_View_DB")
	public ResponseEntity<String> mainViewDB(String user_id) throws Exception {
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");
		
		 List<boardLIstDTO> mainDB = service.mainList(user_id);
		
		Gson gson = new Gson();
		String data =  gson.toJson(mainDB);
		
		System.out.println(data);
		return new ResponseEntity<String>(data,resHeaders,HttpStatus.CREATED);
		
	}
	
	@RequestMapping("all_list_View")
	@ResponseBody
	public ResponseEntity<String> allListView() throws Exception{
		
		HttpHeaders resHeaders = new HttpHeaders();
	    resHeaders.add("Content-Type", "application/json;charset=UTF-8");

	    List<boardLIstDTO> search = service.serachList();
	    
	    
		Gson gson = new Gson();
		
		String data =  gson.toJson(search);
	
		System.out.println(data);
		return new ResponseEntity<String>(data, resHeaders, HttpStatus.CREATED);	    
	}
	
	@RequestMapping("search_View")
	@ResponseBody
	public ResponseEntity<String> searchListView(String hash_tag) throws Exception{
		
		HttpHeaders resHeaders = new HttpHeaders();
	    resHeaders.add("Content-Type", "application/json;charset=UTF-8");

	    List<boardLIstDTO> search = service.serachListHashList(hash_tag);
		
		Gson gson = new Gson();
		
		
		String data =  gson.toJson(search);
		return new ResponseEntity<String>(data, resHeaders, HttpStatus.CREATED);	    
	}
	
	@RequestMapping("like")
	public void boardLike(String user_id, String board_code) throws Exception{
		boardDTO board = new boardDTO();
		board.setBoard_code(Integer.parseInt(board_code));
		board.setUser_id(user_id);
		
		service.boardLike(board);
	}
	
	@RequestMapping("writeComment")
	public void boardComment() throws Exception{
		
	}
}
