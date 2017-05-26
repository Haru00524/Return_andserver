package zarazio.travel.android.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zarazio.travel.android.bean.Member;
import zarazio.travel.android.dao.MemberDAO;


@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO dao ;
	
	@Override
	public void insert(Member member) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(member);
	}

	@Override
	public int loginCheck(Member member) throws Exception {
		// TODO Auto-generated method stub
		return dao.loginCheck(member);
	}

	@Override
	public int idCheck(Member member) throws Exception {
		// TODO Auto-generated method stub
		return dao.idCheck(member);
	}

	@Override
	public String idFind(Member member) throws Exception {
		// TODO Auto-generated method stub
		return dao.idFind(member);
	}

	@Override
	public Member passFind(Member member) throws Exception {
		// TODO Auto-generated method stub
		return dao.passFind(member);
	}

	@Override
	public void lostpass(Member member) throws Exception {
		// TODO Auto-generated method stub
		dao.lostpass(member);
	}

}
