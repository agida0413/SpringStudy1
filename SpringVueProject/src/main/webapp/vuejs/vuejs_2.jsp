<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/vue@3"></script>
<style type="text/css">
.container{
margin-top: 50px;
}
.row{
margin: 0px auto;
width: 800px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" id="app1">
	<div class="row">
		<h3 class="text-center">{{msg}}</h3>
	</div>
</div>

<div class="container" id="app2">
	<div class="row">
		<h3 class="text-center">{{msg}}</h3>
	</div>
</div>

<script>
let app1=Vue.createApp({
data(){
	return {
		msg:'Hello Vue(app1)'			
	}
}
}).mount('#app1')	//태그와 태그 사이 범위까지 제어

let app2=Vue.createApp({
data(){
	return{
		msg:'Hello Vue(app2)'
	}
}	
}).mount('#app2')	
</script>
</body>
</html>