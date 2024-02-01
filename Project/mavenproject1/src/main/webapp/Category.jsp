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
        <<<<<<< Updated upstream
        =======
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

            .icons a {
                font-size: 30px;
                margin-right: 10px; /* Adjust the margin as needed for spacing between icons */
                color: #333; /* Set the desired color */
                text-decoration: none; /* Remove underline from the links */
            }

            .icons a:hover {
                color: #555; /* Set the desired color on hover */
            }
        </style>

    </head>
    <body>
        <section class="products">
            <h1 class="title">Our <span>${catergorytitle}</span></h1>
            <div class="box-container">

                <form action="AddToCart" method="POST">

                    <%
                        List<Item> items = (List<Item>) session.getAttribute("items");

                        for (Item item : items) {

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
                            <div class="icons">
                                <--<!-- Cart1!!!!!!!!!!!!!!! -->
                                <input type="hidden" name="itemId" value="<%= item.getItem_id()%>">
                                <input type="hidden" name="quantity" value="1"> <!-- You can adjust the quantity as needed -->
                                <button type="submit" class="fas fa-shopping-cart" style="background: none; border: none; cursor: pointer;"></button>

                                <a href="Item.jsp" class="fas fa-eye"></a>
                            </div>
                        </div>  

                        <%}%>
                        <%}%>


                </form>

                <%
                    }
                }
                %>

            </div>
        </section>
    </body>
</html>
