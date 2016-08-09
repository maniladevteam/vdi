package com.vm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Announcement
 */
@WebServlet("/announcement")
public class Announcement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Announcement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsonReturn = null;
		response.setContentType("text/html"); 
		try {
			VmBean vms = new VmBean();
			jsonReturn = vms.GetAnnouncement().toString();
			if (!jsonReturn.equals(null))
				response.getWriter().write(jsonReturn);
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());

		}

	}

}
