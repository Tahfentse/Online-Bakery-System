<%-- 
    Document   : cookies
    Created on : Jan 22, 2024, 11:59:38 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookies Page</title>
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
                <h1>Our Cookies</h1>
                <div class="service_box">
                    <div class="item">
                        <img src="./category/cookies/choc_biscuit.png" alt="Category 1">
                        <h3>Chocolate cookies</h3>
                        <button class="add-to-cart-btn">Add to Cart</button>
                    </div>
                    <div class="item">
                        <img src="./category/cookies/ginger_bread.png" alt="Category 1">
                        <h3>Ginger bread cookies</h3>
                        <button class="add-to-cart-btn">Add to Cart</button>
                    </div>
                    <div class="item">
                        <img src="./category/cookies/macaroons.png" alt="Category 1">
                        <h3>Macaroons</h3>
                        <button class="add-to-cart-btn">Add to Cart</button>
                    </div>
                    <div class="item">
                        <img src="./category/cookies/pinwheel.png" alt="Category 1">
                        <h3>Pinwheel</h3>
                        <button class="add-to-cart-btn">Add to Cart</button>
                    </div>
                    <div class="item">
                        <img src="./category/cookies/vegan_chocolate_chip.png" alt="Category 1">
                        <h3>Vegan Chocolate chip</h3>
                        <button class="add-to-cart-btn">Add to Cart</button>
                    </div>

                </div>
            </div>
            <!-- END Service SECTION -->
        </div>
    </body>
</html>
