<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../top.jsp"%> 


<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function writeSave(){ 
	//alert(1);  
	if($('input[name="writer"]').val() ==""){
		alert("이름을 입력하세요");
		$('input[name="writer"]').focus();
		return false;
	}
	
	if($('input[name="subject"]').val()==""){
		alert("제목을 입력하세요");
		$('input[name="subject"]').focus();
		return false;
	}
	if($('input[name="email"]').val()==""){
		alert("메일 입력 해주세요");
		$('input[name="email"]').focus();
		return false;
	}

	if($('textarea[name="content"]').val() == ""){
		alert('내용은 필수입니다');
		$('textarea[name="content"]').focus();
		return false;		
	}

	if($('input[name="passwd"]').val()==""){
		alert("비번 입력 해주세요");
		$('input[name="passwd"]').focus();
		return false;
	}
}   

</script>
 <!-- content -->
   <div class="contents">
     <div class="wpBox">
       <h1 class="mainTit">게시판 글쓰기</h1>
       <div class="tableWp">
         <!-- table -->
         <table class="defaultTb typeBdTop writeTb">
           <colgroup>
             <col style="width:120px;">
             <col style="width:420px;">
             <col style="width:120px;">
             <col style="width:420px;">
           </colgroup>
           <form method="post" name="writeform" action="writeProc.jsp">
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
   