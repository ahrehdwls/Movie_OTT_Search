<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
    <!-- 
findid.jsp<br>
<form action="findIdProc.jsp" method="post">
	<table border=1 height=120>
		<tr>
			<td bgcolor="yellow" align="center">이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td bgcolor="yellow" align="center">주민등록번호</td>
			<td><input type="text" name="rrn1">-
				<input type="text" name="rrn2"></td>
		</tr>
		<tr>
				<td colspan=2 bgcolor="#FFCC00" align="center">
					<input type="submit" value="아이디찾기">
				</td>
		</tr>
	</table>
</form>
-->


<body class="align findIdWp">

  <div class="grid">

    <form action="findIdProc.jsp" method="post" class="form login">

      <div class="form__field">
        <label for="findId__username" class="userInputLB"><span class="">이름</span></label>
        <input id="login__username" type="text" name="name" class="form__input" placeholder="" required>
      </div>

      <div class="form__field">
        <label for="findId__psNum" class="userInputLB"><span class="">주민등록번호</span></label>
        <input id="findId__psNum" type="text" name="rrn1" class="form__input" placeholder="" required maxlength="6">
        <span class="psNumDash"> - </span>
        <input id="findId__psNum" type="text" name="rrn2" class="form__input" placeholder="" required  maxlength="7">
      </div>

      <div class="form__field">
        <input type="submit" value="아이디 찾기!" class="btnSubmitDefault">
      </div>

    </form>

  </div>

</body>