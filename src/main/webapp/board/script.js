/**
 * script.js
 */

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










