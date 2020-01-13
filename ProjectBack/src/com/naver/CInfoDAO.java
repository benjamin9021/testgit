package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CInfoDAO {
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "ca";
	private static final String password = "ca";

	public CInfoDAO() {
		try {
			Class.forName(DRIVER);
			System.out.println("데이터 동기화");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 셀렉
	public ArrayList<CInfoDTO> select() {
		ArrayList<CInfoDTO> list = new ArrayList<CInfoDTO>();

		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from cinfo";
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String cid = rs.getString("cid");
				int cnum = rs.getInt("cnum");
				String cclr = rs.getString("cclr");

				CInfoDTO dto = new CInfoDTO(cid, cnum, cclr);
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
		String sql = "delete from cinfo where cnum = ?";

		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, did);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

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

	// 아이디 호출
	public ArrayList<CInfoDTO> selectID(String id) {
		ArrayList<CInfoDTO> list = new ArrayList<CInfoDTO>();
		CInfoDTO dto = null;

		Connection conn = null;
		PreparedStatement patmt = null;
		String sql = "select * from cinfo where cid = ?";
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection(URL, user, password);
			patmt = conn.prepareStatement(sql);

			patmt.setString(1, id);

			rs = patmt.executeQuery();

			if (rs.next()) {
				int age = rs.getInt("차넘버");
				String cid = rs.getString("차색상");

				for (int i = 0; i < this.select().size(); i++) {
					if (!id.equals(this.select().get(i).getDid())) {
					}

					else {
						list.add(new CInfoDTO(this.select().get(i).getDid(), this.select().get(i).getNumber(),
								this.select().get(i).getCclr()));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
				}
				if (patmt != null) {
				}
				if (conn != null) {
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	// 삽입
	public void insert(CInfoDTO dto) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into cinfo values(?,?,?)";

		try {
			conn = DriverManager.getConnection(URL, user, password);

			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getcid());
			ps.setInt(2, dto.getNumber());
			ps.setString(3, dto.getCclr());

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

	// 아이디 호출
	public CInfoDTO number(int number) {
		CInfoDTO dto = null;

		Connection conn = null;

		PreparedStatement pstmt = null;

		String sql = "select * from cinfo where cnum =?";

		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(URL, user, password);

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, number);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				String cclr = rs.getString("cclr");

				String did = rs.getString("did");

				dto = new CInfoDTO(did, number, cclr);

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

	public void update(CInfoDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update cinfo set did = ?, cclr = ? where cnum = ?";

		try {
			conn = DriverManager.getConnection(URL, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDid());
			pstmt.setString(2, dto.getCclr());
			pstmt.setInt(3, dto.getNumber());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
}
