<%@page import="board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
deleteForm.jsp => deleteProc.jsp <br>
<%
	String num=request.getParameter("num");
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	String passwd=request.getParameter("passwd");
	
	BoardDao dao = BoardDao.getInstance();
	int cnt = dao.deleteArticle(num, passwd); // where num=?
	//21(3페이지)->20(2페이지)
	int pageSize = 10;
	if(cnt >=0 ){
	 	int recordCount = dao.getAritcleCount(); // 20
	 	System.out.println("레코드갯수 recordCount:" + recordCount);
	 	
	 	int pageCount = recordCount/pageSize + (recordCount % pageSize == 0 ? 0:1);
	 	//pageCount:2 
	 	if(pageCount < pageNum){ // 2 < 3
	 		response.sendRedirect("list.jsp?pageNum="+(pageNum-1));
	 	}
	 	else{ // 2 < 1
			response.sendRedirect("list.jsp?pageNum="+pageNum);
	 	}
	}
	else{ // 비번 일치 안함
		//response.sendRedirect("deleteForm.jsp?num="+num+"&pageNum="+pageNum);
	%>
	<script type="text/javascript">
		alert('비번 일치 안함');
		history.go(-1); // back() == go(-1)
	</script>
	<%
	}
%>






