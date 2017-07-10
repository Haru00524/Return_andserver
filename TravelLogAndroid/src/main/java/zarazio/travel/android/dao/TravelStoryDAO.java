package zarazio.travel.android.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import zarazio.travel.android.bean.TravelStory;

public interface TravelStoryDAO {
   public void expenseInsert(TravelStory travelstory) throws Exception; // 사용금액 입력
   public int fineMaxExpenseCode() throws Exception; // 가장 최근에 추가된 지출코드 찾기
   public void expenseInsertTravel(TravelStory travelstory) throws Exception; // 어떤그룹에서 누가 어떤 금액코드를 사용했는지 입력
   public List<TravelStory> titleSearch(String user_id) throws Exception;
   public List<TravelStory> DivisionSearch(String group_Code) throws Exception; // 여비한도와 구분찾기
   public List<TravelStory> selectExpense(String group_Code) throws Exception;
}