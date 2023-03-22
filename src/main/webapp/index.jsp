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
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuBut" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Bottoms
        </button>

        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

        <c:forEach var="bottom" items="${sessionScope.AllBottoms}">
                    <a class="dropdown-item" href="#"> ${bottom.name}</a>
        </c:forEach>
                <a class="dropdown-item" href="#"> test</a>
            </div>
        </div>
<br>
<br>
<br>
        <div class="row mt-3">
        <div class="col">
        <form action="info" method="get">
            <select name="bottom">
                <option value="bottom">Vælg bund</option>
                <c:forEach var="bottom" items="${sessionScope.AllBottoms}">
                    <option value="${bottom.flavor}>${bottom.price}"></option>
                </c:forEach>
            </select>
            <br>
            <br>
            <input type="submit" value="Vælg">
        </form>

        <br>
        <br>
        </div>

        <div class="col">
        <form action="info" method="get">
            <select name="top">
                <option value="top">Vælg Top</option>
                <c:forEach var="top" items="${sessionScope.getAllTops}">
                    <option value=">${top.flavor}>${top.price}"></option>
                </c:forEach>
            </select>
            <br>
            <br>
            <input type="submit" value="Vælg">
        </form>
        </div>
        </div>


        <c:if test="${sessionScope.user != null}">
            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
        </c:if>
        

    </jsp:body>

</t:pagetemplate>