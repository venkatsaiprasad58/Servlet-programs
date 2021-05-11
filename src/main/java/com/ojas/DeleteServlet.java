package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DelServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteServlet() {
		super();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int value = Integer.parseInt(request.getParameter("no"));
        PersonDAO persondao = new PersonDAO();
        if (persondao.deletePerson(value)) {
            response.sendRedirect("./ListPersons");
        }else{
            pw.println("<h3 style=color:red>Successfully Deleted</h3>");
        }
    }
}