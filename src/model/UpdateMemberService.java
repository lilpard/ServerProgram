package model;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.MemberDao;
import dto.Member;

public class UpdateMemberService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(optNo.orElse("0"));
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String grade = request.getParameter("grade");
		Optional<String> optPoint = Optional.ofNullable(request.getParameter("point"));
		int point = Integer.parseInt(optPoint.orElse("0"));
		
		Member member = new Member();
		member.setNo(no);
		member.setId(id);
		member.setName(name);
		member.setGrade(grade);
		member.setPoint(point);;
		
		MemberDao dao = MemberDao.getInstance();
		int result = dao.updateMember(member);
		
		if(result > 0){
			new ModelAndView("views/list.jsp", false);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("location.href='/ServerProgram/list.jsp");
			out.println("</script>");
			out.close();
		}
		return null;
	}

}
