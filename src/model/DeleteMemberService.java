package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDao;

public class DeleteMemberService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(optNo.orElse("0"));
		
		int result = MemberDao.getInstance().deleteMember(no);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<h1>탈퇴되었습니다.</h1>");
			out.println("<a href='/ServerProgram/joinForm.do'>회원가입</a>");
			out.close();
		} else {
			out.println("<script>");
			out.println("history.back();");
			out.println("<script>");
			out.close();
		}
		
		
		return null;
	}

}
