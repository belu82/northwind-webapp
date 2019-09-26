<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: beluscsak
  Date: 2019. 08. 15.
  Time: 14:48
  To change this template use File | Settings | File Templates.
  Lists Products and their Suppliers. Display the ProductName and the CompanyName of the Supplier.
  Name result columns as Product and Company respectively. Order the results alphabetically by ProductName and by CompanyName.


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task1</title>
</head>
<body>
<div class="task1">
    <form method="post" action="Task1">
        <input type="text" name="text" ><br>
        <select name="dropdown">
            <option value="">All</option>
            <option value="product">Product</option>
            <option value="company">Company</option>
        </select>
        <button type="submit">Search</button>
    </form>
    <table>
        <tr>
            <th>Product</th>
            <th>Company</th>
        </tr>
        <c:forEach items="${task1}" var="task" varStatus="status">
            <tr>
                <td><c:out value="${task.product}"></c:out></td>
                <td><c:out value="${task.company}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
<form method="get" action = "index.jsp">
    <input type="submit" value="Back">
</form>
</body>
</html>
