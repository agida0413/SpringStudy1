<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
let bClick=true;
$(function(){
	$('#del').click(function(){
		if(bClick==true){
		bClick=false;	
		$('#delTr').show()
		$('#del').text("취소")
		}
		else{
		bClick=true;	
		$('#delTr').hide()
		$('#del').text("수정")
		}
	})
	
	$('#delBtn').click(function(){
		let no = $('#delBtn').attr('data-no')
		let pwd=$('#pwd').val()
		$.ajax({
			type:'post',
			url:'delete_ok.do',
			data:{"no":no,"pwd":pwd},
			success:function(result){
				if(result=='yes'){
					location.href="list.do"	
				}
				else{
					alert('비밀번호가 틀립니다.')
				}
			}
			
		}
		)
	})
	
	
	
});

</script>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 960px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <h3 class="text-center">내용보기</h3>
      <table class="table">
       <tr>
         <th class="text-center success" width=20%>번호</th>
         <td class="text-center" width=30%>${vo.no }</td>
         <th class="text-center success" width=20%>작성일</th>
         <td class="text-center" width=30%>${vo.dbday }</td>
       </tr>
       <tr>
         <th class="text-center success" width=20%>이름</th>
         <td class="text-center" width=30%>${vo.name }</td>
         <th class="text-center success" width=20%>조회수</th>
         <td class="text-center" width=30%>${vo.hit }</td>
       </tr>
       <tr>
         <th class="text-center success" width=20%>제목</th>
         <td colspan="3">${vo.subject }</td>
       </tr>
       <tr>
        <td colspan="4" class="text-left" valign="top"
         height="200"><pre style="white-space: pre-wrap;border:none;background-color: white;">${vo.content }</pre></td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
          <a href="reply.do?pno=${vo.no }" class="btn btn-xs btn-danger">답변</a>
          <a href="update.do?no=${vo.no }" class="btn btn-xs btn-success">수정</a>
          <span><a href="#" class="btn btn-xs btn-info" id="del">삭제</a></span>
          <a href="list.do" class="btn btn-xs btn-warning">목록</a>
         </td>
       </tr>
       <tr style="display:none;" id="delTr">
       <td colspan="4" class="text-right">
       비밀번호:<input type="password" id="pwd" size="10" class="input-sm">
       			<input type="button" id="delBtn" value="삭제" class="btn-sm btn-warning" data-no="${vo.no }">
       			
       </td>
       </tr>
      </table>
    </div>
    <div style="height:20px;"></div>
    <jsp:include page="top.jsp"></jsp:include>
  </div>
</body>
</html>