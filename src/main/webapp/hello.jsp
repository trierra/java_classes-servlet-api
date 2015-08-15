<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>JSP Hello World</title>
    </head>
    <body>
        <h1>Hello</h1>
        <p>Welcome, user from <c:out value="${pageContext.request.remoteAddr}" />
        <p>It is now <fmt:formatDate value="${date}" pattern="MM/dd/yyyy HH:mm" />
        <span>"${messages.name}"</span>
        <span>"${messages.age}"</span>
        <span>"${messages.success}"</span>
    </body>
</html>