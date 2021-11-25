package movielist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.management.MBeanAttributeInfo;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class daum_movie_croll {

 
	private static daum_movie_croll instance = null; 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	private daum_movie_croll() throws Exception{

		Context initContext = new InitialContext(); Context envContext =
				(Context)initContext.lookup("java:/comp/env"); DataSource ds =
				(DataSource)envContext.lookup("jdbc/OracleDB"); conn = ds.getConnection();
				System.out.println("conn:" + conn); }

	public static daum_movie_croll getInstance() {  
		if(instance== null) { 
			try { instance =
			new daum_movie_croll(); 
			} catch (Exception e) { e.printStackTrace(); } } return
					instance; }

	//�̱��� �۾��Ϸ� ------------------------------------------------------------


	public ArrayList<MovieListBEAN> MovieCrollerDaumBoxYear() {
		ArrayList<MovieListBEAN> mlist=new ArrayList <MovieListBEAN>();
		String url = "https://movie.daum.net/ranking/boxoffice/yearly?date=2020";
		Document doc =null;
		try {

			doc = Jsoup.connect(url).get();
			Elements  list_movieranking= doc.select("ol.list_movieranking");
			Elements topitem = doc.select("div.item_poster");
			// �ֻ��
			Elements poster_movie = topitem.select("div.poster_movie");
			//1��
			String imgSource=topitem.select("img").attr("src");//�̹��� �ҽ� �ּ�

			Elements poster_info = topitem.select("div.poster_info");
			String atag=poster_info.select("a").attr("href");// �󼼺��� �ּ�
			String atagInfo=poster_info.select("a").text();// �ó�ý�
			//1��

			String title = topitem.select("strong.tit_item").text();



			//Iterator<Element> section_ = list_movieranking.select("li").iterator();
			Iterator<Element> section_ = doc.select("div.item_poster").iterator();
			Iterator<Element> movieTitle = topitem.select("strong.tit_item").iterator();
			Iterator<Element> imgStrings =topitem.select("img.img_thumb").iterator();
			Iterator<Element> story =poster_info.select("a.link_story").iterator();
			Iterator<Element> detailmovie = topitem.select("a.link_story").iterator();
			int i =1;
			while(movieTitle.hasNext()) {
				MovieListBEAN  mlb =  new MovieListBEAN();
				mlb.setTitle(movieTitle.next().text());
				mlb.setImgSrc(imgStrings.next().attr("src"));
				mlb.setStory(story.next().text());
				mlb.setMde_addr("https://movie.daum.net"+detailmovie.next().attr("href"));
				mlist.add(mlb);
				System.out.println(i++);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		return mlist;
	}//moviecroller

	//��ȭ ������ȭ �ڽ����ǽ� year ����Ʈ ũ�Ѹ� �� Arraylist �߰� --------------------------------------------


	

	public ArrayList<MovieDetailBean> movieDetailCroll(String mde_addr) {
		ArrayList<MovieDetailBean> mlist=new ArrayList <MovieDetailBean>();
		String url = mde_addr;
		Document doc =null;
		try {

			doc = Jsoup.connect(url).get();
			//Elements  list_movieranking= doc.select("ol.list_movieranking");
			Elements topitem = doc.select("div.section_detail");
			Elements contents = topitem.select("div.contents");
			Elements info_detail = topitem.select("div.info_detail");//Ÿ��Ʋ ����
			Elements kotitleAddr = info_detail.select("span.txt_tit");// �ѱ� Ÿ��Ʋ �ּ�
			Elements entitleAddr = info_detail.select("span.txt_name");// ���� Ÿ��Ʋ �ּ�
			Elements detail_addr = info_detail.select("div.detail_cont");// ������/�帣/����/���/����Ÿ�� �ּ�
			Elements detail_li = detail_addr.select("div.inner_cont");// ������/�帣/����/���/����Ÿ�� �ּ�
			Elements list_cont = detail_li.select("dl.list_cont");// ������/�帣/����/���/����Ÿ�� �ּ�
			
			//------------------------------------------------------

			Iterator<Element> detailFact1 = list_cont.select("dt").iterator();
			Iterator<Element> detailFact2 = list_cont.select("dd").iterator();
			String kotitle = kotitleAddr.text();
			String entitle = entitleAddr.text();
			String fdd =  detailFact1.next().text();
			String sdd =  detailFact2.next().text();
			
			String desc_content =contents.select("div.desc_cont").text();
			//System.out.println(desc_content);

//section_detail -> div.box_detailinfo -> div.contents ->div.detail_crewinfo->ul.list_crewall ->div.item_crewall
			System.out.println("����");
				naver_movie_API nmapi =  new naver_movie_API();
				MovieDetailBean mdb =nmapi.naverApi(kotitle);
				
				
				
				
				
				/*
				 * System.out.println("�ѱ�����  :"+mdb.getKotitle());
				 * 
				 * System.out.println("��������  :"+mdb.getEntitle());
				 * System.out.println("������  :"+mdb.getCrankin());
				 * System.out.println("�帣  :"+mdb.getGenre());
				 * System.out.println("����  :"+mdb.getNation());
				 * System.out.println("���  :"+mdb.getGrade());
				 * System.out.println("�󿵽ð�  :"+mdb.getRuntime());
				 * System.out.println("����  :"+mdb.getRating());
				 * System.out.println("��������  :"+mdb.getBoxconunt());
				 * System.out.println("�����̷�  :"+mdb.getAwards()); System.out.println("������ ��");
				 */


		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		return mlist;
	}//movieDetailCroll
	
	public ArrayList<MovieListBEAN> movieDetailCrewCroll(String mde_addr) {
		ArrayList<MovieListBEAN> mlist=new ArrayList <MovieListBEAN>();
		String url = mde_addr.replace("main","crew");
		Document doc =null;
		try {
			System.out.println(url);
			doc = Jsoup.connect(url).get();
			//Elements  list_movieranking= doc.select("ol.list_movieranking");
			//------------------------------------------------------
			Elements F1 = doc.select("main.kakao_content");
			Elements F2 = F1.select("div.section_detail");
			Elements F3 = F2.select("div.box_detailinfo").attr("crew", "data-tiara-layer");
			Elements F4 = F3.select("div.contents");
			Elements F5 = F4.select("div.detail_crewinfo");
			Elements F6 = F5.select("ul.list_crew");
			Elements F7 = F6.select("div.item_crew");

			//dt ���� dd  2020.06.24 5��

			//String imgSource=topitem.select("img").attr("src");//�̹��� �ҽ� �ּ�
			// �ֻ��

			//section_detail -> div.box_detailinfo -> div.contents ->div.detail_crewinfo->ul.list_crewall ->div.item_crewall
			

			Iterator<Element> detail_crewinfo = F4.select("div.detail_crewinfo").iterator();
			//String crewPhoto = item_crew.next().attr("src");
			Iterator<Element> crewName = F7.select("a.link_txt").iterator();
			Iterator<Element> crewRoll = F7.select("span.txt_info").iterator();
			int i =1;
			System.out.println(i);
			System.out.println(F1.select("h2.screen_out").text());
			System.out.println(F2.select("span.txt_tit").text());
			System.out.println(F4.select("h4.screen_out").text());
			while(detail_crewinfo.hasNext()) {
				System.out.println(i);
				//System.out.println(crewPhoto);
				System.out.print(crewName.next().text()+"    :   ");
				System.out.println(crewRoll.next().text());
				System.out.println(i);
				i++;
				
			}


		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		return mlist;
	}//movieDetailCrewCroll
	
	
}//class


