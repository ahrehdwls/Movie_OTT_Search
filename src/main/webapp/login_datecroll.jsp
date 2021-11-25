<%@page import="movielist.naver_movie_API"%>
<%@page import="movielist.croll_movieDao"%>
<%@page import="movielist.MovieDetailBean"%>
<%@page import="movielist.croll_movieBean"%>
<%@page import="movielist.MovieListBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="movielist.daum_movie_croll"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    request.setCharacterEncoding("UTF-8");
    daum_movie_croll dmc =  daum_movie_croll.getInstance();
    croll_movieDao cmdao =  croll_movieDao.getInstance();
    ArrayList<MovieListBEAN> mlist = dmc.MovieCrollerDaumBoxYear();
    // 다음 무비 크롤링 완료
    naver_movie_API nmapi =  new naver_movie_API();
    //네이버 api 호출 완료 

    ArrayList<croll_movieBean> croll_list = new ArrayList<croll_movieBean>();
    int total=0;
    for(MovieListBEAN mlb : mlist){ 
    	System.out.print("네이버로 넘어가는 타이틀:" +mlb.getTitle());
    	MovieDetailBean mdb = nmapi.naverApi(mlb.getTitle());
    	Thread.sleep(80);
    	// 제목 별 네이버 검색 완료  검색량이 몰릴시 딜레이 요구됨 
    	
      	croll_movieBean cr_mv =  new croll_movieBean();
      	cr_mv.setImgsrc_DB(mlb.getImgSrc());
      	cr_mv.setTitle_DB(mlb.getTitle());
      	cr_mv.setSubtitle_DB(mdb.getSubtitle());
      	cr_mv.setStory_DB(mlb.getStory());
      	cr_mv.setUserRating_DB(mdb.getUserRating());
      	cr_mv.setDirector_DB(mdb.getDirector());
      	cr_mv.setActor_DB(mdb.getActor());
      	cr_mv.setPubdate_DB(mdb.getPubDate());
      	//네이버 & 다음 크롤링 정보 크롤링 빈에 담기 
       	
      	int cnt = cmdao.insertMovieList(cr_mv);
      	if(cnt>=0){
      	System.out.print(cnt + "개 삽입성공");
      	}
      	
      	else{
      		System.out.print("삽입실패");
      	}
    }//for

    response.sendRedirect("main.jsp");
    %>