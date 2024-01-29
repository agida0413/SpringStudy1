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
<form action="../goods/find.do" method="post">
	<div class="row">
		<select name="table_name" class="input-sm">
			<option value="goods_all" ${table_name=='goods_all'?"selected":"" }>전체상품</option>
			<option value="goods_best" ${table_name=='goods_best'?"selected":"" }>베스트</option>
			<option value="goods_new" ${table_name=='goods_new'?"selected":"" }>신상품</option>
		</select>
		<input type="text" name="ss" size=20 class="input-sm" value="${ss }">
		<input type="submit" value="검색" class="btn-sm btn-danger">
		
	</div>
	</form>
	<div style="height:20px;"></div>
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
	
		<div class="row">
		<div class="text-center">
				<ul class="pagination">
				<c:if test="${startpage>1 }">
				 <li><a href="../goods/find.do?page=${startpage-1 }&table_name=${table_name}&ss=${ss}">&lt;</a></li>
				 </c:if>
					<c:forEach var="i" begin="${startpage}" end="${endpage}" >
				  <li ${curpage==i?" class=active":" "}><a href="../goods/find.do?page=${i }&table_name=${table_name}&ss=${ss}">${i}</a></li>
					</c:forEach>
			<c:if test="${endpage<totalpage }">
			 <li><a href="../goods/find.do?page=${endpage+1 }&table_name=${table_name}&ss=${ss}">&gt;</a></li>
			 </c:if>
				</ul> 
		</div>
	</div>
	
	
</div>
</body>
</html>