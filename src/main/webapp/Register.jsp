<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="regform" method="post">
		Name: <input type="text" name="name1" />  <br/><br/>
		Email: <input type="text" name="email1" />  <br/><br/>
		Password: <input type="password" name="pass1" />  <br/><br/>
		Gender: <input type="radio" name="gender1" value="Male"/> Male<input type="radio" name="gender1" value="Female"/>Female <br/><br/>
		City: <select name="city1">
		<option> Select City </option>
		<option> Nanded </option>
		<option> Pune </option>
		<option> Aurangabad </option>  
		<option> Nagpur </option>
		<option> Latur </option>
		<option> Solapur </option>
		</select> <br/><br/>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>