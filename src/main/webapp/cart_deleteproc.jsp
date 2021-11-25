<%@page import="movielist.Cart.cartDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
cart_delete

<%
	request.setCharacterEncoding("UTF-8");

    String cartnum = request.getParameter("cartnum");
    System.out.println(cartnum);
    cartDao cdao = cartDao.getInstance();
    
   int cnt =  cdao.deleteMovie(cartnum);
   
   String msg ="";
   String url ="";
   if(cnt>0){
   	msg = "삭제 완료";
   	url = "cart_list.jsp";
   }
   else{
   	msg = "삭제 실패";
 	url = "cart_list.jsp";
   }
   %>

   <script type="text/javascript">
    	alert("<%=msg%>"+"했습니다.");
    	location.href="<%=url%>"; 
   </script>
    %>