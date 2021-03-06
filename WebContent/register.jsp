<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
    body{
	background-color:#2c3335;
	color:#f5f5f5;
	text-align:center;
	font-family:"Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", "DejaVu Sans", Verdana, sans-serif;
}

a{
	color:#fff;
	text-decoration:none;
}
	
#loginform{
	margin-top:150px;
  margin-left:auto;
  margin-right:auto;
	width:270px;
}
	
.input{
	width:270px;
    padding:15px 25px;
    font-family:"Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", "DejaVu Sans", Verdana, sans-serif;
	background: #f5f5f5;
	border:none;
	border-radius: 5px;
	color: #333;
	font-size: 14px;
	margin-top:15px;
}

.loginbutton{
	background-color:#ffdd00;
	border-radius:5px/5px;
	-webkit-border-radius:5px/5px;
	-moz-border-radius:5px/5px;
	color:#333;
	display:inline-block;
	font-family:"Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", "DejaVu Sans", Verdana, sans-serif;
	font-size:18px;
	font-weight:bold;
	width:270px;
	text-align:center;
	line-height:50px;
	text-decoration:none;
	height:50px;
	margin-top:20px;
	margin-bottom:20px;
	border:none;
	outline:0;
	cursor: pointer;
}

.loginbutton:active {
	position:relative;
	top:1px;
}

.loginbutton:hover{
	background-color:#e5bf05;
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form id="loginform" method="get" action="register">
	<input type="text" class="input" placeholder="Username" name="username" /> 
	<input type="password" class="input" placeholder="Password" name = "password"/>
	<input type="text" class="input" placeholder="Firstname" name = "firstname"/>
	<input type="text" class="input" placeholder="Lastname" name = "lastname"/>	
	<input type="submit" class="loginbutton" value="Register" />
</form>
</body>
</html>