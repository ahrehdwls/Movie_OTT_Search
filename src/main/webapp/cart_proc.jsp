<%@page import="movielist.Cart.cartDao"%>
<%@page import="movielist.croll_movieDao"%>
<%@page import="movielist.croll_movieBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        cart_proc
<%
	request.setCharacterEncoding("UTF-8");

    String mnum = request.getParameter("mnum");
    System.out.println(mnum);
    croll_movieDao CRMD = croll_movieDao.getInstance();
    croll_movieBean CRMB =CRMD.selectByMnum(mnum); 
    //--------------------------------------------
    
    cartDao cdao = cartDao.getInstance();
    int cnt = cdao.insertcart(CRMB); 
    
    String msg ="";
    String url ="";
    if(cnt>0){
    	msg = "찜 목록 담기 완료";
    	//url = request.getContextPath() + "/main.jsp";
    }
    else{
    	msg = "찜 목록 담기 실패";
    	//url = request.getContextPath() +"/myshop/member/registerForm.jsp";
    }
    %>

    <script type="text/javascript">
     	alert("<%=msg%>"+"했습니다.");
     	location.href="main.jsp"; 
    </script>