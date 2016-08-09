package com.vm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.launcher.beans.InternerExplorer;
import com.launcher.beans.Products;
import com.resultset.converter.ResultSetConverter;

/**
 * Servlet implementation class IEController
 */
@WebServlet("/IEController")
public class IEController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IEController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InternerExplorer ie = new InternerExplorer();
		String is = request.getParameterMap().toString();
		String paraNames[] = is.split("=");
		String jsonParameters = (paraNames[0] + "}").replace("{{", "{").replace("}}", "}");

		response.setContentType("text/json");
		try {
			JSONObject jsonObj = new JSONObject(jsonParameters);
			response.getWriter().write(ResultSetConverter.convert(ie.ReturnAllIE()).toString());
		} catch (SQLException | JSONException e) {
			response.getWriter().write(e.getStackTrace().toString());
		}
	}

}
