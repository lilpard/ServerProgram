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
		fnDelete();
		fnModify();
	});
	
	function fnDelete(){
		$('#delete_btn').on('click', function(event){
			if(confirm('탈퇴하시겠습니까?') == false){
				event.prevenDefault();
				return false;
			}
			location.href='/ServerProgram/delete.do?no=${member.no}';
			return true;
		});
	function fnModify(){
		$('#f').on('submit', function(event){
			
			if($('#name').val() == ''){
				alert('이름 필수');
				$('#name').focus();
				event.preventDefault();
				return false;
			} else if($('#point').val() == ''){
				alert('포인트 필수');
				$('#point').focus();
				event.preventDefault();
				return false;
			} else if( $('#name').val() == '${member.name}' && $('#point').val() == '${member.point}'){
				alert('변화가 없음');
				event.preventDefault();
				return false;
			}			
			return true;
		});
		
		}
	};
</script>
</head>
<body>
	<h1>회원 관리 시스템</h1>
	<a href="/ServerProgram/logout.do">로그아웃</a>
	
	<form id="f" action="/ServerProgram/updateMember.do" method="post">
		<table border="1">
			<thead>
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>등급</td>
					<td>포인트</td>
				</tr>
			</thead>
			<form>
				<tbody>
					<tr>
						<td>${member.id}</td>
						<td><input type="text" name="name" value="${member.name }"></td>
						<td>${member.grade }</td>
						<td><input type="text" name="point" value="${member.point }"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<button>수정하기</button> 
							<input type="button" value="탈퇴하기" id="delete_btn">						
						</td>
					</tr>
				</tfoot>
			</form>
		</table>
	</form>
</body>
</html>