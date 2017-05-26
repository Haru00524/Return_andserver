package zarazio.travel.android.dao;

import zarazio.travel.android.bean.Member;

public interface MemberDAO {
	public void insert(Member member) throws Exception;
	public int loginCheck(Member member) throws Exception ;
	public int idCheck(Member member) throws Exception ;
	public String idFind(Member member) throws Exception;
	public Member passFind(Member member) throws Exception;
	public void lostpass(Member member) throws Exception;
}
