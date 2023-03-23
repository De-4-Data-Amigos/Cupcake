<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<t:pagetemplate>
    <jsp:attribute name="header">
         Det her er hvad du har bestilt:
    </jsp:attribute>

    <jsp:attribute name="footer">
        Bestillingsliste:
    </jsp:attribute>

    <jsp:body>

        <p>Checkout:</p>
        <div class="container py-4">

            <div class="row align-items-md-stretch">
                <div class="col-md-8">
                    <div class="h-100 p-5 bg-light border rounded-3">
                        <h2>Change the background</h2>
                        <p>${sessionScope.user.username}</p>
                        <button class="btn btn-outline-light" type="button">Example button</button>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="h-48 p-5 bg-light border rounded-3">
                        <c:if test="${sessionScope.user != null}">
                            <h2>Hej ${sessionScope.user.username}!</h2>
                        </c:if><br/>

                        <c:if test="${sessionScope.user == null}">
                            <h2> Har du en bruger? </h2>
                        </c:if><br/>


                        <p>
                            <c:if test="${sessionScope.user == null}">
                        <p> Login her: <a href="login.jsp">Login</a></p>
                        <p> Eller registrere dig her: <a href="register.jsp">Register</a></p>
                        </c:if>


                        <c:if test="${sessionScope.user != null}">
                            Her er din saldo:
                        </c:if><br/>


                        <button class="btn btn-outline-secondary mt-4" type="button">Example button</button>
                    </div>


                    <div class="h-48 p-5 bg-light border rounded-3 mt-2">
                        <h2>Add borders</h2>
                        <p>Or, keep it light and add a border for some added definition to the boundaries of your
                            content. Be sure to look under the hood at the source HTML here as we've adjusted the
                            alignment and sizing of both column's content for equal-height.</p>
                        <button class="btn btn-outline-secondary" type="button">Example button</button>
                    </div>


                </div>
            </div>

            <footer class="pt-3 mt-4 text-muted border-top">
            </footer>
        </div>

    </jsp:body>

</t:pagetemplate>