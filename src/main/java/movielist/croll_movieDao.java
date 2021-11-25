package movielist;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import my.member.MemberDTO;


public class croll_movieDao {


	private static croll_movieDao instance = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private croll_movieDao() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
		conn = ds.getConnection();
	}

	public static croll_movieDao getInstance() {
		if(instance == null){
			try {
				instance = new croll_movieDao();
			} catch (Exception e) {
				e.printStackTrace();
			}  
		}
		return instance;
	}  //  DB_movieDao instance



	public int insertMovieList(croll_movieBean cr_mb) {
		String sql = "insert into movielist values(moiveseq.nextval,?,?,?,?,?,?,?,?)";
		int cnt = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cr_mb.getImgsrc_DB());
			pstmt.setString(2, cr_mb.getTitle_DB());
			pstmt.setString(3, cr_mb.getSubtitle_DB());
			pstmt.setString(4, cr_mb.getStory_DB());
			pstmt.setString(5, cr_mb.getUserRating_DB());
			pstmt.setString(6, cr_mb.getDirector_DB());
			pstmt.setString(7, cr_mb.getActor_DB());
			pstmt.setString(8, cr_mb.getPubdate_DB());

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

	public ArrayList<croll_movieBean> MovieSelectAll() {

		croll_movieBean CRMB = null;
		String sql = "select * from movielist order by mnum";
		ArrayList<croll_movieBean> CRMB_lists = new ArrayList<croll_movieBean>();

		try { 
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
  
			while(rs.next()) {
				int mnum =  rs.getInt("MNUM");
				String imgsrc_DB = rs.getString("MIMGSRC");
				String title_DB= rs.getString("KOTITLE");
				String subtitle_DB= rs.getString("ENTITLE");
				String story_DB= rs.getString("SHOTSTORY");
				String userRating_DB= rs.getString("RATING");
				String director_DB= rs.getString("DIRECTOR");
				String actor_DB= rs.getString("ACTOR");
				String pubdate_DB= rs.getString("PUBDATE");

				CRMB = new croll_movieBean(mnum,imgsrc_DB,title_DB,subtitle_DB
						,story_DB,userRating_DB
						,director_DB,actor_DB,pubdate_DB);
				
				CRMB_lists.add(CRMB); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}  
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return CRMB_lists;
	}//selectAll
	//-----------------------------------------------------------------------
	
	
	
	public croll_movieBean selectByMnum(String mnum1) {

		String sql = "select * from movielist where mnum=?";
		croll_movieBean CRMB = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(mnum1));

			rs=pstmt.executeQuery();
			if(rs.next()) {
				int mnum =  rs.getInt("MNUM");
				String imgsrc_DB = rs.getString("MIMGSRC");
				String title_DB= rs.getString("KOTITLE");
				String subtitle_DB= rs.getString("ENTITLE");
				String story_DB= rs.getString("SHOTSTORY");
				String userRating_DB= rs.getString("RATING");
				String director_DB= rs.getString("DIRECTOR");
				String actor_DB= rs.getString("ACTOR");
				String pubdate_DB= rs.getString("PUBDATE");

				CRMB = new croll_movieBean(mnum,imgsrc_DB,title_DB,subtitle_DB
						,story_DB,userRating_DB
						,director_DB,actor_DB,pubdate_DB);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return CRMB;

}//selectByMnum
//-----------------------------------------------------------------------

	
	
	public ArrayList<croll_movieBean> MovieSelectBysearch(String search) {

		croll_movieBean CRMB = null;
		String sql = "select * from movielist where kotitle like ?";
		ArrayList<croll_movieBean> CRMB_lists = new ArrayList<croll_movieBean>();

		try { 
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, type);
			pstmt.setString(1, '%'+ search +'%');
			rs = pstmt.executeQuery();
  
			while(rs.next()) {
				int mnum =  rs.getInt("MNUM");
				String imgsrc_DB = rs.getString("MIMGSRC");
				String title_DB= rs.getString("KOTITLE");
				String subtitle_DB= rs.getString("ENTITLE");
				String story_DB= rs.getString("SHOTSTORY");
				String userRating_DB= rs.getString("RATING");
				String director_DB= rs.getString("DIRECTOR");
				String actor_DB= rs.getString("ACTOR");
				String pubdate_DB= rs.getString("PUBDATE");

				CRMB = new croll_movieBean(mnum,imgsrc_DB,title_DB,subtitle_DB
						,story_DB,userRating_DB
						,director_DB,actor_DB,pubdate_DB);
				
				CRMB_lists.add(CRMB); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}  
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("CRMB_lists"+CRMB_lists);
		return CRMB_lists;
	}//MovieSelectBysearch
	//-----------------------------------------------------------------------

	
}//class



