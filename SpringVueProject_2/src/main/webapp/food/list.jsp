<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<style type="text/css">
.container-fluid{
margin-top: 50px;
}
.row{
margin: 0px auto;
width: 100%;
}
.images:hover{
cursor:pointer;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid" id="app">
		<div class="row">
			<div class="col-sm-8" >
								<div class="col-md-4" v-for="vo in food_list">
								    <div class="thumbnail">
								      
								        <img :src="'https://www.menupan.com'+vo.poster" alt="Lights" style="width:100%" class="images"
								        v-on:click="detail(vo.fno)"
								        >
								        <div class="caption">
								          <p>{{vo.name}}</p>
								        </div>
								     
								    </div>
								  </div>
			</div>
			
			<div class="col-sm-4" v-show="isShow">
				<table class="table">
					<tr>
						<td width=30% class="text-center" rowspan="7">
							<img :src="'https://www.menupan.com'+food_detail.poster" style="width:100%">
						</td>
						<td colspan="2" >
						<h3>{{food_detail.name}}&nbsp;<span style="color:orange;">{{food_detail.score}}</span></h3>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<script src="food.js"></script>

	
	
</body>
</html>