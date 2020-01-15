package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CiCuserDAO {

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "ca";
	private static final String PASSWORD = "ca";

	public CiCuserDAO() {

		try {

			Class.forName(DRIVER);
			System.out.println("데이터 동기화");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	public ArrayList<CiCuserDTO> select() {

		ArrayList<CiCuserDTO> list = new ArrayList<CiCuserDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "select did , name , age, cnum , cclr from cuser natural join cinfo";
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(URL, USER, PASSWORD);

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				String id = rs.getString("did");

				String name = rs.getString("name");

				int age = rs.getInt("age");

				int cnum = rs.getInt("cnum");

				String cclr = rs.getString("cclr");

				CiCuserDTO cdto = new CiCuserDTO(id, name, age, cnum, cclr);
				list.add(cdto);

			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {

					conn.close();
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return list;
	}

}
