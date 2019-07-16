<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game</title>
</head>
<body>
<p align="center">
1. Who invented Java ?
</p><br>
Life left : ${lifeLeft}
<br><br>
<p align="center">
Answer: ${answer }
</p>
<form action="validate" method="post">
<input type="text" name="ans"/><br>
<button type="submit">Submit</button>
</form>
</body>
</html>