package zarazio.travel.android.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import zarazio.travel.android.bean.TravelStory;

public interface TravelStoryDAO {
   public void expenseInsert(TravelStory travelstory) throws Exception; // ���ݾ� �Է�
   public int fineMaxExpenseCode() throws Exception; // ���� �ֱٿ� �߰��� �����ڵ� ã��
   public void expenseInsertTravel(TravelStory travelstory) throws Exception; // ��׷쿡�� ���� � �ݾ��ڵ带 ����ߴ��� �Է�
   public List<TravelStory> titleSearch(String user_id) throws Exception;
   public List<TravelStory> DivisionSearch(String group_Code) throws Exception; // �����ѵ��� ����ã��
   public List<TravelStory> selectExpense(String group_Code) throws Exception;
}