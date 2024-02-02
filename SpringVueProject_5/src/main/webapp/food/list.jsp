<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

<style type="text/css">
.container-fluid{
margin-top: 50px;
}
.row{
margin: 0px auto;
width: 960px;
}
.images:hover{
cursor:pointer;
}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		 <div class="col-md-3" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="'https://www.menupan.com/'+vo.poster" style="width:100%">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
	</div>
	
	<div class="row text-center">
		 <ul class="pagination">
		 	  <li  @click="firstpage()"><a href="#">&lt;&lt;</a></li>
			  <li v-if="startPage>1" @click="previousBlock(startPage)"><a href="#">&lt;</a></li>
			  <li v-for="i in range(startPage,endPage)" :class="i===curpage?'active':''" @click="changePage(i)"><a href="#">{{i}}</a></li>
			  <li v-if="endPage<totalPage" @click="nextBlock(endPage)"><a href="#" >&gt;</a></li>
			  	  <li  @click="lastpage()"><a href="#">&gt;&gt;</a></li>
			 
		</ul> 
	</div>
</div>
<script>
let app=Vue.createApp({
	data(){
		return{
			food_list:[],
			curpage:1,
			totalPage:0,
			startPage:0,
			endPage:0,
			
		}
	},
	mounted(){
		this.paging()
	},
	methods:{
		paging(){
			axios.get("../food/list_vue.do",{params:{page:this.curpage}})
			.then(response=>{
				this.food_list=response.data
				this.curpage=response.data[0].curpage
				this.totalPage=response.data[0].totalPage
				this.startPage=response.data[0].startPage
				this.endPage=response.data[0].endPage
				
				
			})
			
		},
		//숫자는 배열로저장 
		range(start,end){
			let arr=[];
			let len=end-start
			for(let i=0;i<=len;i++){
				arr[i]=start;
				start++;
			}
			return arr;
		},
		changePage(page){
			this.curpage=page;
			this.paging()
		},
		nextBlock(endpage){
			this.curpage=endpage+1;
			this.paging()
		},
		previousBlock(startpage){
			this.curpage=startpage-1;
			this.paging()
		},
		firstpage(){
			this.curpage=1;
			this.paging()
		},
		lastpage(){
		
			this.curpage=this.totalPage;
			this.paging()
		}
		
	}
	
}).mount('.container')
</script>
</body>
</html>