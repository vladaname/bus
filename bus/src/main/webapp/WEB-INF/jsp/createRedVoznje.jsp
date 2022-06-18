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


<%--@elvariable id="redVoznjeDTO" type=""--%>
<form:form method="post" action="/createRedVoznje"
           modelAttribute="redVoznjeDTO">
    <table>
        <tr>
            <td><form:label path="start">start</form:label></td>
            <td><form:input path="start" /></td>
        </tr>

        <tr>
            <td><form:label path="cilj">cilj</form:label></td>
            <td><form:input path="cilj" /></td>
        </tr>
        <tr>
            <td><form:label path="distanca">distanca</form:label></td>
            <td><form:input path="distanca" /></td>
        </tr>

        <tr>
            <td><form:label path="ukupnaCena">ukupnaCena</form:label></td>
            <td><form:input path="ukupnaCena" /></td>
        </tr>
        <tr>
            <td><form:label path="vremeDolaska" >vremeDolaska</form:label></td>
            <td><form:input path="vremeDolaska" type="datetime-local"/></td>
        </tr>
        <tr>
            <td><form:label path="vremePolaska">vremePolaska</form:label></td>
            <td><form:input path="vremePolaska" type="datetime-local" /></td>
        </tr>
        <tr>

            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>

</form:form>

</body>
</html>