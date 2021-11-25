package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String id = "jspid";
	String pw = "jsppw";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static BoardDao instance = null;
	
	private BoardDao() {
		System.out.println("BoardDao() 생성자");
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url,id,pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDao getInstance() {
		if(instance== null) {
			instance = new BoardDao();
		}
		return instance;
	}//
	
	public int getAritcleCount(){
		
		String sql = "select count(*) as count from board";
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement( sql );
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(SQLException e) {
				
			}
		}
		return count;
		
	} // getAritcleCount
	
	public ArrayList<BoardBean> getArticles(int start, int end){
		ArrayList<BoardBean> lists = new ArrayList<BoardBean>();
		String sql = "select num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level,content ";
		sql += "from (select rownum as rank, num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level,content ";
		sql += "from (select num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level,content " ;
		sql += "from board ";
		sql += "order by ref desc, re_step asc)) ";
		sql += "where rank between ? and ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,start);
			pstmt.setInt(2,end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num=rs.getInt("num");
				String writer=rs.getString("writer");
				String email=rs.getString("email");
				String subject=rs.getString("subject");
				String passwd=rs.getString("passwd");
				Timestamp reg_date=rs.getTimestamp("reg_date");
				int readcount=rs.getInt("readcount");
				int ref=rs.getInt("ref");
				int re_step=rs.getInt("re_step");
				int re_level=rs.getInt("re_level");
				String content=rs.getString("content");
				
				BoardBean bean=new BoardBean(num, writer, email, subject, passwd, reg_date, readcount, ref, re_step, re_level, content);
				lists.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			}catch(SQLException e) {
				
			}
		}
		
		return lists;
	}//
	
	public int insertArticle(BoardBean bb) throws SQLException{ // 원글
		String sql = "insert into board(num,writer,email,subject,passwd,reg_date,readcount,ref,re_step,re_level,content) " + 
					"values(board_seq.nextval,?,?,?,?,?,0,board_seq.currval,?,?,?)";
		
		int cnt = -1;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,bb.getWriter());
		pstmt.setString(2,bb.getEmail());
		pstmt.setString(3,bb.getSubject());
		pstmt.setString(4,bb.getPasswd());
		pstmt.setTimestamp(5,bb.getReg_date());
		pstmt.setInt(6,0); // re_step
		pstmt.setInt(7,0); // re_level
		pstmt.setString(8, bb.getContent());
		
		cnt = pstmt.executeUpdate();
		return cnt;
		
	}//insertArticle
	
	public BoardBean getArticle(int num){
		String sqlUpdate = "update board set readcount=readcount+1 where num=?";
		String sql = "select * from board where num = ?" ;
		BoardBean article=null;
		try {
			pstmt = conn.prepareStatement( sqlUpdate )  ;
			pstmt.setInt(1, num);	
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement( sql )  ;
			pstmt.setInt(1, num);	
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new BoardBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return article;
	}//getArticle
	
	public BoardBean updateFormArticle(int num){
		String sql = "select * from board where num = ?" ;
		BoardBean article=null;
		try {
			pstmt = conn.prepareStatement( sql )  ;
			pstmt.setInt(1, num);	
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new BoardBean();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return article;
	}//
	
	public int updateArticle(BoardBean article){ //5(수정form에서 입력한 항목)+1(날짜)
		
		String sqlSelect = "select passwd from board where num=?";
		String sqlUpdate = "update board set writer=?, subject=?, email=?, content=?, reg_date=? where num=? ";
		int cnt = -1;
		try {
			pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				System.out.println("dbpasswd:"+dbpasswd);
				if(dbpasswd.equals(article.getPasswd() )) { // db비번==수정form비번
					
					pstmt = conn.prepareStatement(sqlUpdate);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getSubject());
					pstmt.setString(3, article.getEmail());
					pstmt.setString(4, article.getContent());
					pstmt.setTimestamp(5, article.getReg_date());
					pstmt.setInt(6, article.getNum());
					
					cnt = pstmt.executeUpdate();
					
				}
				else { // 비번 일치 안함
					cnt = -1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}//
	
	public int deleteArticle(String num,String passwd){
		
		String sqlSelect="select passwd from board where num=?";
		String sqlDelete="delete from board where num=?";
		int cnt = -1;
		try {
			pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbpasswd = rs.getString("passwd");
				if(dbpasswd.equals(passwd)) {
					pstmt = conn.prepareStatement(sqlDelete);
					pstmt.setInt(1, Integer.parseInt(num));
					cnt = pstmt.executeUpdate();
				}else {
					cnt = -1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	public void replyArticle(BoardBean article){
		//ref,re_step,re_level:부모
		// 나머지:내것
		String sqlUpdate = "update board set re_step = re_step+1 where ref=? and re_step > ?";
		String sqlInsert = "insert into board(num,writer,email,subject,passwd, reg_date,ref,re_step,re_level,content) " +
		"values(board_seq.nextval,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setInt(1, article.getRef());
			pstmt.setInt(2, article.getRe_step());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1, article.getWriter());
			pstmt.setString(2, article.getEmail());
			pstmt.setString(3, article.getSubject());
			pstmt.setString(4, article.getPasswd());
			pstmt.setTimestamp(5, article.getReg_date());
			pstmt.setInt(6, article.getRef());
			pstmt.setInt(7, article.getRe_step()+1);
			pstmt.setInt(8, article.getRe_level()+1);
			pstmt.setString(9, article.getContent());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}



