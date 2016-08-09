package com.launcher.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.launcher.vdi.dao.connector.VDIConnectDAO;

public class Products {

	private String productId = null;
	private String ProductName = null;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public ResultSet ReturnAllProducts(String region) {
		String query = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			query = "EXEC _spGetAllProducts_135_portal " + region;
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;

	}
	
	public ResultSet EikonProducts() {
		String query = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			query = "EXEC _spGetAll_vm_Eikon_version_135_portal";
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;

	}

}
