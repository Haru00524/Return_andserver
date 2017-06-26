package zarazio.travel.android.service;

import java.util.List;

import zarazio.travel.android.bean.TravelStory;

public interface TravelStoryService {
   public void expenseInsert(TravelStory travelstory) throws Exception; // 사용금액 입력
   public int fineMaxExpenseCode() throws Exception;
   public void expenseInsertTravel(TravelStory travelstory) throws Exception;
   public List<TravelStory> titleSearch(String user_id) throws Exception;
   public List<TravelStory> DivisionSearch(String group_Code) throws Exception; // 여비한도와 구분찾기
}