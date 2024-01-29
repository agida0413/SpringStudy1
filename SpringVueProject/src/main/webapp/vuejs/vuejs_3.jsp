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
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-center">사번</th>
					<th class="text-center">이름</th>
					<th class="text-center">성별</th>
					<th class="text-center">부서</th>
					<th class="text-center">근무지</th>
				</tr>
			<%-- v-for 와 v-if는 동시사용이 불가 --%>				
				<tr v-for="vo in sawon">

					<td class="text-center" v-if="vo.loc=='서울'">{{vo.sabun}}</td>
					<td class="text-center" v-if="vo.loc=='서울'">{{vo.name}}</td>
					<td class="text-center" v-if="vo.loc=='서울'">{{vo.sex}}</td>
					<td class="text-center" v-if="vo.loc=='서울'">{{vo.dept}}</td>
					<td class="text-center" v-if="vo.loc=='서울'">{{vo.loc}}</td>
				</tr>
			</table>
		</div>
	</div>
	
	<script>
		let app=Vue.createApp({
			data(){
				return {
					sawon:[
						{"sabun":1,"name":'홍길동',"sex":'남자',"dept":'개발부',"loc":'서울'},
						{"sabun":2,"name":'심청이',"sex":'여자',"dept":'기획부',"loc":'부산'},
						{"sabun":3,"name":'박문수',"sex":'남자',"dept":'영업부',"loc":'서울'},
						{"sabun":4,"name":'이순신',"sex":'남자',"dept":'총무부',"loc":'서울'},
						{"sabun":5,"name":'박문철',"sex":'남자',"dept":'총무부',"loc":'강원'},
					
					]
				}
			}
		}).mount('.container')
	</script>
</body>
</html>