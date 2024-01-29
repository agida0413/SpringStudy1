<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<style type="text/css">
.row{
margin: 0px auto;
width:100%;

}
</style>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../main/header.jsp"></jsp:include>
<c:if test="${sessionScope.id!=null }">
<div class="container">
	<div class="row">
	
		<div class="text-right">
		<form action="../member/logout.do" method="post">
			${sessionScope.name }님 로그인 되었습니다.
			<button class="btn-sm btn-danger">로그아웃</button>
			</form>
		</div>
		
	</div>
</div>
</c:if>
<jsp:include page="${main_jsp}"></jsp:include>
</body>
</html>