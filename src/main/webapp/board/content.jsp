<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.BoardDao"%>
<%@page import="board.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="../top.jsp"%>
    
    <script type="text/javascript">
	function listBtn(pn){
		//alert(pn);
		location.href="list.jsp?pageNum="+pn;
	}
	
</script>  
    
<%
	int num = Integer.parseInt(request.getParameter("num"));
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	System.out.println("content.jsp num:" + num+" pageNum:"+pageNum);
	
	BoardDao dao = BoardDao.getInstance();
	BoardBean article = dao.getArticle(num);  
	int ref, re_step, re_level; // 22 0 0 
	ref = article.getRef();
	re_step = article.getRe_step();
	re_level = article.getRe_level();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
    
    <!-- content -->
   <div class="contents">
     <div class="wpBox">
       <h1 class="mainTit">게시판 글보기</h1>
       <div class="viewWp">
         <div class="postInfo">
           <h2 class="postTit"><%=article.getSubject() %></h2>
           <ul class="after">
             <li>글번호 :<%=article.getNum() %></li>
             <li>조회수 : <%=article.getReadcount() %></li>
             <li>작성자 : <%=article.getWriter() %></li>
             <li>작성일 : <%=sdf.format(article.getReg_date()) %></li>
           </ul>
         </div>
         <div class="postCont">
           <%=article.getContent() %>
         </div>
         <div class="boardBtnWp ar">
           <ul>
             <li>
               <a href="#none" class="btnDefault" onClick="document.location.href='updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
               수정
               </a>
             </li>
             <li>
               <a href="#none" class="btnDefault" onClick="document.location.href='deleteForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
               삭제
               </a>
             </li>
             <li>
               <a href="#none" class="btnDefault" onClick="document.location.href='replyForm.jsp?ref=<%=ref%>&re_step=<%=article.getRe_step()%>&re_level=<%=article.getRe_level()%>'">
               답글쓰기
               </a>
             </li>
             <li>
               <a href="#none" class="btnDefault" onClick="listBtn(<%=pageNum %>)">목록</a>
             </li>
           </ul>
         </div>
       </div><!-- //viewWp -->
     </div>
   </div>
   <!-- //content -->
   
   <%@ include file="../footer.jsp"%>