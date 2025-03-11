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
			    <div class="login-input">
			        <input id="id" type="text" placeholder="아이디">
			        <input id="pw" type="password" placeholder="비밀번호">
			    </div>
			    
			    <div class="login-buttons">
			        <button id="btnLogin">로그인</button>
			    </div>
			</div>
			<div class="categori-box m-t-10">
			    <button class="category-item" data-bs-toggle="modal" data-bs-target="#signupModal">
			        <i class="fas fa-user-plus"></i> 회원가입
			    </button>
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
<!-- 회원가입 모달 -->
<div class="modal fade" id="signupModal" tabindex="-1" aria-labelledby="signupModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="signupModalLabel">회원가입</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="signupForm">
                	<div class="row m-b-10">
                		<label for="memberId" class="form-label">아이디</label>
					    <div class="input-group">
					        <input type="text" class="form-control" id="memberId" name="memberId" required>
					        <button class="btn btn-outline-secondary" type="button" id="checkDuplicate">중복 확인</button>
					    </div>
	                </div>
	                <div class="row m-b-10">
	                    <div class="mb-3">
	                        <label for="pw" class="form-label">비밀번호</label>
	                        <input type="password" class="form-control" id="pw" name="pw" required>
	                    </div>
                    </div>
	                <div class="row m-b-10">
	                    <div class="mb-3">
	                        <label for="rePw" class="form-label">비밀번호 확인</label>
	                        <input type="password" class="form-control" id="rePw" name="rePw" required>
	                    </div>
                    </div>
                    <div class="row m-b-10">
					    <div class="col-md-6">
					        <label for="name" class="form-label">성명</label>
					        <input type="text" class="form-control" id="name" name="name">
					    </div>
					    <div class="col-md-6">
					        <label for="phoneNum" class="form-label">연락처</label>
					        <input type="text" class="form-control" id="phoneNum" name="phoneNum">
					    </div>
                    </div>
                    <div class="row m-b-10">
					    <div class="col-md-6">
					        <label for="birthdate" class="form-label">생년월일</label>
					        <input type="date" class="form-control" id="birthdate" name="birthdate">
					    </div>
					    <div class="col-md-6">
					        <label for="email" class="form-label">이메일</label>
					        <input type="email" class="form-control" id="email" name="email">
					    </div>
                    </div>
                   	<button type="button" class="btn" id="signupSubmit">회원가입</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %> <!-- 공통 푸터 -->
</body>
</html>