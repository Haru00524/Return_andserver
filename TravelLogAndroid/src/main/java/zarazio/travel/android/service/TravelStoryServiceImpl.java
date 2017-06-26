package zarazio.travel.android.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zarazio.travel.android.bean.Member;
import zarazio.travel.android.bean.TravelStory;
import zarazio.travel.android.dao.TravelStoryDAO;

@Service
public class TravelStoryServiceImpl implements TravelStoryService {

   @Inject // �󿡵��, ���
   private TravelStoryDAO dao; // interface�� ��ü�� �ƴϱ⶧���� ��ӹ޴� ������ü�� ����
   
   @Override
   public void expenseInsert(TravelStory travelstory) throws Exception {
      // TODO Auto-generated method stub
      dao.expenseInsert(travelstory);
   }
   
   @Override
	public int fineMaxExpenseCode() throws Exception {
		// TODO Auto-generated method stub
		return dao.fineMaxExpenseCode();
	}

   @Override
	public void expenseInsertTravel(TravelStory travelstory) throws Exception {
		// TODO Auto-generated method stub
		dao.expenseInsertTravel(travelstory);
	}

@Override
   public List<TravelStory> titleSearch(String user_id) throws Exception {
      // TODO Auto-generated method stub
      return dao.titleSearch(user_id); // ������ü�� Ŭ������ ���
   }

	@Override
	public List<TravelStory> DivisionSearch(String group_Code) throws Exception {
		// TODO Auto-generated method stub
		return dao.DivisionSearch(group_Code);
	}
}