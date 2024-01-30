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
        <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
        <style>
            body {
                background-color: #f5deb3; /* Set background color to caramel */
            }

            .item-container {
                display: grid;
                grid-template-columns: repeat(4, 400px); /* Set the width of each column to 200px */
                grid-auto-rows: 400px; /* Set the height of each row to 200px */
                gap: 10px;
                justify-content: space-around;
                margin-top: 20px;
            }

            .item {
                background-color: #f5deb3;
                padding: 10px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                transition: transform 0.3s;
                box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.7);
                border-radius: 10px;
                display: flex;
                position: relative;
                overflow: hidden;
                flex-direction: column;
                align-items: center;
                text-align: center;
                line-height: 50px;
                padding: 10px;
                transition: 0.4 ease;
            }

            .item:hover {
                transform: scale(1.05);
            }

            .item img {
                max-width: 40%;
                height: 40%;
                border-radius: 2px;
            }

            .item-title {
                font-weight: bold;
                margin-top: 10px;
            }

            .item-price {
                margin-top: 5px;
            }

            .add-to-cart {
                margin-top: 10px;
                background-color:  #ffcc99;
                color:  #f5deb3;
                border: none;
                padding: 8px 16px;
                border-radius: 5px;
                cursor: pointer;
            }
            .header{
                position: fixed;
                top: 0;
                left: 0;
                right: 0;
                z-index:1000;
                background: #F2E3CC; /*caramel*/
                display:flex;
                align-items: center;
                justify-content: space-between;
                padding:1.4rem 7%;
            }
            .header .logo{
                font-size:2.5rem;
                font-weight: bolder;
                color:#ffffff;
            }
            .header .logo i{
                color:#222;
                padding-right: .5rem;
            }
            .header .navbar a{
                font-size: 2rem;
                color: #5C3D2E  /*Chocolate Brown */;
                margin: 0 1rem;
                font-weight: bold;
            }
            .header .navbar a:hover{
                color: #985f28; /* Brownish */
            }
            .header .icons div{
                font-size: 1.8rem;
                margin-left: 1.7rem;
                cursor: pointer;
                color: #5C3D2E  /*Chocolate Brown */;
            }
            .header .icons div:hover{
                color: #985f28; /* Brownish */
            }
            .header .search{
                display: none;
                top: 100%;
                margin: 1.5rem 7%;
                border-radius: 10px;
                background: #F2E3CC; /*caramel*/
                width: 50%;
                right: 0;
                height: 5rem;
                position:  absolute;

            }
            .header .search input{
                width: 100%;
                height: 100%;
                font-size: 1.5rem;
                background-color: var(--white);
                color: var(--black);
                margin-right: 7%;
                padding: 0.5rem 1rem;
                box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.7);
                border-radius: 10px;
            }
            .header .search.active{
                display: block;
            }

            /* menu button style */
            #menu-btn{
                display: none;
            }
            @keyframes fadeLeft {
                0%{
                    opacity: 0;
                    transform: translateY(-5rem);
                }
            }
            @keyframes fadeUp {
                0%{
                    opacity: 0;
                    transform: scale(0.5);
                }
            }

        </style>
    </head>


    <body>
        <header class="header">
            <a href="#home" class="logo"> 2<i class="fas fa-chart-pie"></i> 4 Bakery </a>
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



        <div class="item-container">
            <%
                List<Item> items = (List<Item>) session.getAttribute("items");

                for (Item item : items) {
                    Blob imageBlob = item.getPic();
                    byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                    String base64Image = java.util.Base64.getEncoder().encodeToString(imageData);
                    String imgSrc = "data:image/png;base64, " + base64Image;
            %>
            <div class="item">
                <img src="<%= imgSrc%>" alt="Item Image">
                <div class="item-title"><%= item.getItem_title()%></div>
                <div class="item-price">R<%= item.getItem_price()%></div>

                <button name="button" class="add-to-cart">Add to Cart</button>
            </div>
            <%
                }
            %>
        </div>
    </body>
</html>
