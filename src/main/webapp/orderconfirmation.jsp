<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
         Ordre bekræftet!
    </jsp:attribute>

    <jsp:attribute name="footer">
        Tak fordi du køber lokalt og støtter Olsker Cupcakes! <3
    </jsp:attribute>

<jsp:body>

    <div class="container py-4">

    <div class="row align-items-md-stretch">
        <div class="col-md-8">
            <div class="h-100 p-5 bg-light border rounded-3">

                <h2>Din samlede ordre til afhentning:</h2>
                <form method="post">
                    <table class="table table-striped mt-4">
                        <c:forEach var="cupcake" items="${sessionScope.current_order.cupcakes}">
                            <tr>
                                <td class="text-start align-middle"> ${cupcake}</td>
                                <td class="text-center align-middle">${item.created}</td>
                                <td class="text-end">
                                    <button formaction="additem" type="submit"
                                            class="ms-2 btn btn-outline-success btm-sm col-2" name="action"
                                            value="undo-${item.itemId}">Undo
                                    </button>
                                    <button formaction="additem" type="submit"
                                            class="ms-2 btn btn-outline-danger btm-sm col-2" name="action"
                                            value="delete-${item.itemId}">Delete
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>



            <div class="h-48 p-5 bg-light border rounded-3 mt-2">
                <h2> test jaja </h2>
            </div>


        </div>
        </div>
        </div>

        </jsp:body>
</t:pagetemplate>