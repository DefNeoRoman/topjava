<%--
  Created by IntelliJ IDEA.
  User: роман
  Date: 15.07.2017
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
   
    <div class="row">
        <div class="col-md-3"><div class="resumeHref">id</div></div>
        <div class="col-md-3"><div class="resumeHref">Название</div></div>
        <div class="col-md-3"><div class="resumeHref">Время</div></div>
        <div class="col-md-3"><div class="resumeHref">Калории</div></div>
    </div>
    <form action="meals" method="post" enctype="application/x-www-form-urlencoded">
    <jsp:useBean id="meal" scope="request" type="ru.javawebinar.topjava.model.Meal"/>
         <div class="row">
            <div class="col-md-1">
                <input type="hidden" name="uuid" size="75" value="${meal.uuid}">
              ${meal.uuid}
            </div>
            <div class="col-md-2">

                <input type="text" name="description" size="75" value="${meal.description}">
            </div>
            <div class="col-md-3">
                <input type="text" name="datetime" size="75" value="${meal.dateTime}" placeholder="MM/yyyy>
            </div>
            <div class="col-md-3">

                <input type="text" name="calories" size="75" value="${meal.calories}">

            </div>
            <div class="col-md-1">
                <a href="meals?id=${meal.uuid}&action=add">Save</a>
            </div>
           
        </div>
    </form>
</div>
</body>
</html>
