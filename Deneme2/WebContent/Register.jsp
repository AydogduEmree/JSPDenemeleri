<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KAYIT SAYFASI</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#register').on('click', function(){
			$.ajax({
				url:"/Deneme2/Register",
				type:"POST",
				data:{
					username : $('#username').val(),
					password : $('#password').val(),
					name : $('#name').val(),
					surname : $('#surname').val()
				},
				success: function(response){
					if(response == "basarili"){
						window.location.replace("/Deneme2/Login");
					}else if(response == "kayitliVar"){
						alert("Böyle bir kullanici bulunmaktadir.");
					}
				}
			});
		});
	});
</script>
</head>

<body>
	<input id="username" name="username" placeholder="Kullanıcı Adı">
	<input id="password" name="password" placeholder="Kullanıcı Şifresi">
	<input id="name" name="name" placeholder="Adı">
	<input id="surname" name="surname" placeholder="Soyadı">
	<input id="register" type="submit"	value="KAYIT OL">
</body>
</html>