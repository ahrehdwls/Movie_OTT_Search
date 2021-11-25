<%@page import="board.BoardDao"%>
<%@page import="board.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../top.jsp"%>

<%
 	int pageSize = 10; // 
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
 	
 	String pageNum = request.getParameter("pageNum");
 	if(pageNum == null){
 		pageNum="1";
 	}
 	
 	int currentPage = Integer.parseInt(pageNum); // 1, 2, 3, 17
 	int startRow = (currentPage - 1) * pageSize + 1; // 1, 11,21
 	int endRow = currentPage * pageSize; // 10, 20, 30
 	int count = 0;
 	int number = 0;
 	
 	ArrayList<BoardBean> blists = null;
 	
 	/* select~ */
 	BoardDao dao = BoardDao.getInstance();
 	count = dao.getAritcleCount(); 
 	System.out.println("레코드갯수 count:" + count);
 	if(count > 0){
 		blists = dao.getArticles(startRow, endRow);   
 	}
 	
 	number= count-(currentPage-1) * pageSize;
 	
 %>
  <b>전체 레코드 갯수(<%=count %>)</b>
<!-- content -->
<div class="contents">
	<div class="wpBox">
		<h1 class="mainTit">게시판</h1>
		<div class="tableWp">
			<div class="boardBtnWp ar">
				<a href="writeForm.jsp" class="btnDefault">글쓰기</a>
			</div>
			<!-- table -->
			<table class="defaultTb">
				<colgroup>
					<col style="width: 80px;">
					<col style="width: 600px;">
					<col style="width: 120px;">
					<col style="width: 180px;">
					<col style="width: 100px;">
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회</th>
					</tr>
				</thead>
				<tbody>
					<%
 				for(int i=0;i<blists.size();i++){ 
 					BoardBean article = blists.get(i);
 			%>
					<tr>
						<td><%=number-- %></td>
						<td class="bTit">
							 <!-- <span class="material-icons md-18">subdirectory_arrow_right</span> 답글일경우 노출, 1개당 18px .css({"margin-left" : "18px"}) -->
							<a href="content.jsp?num=<%=article.getNum() %>&pageNum=<%=currentPage%>" target=""><%=article.getSubject() %></a>
						</td>
						<td><span class="usName"><%=article.getWriter() %></span></td>
						<td><%=article.getReg_date() %></td>
						<td><%=article.getReadcount() %></td>
					</tr>
				<%} %>
				</tbody>				
			</table>
			<!-- //table -->
<%  
 	if(count>0){ // 37/10=3 + 1(0)
 		int pageCount = count/pageSize + (count % pageSize == 0 ? 0:1);
 		int pageBlock = 10; 
 		
 		int startPage = ((currentPage-1)/ pageBlock*pageBlock)+1;
 		int endPage = startPage + pageBlock-1;
 		if(endPage > pageCount)
 			endPage = pageCount;
 		
 		
 	%>
			<!-- 페이징 -->
			<div class="pageNavWp">
				<ul class="pageNav after">
				<%if(startPage > 10){ %>
					<li><a href="list.jsp?pageNum=<%=startPage - 10 %>">이전 </a></li>
				<%
 			} // if
 		
 			for(int i=startPage;i<=endPage;i++){%>
 				
					<li><a href="list.jsp?pageNum=<%=i%>"><%=i %></a></li>
					<%
 			}//for
 		
 			if(endPage < pageCount){
 					%>
					<li><a href="#none">3</a></li>
						<%	
 			} // if
 		
 		}//ifcount
			 %>
				</ul>
			</div>
			<!-- //페이징 -->
		</div>
		<!-- //tableWp -->
	</div>
</div>
<!-- //content -->
<%@ include file="../footer.jsp"%>


