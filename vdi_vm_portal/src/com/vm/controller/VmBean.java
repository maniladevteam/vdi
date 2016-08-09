package com.vm.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import com.launcher.beans.Products;
import com.launcher.vdi.dao.connector.VDIConnectDAO;
import com.resultset.converter.ResultSetConverter;

public class VmBean {

	public JSONArray DisplayProducts(String region) throws SQLException, JSONException {

		Products prod = new Products();
		return ResultSetConverter.convert(prod.ReturnAllProducts(region));
	}

	public JSONArray DisplayEikonVersion() throws SQLException, JSONException {

		Products prod = new Products();
		return ResultSetConverter.convert(prod.EikonProducts());
	}

	public JSONArray SearchVM(String queryString, String region) {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			conn = VDIConnectDAO.VdiDataSource().getConnection();
			cstmt = conn.prepareCall(" EXEC [_spSearchVM_135_portal] ?,? ");
			cstmt.setString(1, queryString);
			cstmt.setString(2, region);

			rs = cstmt.executeQuery();
			return ResultSetConverter.convert(rs);
		} catch (Exception e) {
			e.getMessage();
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

	public JSONArray SearchVMDetail(String queryString, String region) {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			conn = VDIConnectDAO.VdiDataSource().getConnection();
			cstmt = conn.prepareCall(" EXEC [_spGetAll_vm_detail_135_portal] ?,? ");
			cstmt.setString(1, queryString);
			cstmt.setString(2, region);

			rs = cstmt.executeQuery();
			return ResultSetConverter.convert(rs);
		} catch (Exception e) {
			e.getMessage();
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

	public JSONArray SearchVMProduct(String queryString, String region, String regionProd) {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			conn = VDIConnectDAO.VdiDataSource().getConnection();
			cstmt = conn.prepareCall(" EXEC [_spGetAll_vm_prod_135_portal] ?,?,? ");
			cstmt.setString(1, queryString);
			cstmt.setString(2, region);
			cstmt.setString(3, regionProd);

			rs = cstmt.executeQuery();
			return ResultSetConverter.convert(rs);
		} catch (Exception e) {
			e.getMessage();
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

	public JSONArray GetAnnouncement() {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			conn = VDIConnectDAO.VdiDataSource().getConnection();
			cstmt = conn.prepareCall(" EXEC [spGetComments]");

			rs = cstmt.executeQuery();
			return ResultSetConverter.convert(rs);
		} catch (Exception e) {
			e.getMessage();
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

	public JSONArray AddPortalActivity(String field, String category, String count, String user_id) {
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;

		try {
			conn = VDIConnectDAO.VdiDataSource().getConnection();    
			cstmt = conn.prepareCall(" EXEC [_sp_add_portal_135_activity] ?,?,?,? "); 
			cstmt.setString(1, field);
			cstmt.setString(2, category);
			cstmt.setString(3, count);
			cstmt.setString(4, user_id);

			rs = cstmt.executeQuery();
			return ResultSetConverter.convert(rs);
		} catch (Exception e) {
			e.getMessage();
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
