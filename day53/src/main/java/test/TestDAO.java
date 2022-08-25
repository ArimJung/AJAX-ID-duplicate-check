package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAO {
	Connection conn;
	PreparedStatement pstmt;
	final private String sql="SELECT * FROM TEST WHERE MID=?";
	
	public int check(TestVO vo) { // DAO 아웃풋이 달라질수 있다
		// 1(성공) 0(실패) -1(오류보고)
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) { // 데이터가 있니?
				return 0; // 있다는거니까, 아이디중복 발생 ... > 0
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return 1; // 아이디 중복 아님!
	}
}
