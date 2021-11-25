<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 결재-계속?취소 클릭 => webapp-logout.jsp -->

<!-- 장바구니 세션
로그인한 id, no -->
<%
	session.invalidate();
	response.sendRedirect("login.jsp");
%>


