package zarazio.travel.android;

import java.util.Random;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zarazio.travel.android.bean.Member;
import zarazio.travel.android.dao.MemberDAO;
import zarazio.travel.android.service.MemberService;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Inject
	private MemberService service;

	@Inject
	private JavaMailSender mailSender;

	@RequestMapping("register")
	public void androidTest2(HttpServletRequest request, Member member) throws Exception {

		service.insert(member);

	}

	@RequestMapping("idCheck")
	@ResponseBody
	public String androidIdCheck(HttpServletRequest request, Member member) throws Exception {

		String count = service.idCheck(member) + "";
		System.out.println(count);
		return count;
	}

	@RequestMapping("login")
	@ResponseBody
	public String androidLogin(HttpServletRequest request, Member member) throws Exception {

		String count = service.loginCheck(member) + "";

		System.out.println(request.getParameter("user_id"));
		System.out.println(request.getParameter("user_pass"));

		System.out.println("count : " + count);

		return count;
	}

	@RequestMapping("findId")
	@ResponseBody
	public String idFind(Member member) throws Exception {

		String user_id = service.idFind(member);
		if (user_id == null) {
			user_id = "NOT FOUND";
		}
		return user_id;
	}

	@RequestMapping("findPass")
	@ResponseBody
	public String passFind(Member member) throws Exception {

		System.out.println("ㅇㅇ");
		System.out.println(member.getUser_id());
		Member mem = service.passFind(member);
		String result = "FAILED";

		if (mem != null) {
			result = "SUCCESS";
			
			String buf = getRandomPassword(15);
			
			Member mem2 = new Member();
			
			mem2.setUser_id(member.getUser_id());
			mem2.setUser_pass(buf);
			service.lostpass(mem2);
			// mailSending 코드

			String setfrom = "travellogproject@gmail.com";
			String tomail = mem.getUser_email(); // 받는 사람 이메일
			String title = "[Travel_log] 비밀번호 찾기 문의"; // 보내는 사람 이메일
			String content = "임시 비밀번호는 "+buf + "입니다. 로그인시 비밀번호를 바꿔주세요"; // 보내는 사람 이메일
			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
				messageHelper.setTo(tomail); // 받는사람 이메일
				messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
				messageHelper.setText(content); // 메일 내용
				mailSender.send(message);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		return result;
	}
	public String getRandomPassword( int length ){
        char[] charaters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        StringBuffer sb = new StringBuffer();
        Random rn = new Random();
        for( int i = 0 ; i < length ; i++ ){
            sb.append( charaters[ rn.nextInt( charaters.length ) ] );
        }
        return sb.toString();
    }
}
