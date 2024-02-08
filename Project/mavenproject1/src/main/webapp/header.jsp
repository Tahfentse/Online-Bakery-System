<%-- 
    Document   : header
    Created on : Feb 8, 2024, 9:42:17 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Header SECTION -->
<header class="header">
    <a href="startuppage.jsp#home" class="logo"> 2<i class="fas fa-chart-pie"></i> 4 Bakery </a>
    <nav class="navbar">                
        <a href="startuppage.jsp#category">Category</a>
        <a href="startuppage.jsp#products">Products</a>
        <a href="startuppage.jsp#about">About</a>
        <a href="startuppage.jsp#reviews">Review</a>
        <a href="startuppage.jsp#contact">Contact</a>
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
<!--End Header SECTION -->
