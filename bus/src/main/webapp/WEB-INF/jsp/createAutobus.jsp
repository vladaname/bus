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


<%--@elvariable id="autobusDTO" type=""--%>
<form:form method="post" action="/createAutobus"
           modelAttribute="autobusDTO">
    <table>
        <tr>
            <td><form:label path="brojSedista">brojSedista</form:label></td>
            <td><form:input path="brojSedista" /></td>
        </tr>
        <tr>
            <td><form:label path="naziv">naziv</form:label></td>
            <td><form:input path="naziv" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>

</form:form>

</body>
</html>