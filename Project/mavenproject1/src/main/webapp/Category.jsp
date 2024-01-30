<%-- 
    Document   : cookies
    Created on : Jan 22, 2024, 11:59:38 AM
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
        <title> ${catergorytitle}</title>
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #FEF7E4; /* Vanilla Cream */
            }
            .img {
                width: 300px;
                height: 300px;
                object-fit: cover; /* Ensure the image covers the entire box */
                border-radius: 8px; /* Optional: add border radius for rounded corners */
            }

            .container {
                margin: 0 100px; /* 100px space from both left and right */
            }
            .services {
                /*                background-color: lightgoldenrodyellow;*/
                text-align: center;
                padding: 40px 20px 60px;
                /*                box-shadow: 20px 20px 10px rgba(0, 0, 0, 1);*/
            }

            .services h1 {
                padding: 0 0 30px 0;
                font-size: 84px;
                font-weight: 900;
            }

            .service_box {
                justify-content: space-between;
                display: flex;
                gap: 1rem;
                flex-direction: row;
            }

            .service_box .item {
                box-shadow: 10px 20px 30px rgba(89, 18, 18, 0.5);
                border-radius: 10px;
                display: flex;
                flex-direction: column;
                align-items: center;
                text-align: center;
                line-height: 50px;
                padding: 10px;
                transition: 0.4 ease;
            }

            .service_box .item img {
                width: 60%;
                border-radius: 10px;
                height: 100%;
                cursor: pointer;
            }

            .service_box .item:hover {
                box-shadow: 0px 4px 23px 12px rgba(245, 71, 73, 0.6);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <!-- END Service SECTION -->
            <div class="services">
                <h1>${catergorytitle}</h1>

                <form action="AdminController" method="POST">

                    <%
                        List<Item> items = (List<Item>) session.getAttribute("items");

                        for (Item item : items) {
                            ;

                            Blob imageBlob = item.getPic();
                            if (imageBlob != null) {
                                byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                                String base64Image = java.util.Base64.getEncoder().encodeToString(imageData);

                                // Assuming the image is a PNG for this example, adjust as needed
                                String imgSrc = "data:image/png;base64, " + base64Image;


                    %>
                    <div class="service_box">

                        <div class="item">

                            <img src="<%=imgSrc%>" alt="Category 1">

                            <h3><%=item.getItem_title()%></h3>
                            <h1><%= item.getItem_price()%></h1>

                            <input type="hidden" name="" value="">
                            <button class="add-to-cart-btn">Add to Cart</button>
                        </div>  

                        <%}%>
                        <%}%>

                </form>
            </div>


        </div>

    </div>
</body>
</html>
