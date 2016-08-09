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
import com.resultset.converter.ResultSetConverter;

/**
 * Servlet implementation class AddVMActivity
 */
@WebServlet("/AddVMActivity")
public class AddVMActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddVMActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InternerExplorer ie = new InternerExplorer();
		String is = request.getParameterMap().toString();
		String paraNames[] = is.split("=");
		String jsonParameters = (paraNames[0] + "}").replace("{{", "{").replace("}}", "}");
		
		JSONObject jsonObj;
		response.setContentType("text/json");
		try {
			jsonObj = new JSONObject(jsonParameters);
			String field = jsonObj.optString("fieldName");  
			String category = jsonObj.optString("category");
			String count = jsonObj.optString("count"); 
			String user_id = jsonObj.optString("userId");
			String region = jsonObj.optString("region");
			
			if(ie.InsertVmActivity(field, category, count, user_id,region)){
				
				
				response.getWriter().write("successful!!");
			}else{
				response.getWriter().write("unsuccessful!!");
			}
			
			//response.getWriter().write(ResultSetConverter.convert(ie.ReturnAllIE()).toString());
		} catch (Exception e) {
			response.getWriter().write(e.getStackTrace().toString());
		}finally {
			
		}
	}

}
