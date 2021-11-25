<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">

<body class="align findPwWp">

  <div class="grid">

    <form action="findPwdProc.jsp" method="post" class="form login">
    
      <div class="form__field">
        <label for="findPw__userId" class="userInputLB"><span class="">아이디</span></label>
        <input id="findPw__userId" type="text" name="id" class="form__input" placeholder="" required>
      </div>

      <div class="form__field">
        <label for="findPw__username" class="userInputLB"><span class="">이름</span></label>
        <input id="findPw__username" type="text" name="name" class="form__input" placeholder="" required>
      </div>

      <div class="form__field">
        <label for="findPw__psNum" class="userInputLB"><span class="">주민등록번호</span></label>
        <input id="findPw__psNum" type="text" name="rrn1" class="form__input" placeholder="" required maxlength="6">
        <span class="psNumDash"> - </span>
        <input id="findPw__psNum" type="text" name="rrn2" class="form__input" placeholder="" required maxlength="7">
      </div>

      <div class="form__field">
        <input type="submit" value="비밀번호 찾기!" class="btnSubmitDefault">
      </div>

    </form>

  </div>