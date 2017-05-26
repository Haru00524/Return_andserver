package zarazio.travel.android.dao;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import zarazio.travel.android.bean.Member;


@Repository 
public class MemberDAOImpl implements MemberDAO{

	public static final String namespace = "travel.android.memberMapper" ;
	
	@Inject
	private SqlSession sqlSession ;
	
	
	@Override
	public void insert(Member member) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insert", member);
	}


	@Override
	public int loginCheck(Member member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".loginCheck", member);
	}


	@Override
	public int idCheck(Member member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".idCheck",member) ;
	}


	@Override
	public String idFind(Member member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".idfind",member);
	}


	@Override
	public Member passFind(Member member) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".passfind", member);
	}


	@Override
	public void lostpass(Member member) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".lostpass", member);
	}

	
}
