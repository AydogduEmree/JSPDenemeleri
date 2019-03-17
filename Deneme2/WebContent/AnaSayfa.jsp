<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ANA SAYFA</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	
	<%
		HttpSession ses = request.getSession();
		if(ses != null){
			if(ses.getAttribute("login") != null){
				if((boolean) ses.getAttribute("login")){
					out.println(kayitli());
				}else{
					out.println(kayitsiz());
				}
			}else{
				out.println(kayitsiz());
			}
		}else{
			out.println(kayitsiz());
		}
	%>
	
	<%!
		private String kayitli(){
			return "<a href=\"/Deneme2/Logout\">ÇIKIŞ YAP</a>";
		}	
		private String kayitsiz(){
			return "<a href=\"/Deneme2/Login\">GİRİŞ YAP</a>";
		}
	%>
	
	
</body>
</html>