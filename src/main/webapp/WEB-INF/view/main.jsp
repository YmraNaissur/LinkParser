<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <body>
        <form method="post" action="${parseAction}">
            <label for="link">Link:</label>
            <input type="text" id="link" name="link" />
            <input type="submit" value="Parse" />
        </form>

        <c:forEach items="${links}" var="link">
            <p>${link}</p>
        </c:forEach>
    </body>
</html>