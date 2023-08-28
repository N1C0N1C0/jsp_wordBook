<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th,td{
	padding: 10px 0px;
}

.th__space__ten {
	word-spacing:40px;
}

.th__space__two {
	letter-spacing:1px;
}

.btn__word {
	background-color: transparent;
	color: var(--color-white);
	border: none;
    outline: none;
    cursor: pointer;
    padding: 8px;
    margin-right: 10px;
    font-family:"맑은 고딕";
    font-size: 16px;
}

.btn__word:hover {
	background-color: var(--color-white);
	color: var(--color-black);
	border-radius: var(--size-border-radius);
	padding: 8px;
}

</style>
</head>
<body>
	<div align="center">
		<h2>단어 등록</h2><br/>
		<form action="wordJpWirte.do" method="post" onsubmit="return check(this)">
			<input type="hidden" name="idChecked"/>
			
			<table>
				<tr>
					<th class="th__space__ten"> 단 어</th>
					<td>&nbsp;&nbsp;<input type="text" name="WORD" size="20"/></td>
				</tr>
				<tr>
					<th class="th__space__ten"> 의 미 </th>
					<td>&nbsp;&nbsp;<input type="text" name="MEAN" size="20"/></td>
				</tr>
				<tr>
					<th class="th__space__ten"> 발 음</th>
					<td>&nbsp;&nbsp;<input type="text" name="PRONUNCIATION" size="20"/></td>
				</tr>
				<tr>
					<th class="th__space__two"> 한 글 발 음 </th>
					<td>&nbsp;&nbsp;<input type="text" name="K_PRONUNCIATION" size="20"/></td>
				</tr>
			</table>
			<br/>
			<hr width="250px;"/>
			<input class="btn__word" type="submit" value="단어 등록"/>
			<input class="btn__word" type="reset" value="취 소"/>
			<input class="btn__word" type="button" value="뒤로" name="BACK" onclick="back()">
			<hr width="250px;"/>
		</form>
	</div>
	<script type="text/javascript">
		function check(frm){
			if(frm.WORD.value == ''){
				alert("단어를 입력하세요.");
				frm.WORD.focus();
				return false;
			}
			
			if(frm.MEAN.value == ''){
				alert("의미를 입력하세요.");
				frm.MEAN.focus();
				return false;
			}
			
			if(frm.PRONUNCIATION.value == ''){
				alert("발음을 입력하세요.");
				frm.PRONUNCIATION.focus();
				return false;
			}
			
			if(frm.K_PRONUNCIATION.value == ''){
				alert("한글 발음 입력하세요.");
				frm.K_PRONUNCIATION.focus();
				return false;
			}
			
			if(!confirm("입력한 내용이 맞습니까?")) return false;
		}
		function back(){
			location.href = "japaneseWord.do?page=1";
		}
	</script>
</body>
</html>