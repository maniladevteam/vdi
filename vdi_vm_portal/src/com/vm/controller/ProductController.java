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

import com.launcher.beans.Products;
import com.resultset.converter.ResultSetConverter;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Products products = new Products();
		String is = request.getParameterMap().toString();
		String paraNames[] = is.split("=");
		String jsonParameters = (paraNames[0] + "}").replace("{{", "{").replace("}}", "}");

		response.setContentType("text/json");
		try {
			JSONObject jsonObj = new JSONObject(jsonParameters);
			String region = jsonObj.optString("region", "");
			response.getWriter().write(ResultSetConverter.convert(products.ReturnAllProducts(region)).toString());
		} catch (SQLException e) {
			response.getWriter().write(e.getStackTrace().toString());
		} catch (JSONException f) {

		}

	}

}
