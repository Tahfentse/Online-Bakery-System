<%-- 
    Document   : viewall
    Created on : Jan 30, 2024, 11:23:05 AM
    Author     : Train
--%>

<%@page import="java.sql.Blob"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>2Pie4 Bakery</title>
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <header class="header">
            <a href="startuppage.jsp" class="logo"> 2<i class="fas fa-chart-pie"></i> 4 Bakery </a>
            <nav class="navbar">                
                <a href="#category">Category</a>
                <a href="#products">Products</a>
                <a href="#about">About</a>
                <a href="#reviews">Review</a>
                <a href="#contact">Contact</a>
            </nav>
            <div class="icons">
                <div id="menu-btn" class="fas fa-bars"></div>
                <div id="search" class="fas fa-search" ></div>
                <a id="cart-btn" href="cart.jsp">
                    <div id="cart-btn" class="fas fa-shopping-cart"></div>
                </a>               
                <a id="login-btn" href="sign_in.jsp">
                    <div id="login-btn" class="fas fa-user"></div>
                </a> 
            </div>
            <div class="search">
                <input type="search" placeholder="search...">
            </div>
        </header>
    <div class="space"></div>

        <section class="products">
            <h1 class="title"><span>Products</span></h1>
            <div class="box-container">
                <%
                    List<Item> items = (List<Item>) session.getAttribute("items");

                    for (Item item : items) {
                        Blob imageBlob = item.getPic();
                        byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                        String base64Image = java.util.Base64.getEncoder().encodeToString(imageData);
                        String imgSrc = "data:image/png;base64, " + base64Image;
                %>
                <div class="box">
                    <div class="icons">
                        <a href="/mavenproject1/AddToCart?action=GET&quantity=1&itemId=<%=item.getItem_id()%>" class="fas fa-shopping-cart" name="itemId"></a>
                         <a href="/mavenproject1/StoreController.do?action=GET&act=viewItem&itemid=<%=item.getItem_id()%>" class="fas fa-eye"></a>
                    </div>
                    <div class="img">
                    <img decoding="async" src="<%= imgSrc%>" alt="Item Image">
                    </div>
                    <div class="content">
                    <h3><%=item.getItem_title()%></h3>
                    <div class="price">R<%= item.getItem_price()%></div>
                    <div class="stars">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="far fa-star"></i>
                    </div>
                </div>
                    </div>
                <%
                    }
                %>
            </div>
        </section>


    </body>
</html>
