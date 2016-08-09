package com.launcher.vdi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class LauncherClass
 */
@WebServlet("/LauncherClass")
public class LauncherClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LauncherClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
			try {
				
				String poolName = request.getParameter("poolname"); //(jsonObj.optString("poolName", "").replace("******", " "));
				String region = request.getParameter("region");
				String vmref = request.getParameter("vmref");
				String vm = "";
				switch (region) {
				case "AMERS":
					vm = "vmware-view://view-AMERS.ten.thomsonreuters.com/";
					break;
				case "EMEA":
					vm = "vmware-view://view-EMEA.ten.thomsonreuters.com/";
					break;
				case "APAC":
					vm = "vmware-view://view-APAC.ten.thomsonreuters.com/";
					break;
				case "IPBS":
					vm = "vmware-view://view-india.ten.thomsonreuters.com/";
					break;    
				default :
					vm ="vmware-view://view-AMERS.ten.thomsonreuters.com/";
					break;

				}
				final int BYTES_DOWNLOAD = 1024;
				response.setContentType("application/octet-stream");
		        response.setHeader("Content-Disposition", "signal;filename=Launch_Virtual_Machine_" + vmref + ".bat");
		        String path = "start /B \"VDI\" \"C:/Program Files/VMware/VMware View/Client/bin/wswc.exe\" " + "\"" +vm+poolName+"?action=start-session&logInAsCurrentUser=true\"";
		        String cleanPath = path.replace("%20"," ").replace("%28", "(").replace("%29", ")").replace("%2D", "-");
		        InputStream input = new ByteArrayInputStream(cleanPath.getBytes("UTF8"));

		        int read = 0;
		        byte[] bytes = new byte[BYTES_DOWNLOAD];
		        OutputStream os = response.getOutputStream();

		        while ((read = input.read(bytes)) != -1) {
		            os.write(bytes, 0, read);
		        }
		        os.flush();
		        os.close();
		        
		        
			} catch (Exception h) {
				h.getMessage();
			}

		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String is = request.getParameterMap().toString();
		String paraNames[] = is.split("=");
		String jsonParameters = (paraNames[0] + "}").replace("{{", "{").replace("}}", "}");

		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(jsonParameters);
			String poolName = (jsonObj.optString("poolName", "").replace("******", " "));
			String region = (jsonObj.optString("region", ""));
			String vm = "";
			switch (region) {
			case "AMERS":
				vm = "vmware-view://view-AMERS.ten.thomsonreuters.com/";
				break;
			case "EMEA":
				vm = "vmware-view://view-EMEA.ten.thomsonreuters.com/";
				break;
			case "APAC":
				vm = "vmware-view://view-APAC.ten.thomsonreuters.com/";
				break;
			case "IPBS":
				vm = "vmware-view://view-india.ten.thomsonreuters.com/";
				break;

			}
			final int BYTES_DOWNLOAD = 1024;
			response.setContentType("application/text");
	        response.setHeader("Content-Disposition", "attachment;filename=downloadname.txt");

	        String s = "Test\n\nText file contects!!";
	        InputStream input = new ByteArrayInputStream(s.getBytes("UTF8"));

	        int read = 0;
	        byte[] bytes = new byte[BYTES_DOWNLOAD];
	        OutputStream os = response.getOutputStream();

	        while ((read = input.read(bytes)) != -1) {
	            os.write(bytes, 0, read);
	        }
	        os.flush();
	        os.close();
	        
	        
		} catch (

		JSONException e)

		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception h) {
			h.getMessage();
		}

	}

}
