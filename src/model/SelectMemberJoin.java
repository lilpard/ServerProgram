package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class SelectMemberJoin implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		Member member = new Member();
		member.setId(id);
		member.setName(name);
		
		int result = MemberDao.getInstance().insertMember(member);
		
		PrintWriter out = null;
		if(result > 0) {
			out.println("<h1>가입되었습니다.</h1>");
			out.println("<a href='/ServerProgram/loginForm.do>로그인</a>");
			out.close();
		}else {
			out.println("<script>history.back()</script>");
			out.close();
		}
		
		return null;
	}

}
