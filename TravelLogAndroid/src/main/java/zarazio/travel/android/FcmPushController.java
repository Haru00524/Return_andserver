package zarazio.travel.android;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import zarazio.travel.android.bean.QnaBean;
import zarazio.travel.android.bean.QnaResultBean;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.myPlaceDTO;
import zarazio.travel.android.service.QNAService;
import zarazio.travel.android.util.TimeTasks;
import zarazio.travel.android.util.TwitterTextAnalysis;

@Controller
public class FcmPushController {

	String qnaText;
	@Inject
	public QNAService service;

	@RequestMapping("push_alram")
	public ResponseEntity<String> pushFCMNotification(String userDeviceIdKey, String longitude, String latitude, String user_id)
			throws Exception {
		
		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("Content-Type", "application/json;charset=UTF-8");
		QnaResultBean result = new QnaResultBean();
		myPlaceDTO place = new myPlaceDTO();
		place.setLatitude(Double.parseDouble(latitude));
		place.setLongitude(Double.parseDouble(longitude));
		place.setUser_id(user_id);
		int board_code = 0;
		String data = null;
		board_code = service.boardserch(place);
		System.out.println(latitude +"/"+ longitude);
		System.out.println(board_code);
		/*for(Object object : log_text) {
		    String element = (String) object;
		    System.out.println(element);
		}*/
		if (board_code == -1) {
			service.placeOff(user_id);
			System.out.println("아무것도 없음");
			return new ResponseEntity<String>("없음",resHeaders,HttpStatus.CREATED);
		} else {
			boardDTO board = service.placeIn(board_code);
			System.out.println(board.getPlace_in());
			if (board.getPlace_in() == 0) {
				service.placeOn(board_code);
				TwitterTextAnalysis twitter = new TwitterTextAnalysis();
				List<String> log_text = twitter.TextAnalysis(board.getBoard_content());
				
				List<String> qna = service.selectQNA(log_text);

				int random = (int) (Math.random() * qna.size()); 

				System.out.println(qna.get(random).toString());

				qnaText = qna.get(random).toString();
		
				result.setBoard_code(board_code);
				result.setQuestion_content(qnaText);
				
				Timer t = new Timer(true);
				TimerTask task1 = new TimeTasks(userDeviceIdKey);
				t.schedule(task1, 4000);
				
				Gson gson = new Gson();
				data =  gson.toJson(result);
			}
		}
		System.out.println(data);
		return new ResponseEntity<String>(data,resHeaders,HttpStatus.CREATED);
		
	}

	
	
}
