package com.vm.search.vdi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.vm.controller.VmBean;

/**
 * Servlet implementation class SearchVmDetails
 */
@WebServlet("/SearchVmDetails")
public class SearchVmDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchVmDetails() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("test");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String is = request.getParameterMap().toString();
		String paraNames[] = is.split("=");
		String jsonParameters = (paraNames[0] + "}").replace("{{", "{").replace("}}", "}");
		response.setContentType("text/json");
		String jsonReturn = null;
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(jsonParameters);
			String queryString = (jsonObj.optString("vmref", "").replace("#", "="));
			String region = (jsonObj.optString("region", ""));

			VmBean vms = new VmBean();
			jsonReturn = vms.SearchVMDetail(queryString, region).toString();
			if (!jsonReturn.equals(null))
				response.getWriter().write(jsonReturn);
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());

		}
	}

}
