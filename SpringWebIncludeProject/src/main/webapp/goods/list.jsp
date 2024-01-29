<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
		
		<c:forEach var="vo" items="${list }">
		<div class="col-sm-3">
		<a href="../goods/detail_before.do?no=${vo.no }">
		 <div class="panel panel-primary">
		    <div class="panel-heading">${vo.goods_price }</div>
		    <div class="panel-body"><img src="${vo.goods_poster }" style="width:180px; height:100px;"></div>
		  	</div>
		  	</a>
		  </div>
		  
		</c:forEach>
	</div>
	<div style="height:20px"></div>
			<div class="row">
		<div class="text-center">
				<ul class="pagination">
				<c:if test="${startpage>1 }">
				 <li><a href="../goods/list.do?page=${startpage-1 }">&lt;</a></li>
				 </c:if>
					<c:forEach var="i" begin="${startpage}" end="${endpage}" >
				  <li ${curpage==i?" class=active":" "}><a href="../goods/list.do?page=${i }">${i}</a></li>
					</c:forEach>
			<c:if test="${endpage<totalpage }">
			 <li><a href="../goods/list.do?page=${endpage+1 }">&gt;</a></li>
			 </c:if>
				</ul> 
		</div>
	</div>
	<div style="height:20px;"></div>
	
	<div class="row">
		<h3>최근 방문 맛집</h3>
		<hr>
		<c:if test="${gcount!=0 }">
		<form action="../goods/deleteCookie.do" method="post">
			<c:forEach var="cgvo" items="${cgList }" varStatus="s">
				<c:if test="${s.index<9 }">
				<a href="../goods/detail_before.do?no=${cgvo.no }">
					<img src="${cgvo.goods_poster }" style="width:100px; height:100px;"/>
					</a>
					
					<input type="checkbox" name="dcookies[${s.index }]" value="${cgvo.no }">
					
				</c:if>
			</c:forEach>
			<input type="submit" class="btn btn-danger" value="삭제">
			</form>
		</c:if>
	</div>
	
		</div>
	
</body>
</html>