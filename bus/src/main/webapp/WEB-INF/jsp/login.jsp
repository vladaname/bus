<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
Poruka:${poruka}
<p></p>
<%--@elvariable id="osobaDto" type=""--%>
<form:form method="post" action="/login"
           modelAttribute="osobaDto">
    <h3>Logovanje:</h3>
    <input type="text" name="username" placeholder="username">
    <p></p>
    <input type="text" name="pass" placeholder="pass">
    <p></p>


    <input type="submit" value="Log In">
</form:form>

</body>
</html>