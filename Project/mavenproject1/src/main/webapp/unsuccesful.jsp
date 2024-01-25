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
<<<<<<< HEAD
        <style>

            *{
                margin: 0;
                padding: 0;
                font-family: 'Poppins', sans-serif;
                box-sizing: border-box;
                text-decoration: none;
                list-style: none;
            }

            .container{
                position: absolute;
                width: 100%;
                top: 20%;
                left: 15%;
                background: #fff;

            }

            .content-table{
                border-collapse: collapse;
                margin: 20px 0;
                font-size: 0.9em;
                min-width: 400px;
                border-radius: 5px 5px 0 0;
                overflow: hidden;
                box-shadow: 0 0 5px #424543;
            }
            .content-table thead tr{
                background-color: #009879;
                color: #fff;
                text-align: left;
                font-weight: bold;
            }
            .content-table th, .content-table td{
                padding: 12px 15px;
            }
            .content-table tbody tr{
                border-bottom: 1px solid #dddddd;
            }
            .content-table tbody tr:nth-of-type(even){
                background-color: #f3f3f3;
            }
            .content-table tbody tr:nth-last-of-type{
                border-bottom: 2px solid  #009879;

            }

            .popup{
                background-color: #424543;
                width: 100%;
                height: 100%;
                position: absolute;
                top: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                text-align: center;

            }

            .popup-content{
                height: 250px;
                width:500px;
                padding: 20px;
                background: #fff;
                border-radius: 20px;
                position:relative;
            }

            img{
                height: 50px;
                width: 50px;
            }
            .question{
                margin: 20px auto;
                padding: 8px;
                display: block;
            }

            a.button, a:hover{
                display: inline;
                border: 1px solid #1b9bff;
                background: #1b9bff;
                padding: 10px;
                border-radius: 20px;
                width: 10%;
            }


        </style>
=======
        <link href="successful&Unsuccesful.css" rel="stylesheet" type="text/css"/>
>>>>>>> Ofentse-branch
    </head>
    <body>
        <%
            String path = String.valueOf(session.getAttribute("path"));
<<<<<<< HEAD
=======
            
>>>>>>> Ofentse-branch
            String message = String.valueOf(request.getAttribute("message"));
        %>

        <form action="action">
            <div class="popup">
                <div class="popup-content">
                    <img src="img/unsuccesful.png" alt="user">
<<<<<<< HEAD
                    <label class="question"><%=message%></label>
=======
                    <label class="question">${message}</label>
>>>>>>> Ofentse-branch
                    <a href="<%=path%>" value="o" class="button" >OK</a>
                </div>
            </div>
        </form>
    </body>
</html>
