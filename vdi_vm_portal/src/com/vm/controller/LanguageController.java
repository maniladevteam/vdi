package com.vm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.launcher.beans.Languages;
import com.resultset.converter.ResultSetConverter;

/**
 * Servlet implementation class LanguageController
 */
@WebServlet("/LanguageController")
public class LanguageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LanguageController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Languages lang = new Languages();
		response.setContentType("text/json");
		try {
			response.getWriter().write(ResultSetConverter.convert(lang.ReturnAllIE()).toString());
		} catch (SQLException e) {
			response.getWriter().write(e.getStackTrace().toString());
		} catch (JSONException f) {
				
		}

	}

}
