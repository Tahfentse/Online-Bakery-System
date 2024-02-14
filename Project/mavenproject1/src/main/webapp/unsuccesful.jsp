<%-- 
    Document   : unsuccesful
    Created on : Jan 23, 2024, 9:00:02 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Unsuccessful popup</title>
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="stylesheet" href="un-successful.css">

    </head>
    <body>
        <form action="action">
            <%
                String path = String.valueOf(session.getAttribute("path"));
                String message = String.valueOf(request.getAttribute("message"));
            %>

            <div class="popup">
                <div class="popup-content">
                    <img src="img/unsuccesful.png" alt="user">

                    <label class="question">${message}</label>
                    <button><a href="<%=path%>" class="button" >OK</a></button>
                </div>
            </div>
        </form>
    </body>
</html>
