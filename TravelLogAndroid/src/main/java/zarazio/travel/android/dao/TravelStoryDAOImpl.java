package zarazio.travel.android.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import zarazio.travel.android.bean.Member;
import zarazio.travel.android.bean.TravelStory;

@Repository // DAO��ü ����Ҽ� �ֵ����Ѵ�.
public class TravelStoryDAOImpl implements TravelStoryDAO {
   
   // Mapperã�ư��� �ֵ��� �������ش�.
   public static final String namespace = "travel.android.TravelStoryMapper";
   
   // sql�������� ����ϰڴ�(CRUD����).
   @Inject
   private SqlSession sqlSession;
   
   @Override
   public void expenseInsert(TravelStory travelstory) throws Exception {
      // TODO Auto-generated method stub
      sqlSession.insert(namespace+".expenseInsert", travelstory);
   }
   @Override
public List<TravelStory> selectExpense(String group_Code) throws Exception {
   // TODO Auto-generated method stub
   return sqlSession.selectList(namespace+".selectExpense", group_Code);
}
@Override
   public void expenseInsertTravel(TravelStory travelstory) throws Exception {
      // TODO Auto-generated method stub
         sqlSession.insert(namespace+".expenseInsertTravel", travelstory); 
   }
   @Override
   public List<TravelStory> DivisionSearch(String group_Code) throws Exception {
      // TODO Auto-generated method stub
      return sqlSession.selectList(namespace+".DivisionSearch", group_Code);
   }
   @Override
   public int fineMaxExpenseCode() throws Exception {
      // TODO Auto-generated method stub
      return sqlSession.selectOne(namespace+".fineMaxExpenseCode");
   }
   @Override
   public List<TravelStory> titleSearch(String user_id) throws Exception {
      // TODO Auto-generated method stub1
      return sqlSession.selectList(namespace+".titleSearch", user_id); // �Ķ������ ������
   }

}