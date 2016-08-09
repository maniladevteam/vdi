package com.vm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.launcher.beans.OperatingSystem;
import com.resultset.converter.ResultSetConverter;

@WebServlet("/OSController")
public class OSController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OSController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OperatingSystem os = new OperatingSystem();
		response.setContentType("text/json");
		try {
			response.getWriter().write(ResultSetConverter.convert(os.ReturnAllOS()).toString());
		} catch (SQLException e) {
			response.getWriter().write(e.getStackTrace().toString());
		} catch (JSONException f) {

		}
	}

}
