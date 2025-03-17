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
<script src="/js/common/memberValidator.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>
<body>
<div class="container-fluid">
	<div id="main" class="col-md-9 main-content">
		<div class="post">
			<div class="post-box post-best-box">
				<img alt="" src="/image/logo.png" width="100%" height="100%">
			</div>
			<div class="notice-box">
				<h3>🔔 공지사항 </h3>			
				<div class="notice-contents m-b-30">
					<p> - 새로운 공지1</p>
					<p> - 새로운 공지2</p>
					<p> - 새로운 공지3</p>
					<p> - 새로운 공지4</p>
				</div>
				
				<h3>🖊 게시글 </h3>	
				<div class="board-contents">
					<p> - 새로운 게시글1</p>
					<p> - 새로운 게시글2</p>
					<p> - 새로운 게시글3</p>
					<p> - 새로운 게시글4</p>
				</div>
			</div>
		</div>
		<div class="board">
			<div class="board-img-box m-l-10">
				<div class="board-img">
					<img alt="" src="https://picsum.photos/600/400" width="100%" height="100%">
				</div>
				<div class="board-img">
					<img alt="" src="https://picsum.photos/600/400" width="100%" height="100%">
				</div>
				<div class="board-img">
					<img alt="" src="https://picsum.photos/600/400" width="100%" height="100%">
				</div>
				<div class="board-img">
					<img alt="" src="https://picsum.photos/600/400" width="100%" height="100%">
				</div>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-3 sidebar">
			<div class="watch-box">
				<div id="clock"></div>
			</div>
			<div class="login-box m-t-10">
				<%-- 로그인 전 화면 --%>
				<c:if test="${empty sessionScope.loginUser}">
				    <div class="login-input">
				        <input id="id" type="text" placeholder="아이디">
				        <input id="loginPw" type="password" placeholder="비밀번호">
				    </div>
				    
				    <div class="login-buttons">
				        <button id="btnLogin">로그인</button>
				    </div>
				</c:if>
				<%-- 로그인 후 화면 --%>
				<c:if test="${not empty sessionScope.loginUser}">
			        <div id="profileImg">
			            <img alt="" src="https://picsum.photos/600/400" width="100%" height="100%">
			        </div>
			        
			        <div id="profileInfo">
			            <p>- ${sessionScope.loginUser.name} </p>
			            <p>- ${sessionScope.loginUser.email} </p>
			        </div>
				</c:if>
			</div>
			<div class="categori-box m-t-10">
				<%-- 로그인 전 화면 --%>
				<c:if test="${empty sessionScope.loginUser}">
					<button class="category-item" data-bs-toggle="modal" data-bs-target="#signModal">
					    <i class="bi bi-person-plus-fill"></i> 회원가입
					</button>
					<button class="category-item" id="btnFindIdModal" data-bs-toggle="modal" data-bs-target="#findIdModal">
					    <i class="bi bi-person"></i> 아이디 찾기
					</button>
<!-- 					<button class="category-item" id="btnFindPwModal" data-bs-toggle="modal" data-bs-target="#findPwModal"> -->
<!-- 					    <i class="bi bi-key-fill"></i> 비밀번호 찾기 -->
<!-- 					</button> -->
				</c:if>
				
				<%-- 로그인 후 화면 --%>
				<c:if test="${not empty sessionScope.loginUser}">
				    <button class="category-item" id="btnModify">
				        <i class="bi-person-lines-fill"></i> 내 정보 수정
				    </button>
				    <button class="category-item" id="btnMyBoard">
				        <i class="bi-person"></i> 나의 게시물
				    </button>
				    <button class="category-item" id="btnLikeBoard">
				        <i class="bi-hand-thumbs-up-fill"></i> 좋아요 한 게시물
				    </button>
				    <button class="category-item" id="btnCommentBoard">
				        <i class="bi-chat-dots-fill"></i> 댓글 단 게시물
				    </button>
				    <button class="category-item" id="btnLogout">
				        <i class="bi-box-arrow-right"></i> 로그아웃
				    </button>
			    </c:if>
			</div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/main/modal/signModal.jsp" %>
<%@ include file="/WEB-INF/views/main/modal/findIdModal.jsp" %>
<%-- <%@ include file="/WEB-INF/views/main/modal/findPwModal.jsp" %> --%>
<%@ include file="/WEB-INF/views/common/footer.jsp" %> <!-- 공통 푸터 -->
</body>
</html>