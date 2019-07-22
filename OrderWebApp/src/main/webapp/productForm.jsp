<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	.errClass {
		color:red;
	}
</style>
<body>

<form:form method="post" action="addProduct.do" commandName="product">
<!-- path values should be same as data members of the class -->
Name : <form:input path="name"/> <br/> <form:errors path="name" cssClass="errClass"/><br/>
Category : <form:input path="category"/><br/> <form:errors path="category" cssClass="errClass"/><br/>
Price : <form:input path="price"/> <br/> <form:errors path="price" cssClass="errClass"/><br/>
Count : <form:input path="count"/><br/><form:errors path="count" cssClass="errClass"/><br/>
<button type="submit">Add Product</button>
</form:form>
</body>
</html>