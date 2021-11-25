<%@page import="movielist.Colletion.colletionDao"%>
<%@page import="movielist.Cart.cartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
cart_delete

<%
	request.setCharacterEncoding("UTF-8");

    String clnum = request.getParameter("clnum");
    System.out.println(clnum);
    colletionDao cldao = colletionDao.getInstance();
    
   int cnt =  cldao.deleteMovie(clnum);
   
   String msg ="";
   String url ="";
   if(cnt>0){
   	msg = "삭제 완료";
   	url = "mycollection.jsp";
   }
   else{
   	msg = "삭제 실패";
 	url = "mycollection.jsp";
   }
   %>

   <script type="text/javascript">
    	alert("<%=msg%>"+"했습니다.");
    	location.href="<%=url%>"; 
   </script>
    %>