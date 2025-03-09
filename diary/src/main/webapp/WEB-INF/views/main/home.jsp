<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/common/header.jsp" %> <!-- 공통 헤더 -->
<link rel="stylesheet" href="/css/main/home.css">
<script src="/js/main/home.js"></script>
</head>
<body>
    <h1>로그 데이터 조회</h1>
    <button id="loadLogs">로그 가져오기</button>
    <ul id="logList"></ul>
</body>
</html>