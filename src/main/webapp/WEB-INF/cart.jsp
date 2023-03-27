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

        <div class="container py-4">

            <div class="row align-items-md-stretch">
                <div class="col-md-8">
                    <div class="h-100 p-5 bg-light border rounded-3">

                        <h2>Her er din bestilling - tak fordi du køber lokalt!</h2>
                        <p>*import samlet ordre*</p>



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
                        <h5>Pris:   ${sessionScope.current_order.totalPrice} kr. </h5>
                        <h5>Moms udgør:   ${sessionScope.current_order.totalPrice*0.20} kr. </h5>
                        <div class="spacer bg-dark border-2 border-top border-dark"></div>
                        <h5>At betale: ${sessionScope.current_order.totalPrice} kr. </h5>
                        <h5></h5>
                        <form method="get" action="orderconfirmation">
                            <button type="submit" class="btn btn-success">Bekræft bestilling</button>
                    </div>



                </div>
            </div>

            <footer class="pt-3 mt-4 text-muted border-top">
            </footer>
        </div>

    </jsp:body>

</t:pagetemplate>
