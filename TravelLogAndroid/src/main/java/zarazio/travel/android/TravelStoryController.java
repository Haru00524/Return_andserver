package zarazio.travel.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import zarazio.travel.android.bean.Member;
import zarazio.travel.android.bean.TravelStory;
import zarazio.travel.android.service.TravelStoryService;

@Controller
public class TravelStoryController {

   @Inject
   private TravelStoryService service;
   
   @RequestMapping("/expenseInsert")
   @ResponseBody // 데이터만 보낼때 씀
   public void expenseInsert(HttpServletRequest request, TravelStory travelstory) throws Exception {
	   service.expenseInsert(travelstory);
	   travelstory.setExpense_Code(service.fineMaxExpenseCode());
//	   System.out.println("그룹코드 : "+travelstory.getGroup_Code());
//	   System.out.println("사용자아이디 : "+travelstory.getUser_id());
//	   System.out.println("지출코드 : "+travelstory.getExpense_Code());
	   service.expenseInsertTravel(travelstory);
	   
   }
   
   @RequestMapping("/titleSearch")
   @ResponseBody // 데이터만 보낼때 씀
   public List titleSearch(HttpServletRequest request, String user_id) throws Exception { // String user_id를 쓰려면 안드로이드에서
      List<TravelStory> list = service.titleSearch(user_id);
      
      List<HashMap> m_list = new ArrayList();
      Map<Object, String> map = null;
      
      for(int i=0; i<list.size(); i++) {
         map = new HashMap();
         
         map.put("group_Code", list.get(i).getGroup_Code()+"");
         map.put("travel_title", list.get(i).getTravel_title());
         map.put("start_date", list.get(i).getStart_Date().toString());
         map.put("end_date", list.get(i).getEnd_Date().toString());
         m_list.add((HashMap) map);
      }                                                         // Map에 담아서 보낼때 key와 같게해야함
      
      System.out.println(m_list);
      return m_list; // 웹 -> 앱
   }
   
   @RequestMapping("/scDivisionSearch")
   @ResponseBody
   public List scDivisionSearch(HttpServletRequest request, String group_Code) throws Exception{
	  List<TravelStory> s_list = service.DivisionSearch(group_Code);
      
	  System.out.println("한도, 구분출력 : "+s_list.get(0));
      return s_list;
   }
}
