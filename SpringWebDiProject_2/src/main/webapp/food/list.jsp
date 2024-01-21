<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
margin:0px auto;
width:960px;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<c:forEach var="vo" items="${list}">
			<div class="col-md-3">
			    <div class="thumbnail">
			      <a href="../food/detail.do?fno=${vo.fno }">
			        <img src="https://www.menupan.com/${vo.poster}" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p style="font-size:9px;">${vo.name}</p>
			        </div>
			      </a>
			    </div>
			  </div>
		</c:forEach>
	</div>
	
	<div style="height:20px">
		
	</div>
	
	<div class="row">
		<div class="text-center">
				<ul class="pagination">
				<c:if test="${startpage>1 }">
				 <li><a href="list.do?page=${startpage-1 }">&lt;</a></li>
				 </c:if>
					<c:forEach var="i" begin="${startpage}" end="${endpage}" >
				  <li ${curpage==i?" class=active":" "}><a href="list.do?page=${i }">${i}</a></li>
					</c:forEach>
			<c:if test="${endpage<totalpage }">
			 <li><a href="list.do?page=${endpage+1 }">&gt;</a></li>
			 </c:if>
				</ul> 
		</div>
	</div>
</div>
</body>
</html>