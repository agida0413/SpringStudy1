<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container{
margin-top: 50px;
}
.row{
margin: 0px auto;
width: 900x;
}
</style>
</head>
<body>
<%-- axios.get = > params가 있어야함  = > @getmapping
	axios.post= > params가 없음=>@postmapping
 --%>
<div class="container">
	<div class="row">
		<ul>
		<!-- v-for= "받는변수 in 배열"
		v-for="(실제데이터,인덱스번호) in 배열" -->
			<li v-for="(name,index) in names">
			{{index+1}}.{{name}}
			</li>
		</ul>
	</div>
</div>
</body>
<script>
let app=Vue.createApp({
	data(){
		return{
			names:['홍길동','이순신','심청이','박문수','강감찬']
		}
	}
}).mount(".container")
</script>
</html>