package my.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private static MemberDAO instance = null;
	Connection conn = null;
	PreparedStatement pstmt = null;

	private MemberDAO() throws Exception{

		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
		conn = ds.getConnection();
		System.out.println("conn:" + conn);
	}

	public static MemberDAO getInstance() {
		if(instance== null) {
			try {
				instance = new MemberDAO();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}

	public boolean searchId(String userid){
		ResultSet rs = null;
		boolean flag = false;
		String sql = "select id from members where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userid);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(SQLException e) {

			}
		}

		return flag;
	}//searchId

	public int insertData(MemberDTO mm) {
		String sql = "insert into members values(memseq.nextval,?,?,?,?,?,?)";
		int cnt = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mm.getName());
			pstmt.setString(2, mm.getId());
			pstmt.setString(3, mm.getPassword());
			pstmt.setString(4, mm.getRrn1());
			pstmt.setString(5, mm.getRrn2());
			pstmt.setString(6, mm.getEmail());

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			}catch(SQLException e) {

			}
		}
		return cnt;
	}//insertData

	public MemberDTO getMemberByrrn(String name,String rrn1,String rrn2){
		ResultSet rs = null;
		MemberDTO member = null; 
		String sql = "select * from members where name=? and rrn1=? and rrn2=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, rrn1);
			pstmt.setString(3, rrn2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				// 
				member = getMemberBean(rs);
			}
		} catch (SQLException e) {
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
			}
		}
		System.out.println("member:" + member);
		return member;
	} // getMemberByrrn

	public MemberDTO getMemberByIdAndName(String id,String name,String rrn1,String rrn2){
		ResultSet rs = null;
		MemberDTO member = null; 
		String sql = "select * from members where id=? and name=? and rrn1=? and rrn2=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, rrn1);
			pstmt.setString(4, rrn2);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//
				member = getMemberBean(rs);
			}
		} catch (SQLException e) {
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(rs != null)
					rs.close();
			} catch (SQLException e) {
			}
		}
		System.out.println("member:" + member);
		return member;
	}

	public MemberDTO getMemberBean(ResultSet rs) throws SQLException{
		MemberDTO member = null;
		int no = rs.getInt("no");
		String name2= rs.getString("name");
		String id2 = rs.getString("id");
		String password = rs.getString("password");
		String rrn11 = rs.getString("rrn1");
		String rrn22 = rs.getString("rrn2");
		String email = rs.getString("email");

		member = new MemberDTO(no,name2,id2,password,rrn11,rrn22,email);
		return member;
	}

	public MemberDTO getMemberInfo(String id, String password){
		ResultSet rs = null;
		String sql = "select * from members where id =? and password=?";
		MemberDTO dto = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = getMemberBean(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(SQLException e) {

			}
		}

		return dto;
		
	}//getMemberInfo

}






