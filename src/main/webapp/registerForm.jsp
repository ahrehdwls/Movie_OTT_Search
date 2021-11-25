<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <link rel="stylesheet" type="text/css" href=../../style.css> -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function duplicate(){
	//alert(1);
	isCheck = true;
	isChange = false;
	
	$.ajax({
		url : "id_check_proc.jsp",
		data: ({
			userid: $('input[name="id"]').val() // userid=kim
		}),
		success:function(data){ 
			if($('input[name="id"]').val() == ""){
				$('#idmessage').html("<font color=red>id 입력 누락</font>");
				$('#idmessage').show();
			}
			else if($.trim(data)=='YES'){
				$('#idmessage').html("<font color=red>사용 가능합니다.</font>");
				$('#idmessage').show();
				use = "possible";
			}
			else{ // NO
				$('#idmessage').html("<font color=red>이미 사용중인 아이디입니다.</font>");
				$('#idmessage').show();
				use = "impossible";
			}
		}// success
	});
	
}//duplicate

function pwcheck(){ // onBlur
	//alert('pwcheck');
	//pw = $('input[name="password"]').val();
	pw = document.forms[0].password.value; // 34q@9
	
	// 소문자 + 숫자 조합 3~8
	var regexp = /^[a-z0-9]{3,8}$/; // abc(o) , 876(o), #abc4*
	
	if(pw != ''){
		if(pw.search(regexp) == -1){
			alert('비번 형식이 틀렸습니다.');
			document.forms[0].password.value="";
			document.forms[0].password.focus();
			return false;
		}
		var chk_num = pw.search(/[0-9]/);
		var chk_eng = pw.search(/[a-z]/);
		
		if(chk_num < 0 || chk_eng < 0){
			alert('비번은 영문자 숫자 조합해 주세요');
			document.forms[0].password.value="";
			document.forms[0].password.focus();
			return false;
		}
	}
} // pwcheck

function passwd_confirm(){
	//alert('passwd_confirm()')
	
	if($('input[name="password"]').val()== $('input[name="repassword"]').val()){
		$('#pwmessage').html("<font color=red>비번 일치</font>");
		$('#pwmessage').show();
		pwsame="same";
	}
	else{
		$('#pwmessage').html("<font color=red>비번 불일치</font>");
		$('#pwmessage').show();
		pwsame="nosame";
	}
}// passwd_confirm

</script>

<body class="align registerWp">

  <div class="grid">

    <form  action="registerProc.jsp" method="post" class="form login">
	  
	  <h2>기본정보</h2>
	  <div class="form__field">
        <label for="rgst__userId" class="userInputLB"><span class="">아이디</span></label>
        <input id="rgst__userId" type="text" name="id" class="form__input registIDIpt" placeholder="" required>
        <button type="button" id="id_check" class="registIDBtn" onclick="return duplicate()">중복체크</button> 
      </div>
      <div id="idmessage" class="formAlertMsg" style="display:none;"></div>
	  
	  <div class="form__field">
        <label for="rgst__password" class="userInputLB"><span class="">비밀번호</span></label>
        <input id="rgst__password" type="password" name="password" onBlur="pwcheck()" class="form__input" placeholder="영문 소문자/숫자 조합 3~8자" required>
      </div>
      
      <div class="form__field">
        <label for="rgst__repassword" class="userInputLB"><span class="">비밀번호 확인</span></label>
        <input id="rgst__repassword" type="password" name="repassword" onKeyUp="passwd_confirm()" placeholder="비밀번호를 한번 더 입력하세요" class="form__input" required>
      </div>
      
      <div id="pwmessage" class="formAlertMsg" style="display:none;"></div>  
      
      <div class="form__field">
        <label for="rgst__email" class="userInputLB"><span class="">이메일</span></label>
        <input id="rgst__email" type="text" name="email" value="" class="form__input" placeholder="gildong@naver.com" required>      
      </div>
      
      <h2>개인 신상 정보</h2>
      <div class="form__field">
        <label for="rgst__username" class="userInputLB"><span class="">이름</span></label>
        <input id="rgst__username" type="text" name="name" class="form__input" placeholder="" required>
      </div>
  
      <div class="form__field">
        <label for="findPw__psNum" class="userInputLB"><span class="">주민등록번호</span></label>
        <input id="findPw__psNum" type="text" name="rrn1" class="form__input" placeholder="" required maxlength="6">
        <span class="psNumDash"> - </span>
        <input id="findPw__psNum" type="text" name="rrn2" class="form__input" placeholder="" required maxlength="7">
      </div>

      <div class="form__field">
        <input type="submit" value="가입하기" class="btnSubmitDefault">
        <input type="reset" value="취소" class="btnResetDefault">
      </div>
	  
    </form>

  </div>

</body>

<!--  
<form method="post" action="registerProc.jsp" onsubmit="return writeSave()">
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center" bgcolor="#FFCC00">
			<font size="3" color="#5D1900"><b>◈ 기본 정보 ◈</b></font>
		</td>
	</tr>
	<tr>
		<th bgcolor="yellow" align="center"> * 회원 아이디 </th>
		<td>
			<input type="text" name="id">
			<button type="button" id="id_check" onclick="return duplicate()">중복체크</button>
			<span id="idmessage" style="display:none;"></span>
		</td>
	</tr>
	<tr>
		<th bgcolor="yellow" align="center"> * 비밀 번호</th>
		<td><input type="password" name="password" onBlur="pwcheck()"> 영문 소문자/숫자 조합 3~8자</td>
	</tr>
	<tr>
		<th bgcolor="yellow" align="center"> * 비밀 번호 확인</th>
		<td><input type="password" name="repassword" id="repassword" onKeyUp="passwd_confirm()">
		<span id="pwmessage" style="display:none;"></span>
	</tr>	
	<tr>
		<th bgcolor="yellow" align="center"> E-Mail </th>
		<td>
			<input type="text" name="email" value="gildong@naver.com"> 
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center" bgcolor="#FFCC00">
			<font size="3" color="#5D1900"><b>◈ 개인 신상 정보 ◈</b></font>
		</td>
	</tr>
	<tr>
		<th bgcolor="yellow" align="center">한글 이름</th>
		<td><input type="text" name="name" value="홍길동"> 성과 이름을 붙여주세요 (예)홍길동</td>
	</tr>
	<tr>
		<th bgcolor="yellow" align="center">휴대 전화 번호</th>
		<td>
			<select name="hp1">
				<option value="010">010</option>
				<option value="011">011</option>
			</select>
			- 
			<input type="text" name="hp2" size="4" maxlength="4" value="1234"> - 
			<input type="text" name="hp3" size="4" maxlength="4" value="5678"> 예) 011-000-0000
		</td>
	</tr>
	<tr>
		<td colspan="2" bgcolor="#FFCC00"  align="center">
			<input type="submit" value="가입 하기" id="sub">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</td>
	</tr>	
</table>
</form>
 -->

