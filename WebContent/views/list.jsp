<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			fnSelectMemberList();
		});
		
		function fnSelectMemberList(){
			$.ajax({
				url: '/ServerProgram/selectList.do',
				type: 'get',
				success: function(resData){
					$('#member_list').empty();
					if(resData.length == 0){
						$('<tr>')
						.append($('<td colspan="5">').text('등록된 멤버가 없습니다.'))
						.appendTo('#member_list');
					}else{
						for(let i = 0; i < resData.length; i++){
							$('<tr>')
							.append($('<td>').text(resData[i].no))
							.append($('<td>').text(resData[i].id))
							.append($('<td>').text(resData[i].name))
							.append($('<td>').text(resData[i].grade))
							.append($('<td>').text(resData[i]).point)
							.appendTo('#member_list');
						}
					}
				},
				error: function(){
					alert('멤버 목록 가져오기 실패')
				}
				
			})
		}
		
	</script>
</head>
<body>
	<a href='/ServerProgram/loginForm.do'>로그인 하러가기</a>
	
	<table>
		<thead>
			<tr>
				<td>회원번호</td>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>포인트</td>
			</tr>
		</thead>
		<tbody id="member_list"></tbody>
	</table>
</body>
</html>