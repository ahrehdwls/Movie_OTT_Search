<%@page import="movielist.croll_movieBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="movielist.croll_movieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="top.jsp"%>


<%
    request.setCharacterEncoding("UTF-8");
   // String type = request.getParameter("type");
    String search = request.getParameter("search");
    
    
    croll_movieDao crdao = croll_movieDao.getInstance();
    ArrayList<croll_movieBean> CRMB_lists= crdao.MovieSelectBysearch(search); 
    
   // System.out.println(type);
    System.out.println(search);
    System.out.println(CRMB_lists);
    System.out.println(CRMB_lists.size());
    
   %>
<!-- content -->
<div class="contents">
	<div class="wpBox">
		<h1 class="mainTit">영화 검색</h1>

		<div class="schBox">
			<!-- 검색창 -->
			<form method="post">
				<div class="searchWp ar">
					<div class="searchBox">
						<input type="text" class="searchTxt" placeholder="검색어를 입력하세요."
							name="search"> 
							<input type="submit" value="검색" 
							class="searchBtn" formaction="search_proc.jsp">
						<!--  <a href="search_proc.jsp"  class="searchBtn"><i class="material-icons md-light">search</i></a> -->
					</div>
				</div>
			</form>
			<!-- //검색창 -->
			<div class="searchResult">
				<p>
					총 <span class="pointColor fwB"><%=CRMB_lists.size() %></span>건 검색되었습니다.
				</p>
			</div>
		</div><!-- //schBox -->
		<div class="movieListWp">
			<ul class="movieList">
				<%
for(croll_movieBean crmb : CRMB_lists){ 
	
	System.out.println(crmb.getMnum());
	System.out.println(crmb.getTitle_DB());
	
	%>
				<li><img src="<%=crmb.getImgsrc_DB()%>" />
					<div class="over">
						<ul class="disc">
							<li class="tit"><%=crmb.getTitle_DB()%></li>
							<li class="story"><%=crmb.getStory_DB()%></li>
						</ul>
						<a href="#none" class="btnMore"><span>자세히 보기</span><i
							class="material-icons md-light md-18">arrow_right_alt</i></a>
					</div>
					<div class="popDetail">
						<h1><%=crmb.getTitle_DB()%><span>(<%=crmb.getSubtitle_DB()%>)</span></h1>
						<div class="mInfo after">
							<div class="infoL"><img src="<%=crmb.getImgsrc_DB()%>" width="250" height="400"></div>
							<div class="infoR">
								<div class="subBtnWp">
									<a href="https://www.netflix.com/browse" target="_blank"
										class="netlfix">N넷플릭스</a> <a href="https://watcha.com/"
										target="_blank" class="watcha">W왓챠</a>
									<form method="post" name="myform">
										<!-- <input type="button" class="addShow" onclick="col_conrfirm()" id="addShowList"> -->
										<input type="submit" value="컬렉션추가" class="addShow"
											formaction="mycollection_proc.jsp?mnum=<%=crmb.getMnum()%>"
											onclick="col_conrfirm()" id="addShowList">

										<!--  <input type="submit" class="addLike" formaction="/cart_proc.jsp"  onclick="cart_conrfirm()" id="addLikeList"> -->
										<input type="submit" value="찜하기" class="addLike"
											id="addLikeList"
											formaction="cart_proc.jsp?mnum=<%=crmb.getMnum()%>"
											onclick="return cart_conrfirm()">
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

							</form>
						</div>
						<!-- //mInfo -->
						<a href="#none" class="popClose"><i
							class="material-icons md-36">close</i></a>

					</div>
					<!-- //popDetail --></li>

				<%

}%>
			</ul>
		</div>
		<!-- //movieListWp -->
	</div>
</div>
<!-- //content -->

<div class="dim"></div>
</tr>



<%@include file="footer.jsp"%>