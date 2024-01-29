<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form action="../food/find.do" method="post">
	<div class="row">
		<select name="colname" class="input-sm">
			<option value="type" ${colname=='type'?"selected":"" }>음식종류</option>
			<option value="address" ${colname=='address'?"selected":"" }>주소</option>
			<option value="name" ${colname=='name'?"selected":"" }>업체명</option>
		</select>
		<input type="text" name="ss" size=20 class="input-sm" value="${ss }">
		<input type="submit" value="검색" class="btn-sm btn-danger">
		
	</div>
	</form>
	<div style="height:20px;"></div>
	<div class="row">
			<c:forEach var="vo" items="${list }">
		<div class="col-sm-3">
		<a href="../food/detail_before.do?fno=${vo.fno }">
		 <div class="panel panel-primary">
		    <div class="panel-heading">${vo.name }</div>
		    <div class="panel-body"><img src="https://www.menupan.com/${vo.poster }" style="width:180px; height:100px;"></div>
		  	</div>
		  	</a>
		  </div>
		  
		</c:forEach>
	</div>
	
		<div class="row">
		<div class="text-center">
				<ul class="pagination">
				<c:if test="${startpage>1 }">
				 <li><a href="../food/find.do?page=${startpage-1 }&colname=${colname}&ss=${ss}">&lt;</a></li>
				 </c:if>
					<c:forEach var="i" begin="${startpage}" end="${endpage}" >
				  <li ${curpage==i?" class=active":" "}><a href="../food/find.do?page=${i }&colname=${colname}&ss=${ss}">${i}</a></li>
					</c:forEach>
			<c:if test="${endpage<totalpage }">
			 <li><a href="../food/find.do?page=${endpage+1 }&colname=${colname}&ss=${ss}">&gt;</a></li>
			 </c:if>
				</ul> 
		</div>
	</div>
	
	<div class="row">
		<h3>최근 방문 맛집</h3>
		<hr>
		<c:if test="${count!=0 }">
			<c:forEach var="cvo" items="${cList }" varStatus="s">
				<c:if test="${s.index<9 }">
					<img src="https://www.menupan.com/${cvo.poster }" style="width:100px; height:100px;"/>
				</c:if>
			</c:forEach>
		</c:if>
	</div>
</div>
</body>
</html>