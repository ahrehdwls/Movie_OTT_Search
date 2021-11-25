<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%>

<script type="text/javascript">
	function deleteSave(){
		if(document.delForm.passwd.value==''){
			alert('비밀번호를 입력하세요');
			document.delForm.passwd.focus();
			return false;
		}
	}
</script>
<%
int num = Integer.parseInt(request.getParameter("num"));
int pageNum = Integer.parseInt(request.getParameter("pageNum"));
System.out.println("deleteForm.jsp num:" + num+" pageNum:"+pageNum);
%>
<form method="post" name="delForm" action="deleteProc.jsp"  onSubmit="return deleteSave()">
	<input type="hidden" name="num" value="<%=num %>">
	<input type="hidden" name="pageNum" value="<%=pageNum%>">

<div class="contents">
     <div class="wpBox">
       <h1 class="mainTit">게시글 삭제</h1>
       <div class="deleteWp">
         <div class="deleteBox">
           <p class="ac">비밀번호를 입력하세요.</p>
           <input type="password" class="wM" name="passwd" />
           <div class="boardBtnWp ac">
             <ul>
               <li>
                 <a href="deleteProc.jsp" class="btnDefault">삭제</a>
               </li>
               <li>
                 <a href="list.jsp" class="btnDefault">목록</a>
               </li>
             </ul>
           </div>
         </div>
       </div><!-- //deleteWp -->
     </div>
   </div>
   <!-- //content -->
   </form>
   <%@ include file="../footer.jsp"%>