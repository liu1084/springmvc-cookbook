<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">
<head>
    <title>CloudStreetMarket - The amazing Social Stock Exchange Platform</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="CloudStreetMarket, the amazing Social Stock Exchange Platform">
    <meta name="author" content="Alex Bretet">
    <spring:url value="/static/css/index.css" var="indexCss" />
    <link href="${indexCss}" rel="stylesheet" />
</head>

<body>
<h1>
    ${message},Well done !
    <c:if test="${not empty name}">${name}</c:if>
</h1>
<h3>You've completed the first chapter :)</h3>
</body>
</html>
