package com.launcher.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.launcher.vdi.dao.connector.VDIConnectDAO;

public class InternerExplorer {

	public ResultSet ReturnAllIE() {
		String query = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			query = "EXEC [_spGetAllIE_135_portal]";
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
	
	public Boolean InsertVmActivity(String field,
			String category,
			String count,
			String user_id,
			String region
			) {
		String query = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			query = "EXEC [_sp_add_portal_135_activity] ?,?,?,?,?";
			conn = VDIConnectDAO.VdiDataSource().getConnection();
			cstmt = conn.prepareCall(query);
			
			cstmt.setString(1, field);
			cstmt.setString(2, category);
			cstmt.setString(3, "1");
			cstmt.setString(4, user_id);
			cstmt.setString(5, region);
			
			cstmt.executeQuery();
			return true;
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

		return false;

	}
}
