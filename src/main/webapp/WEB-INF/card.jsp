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
                        <p>Swap the background-color utility and add a `.text-*` color utility to mix up the jumbotron
                            look. Then, mix and match with additional component themes and more.</p>
                        <button class="btn btn-outline-light" type="button">Example button</button>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="h-50 p-5 bg-light border rounded-3">
                        <h2>Add borders</h2>
                       <p> ${sessionScope.user.username}</p>
                        <button class="btn btn-outline-secondary" type="button">Example button</button>
                    </div>


                    <div class="h-50 p-5 bg-light border rounded-3">
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
