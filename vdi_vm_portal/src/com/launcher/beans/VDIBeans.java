package com.launcher.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.launcher.vdi.dao.connector.VDIConnectDAO;

public class VDIBeans {

	public ResultSet VDIBeans(String region, String queryString) {
		CallableStatement query = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = VDIConnectDAO.VdiDataSource().getConnection();
			query = connection.prepareCall("");
			rs = query.executeQuery();
			return rs;
		} catch (Exception e) {

		} finally {

		}
		return null;
	}

}
