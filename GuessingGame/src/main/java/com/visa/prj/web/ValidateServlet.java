package com.visa.prj.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		session.setAttribute("lifeLeft", 5);
		session.setAttribute("answer","*****");
		session.setAttribute("finall","james");
		request.getRequestDispatcher("game.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String final_ans = (String)session.getAttribute("finall");
		String cur_ans = (String)session.getAttribute("answer");
		String guess = (String)request.getParameter("ans");
		if(final_ans.contains(guess)) {
			char[] fc = final_ans.toCharArray();
			char[] cc = cur_ans.toCharArray();
			for(int i=0;i<fc.length;i++)
			{
				if(cc[i]=='*')
				{
					if(fc[i]==guess.charAt(0))
						cc[i]=guess.charAt(0);
				}
			}
					
				session.setAttribute("answer", new String(cc));
		}
		else {
			session.setAttribute("lifeLeft", (int)session.getAttribute("lifeLeft")-1);
		}
		if(session.getAttribute("answer").equals(session.getAttribute("finall")))
			response.sendRedirect("success.jsp");
		else if((int)session.getAttribute("lifeLeft") == 0)
		{
			response.sendRedirect("success.jsp");
		}
		else
			response.sendRedirect("game.jsp");
	}

}
