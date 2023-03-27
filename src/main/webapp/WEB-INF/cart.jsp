<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<t:pagetemplate>
    <jsp:attribute name="header">
         Din bestilling
    </jsp:attribute>

    <jsp:attribute name="footer">
        Her er din bestilling
    </jsp:attribute>

    <jsp:body>

        <div class="container py-4">

            <div class="row align-items-md-stretch">
                <div class="col-md-8">
                    <div class="h-100 p-5 bg-light border rounded-3">

                        <h2>.. og tak fordi du køber lokalt!</h2>
                        <h5>Ordre:</h5>
                            <p>*import samlet ordre*</p>
                        <form method="get" action="orderconfirmation">
                            <button type="submit" class="btn btn-primary">Bekræft bestilling</button>

                        </form>
                        </div>

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
                            Her er din saldo:${sessionScope.user.saldo},-
                        </c:if><br/>


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
