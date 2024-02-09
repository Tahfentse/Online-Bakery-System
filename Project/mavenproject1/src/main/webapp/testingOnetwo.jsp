<%-- 
    Document   : testingOnetwo
    Created on : Feb 6, 2024, 11:40:16 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <style>
        .cart{
            display: flex;
            background-color: blue;
            justify-content: space-between;
            align-items: center;
            padding: 7px 10px;
            border-radius: 3px;
            width:80px;
        }
        
        .fas {
            color: gold;
            
        }
        .cart p{
            height: 22px;
            width:22px;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 22px;
        }
        
    </style>
    <body>
        
        <div class="header">
            <div class="cart"><i class="fas fa-shopping-cart"></i><p id="count">0</p></div>
        </div>
        
        
    </body>
</html>
