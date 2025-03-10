<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <title>Insert title here</title> -->
<%@ include file="/WEB-INF/views/common/header.jsp" %> <!-- 공통 헤더 -->
<link rel="stylesheet" href="/css/main/home.css">
<script src="/js/main/home.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>
<body>
<nav id="nav" class="navbar navbar-expand-lg navbar-lightbg-light border-style">
	<a class="navbar-brand" href="#">
	    <img src="/image/logo.png" width="80" alt="로고">
	</a>
	<div class="collapse navbar-collapse">
	    <ul class="navbar-nav">
	        <li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
	        <li class="nav-item"><a class="nav-link" href="#">강아지</a></li>
	        <li class="nav-item"><a class="nav-link" href="#">채소</a></li>
	        <li class="nav-item"><a class="nav-link" href="#">커뮤니티</a></li>
	    </ul>
	</div>
</nav>
<div class="container-fluid">
<!-- 3번 구역: 메인 콘텐츠 -->
	<div id="main" class="col-md-9 main-content">
	    <h3>3번 구역</h3>
	</div>
</div>

<!-- ✅ 2번 & 3번 구역 -->
<div class="container-fluid">
    <div class="row">
        <!-- 2번 구역: 사이드바 -->
        <div class="col-3 sidebar">
			<div class="login-box">
			    <!-- 입력 필드 -->
			    <div class="login-input">
			        <input id="id" type="text" placeholder="아이디">
			        <input id="pw" type="password" placeholder="비밀번호">
			    </div>
			    
			    <!-- 로그인 & 회원가입 버튼 -->
			    <div class="login-buttons">
			        <button id="btnLogin">로그인</button>
			    </div>
			</div>
			<div class="categori-box">
			    <div class="category-item">
			        <i class="fas fa-user-plus"></i> 회원가입
			    </div>
			    <div class="category-item">
			        <i class="fas fa-user"></i> 아이디 찾기
			    </div>
			    <div class="category-item">
			        <i class="fas fa-lock"></i> 비밀번호 찾기
			    </div>
			</div>
        </div>
    </div>
</div>
</body>
</html>