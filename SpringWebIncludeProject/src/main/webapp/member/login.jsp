<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 
<meta charset="UTF-8">
<style type="text/css">
.container{
marigin-top:50px;
}
.row{
margin: 0px auto;
width:350px;

}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row">
		<h3 class="text-center">Login</h3>
		<form action="../member/login_ok.do" method="post">
		<table class="table">
			<tr>
				<th width="20%" class="text-right">ID</th>
				<td width="80%">
					<input type="text" name="id" class="input-sm" size=15 required>
				</td>
			</tr>
			
			<tr>
				<th width="20%" class="text-right">Password</th>
				<td width="80%">
					<input type="password" name="pwd" class="input-sm" size=15 required>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" class="text-center">
				<button class="btn-sm btn-primary">로그인</button>
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>
</body>
</html>