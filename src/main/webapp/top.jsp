<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
 <head>
  <meta charset="UTF-8">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>main</title> 
  <link href="<%=request.getContextPath()%>/css/reset.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
     <script src="script.js"></script>
</head>


  <script>
  $(document).ready(function() {
	/* 메인 팝업열기*/
    $('.btnMore').click(function(){
     //$('.dim, .popDetail').show();
     $(this).parent().siblings('.popDetail').show();
     $('.dim').show();
    });
    
    /* 찜한영화,최근본영화 팝업열기 */
    $('.btnMInfo').click(function(){
        $(this).parent().find('.popDetail').show();
        $('.dim').show();
    });
    $('.btnMInfo2').click(function(){
        $(this).parent().siblings().find('.popDetail').show();
        $('.dim').show();
    });
    
    /* 팝업닫기 */
    $('.popClose').click(function(){
     $('.dim, .popDetail').hide();
    });
  });
  </script>
 </head>
 <body>
  <!-- header -->
  <div class="header">
    <div class="hTop wpBox after">
      <h1 class="logo">
        <a href="<%=request.getContextPath()%>/main.jsp"><i class="material-icons md-48">movie</i></a>
      </h1>
      <div class="joinWp">
        <a href="<%=request.getContextPath()%>/logout.jsp" class="login"><i class="material-icons md-light">login</i></a><!-- logout일때 login > logout 로 텍스트 변경  -->
        <a href="#none" class="join"><i class="material-icons md-light">person</i></a>
      </div>
    </div>
    <div class="hBtm">
      <ul class="nav wpBox">
        <li class="on"><a href="<%=request.getContextPath()%>/main.jsp">영화 목록</a></li><!-- 활성화시 class 추가 : on .addClass('on'); .removeClass('on'); -->
        <li><a href="<%=request.getContextPath()%>/search_proc.jsp">영화검색</a></li>
        <li><a href="<%=request.getContextPath()%>/mycollection.jsp">내가 본 영화</a></li>
        <li><a href="<%=request.getContextPath()%>/cart_list.jsp">찜한 영화</a></li>
        <li><a href="<%=request.getContextPath()%>/board/list.jsp">게시판</a></li>
      </ul>
    </div>
  </div>
  <!-- //header -->