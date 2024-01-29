<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<%--
      Vue : 1. 가상 돔을 사용 => 속도를 빠르게 처리
             mount => 가상 메모리에 저장
             => String / StringBuffer
            2.생명주기 
            3.디렉티브 
            4.서버연동 
            5.출력형식 
            6.양방향통신
            7.router
 --%>
<body>
<div class="container">
<div class="row">
<h3 class="text-center">{{msg}}</h3>
</div>
</div>
<script>
// Vue JS 셋팅
// Vue 객체 생성
let app=Vue.createApp({
   data(){
      // 멤버 변수 설정
      return{
         msg:'Hello Vue3'      
      }
   }
}).mount('.container')//가상돔에 올림 - > 제어영역선택
</script>
</body>
</html>