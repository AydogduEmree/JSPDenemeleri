<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#button').on('click', function(){
					$.ajax({
						url: "/Deneme2/Login",
						type: "POST",
						data: {
							username: $('#username').val(),
							password: $('#password').val()
						},
						success: function(response){
							console.log(response);
							if(response == "GIRILDI"){
								window.location.replace("/Deneme2/AnaSayfa")
							}else if(response == "GIRILMEDI"){
								alert("GIRILMEDI");
							}else{
								alert("BASKA HATA VAR");
							}
						},
					});
				});
			});
		</script>
		<meta charset="UTF-8">
		<title>Giriş Yap</title>
	</head>
	<body>
		
		<input id="username" placeholder="kullanıcı adı" type="text">
		<input id="password" placeholder="şifre" type="password">
		<input id="button" value="giriş yap" type="submit">
	</body>
</html>