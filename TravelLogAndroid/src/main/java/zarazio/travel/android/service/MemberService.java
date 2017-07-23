package zarazio.travel.android.service;

import zarazio.travel.android.bean.Member;

public interface MemberService {
	public void insert(Member member) throws Exception;
	public Member loginCheck(Member member) throws Exception ;
	public int idCheck(Member member) throws Exception ;
	public String idFind(Member member) throws Exception;
	public Member passFind(Member member) throws Exception;
	public void lostpass(Member member) throws Exception;
	public void user_update(Member member) throws Exception;
	public void passUpdate(Member member) throws Exception;
}
