<%--
  Created by IntelliJ IDEA.
  User: роман
  Date: 15.07.2017
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="webjars/bootstrap/4.0.0-alpha.6-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-11">
            <a class="resumeHref" href="meals?action=create">
                Create meal
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3"><div class="resumeHref">id</div></div>
        <div class="col-md-3"><div class="resumeHref">Название</div></div>
        <div class="col-md-3"><div class="resumeHref">Время</div></div>
        <div class="col-md-3"><div class="resumeHref">Калории</div></div>
    </div>
    <jsp:useBean id="meals" scope="request" type="java.util.List"/>
    <c:forEach items="${meals}" var="meal" >
        <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealWithExceed"/>
        <div class="row">
            <div class="col-md-1">
                ${meal.uuid}
            </div>
            <div class="col-md-2">

                ${meal.description}
            </div>
            <div class="col-md-3">
                 ${meal.dateTime}
            </div>
            <div class="col-md-3">
                <c:if test = "${meal.exceed == true}">
                    <p class="red">${meal.calories}</p>
                </c:if>
                <c:if test = "${meal.exceed == false}">
                    <p class="green">${meal.calories}</p>
                </c:if>

            </div>
            <div class="col-md-1">
                <a href="meals?id=${meal.uuid}&action=update">Edit</a>
            </div>
            <div class="col-md-2">
                <a href="meals?id=${meal.uuid}&action=delete">Delete</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
