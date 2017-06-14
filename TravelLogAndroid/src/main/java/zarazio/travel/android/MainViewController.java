package zarazio.travel.android;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

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

import zarazio.travel.android.bean.ARDataInfo;
import zarazio.travel.android.bean.boardLIstDTO;
import zarazio.travel.android.service.ARDataService;
import zarazio.travel.android.service.ListViewService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainViewController {
	
	@Inject
	private ListViewService service ;
	
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
}
