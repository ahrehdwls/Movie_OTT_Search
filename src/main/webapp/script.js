/**
 * 
 */
function col_conrfirm() {
	var concheck = confirm("내 컬렉션에 추가하시겠습니까?");
	//colfun=false;
	if(concheck ==false){
		alert("취소 되었습니다.")
		return false;
	}
} 
function cart_conrfirm() {
	var cartcheck = confirm("찜 목록에 추가하시겠습니까?");
	//cartfun=false;
	if(cartcheck ==false){
		alert("취소 되었습니다.")
		return false;
	}
		
	}
	
	function deletecheck(){
		
		var delcheck = confirm("목록에서 삭제하시겠습니까?");
		if(cartcheck ==false){
		return false;
	}
	
	}
	
	function writeSave(){ 
	//alert(1);  
	if($('input[name="writer"]').val() ==""){
		alert("이름을 입력하세요");
		$('input[name="writer"]').focus();
		return false;
	}
	
	if($('input[name="subject"]').val()==""){
		alert("제목을 입력하세요");
		$('input[name="subject"]').focus();
		return false;
	}
	if($('input[name="email"]').val()==""){
		alert("메일 입력 좀");
		$('input[name="email"]').focus();
		return false;
	}

	if($('textarea[name="content"]').val() == ""){
		alert('내용은 필수입니다');
		$('textarea[name="content"]').focus();
		return false;		
	}

	if($('input[name="passwd"]').val()==""){
		alert("비번 입력 좀");
		$('input[name="passwd"]').focus();
		return false;
	}
}   



var use;
var isCheck = false;
var isChange = false;

$(function(){
	//alert('ready');
	$('input[name="id"]').keydown(function(){
		//alert(1);
		$('#idmessage').css('display','none');
		isChange = true;
		use = "";
		isCheck = false;
	});
});

function writeSave(){ // 가입하기
	//alert('writeSave');
	if($('input[name="id"]').val()==''){
		alert('id를 입력하세요');
		return false;
	}
	if(use == "impossible"){
		alert("이미 사용중인 아이디입니다.");
		return false;
	}
	if(isCheck == false || isChange == true){
		alert("중복체크하세요");
		return false;
	}
	if(pwsame == "nosame"){
		alert("비번 불일치");
		return false;
	}
}//writeSave

function duplicate(){
	//alert(1);
	isCheck = true;
	isChange = false;
	
	$.ajax({
		url : "id_check_proc.jsp",
		data: ({
			userid: $('input[name="id"]').val() // userid=kim
		}),
		success:function(data){ 
			if($('input[name="id"]').val() == ""){
				$('#idmessage').html("<font color=red>id 입력 누락</font>");
				$('#idmessage').show();
			}
			else if($.trim(data)=='YES'){
				$('#idmessage').html("<font color=red>사용 가능합니다.</font>");
				$('#idmessage').show();
				use = "possible";
			}
			else{ // NO
				$('#idmessage').html("<font color=red>이미 사용중인 아이디입니다.</font>");
				$('#idmessage').show();
				use = "impossible";
			}
		}// success
	});
	
}//duplicate

function pwcheck(){ // onBlur
	//alert('pwcheck');
	//pw = $('input[name="password"]').val();
	pw = document.forms[0].password.value; // 34q@9
	
	// 소문자 + 숫자 조합 3~8
	var regexp = /^[a-z0-9]{3,8}$/; // abc(o) , 876(o), #abc4*
	
	if(pw != ''){
		if(pw.search(regexp) == -1){
			alert('비번 형식이 틀렸습니다.');
			document.forms[0].password.value="";
			document.forms[0].password.focus();
			return false;
		}
		var chk_num = pw.search(/[0-9]/);
		var chk_eng = pw.search(/[a-z]/);
		
		if(chk_num < 0 || chk_eng < 0){
			alert('비번은 영문자 숫자 조합해 주세요');
			document.forms[0].password.value="";
			document.forms[0].password.focus();
			return false;
		}
	}
} // pwcheck

function passwd_confirm(){
	//alert('passwd_confirm()')
	
	if($('input[name="password"]').val()== $('input[name="repassword"]').val()){
		$('#pwmessage').html("<font color=red>비번 일치</font>");
		$('#pwmessage').show();
		pwsame="same";
	}
	else{
		$('#pwmessage').html("<font color=red>비번 불일치</font>");
		$('#pwmessage').show();
		pwsame="nosame";
	}
}// passwd_confirm


