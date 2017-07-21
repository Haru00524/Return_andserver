package zarazio.travel.android.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import zarazio.travel.android.bean.attachedFileDTO;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.boardLIstDTO;
import zarazio.travel.android.bean.hashTagDTO;

@Repository 
public class ListViewDAOImpl implements ListViewDAO {

public static final String namespace = "travel.android.boardMapper" ;

@Inject
private SqlSession sqlSession ;

@Override
public List<boardLIstDTO> serachList() throws Exception {
	// TODO Auto-generated method stub
	return sqlSession.selectList(namespace+".share_Log_all_List");
}

@Override
public List<boardLIstDTO> serachListHashList(String hash_tag) throws Exception {
	// TODO Auto-generated method stub
	return sqlSession.selectList(namespace+".share_Log_search_List", hash_tag);
}

@Override
public List<boardLIstDTO> mainList(String main_user_id) throws Exception {
	// TODO Auto-generated method stub
	return sqlSession.selectList(namespace+".share_Log_main_List", main_user_id);
}

@Override
public void boardLike(boardDTO board) throws Exception {
	// TODO Auto-generated method stub
	sqlSession.insert(namespace+".likeInsert", board);
}
	
	

}
