<%@page import="movielist.croll_movieDao"%>
<%@page import="movielist.croll_movieBean"%>
<%@page import="movielist.daum_movie_croll"%>
<%@page import="movielist.MovieDetailBean"%>
<%@page import="movielist.naver_movie_API"%>
<%@page import="movielist.MovieListBEAN"%>
<%@page import="java.io.IOException"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="script.js"></script>
<%@include file="top.jsp" %>

메인 화면


<%
request.setCharacterEncoding("UTF-8");
croll_movieDao cmdao =  croll_movieDao.getInstance();
ArrayList<croll_movieBean> CRMB_lists = cmdao.MovieSelectAll();  

int colnum = 1;%>
<!-- content -->
<div class="contents">
  <div class="wpBox">
    <div class="movieListWp">
      <ul class="movieList">
      <%
for(croll_movieBean crmb : CRMB_lists){ 
	
	System.out.println(crmb.getMnum());
	System.out.println(crmb.getTitle_DB());
	
	%>
           <li>
             <img src="<%=crmb.getImgsrc_DB()%>"/> 
             <div class="over">
               <ul class="disc">
                 <li class="tit"><%=crmb.getTitle_DB()%></li>  
                 <li class="story"><%=crmb.getStory_DB()%></li>
               </ul>
               <a href="#none" class="btnMore"><span>자세히 보기</span><i class="material-icons md-light md-18">arrow_right_alt</i></a>
             </div>
             <div class="popDetail">
		         <h1><%=crmb.getTitle_DB()%><span>(<%=crmb.getSubtitle_DB()%>)</span></h1>
		         <div class="mInfo after">
		           <div class="infoL">
		           		<img src="<%=crmb.getImgsrc_DB()%>" width="250" height="400">
		           </div>
		           <div class="infoR">
			           <div class="subBtnWp">
			           	<a href="https://www.netflix.com/browse" target="_blank" class="netlfix">N넷플릭스</a>
			           	<a href="https://watcha.com/" target="_blank" class="watcha">W왓챠</a>
			           	<form method="post" name="myform" >
				           <!-- <input type="button" class="addShow" onclick="col_conrfirm()" id="addShowList"> -->
				           <input type="submit"  value="컬렉션추가" class="addShow" id="addShowList" formaction="mycollection_proc.jsp?mnum=<%=crmb.getMnum()%>"  onclick="return col_conrfirm()" >
				          
				           <!--  <input type="submit" class="addLike" formaction="/cart_proc.jsp"  onclick="cart_conrfirm()" id="addLikeList"> -->
				            <input type="submit" class="addLike" value="찜하기"  id="addLikeList" formaction="cart_proc.jsp?mnum=<%=crmb.getMnum()%>" onclick="return cart_conrfirm()">
			            </form>
			           </div>
			           	<dl class="after">
			           		<dt>평점 :</dt>
			           		<dd><%=crmb.getUserRating_DB()%></dd>
			           		<dt>감독 :</dt>
			           		<dd><%=crmb.getDirector_DB() %></dd>
			           		<dt>배우 :</dt>
			           		<dd><%=crmb.getActor_DB() %></dd>
			           		<dt>개봉 :</dt>
			           		<dd><%=crmb.getPubdate_DB() %></dd>
			           	</dl>
			           	<p class="iStory"><%=crmb.getStory_DB()%></p>
			        </div>
		           
		         </div><!-- //mInfo -->
		         <a href="#none" class="popClose"><i class="material-icons md-36">close</i></a>
		         
		       </div><!-- //popDetail -->
            </li>
					
  <%
colnum++;
}%>
           </ul>
       </div><!-- //movieListWp -->
     </div>
   </div>
   <!-- //content -->
   
   <div class="dim"></div>
</tr> 



 <%@include file="footer.jsp" %>