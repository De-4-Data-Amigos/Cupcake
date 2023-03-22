<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        Velkommen ombord
    </jsp:attribute>

    <jsp:attribute name="footer">
        Velkommen ombord
    </jsp:attribute>

    <jsp:body>

        <p> Øens bedste cupcakes. Vælg og bestil her: </p>

        <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Bottoms
        </button>

        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

        <c:forEach var="bottom" items="${requestScope.AllBottoms}">
                    <a class="text-start align-middle"> ${bottom.name}</a>
        </c:forEach>

        </div>
        </div>

        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>




   

    </jsp:body>

</t:pagetemplate>