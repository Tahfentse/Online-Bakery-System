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
    </head>
    <style>

        *{
            margin: 0;
            padding: 0;
            font-family: 'Poppins', sans-serif;
            box-sizing: border-box;
            text-decoration: none;
            list-style: none;
        }

        .popup{
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            background-color: rgba(0, 0, 0, 0.5);
        }

        .popup-content{
            background-color: #FEF7E4;
            height: 250px;
            width:500px;
            padding: 20px;
            position:relative;
            border-radius: 10px;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.7);
        }

        .popup-content:hover{
            box-shadow: 0 0 10px rgba(152, 95, 40, 0.8);
        }

        img{
            height: 50px;
            width: 50px;
        }
        .question{
            margin: 20px auto;
            padding: 8px;
            display: block;
            color: #5C3D2E;
            font-size: 1rem;
        }

        button{
            background-color: #5C3D2E;
            color: white;
            padding: 15px 30px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
            transition: box-shadow 0.3s ease;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.7);

        }
        button:hover{
            background-color: #985f28;
            box-shadow: 0 4px 23px 14px rgba(152, 95, 40, 0.8);
        }
        a{
            color: #FFF;
        }
    </style>

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
