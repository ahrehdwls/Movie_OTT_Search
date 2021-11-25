<%@page import="board.BoardDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
updateForm.jsp => updateProc.jsp <br>
<%
	request.setCharacterEncoding("UTF-8");
	String pageNum = request.getParameter("pageNum");
%>
<jsp:useBean id="bb" class="board.BoardBean"/>
<jsp:setProperty property="*" name="bb"/>
<!-- form=>5가지 -->
<%
bb.setReg_date(new Timestamp(System.currentTimeMillis()));
/* 5+1 */ 

BoardDao dao = BoardDao.getInstance();
int cnt = dao.updateArticle(bb);
System.out.println("updateProc.jsp cnt:"+cnt);
if(cnt >= 0){
	response.sendRedirect("list.jsp?pageNum="+pageNum);
	
}else{ // 비번 일치 안함
	%>
		<script type="text/javascript">
			alert("비밀 번호가 맞지 않습니다.");
			history.go(-1);
		</script>   
	<%
	
	//response.sendRedirect("updateForm.jsp?num="+bb.getNum()+"&pageNum=1");

}//else
%>
