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
width: 900px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container" id="app1">
	<div class="row">
		<input type="button" class="btn-xs btn-danger" value="한식" @click="click(1)" >
		<input type="button" class="btn-xs btn-info" value="중식" @click="click(2)">
		<input type="button" class="btn-xs btn-success" value="일식" @click="click(3)">
		<input type="button" class="btn-xs btn-warning" value="양식" @click="click(4)">
		 
	</div>
	<div style="height:20px"></div>
	<div class="row">
		<div v-if="type===1">
		한식을 선택
		</div>
		
		<div v-else-if="type===2">
		중식을 선택
		</div>
		
		<div v-else-if="type===3">
		일식을 선택
		</div>
		<div v-else-if="type===4">
			양식을 선택
		</div>
		
		<div v-else>
		선택하세요
		</div>
	
	</div>
</div>
<div class="contianer" id="app2">
	<div class="row">
	<input type="button" value="로그인" class="btn-sm btn-success" @click="login2(true)">
		<input type="button" value="로그아웃" class="btn-sm btn-success" @click="login2(false)">
		<div v-if="login===true">
			로그인되었습니다.
		</div>
		
		<div v-else>
			로그아웃되었습니다.
		</div>
	</div>
</div>
</body>
<script>
let app=Vue.createApp({
	data(){
		return{
			type:0
		}
	},
	methods:{
		click(type){
			this.type=type;
		}
	}
}).mount('#app1')

let app2=Vue.createApp({
	data(){
		return{
			login:false
		
	}
		},
	methods:{
		login2(bcheck){
			this.login=bcheck;
		}
	}
}).mount('#app2')
</script>
</html>