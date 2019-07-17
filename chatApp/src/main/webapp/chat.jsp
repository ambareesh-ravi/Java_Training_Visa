<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="10">
<title>V Chat</title>
</head>
<body>
<c:forEach items="${messages}" var="m"> 
${m} <br/>
<!--  	${messages} will search for its value in the order :
1.		request.getAttribute ${requestScope.messages}
2.		session.getAttribute ${sessionScope.messages}
3.		context.getAttribute ${applicationScope.messages}
 -->
</c:forEach>
<br/><br/><hr/>
	<form method="post" action="ChatServlet">
		<input type="text" name="msg" required /> <br>
		<br>
		<br>
		<button type="submit">Send Messages</button>
	</form>
</body>
</html>