<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hiển thị thời gian thực</title>
</head>
<body>
    <h1>Ứng dụng hiển thị thời gian thực</h1>

    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>

    <form action="time" method="post">
        Chọn định dạng thời gian:
        <select name="format">
            <option value="HH:mm:ss">HH:mm:ss</option>
            <option value="dd/MM/yyyy">dd/MM/yyyy</option>
            <option value="yyyy-MM-dd HH:mm:ss">yyyy-MM-dd HH:mm:ss</option>
            <option value="MM/dd/yy hh:mm a">MM/dd/yy hh:mm a</option>
        </select>
        <button type="submit">Hiển thị</button>
    </form>

    <c:if test="${not empty currentTime}">
        <h2>Thời gian hiện tại: <span style="font-weight: bold;">${currentTime}</span></h2>
    </c:if>

    <c:if test="${formatChanged == true}">
        <p style="color: green;">Định dạng thời gian đã được thay đổi.</p>
    </c:if>
</body>
</html>