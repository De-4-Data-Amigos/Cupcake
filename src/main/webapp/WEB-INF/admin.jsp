<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<t:pagetemplate>
    <jsp:attribute name="header">
         Din bestilling
    </jsp:attribute>

    <jsp:attribute name="footer">
        Bestillingsliste:
    </jsp:attribute>

    <jsp:body>

        <form method="post">
            <select class="form-select" style="color: #6f42c1" aria-label="Default select example" name="user">
                <option selected>Vælg en bruger</option>
                <c:forEach var="user" items="${requestScope.userList}">
                    <option value="${user.username}">${user.username} ${user.saldo},-</option>
                </c:forEach>
            </select>

            <br>
            <label for="money" class="form-label">Hvor meget skal det indsættes?</label>
            <input type="text" class="form-control" id="money" name="money" required> <br/>

            <button formaction="admin" type="submit" class="btn btn-primary">Submit</button>

        </form>
    </jsp:body>

</t:pagetemplate>
