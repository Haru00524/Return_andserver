package zarazio.travel.android.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import zarazio.travel.android.bean.attachedFileDTO;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.hashTagDTO;

@Repository 
public class boardDAOImpl implements boardDAO {

public static final String namespace = "travel.android.boardMapper" ;
	
	@Inject
	private SqlSession sqlSession ;
	
	@Override
	public void insertBoard(boardDTO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".Log_inset", board);
	}

	@Override
	public void insertHash(hashTagDTO hash) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".hash_Tag_insert", hash);
	}

	@Override
	public int maxboard_Code() throws Exception {
		// TODO Auto-generated method stub
		int number=0;
		if(sqlSession.selectOne(namespace+".max_board_code") == null){
			number = 0;
		}else{
			number = sqlSession.selectOne(namespace+".max_board_code");
		}
		return number;
	}

	@Override
	public void insertFile(attachedFileDTO files) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".attachecFile", files);
	}

	@Override
	public List<boardDTO> boardList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".share_Log_List");
	}

}
