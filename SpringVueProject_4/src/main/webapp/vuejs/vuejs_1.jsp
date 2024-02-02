<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--vue: Evan you(구글 = > angularjs= > 복잡하다) 
    	IBM = > OS2,MS도스창
    	| 단순한 프레임워크 ( VUEJS=>1.단수놔다 ,가벼운 프레임워크
    							 2.데이터를 효율적으로처리
    							 3.속도가 빠르다
    							 4.코드의 재사용이 가능 
    							 5.컴포넌트 기반
    							 =>전자상 거래 ,대시보드 , 블로그 ,뉴스사이트 
    	
    	사용:MVVM
    		M (model) : 데이터 저장 =>data()
    		V (view) : 화면출력
    		{{}},v-for,v-model,v-if,v-show,v-if v-else
    		VM(viewModel):상태(데이터) 관리 , 연산처리 						 
    					생명주기
    					1.mounted : onLoad
    					2.updated : 수정
    					3.사용자 정의:
    						methods:{
    							=>이벤트처리
    						}			
    					4.components:{
    						기능 => 이미지 카드,애니메이션=>재사용
    					}
  
  						5.filter : 10,000
  							=>computed:계산된 경우
  ---------------------------------------------------------------------------
  1.vue객체생성 => 여러개 생성 가능 
    ----
    |범위 지정 == >mount('태그명,클래스명,아이디명')
    let app=Vue.createApp({
    		--------------
    		model = > 데이터관리
    		data(){
    			return{
    				fno:0, //NUMBER
    				fd:'', //String
    				list:[], //array
    				obj:{} //객체
    				isShow:true, //boolean
    			}
    		}==> 선언/초기화 :서버(Spring / NodeJS) 읽기가 불가능 
    		--------------
    		viewModel=>데이터처리
    		1)변수의 초기화 
    			=>서버나 파일
    			=>이미 만들어진 메소드 (mounted 등등..)
    			mounted(){
    				서버나 파일읽기 = > data에 저장된 변수의 초기화 
    				==
    				axios.get("서버URL",{
    								서버로 요청하는 데이터 요청
    								params:{
    									fno:1,
    									id:'admin'
    								}
    				}).then(res(결과값을받는다)=>{
    						맴버변수에 대입 
    				})
    				axios.post.("서버URL",{
    								서버로 요청하는 데이터 요청
    								
    									fno:1,
    									id:'admin'
    								
    				}).then(res(결과값을받는다)=>{
    						맴버변수에 대입 
    				})
    			} 
    		--------------
			사용자 정의 메소드 
			이벤트 (버튼 클릭, 마우스오버 ,key...)
			methods:{
				btnClick(){
				},
				mouserClick(){
				}
			}
			재사용을 목적 
			components:{
				template:'<div></div>'
			}
    })			
    ==================================================
    화면 출력 
    
    출력 형식 
    <div>{{data()에 설정된 변수명}}</div> = > text()
    <div :data-no="fd"> = > :속성명 = "변수명" 	
    디렉티브
    	=>v-for ="vo in 배열"   = > v-for="(vo,index) in 배열 "
    	=>v-if ="true/false"
    	=>v-show ="true/false"=>display:none;
    	=>v-if~v-else
    	=>v-if ~v-elseif ~ v-else
    	=>입력값 = > 맴버변수에 전송 = > v-model="맴버변수 설정"
    	=>이벤트 
    	v-on:click : @click 
    	v-on:change :@change
    	v-on:keyup :@keyup.enter,space ....
    	v-on:keydown: @keydown
    	
    	
    	=>프로그램 
    		=>반복수행을 할떄 : 메소드를 제작(사용자 정의) 
    		
    		=>시작과 동시에 데이터 읽기
    		========================mounted()
    		=>이전  this.curpage-1
    		=>다음 this.curpage+1
    		=>블록별 번호 	this.curpage=값대입 
    		
    	class A{
    		state={
    		data()
    		}
    		componentDidMount(){mounted()}
    		btnclick(){
    		
    		}
    		
    		
    	}
    	
    	
    	=>react : 단독처리 
    	
    	=>jsp/spring =>PR 			   
    
    			
    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://unpkg.com/vue@3"></script>


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
<!-- 뷰 -->
<div class="container">
	<div class="row">
		<h3 class="text-center">{{message}}</h3>
		<input type="text" size=20 v-model="message">
		<div style="heigth:40px;"></div>
		<input type="button" value="클릭" @click="change()" >
	</div>
</div>
<script>
let app=Vue.createApp({
	data(){
		return{
			message:'Hello VUe',
			check : false
		}	
		
	},
	methods:{
		change(){
			if(this.check==false){
				this.message='변경된 메시지'
				this.check=true;
			}
			else if(this.check==true){
				this.message='Hello vue'
				this.check=false
			}
		}
	}
	
}).mount('.container') //데이터 처리 /초기화 = > mvvm
</script>
</body>
</html>