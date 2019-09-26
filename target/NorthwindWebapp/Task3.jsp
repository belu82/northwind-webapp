<%--
  Created by IntelliJ IDEA.
  User: beluscsak
  Date: 2019. 08. 26.
  Time: 8:16
  To change this template use File | Settings | File Templates.
  st Suppliers and the number of products they supply (similarly to Task 2),
   but only those who supply 5 different products. Display the CompanyName of the Suppliers.
   Order the results alphabetically.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Task3</title>
</head>
<body>
<div class="task3">
    <form method="post" action="Task3">
        <input type="text" name="text" ><br>
        <button type="submit">Search</button>
    </form>
    <table>
        <tr>
            <th>Company</th>
        </tr>
        <c:forEach items="${task3}" var="task" varStatus="status">
            <tr>
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
