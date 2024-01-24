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
        <title>JSP Page</title>
        <link rel="website icon" type="png" href="img/logo.png">
        <link href="successful&Unsuccesful.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            String path = String.valueOf(session.getAttribute("path"));
            
            String message = String.valueOf(request.getAttribute("message"));
        %>

        <form action="action">
            <div class="popup">
                <div class="popup-content">
                    <img src="img/unsuccesful.png" alt="user">
                    <label class="question">${message}</label>
                    <a href="<%=path%>" value="o" class="button" >OK</a>
                </div>
            </div>
        </form>
    </body>
</html>
