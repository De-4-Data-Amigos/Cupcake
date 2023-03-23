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
        <div>
            <form method="post">
                <select class="form-select" aria-label="Default select example" name="bottom">
                    <option selected>Vælg en bund</option>
                    <c:forEach var="bottom" items="${sessionScope.cupcakebottoms}">
                        <option value="${bottom.cupcakeBottomId}">${bottom.flavor} - ${bottom.price},-</option>
                    </c:forEach>
                </select>
                <select class="form-select" aria-label="Default select example" name="top">
                    <option selected>Vælg en top</option>
                    <c:forEach var="top" items="${sessionScope.cupcaketops}">
                        <option value="${top.cupcakeTopId}">${top.flavor} - ${top.price},-</option>
                    </c:forEach>
                </select>
                <button formaction="AddCupcakeOrder" type="submit"
                        class="ms-2 btn btn-outline-success btm-sm col-2">Læg i kurven
                </button>
            </form>

        </div>



        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>

    </jsp:body>

</t:pagetemplate>