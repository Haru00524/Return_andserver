package zarazio.travel.android;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.myPlaceDTO;
import zarazio.travel.android.service.QNAService;

@Controller
public class FcmPushController {
	public final static String AUTH_KEY_FCM = "AAAA38W0sqQ:APA91bERMrpDlZlVLMxJWbrf1u2Q5Mm7QIRbQC942UD2sIBBavbgwyre0xozWYyR1AMe_R8Xqsm09jKWI6MRgPMpAZ49jmwsGVb0faUubr1M_gOJDyLpM9oQa-XBH2UpSiZ_uzcH3YmE";
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
	
	@Inject
	private static QNAService service;
	
	@RequestMapping("push_alram")
	@ResponseBody
	public static void pushFCMNotification(String userDeviceIdKey, String longitude, String latitude) throws Exception {
		String authKey = AUTH_KEY_FCM; // You FCM AUTH key
		String FMCurl = API_URL_FCM;
		myPlaceDTO place = new myPlaceDTO();
		place.setLatitude(Double.parseDouble(latitude));
		place.setLongitude(Double.parseDouble(longitude));
		int board_code = 0;
		board_code = service.boardserch(place);
		if(board_code == -1){
			System.out.println("�ƹ��͵� ����");
		}else{
			System.out.println(board_code);
		}
		/*URL url = new URL(FMCurl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + authKey);
		conn.setRequestProperty("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		JSONObject info = new JSONObject();

		info.put("body", "Ǫ�� �߼� �׽�Ʈ �Դϴ�."); // Notification body

		json.put("notification", info);
		json.put("to", userDeviceIdKey.trim()); // deviceID

		try (OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream())) {
			// Ȥ�ó� �ѱ� ������ �߻��ϸ�
			// try(OutputStreamWriter wr = new
			// OutputStreamWriter(conn.getOutputStream(), "UTF-8")){ ���ڵ��� �������ش�.

			wr.write(json.toString());
			wr.flush();
		} catch (Exception e) {
		}

		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();*/
	}

	
}
