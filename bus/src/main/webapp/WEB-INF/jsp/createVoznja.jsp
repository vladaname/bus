<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
Poruka:${poruka}


<%--@elvariable id="voznjaDTO" type=""--%>
<form:form method="post" action="/createVoznja"
           modelAttribute="voznjaDTO">
    <table>
        <tr>
            <form:select path="idAutobus" id="idAutobus" name="idAutobus">
                <c:forEach var="a" items="${listaAutobusa}">
                    <form:option value="${a.idAutobus}">${a.naziv}</form:option>
                </c:forEach>

            </form:select>
        </tr>
        <br>
        <tr>
            <form:select path="idRedVoznje" id="idRedVoznje" name="idRedVoznje">
                <c:forEach var="rv" items="${listaRedVoznje}">
                    <form:option value="${rv.idRedVoznje}">${rv.cilj} ${rv.ukupnaCena}</form:option>
                </c:forEach>
            </form:select>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
        </tr>
    </table>

</form:form>

</body>
</html>