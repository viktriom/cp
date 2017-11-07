package com.bds.cp.core.db;

import java.sql.*;

import com.bds.cp.core.constants.CPConstants;

public class DBUtils {

	public static void executeQuery(String query) {
		try {
			Class.forName(CPConstants.getJdbcDBDriver());
			Connection con = DriverManager.getConnection(CPConstants.getCompleteDBUrl(), CPConstants.getDbUser(), CPConstants.getDbPassword());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
