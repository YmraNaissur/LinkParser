<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="links" type="java.util.List" scope="request"/>

<html>
    <body>
        <form>
            <label for="link">Link:</label>
            <input type="text" id="link">
            <input type="submit" value="Parse">
        </form>

        <c:forEach items="${links}" var="link">
            <p>${link}</p>
        </c:forEach>
    </body>
</html>