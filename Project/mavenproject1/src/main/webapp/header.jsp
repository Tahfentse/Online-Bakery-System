<%-- 
    Document   : header
    Created on : Feb 8, 2024, 9:42:17 AM
    Author     : Train
--%>

<%@page import="za.ac.bakery.model.Customer"%>
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
        
<!--other side of cart, will review later-->
        <a id="cart-link" href="cart_view.jsp">
            <div id="cart-icon" class="fas fa-shopping-cart">
                <span id="cart-count">
                    <%
                            // Retrieve the count from the session
                            Integer cartItemCount = (Integer) session.getAttribute("cartItemCount");
                            // Display 0 if count is null
                            if (cartItemCount == null) {
                                cartItemCount = 0;
                            }
                            out.print(cartItemCount);
                        %>
                </span>

            </div>
        </a>       

        <%
            Customer customer = (Customer) session.getAttribute("customer");

            if (customer == null) {
        %>
        <a id="login-btn" href="sign_in.jsp">
            <div id="login-btn" class="fas fa-user"></div>
        </a> 
        <%} else {%>
        <a id="login-btn" href="viewCustomer.jsp">
            <div id="login-btn" class="fas fa-user"></div>
        </a> 
        <%}%>
    </div>
    <div class="search">
        <input type="search" placeholder="search...">
    </div>
</header>
<!--End Header SECTION -->
