package zarazio.travel.android.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zarazio.travel.android.bean.Member;
import zarazio.travel.android.bean.TravelStory;
import zarazio.travel.android.dao.TravelStoryDAO;

@Service
public class TravelStoryServiceImpl implements TravelStoryService {

   @Inject // 빈에등록, 사용
   private TravelStoryDAO dao; // interface가 객체가 아니기때문에 상속받는 하위객체를 선언
   
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
      return dao.titleSearch(user_id); // 하위객체의 클래스를 사용
   }

	@Override
	public List<TravelStory> DivisionSearch(String group_Code) throws Exception {
		// TODO Auto-generated method stub
		return dao.DivisionSearch(group_Code);
	}
}