package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;
import session.MemberLogin;

public class SelectMemberLogin implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = request.getParameter("id");
		
		int result = MemberDao.getInstance().selectMember(id);
		
		ModelAndView mav = null;
		PrintWriter out = response.getWriter();
		if(result > 0) {
			Member member = MemberDao.getInstance().memberInfo(id);
			request.setAttribute("member", member);
			mav = new ModelAndView("views/manager.jsp", false);
		}else {
			out.println("<script>");
			out.println("alert('아이디와 이름을 확인하세요.");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return mav;
	}

}
