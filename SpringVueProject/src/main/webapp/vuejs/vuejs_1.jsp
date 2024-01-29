<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#msg').keyup(function(){
		$('#print').text($('#msg').val());
	})
});
</script> -->
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
             mount => 가상 메모리에 저장 = > 태그선택이없다 
             => String / StringBuffer
            2.생명주기  ->callback
            3.디렉티브 =>제어문
            4.서버연동 =>axios
            5.출력형식 = > {{}} / : src=  
            6.양방향통신  = > v-model
            7.router => 화면 변경 
 		    8. vue-bootstrap
 		    
 		    1.생명주기 => vue3(react랑 비슷) , vuex(mvc)
 		    	beforeCreate() 생성
 		    	created() 생성된상태
 		    	----------------------------Vue객체 생성
 				beforeMount
 				mounted
 			--------------------------------------------가상 메모리에 HTML을 올린경우 
 				= > $(function(){}) ,window.onload
 				=>서버에서 데이터를 읽는다 : 맴버변수에 저장
 				=>jquery연동 시점
 				---------------------------------
 				beforeUpdate()
 				updated() 
 				------------------------ 데이터 갱신 
 						=>component : Main/Sub = > sub에 값을 전송 = > $emit
 			---------------------------------------------------------
 			beforeDestroy()
 			destroyed()
 			-------------------------메모리해제
 --%>
<body>
<div class="container">
<div class="row">
<input type="text" size=30 class="input-sm" v-model="msg">  <!-- data 부분에 전송 -->

</div>
<div class="row">
	<div>{{msg}}</div>
</div>
</div>
<script>
// Vue JS 셋팅
// Vue 객체 생성
let app=Vue.createApp({
  
   //콜백함수 => Vue 에 의해서 자동으로 호출
   beforeCreate(){
	   console.log("Vue 객체 생성전 :beforeCreate() call")
   },
   created(){
	   console.log("Vue 객체 생성완료 :Created() call")  
   },
   beforeMounted(){
	   console.log("HTML과 데이터가 가상메모리에 올라가기전 :beforeMounted() call")  
   },
   mounted(){
	   console.log("가상메모리에 html이 올라간 상태 :mounted() call(window.onload,$(funtion(){}))")  
   },
   beforeUpdate(){
	   console.log("변경하기 전  :beforeUpdate() call")  
   },
   updated(){
	   console.log("변경완료  :updated() call")  
   },
   beforeDestroy(){
	   console.log("vue객체메모리 해제 전  :beforeDestroyed() call")  
   },
   destroyed(){
	   console.log("vue객체메모리 해제 완료   :destroyed() call")    
   },
   //사용자 정의 메소드 
   methods:{
	   
   },
   data(){
	      // 멤버 변수 설정
	      return{
	         msg:''      
	      }
	   }
}).mount('.container')//가상돔에 올림 - > 제어영역선택
</script>
</body>
</html>