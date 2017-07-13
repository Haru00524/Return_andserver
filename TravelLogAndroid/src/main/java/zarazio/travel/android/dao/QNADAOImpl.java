package zarazio.travel.android.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.myPlaceDTO;

@Repository 
public class QNADAOImpl implements QNADAO {
	
	public static final String namespace = "zara.zio.qnaMapper" ;
	
	@Inject
	private SqlSession sqlSession ;
	@Override
	public int boardserch(myPlaceDTO myplace) throws Exception {
		// TODO Auto-generated method stub\
		int board_code = sqlSession.selectOne(namespace+".boardserch", myplace);
		System.out.println(board_code);
		return board_code;
	}

}
