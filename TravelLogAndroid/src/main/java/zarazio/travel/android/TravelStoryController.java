package zarazio.travel.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
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
   @ResponseBody // �����͸� ������ ��
   public void expenseInsert(HttpServletRequest request, TravelStory travelstory) throws Exception {
      service.expenseInsert(travelstory);
      travelstory.setExpense_Code(service.fineMaxExpenseCode());
//      System.out.println("�׷��ڵ� : "+travelstory.getGroup_Code());
//      System.out.println("����ھ��̵� : "+travelstory.getUser_id());
//      System.out.println("�����ڵ� : "+travelstory.getExpense_Code());
      service.expenseInsertTravel(travelstory);
      
   }
   
   @RequestMapping("/titleSearch")
   @ResponseBody // �����͸� ������ ��
   public List titleSearch(HttpServletRequest request, String user_id) throws Exception { // String user_id�� ������ �ȵ���̵忡��
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
      }                                                         // Map�� ��Ƽ� ������ key�� �����ؾ���
      
      System.out.println(m_list);
      return m_list; // �� -> ��
   }
  
   @RequestMapping("/scDivisionSearch")
   @ResponseBody
   public JSONObject scDivisionSearch(HttpServletRequest request, String group_Code) throws Exception{
     List<TravelStory> s_list = service.DivisionSearch(group_Code);
      
     JSONObject jsonObj = new JSONObject();
     jsonObj.put("coin_Limit", s_list.get(0).getCoin_Limit());
     jsonObj.put("sc_Division", s_list.get(0).getSc_Division());
     
     System.out.println("�ѵ�, ������� : "+jsonObj.toString());
      return jsonObj;
   }
   
   @RequestMapping("/selectExpense")
   @ResponseBody // �����͸� ������ ��
   public List selectExpense(HttpServletRequest request, String group_Code) throws Exception { // String user_id�� ������ �ȵ���̵忡��
     List<TravelStory> list = service.selectExpense(group_Code);
      
      List<HashMap> m_list = new ArrayList();
      Map<Object, String> map = null;
      
      for(int i=0; i<list.size(); i++) {
         map = new HashMap();
         
         map.put("user_id", list.get(i).getUser_id()+"");
         map.put("expense_Content", list.get(i).getExpense_Content());
         map.put("expense_Cost", list.get(i).getExpense_Cost()+"");
         map.put("expense_Date", list.get(i).getExpense_Date().toString());
         m_list.add((HashMap) map);
      }                                                         // Map�� ��Ƽ� ������ key�� �����ؾ���
      
      System.out.println(m_list);
      return m_list; // �� -> ��
   }
}