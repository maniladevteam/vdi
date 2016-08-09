package com.launcher.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.launcher.vdi.dao.connector.VDIConnectDAO;

public class MsOffice {

	public ResultSet ReturnAllOffice() {
		String query = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			query = "EXEC [_spGetAllOffice_135_portal]";
			conn = VDIConnectDAO.VdiDataSource().getConnection();
			cstmt = conn.prepareCall(query);
			rs = cstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return null;

	}
}
