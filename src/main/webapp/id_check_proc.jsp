<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid"); // kim
	
	MemberDAO mdao = MemberDAO.getInstance();
	boolean isCheck = mdao.searchId(userid);
	/* 존재한다:true
	존재안한다:false */
	String str="";
	if(isCheck){
		str = "NO";
		out.print(str);
	}
	else{
		str = "YES";
		out.print(str);
	}
	
%>
