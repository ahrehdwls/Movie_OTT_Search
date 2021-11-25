package movielist.Cart;

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

public class cartDao {
	private static cartDao instance = null;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private cartDao() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB");
		conn = ds.getConnection();
	}

	public static cartDao getInstance() {
		if(instance == null){
			try {
				instance = new cartDao();
			} catch (Exception e) {
				e.printStackTrace();
			}  
		}
		return instance;
	}  //  cartDao instance
	
	

	public int insertcart(croll_movieBean ctb) {
		String sql = "insert into movie_cart values(cart_seq.nextval,?,?,?,?,?,?,?,?)";
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
		}
		return cnt;
	}//insertcart
	
	//-----------------------------------------------------------------------
	
	
	public ArrayList<cartBean> cartSelectAll() {

		cartBean ctb = null;
		String sql = "select * from movie_cart order by cartnum";
		ArrayList<cartBean> ctb_lists = new ArrayList<cartBean>();

		try { 
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
  
			while(rs.next()) {
				int cartnum =  rs.getInt("cartnum");
				String cart_img = rs.getString("cart_img");
				String cart_title= rs.getString("cart_title");
				 String cart_subtitle= rs.getString("cart_subtitle");
				 String cart_story= rs.getString("cart_story");
				 String cart_rate= rs.getString("cart_rate");
				 String cart_director= rs.getString("cart_director");
				 String cart_actor= rs.getString("cart_actor");
				 String cart_pubdate= rs.getString("cart_pubdate");

				ctb = new cartBean(cartnum,cart_img,cart_title,cart_subtitle,cart_story,cart_rate,cart_director,cart_actor,cart_pubdate);
				
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
	
	public int deleteMovie(String cartnum){
		int cnt = -1;
		String sql = "delete from movie_cart where cartnum = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(cartnum));
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
