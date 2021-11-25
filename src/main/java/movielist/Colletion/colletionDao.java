package movielist.Colletion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import movielist.croll_movieBean;
import movielist.croll_movieDao;

public class colletionDao {
	private static colletionDao instance = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private colletionDao() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
		conn = ds.getConnection();
	}

	public static colletionDao getInstance() {
		if(instance == null){
			try {
				instance = new colletionDao();
			} catch (Exception e) {
				e.printStackTrace();
			}  
		}
		return instance;
	}  //  cartDao instance
	
	

	public int insertcart(croll_movieBean ctb) {
		String sql = "insert into collection values(collection_seq.nextval,?,?,?,?,?,?,?,?)";
		int cnt = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctb.getImgsrc_DB());
			pstmt.setString(2, ctb.getTitle_DB());
			pstmt.setString(3, ctb.getSubtitle_DB());
			pstmt.setString(4, ctb.getStory_DB());
			pstmt.setString(5, ctb.getUserRating_DB());
			pstmt.setString(6, ctb.getDirector_DB());
			pstmt.setString(7, ctb.getActor_DB());
			pstmt.setString(8, ctb.getPubdate_DB());

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
	}//insertcart
	
	//-----------------------------------------------------------------------
	
	
	public ArrayList<collectionBean> collectionSelectAll() {

		collectionBean ctb = null;
		String sql = "select * from collection order by clnum";
		ArrayList<collectionBean> ctb_lists = new ArrayList<collectionBean>();

		try { 
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
  
			while(rs.next()) {
				int clnum =  rs.getInt("clnum");
				String cl_img = rs.getString("cl_img");
				String cl_title= rs.getString("cl_title");
				 String cl_subtitle= rs.getString("cl_subtitle");
				 String cl_story= rs.getString("cl_story");
				 String cl_rate= rs.getString("cl_rate");
				 String cl_director= rs.getString("cl_director");
				 String cl_actor= rs.getString("cl_actor");
				 String cl_pubdate= rs.getString("cl_pubdate");

				ctb = new collectionBean(clnum,cl_img,cl_title,cl_subtitle,cl_story,cl_rate,cl_director,cl_actor,cl_pubdate);
				
				ctb_lists.add(ctb); 
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
		return ctb_lists;
	}//selectAll
	
	//--------------------------------------------------
	
	public int deleteMovie(String clnum){
		int cnt = -1;
		String sql = "delete from collection where clnum = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(clnum));
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			}catch(SQLException e) {
				
			}finally {
				try {
					if(pstmt!=null) {
						pstmt.close();
					}  
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//finally
		return cnt;
	}

}
