package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.MemberService;
import model.SelectMemberJoin;
import model.SelectMemberListService;
import model.SelectMemberLogin;
import model.UpdateMemberService;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		ModelAndView mav = null;
		MemberService service = null;
		
		switch(command) {
		case "SelectListForm.do":
			mav = new ModelAndView("views/list.jsp", false);
			break;
		case "selectList.do":
			service = new SelectMemberListService();
			break;
		case "loginForm.do":
			mav = new ModelAndView("views/login.jsp", false);
		case "login.do":
			service = new SelectMemberLogin();
			break;
		case "logout.do":
			mav = new ModelAndView("views/list.jsp", false);
			break;
		case "updateMember.do":
			service = new UpdateMemberService();
			break;
		case "joinForm.do":
			mav = new ModelAndView("views/join.jsp", false);
			break;
		case "join.do":
			service = new SelectMemberJoin();
			break;
		case "delete.do":
			service = new DeleteMemberService();
			break;
		}
		
		if(service != null) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(mav == null) {
			return;
		}
		
		if(mav != null) {
			if(mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
