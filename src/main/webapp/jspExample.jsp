<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>JSP Hello World</title>
    </head>
    <body>
       <form action="/myapp/myJsp" method="POST">
       First Name: <input type="text" name="name">
       <br />
       Age: <input type="text" name="age" />
       <input type="submit" value="Submit" />
       </form>
    </body>
</html>