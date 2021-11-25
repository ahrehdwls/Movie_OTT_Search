<%@page import="my.member.MemberDAO"%>
<%@page import="my.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
findId.jsp => findIdProc.jsp<br>
<%
	request.setCharacterEncoding("UTF-8"); 
	String name = request.getParameter("name");
	String rrn1 = request.getParameter("rrn1");
	String rrn2 = request.getParameter("rrn2");
	System.out.println(name);
	System.out.println(rrn1);
	System.out.println(rrn2);
	
	MemberDAO mdao = MemberDAO.getInstance(); 
	MemberDTO member = mdao.getMemberByrrn(name,rrn1,rrn2);
	String msg;
	if(member != null){
		msg = member.getId();
	}
	else{
		msg = "없는 회원";
	}
	String url = "login.jsp";
%>
<script type="text/javascript">
	alert("<%=msg%>"+"입니다.");
	location.href="<%=url%>";
</script>
