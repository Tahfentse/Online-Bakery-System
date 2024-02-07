<%-- 
    Document   : sucessful
    Created on : Jan 22, 2024, 3:08:36 PM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="stylesheet" href="un-successful.css">
    </head>
    <body>

        <%
            String path = String.valueOf(session.getAttribute("path"));
            String message = String.valueOf(session.getAttribute("message"));

        %>

        <form action="action">
            <div class="popup">
                <div class="popup-content">
                    <img src="img/sucessful.png" alt="user">

                    <label class="question">${message}</label>

                    <button><a href="<%=path%>" class="button" >OK</a></button>
                </div>
            </div>
        </form>
    </body>
</html>
