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
 * Servlet implementation class AddUserActivity
 */
@WebServlet("/AddUserActivity")
public class AddUserActivity extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			String field = (jsonObj.optString("field", "").replace("#", "="));
			String category = (jsonObj.optString("category", ""));
			
			String count = (jsonObj.optString("count", "").replace("#", "="));
			String user_id = (jsonObj.optString("user_id", ""));

			VmBean vms = new VmBean();
			jsonReturn = vms.AddPortalActivity(field, category,count, user_id).toString();
			if (!jsonReturn.equals(null))
				response.getWriter().write(jsonReturn);
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());

		}
	}

}
