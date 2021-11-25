<%@page import="movielist.Colletion.collectionBean"%>
<%@page import="movielist.Colletion.colletionDao"%>
<%@page import="movielist.Cart.cartDao"%>
<%@page import="movielist.Cart.cartBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <script src="script.js"></script>

    <%@include file="top.jsp" %>

  <%
  colletionDao cldao = colletionDao.getInstance();
	ArrayList<collectionBean> col_lists = cldao.collectionSelectAll();
  %>  
    
 <!-- content -->
   <div class="contents">
     <div class="wpBox">
       <h1 class="mainTit">내 컬렉션</h1>
       <div class="tableWp">
         <!-- table -->
         <table class="defaultTb typeMovie">
           <colgroup>
             <col style="width:80px;">
             <col style="width:180px;">
             <col style="width:600px;">
             <col style="width:120px;">
             <col style="width:100px;">
           </colgroup>
           <thead>
             <tr>
               <th>번호</th>
               <th>포스터</th>
               <th>영화명</th>
               <th>평점</th>
               <th>삭제</th>
             </tr>
           </thead>
           <tbody>
           <%
           for(collectionBean colb : col_lists){
           %>
             <tr>
               <td><%=colb.getClnum()%></td>
               <td class="bImg">
                 <a href="#none" class="btnMInfo2"><img src="<%=colb.getCl_img()%>" alt=""/></a>
               </td>
               <td class="bTit">
                 <a href="#none" class="btnMInfo"><%=colb.getCl_title()%></a>
                 
                 <div class="popDetail">
			         <h1><%=colb.getCl_title()%><span>(<%=colb.getCl_subtitle()%>)</span></h1>
			         <div class="mInfo after">
			           <div class="infoL">
			           	<img src="<%=colb.getCl_img()%>" width="250" height="400">
			           </div>
			           <div class="infoR">
				           <div class="subBtnWp">
				           	<a href="https://www.netflix.com/browse" target="_blank" class="netlfix">N넷플릭스</a>
				           	<a href="https://watcha.com/" target="_blank" class="watcha">W왓챠</a>
				           <!-- <input type="button" class="addShow" onclick="col_conrfirm()" id="addShowList"> -->
				         
				           <!--  <input type="submit" class="addLike" formaction="/cart_proc.jsp"  onclick="cart_conrfirm()" id="addLikeList"> -->
				           </div>
				           	<dl class="after">
				           		<dt>평점 :</dt>
				           		<dd><%=colb.getCl_rate()%></dd>
				           		<dt>감독 :</dt>
				           		<dd><%=colb.getCl_director() %></dd>
				           		<dt>배우 :</dt>
				           		<dd><%=colb.getCl_actor() %></dd>
				           		<dt>개봉 :</dt>
				           		<dd><%=colb.getCl_pubdate() %></dd>
				           	</dl>
			           		<p class="iStory"><%=colb.getCl_story()%></p>
				        </div>
			           
			         </div><!-- //mInfo -->
			         <a href="#none" class="popClose"><i class="material-icons md-36">close</i></a>
			         
			       </div><!-- //popDetail -->
               </td>
               <td><%=colb.getCl_rate()%></td>
               
               <td>
               
                 <a class="btnDel" href="mycolletion_deleteproc.jsp?clnum=<%=colb.getClnum()%>" onclick="return deletecheck()">
                 <i class="material-icons md-light">remove_circle_outline</i>
                 </a>
               </td>
             </tr>
             <%} %> 
           </tbody>
         </table>
       </div><!-- //tableWp -->
     </div><!-- //wpBox -->
   </div>
   <!-- //content -->
   <div class="dim"></div>
    <%@include file="footer.jsp" %>
  