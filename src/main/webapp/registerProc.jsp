<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
registerForm.jsp => registerProc.jsp<br>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="bean" class="my.member.MemberDTO"/>  
<jsp:setProperty property="*" name="bean"/>
<%
MemberDAO mdao = MemberDAO.getInstance();

int cnt = mdao.insertData(bean);
String msg="";
String url="";

if(cnt>0){
	msg = "가입 성공";
	url = request.getContextPath() + "/login.jsp";
}
else{
	msg = "가입 실패";
	url = request.getContextPath() +"/myshop/member/registerForm.jsp";
}
%>

<script type="text/javascript">
 	alert("<%=msg%>"+"했습니다.");
 	location.href="<%=url%>"; 
</script>
