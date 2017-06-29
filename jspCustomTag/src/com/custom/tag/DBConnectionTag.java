package com.custom.tag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 自定义标签中的属性
 * 
 * @author weineng
 *
 */
public class DBConnectionTag extends TagSupport {

	private String url;
	private String username;
	private String password;
	private String driver;
	private String sql;
	
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public String getSql() {
		return sql;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public int doEndTag() throws JspException {
		try {
			Class.forName(this.driver);
			conn = DriverManager.getConnection(this.url, this.username, this.password);
			ps = conn.prepareStatement(this.sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				pageContext.getOut().print(rs.getString("name"));
			}
			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			return SKIP_PAGE;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
