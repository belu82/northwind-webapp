<%--
  Created by IntelliJ IDEA.
  User: beluscsak
  Date: 2019. 08. 22.
  Time: 15:20
  To change this template use File | Settings | File Templates.

  List Suppliers and the number of products they supply.
  Display the CompanyName of the Supplier and the number of products the supplier has.
  Name result columns as Company and NumberOfProducts respectively. Order the results so t
  hat the Supplier with the most products is displayed first. Order Suppliers with identical number of products alphabetically.


--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task2</title>
</head>
<body>
<div class="task2">
    <form method="post" action="Task2">
        <input type="text" name="text" ><br>
        <select name="dropdown">
            <option value="">All</option>
            <option value="productName">Poruduct name</option>
            <option value="products">Poruduct</option>

        </select>
        <button type="submit">Search</button>
    </form>
    <table>
        <tr>
            <th>Company</th>
            <th>Product numbers</th>
        </tr>
        <c:forEach items="${task2}" var="task" varStatus="status">
            <tr>
                <td><c:out value="${task.productName}"></c:out></td>
                <td><c:out value="${task.products}"></c:out></td>

            </tr>
        </c:forEach>
    </table>
</div>
<form method="get" action = "index.jsp">
    <input type="submit" value="Back">
</form></body>
</html>
