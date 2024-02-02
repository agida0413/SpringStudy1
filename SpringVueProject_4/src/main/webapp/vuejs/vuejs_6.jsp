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
<div class="container">
   <div class="row">
      <div class="text-center">
         <input type="button" class="btn-lg btn-danger" value="일일 박스오피스" @click="change(1)">
         <input type="button" class="btn-lg btn-success" value="실시간 예매율" @click="change(2)">
         <input type="button" class="btn-lg btn-info" value="좌석점유율" @click="change(3)">
         <input type="hidden" value="추출값" ref="asd"> 
      </div>
   </div>
   <div style="height: 20px"></div>
   <div class="row">
      {{$data}}
   </div>
   <%--
   
    --%>
</div>
<script>

let app=Vue.createApp({
   data(){
      return{
         movie_list:[],
         no:1
      }
   },
   mounted(){
      axios.get("http://localhost:8080/web/jsp/movie.jsp",{
         params:{
            no:this.no
         }
      }).
      then(res=>{
    	  let test=app.$refs.asd.value
    	  console.log(test)
         console.log(res.data)
         this.movie_list=res.data
      })
   },
   methods:{
      change(no){
         this.no=no
         axios.get("http://localhost:8080/web/jsp/movie.jsp",{
            params:{
               no:this.no
            }
         }).
         then(res=>{
            console.log(res.data)
            this.movie_list=res.data
            
         })
      }   
   }
}).mount(".container")
</script>
</body>
</html>