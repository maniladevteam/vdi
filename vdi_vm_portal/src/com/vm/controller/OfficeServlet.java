package com.vm.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.launcher.beans.MsOffice;
import com.resultset.converter.ResultSetConverter;

@WebServlet("/OfficeController")
public class OfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OfficeServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MsOffice office = new MsOffice();
		response.setContentType("text/json");
		try {
			response.getWriter().write(ResultSetConverter.convert(office.ReturnAllOffice()).toString());
		} catch (SQLException e) {
			response.getWriter().write(e.getStackTrace().toString());
		} catch (JSONException f) {

		}

	}

}