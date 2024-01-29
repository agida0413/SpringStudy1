<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--  NO                                        NOT NULL NUMBER
 GOODS_NAME                                NOT NULL VARCHAR2(1000)
 GOODS_SUB                                          VARCHAR2(1000)
 GOODS_PRICE                               NOT NULL VARCHAR2(50)
 GOODS_DISCOUNT                                     NUMBER
 GOODS_FIRST_PRICE                                  VARCHAR2(20)
 GOODS_DELIVERY                            NOT NULL VARCHAR2(20)
 GOODS_POSTER                                       VARCHAR2(260)
 HIT                                                NUMBER -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="row">
<table class="table">
<tr>
<td width="30%" class="text-center" rowspan="8">
<img src="${vo.goods_poster }" style="width: 290px; height: 400px">
</td>
<td colspan="2">
<h3>${vo.goods_name }&nbsp;<span style="color: orange"></span></h3>
</td>
</tr>
<tr>
<th width="20%" class="text-right">이름</th>
<td width="50%">${vo.goods_name }</td>
</tr>
<tr>
<th width="20%" class="text-right">부제목</th>
<td width="50%">${vo.goods_sub }</td>
</tr>
<tr>
<th width="20%" class="text-right">가격대</th>
<td width="50%">${vo.goods_price }</td>
</tr>
<tr>
<th width="20%" class="text-right">첫가격</th>
<td width="50%">${vo.goods_first_price}</td>
</tr>
<tr>
<th width="20%" class="text-right">할인</th>
<td width="50%">${vo.goods_discount }</td>
</tr>
<tr>
<th width="20%" class="text-right">배송</th>
<td width="50%">${vo.goods_delivery }</td>
</tr>
<tr>
<th width="20%" class="text-right">조회수</th>
<td width="50%">${vo.hit }</td>
</tr>
<tr>
<td colspan="3">
<pre style="white-space: pre-wrap; border:none; background-color: white" ></pre>
</td>
</tr>
<tr>
<td colspan="3" class="text-right">
<a href="../goods/list.do" class="btn btn-sm btn-danger">목록</a>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>