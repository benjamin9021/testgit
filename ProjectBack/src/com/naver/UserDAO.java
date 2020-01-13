package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "ca";
	private static final String password = "ca";

	public UserDAO() {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 수정
	public ArrayList<UserDTO> select() {
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from cuser";
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String did = rs.getString("did");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				UserDTO dto = new UserDTO(did, name, age);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	// 삭제
	public void delete(String did) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from cuser where did=?";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, did);

//	         rs = pstmt.executeQuery();

			pstmt.executeUpdate();

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
	}

	// 업데이트
	public void update(UserDTO dto) {
		Connection conn = null;
		PreparedStatement pastmt = null;
		String sql = "update cuser set name = ?, age = ? where did = ?";
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, user, password);
			pastmt = conn.prepareStatement(sql);

			pastmt.setString(1, dto.getName());
			pastmt.setInt(2, dto.getAge());
			pastmt.setString(3, dto.getDid());

			rs = pastmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pastmt != null) {
					pastmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// 아이디 호출
	public UserDTO selectID(String id) {
		UserDTO dto = null;

		Connection conn = null;

		PreparedStatement pstmt = null;

		String sql = "select * from cuser where did =?";

		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(URL, user, password);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String name = rs.getString("name");

				int age = rs.getInt("age");

				dto = new UserDTO(id, name, age);

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

		return dto;

	}

	// 이름 호출
	public ArrayList<UserDTO> selectNAME(String name) {
		ArrayList<UserDTO> list = new ArrayList<UserDTO>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from cuser where name =?";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String did = rs.getString("did");
				int age = rs.getInt("age");
				for (int i = 0; i < this.select().size(); i++) {
					if (!name.equals(this.select().get(i).getName())) {

					} else {
						list.add(new UserDTO(this.select().get(i).getDid(), this.select().get(i).getName(),
								this.select().get(i).getAge()));
					}

				}
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

	// 삽입
	public void insert(UserDTO dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into cuser values(?,?,?)";

		try {
			conn = DriverManager.getConnection(URL, user, password);

			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getDid());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
