<%@page import="board.BoardDao"%>
<%@page import="board.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript" src="./js/jquery.js"></script>
<script type="text/javascript" src="script.js"></script>
<%@ include file="../top.jsp"%> 

<%
int num = Integer.parseInt(request.getParameter("num"));
int pageNum = Integer.parseInt(request.getParameter("pageNum"));
System.out.println("updateForm.jsp num:" + num+" pageNum:"+pageNum);

	
	BoardDao dao = BoardDao.getInstance(); 
	BoardBean article = dao.updateFormArticle(num);
%>

 <div class="contents">
     <div class="wpBox">
       <h1 class="mainTit">게시판 수정양식</h1>
       <div class="tableWp">
         <!-- table -->
         <table class="defaultTb typeBdTop writeTb">
           <colgroup>
             <col style="width:120px;">
             <col style="width:420px;">
             <col style="width:120px;">
             <col style="width:420px;">
           </colgroup>
          <form method="post" name="writeform" action="updateProc.jsp?pageNum=<%=pageNum%>">
		<input type="hidden" name="num" value="<%=num %>">
           <tbody>
             <tr>
               <th>이름</th>
               <td class=""><input type="text" name="writer" placeholder="이름을 입력하세요." />
               </td>
               <th>E-mail</th>
               <td class=""><input type="email" name="email" placeholder="E-mail 주소를 입력하세요." />
               </td>
             </tr>
             <tr>
               <th>제목</th>
               <td colspan="3"><input type="text" name="subject" placeholder="제목을 입력하세요." /></td>
             </tr>
             <tr>
               <th>비밀번호</th>
               <td colspan="3"><input type="password" name="passwd" placeholder="비밀번호를 입력하세요." /></td>
             </tr>
             <tr class="tdCont">
               <th>내용</th>
               <td colspan="3">
                <textarea name="content" placeholder="내용을 입력하세요."></textarea>
               </td>
             </tr>
           </tbody>
          
         </table>
         <!-- //table -->
         <div class="boardBtnWp ar">
           <ul>
             <li>
               <input type="submit" value="글쓰기" onClick="return writeSave()">
             </li>
             <li>
               <a href="#none" class="btnDefault">다시작성</a>
             </li>
             <li>
               <a href="list.jsp"class="btnDefault">목록</a>
             </li>
           </ul>
         </div>
          </form>
       </div><!-- //tableWp -->
     </div>
   </div>
   <!-- //content -->
   <%@ include file="../footer.jsp"%>




 