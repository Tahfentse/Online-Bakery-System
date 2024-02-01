<%-- 
    Document   : Item
    Created on : 18 Jan 2024, 6:42:47 PM
    Author     : brill
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.bakery.model.Ingridient"%>
<%@page import="java.sql.Blob"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Item Page - To Pie Four Bakery</title>
        <link rel="website icon" type="png" href="img/logo.png">
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #FEF7E4; /* Vanilla Cream */
                color: #5C3D2E; /* Chocolate Brown */
            }

            .container {
                margin: 0 100px; /* 100px space from both left and right */
            }

            .single-item {
                display: flex; /* Use flexbox for layout */
                align-items: center; /* Center vertically */
                text-align: left;
                padding: 30px 0; /* Reduced padding for better spacing */
            }

            .single-item img {
                width: 100%; /* Make the image responsive */
                max-width: 400px; /* Set max-width for larger screens */
                height: auto; /* Maintain aspect ratio */
                border-radius: 10px;
                margin-right: 20px; /* Add space between image and text */
            }

            .item-details {
                flex: 1; /* Take remaining width */
            }

            .item-details h2 {
                font-size: 32px;
                margin-bottom: 10px;
            }

            .info-box {
                background-color: #F2E3CC; /* Light Yellow */
                padding: 15px;
                border-radius: 10px;
                margin-bottom: 15px;
            }

            .info-box p {
                margin: 0;
                font-size: 18px; /* Increased font size for better readability */
            }

            .add-to-cart-button {
                background-color: #5C3D2E; /* Chocolate brown */
                color: #FFF; /* White text */
                padding: 20px 40px; /* Increased padding for a larger button */
                border: none;
                border-radius: 10px; /* Rounded corners for the button */
                font-size: 1.5rem;
                font-weight: 600; /* Increased font size for better visibility */
                cursor: pointer;
                transition: background-color 0.3s; /* Added transition for a smooth hover effect */
            }

            .add-to-cart-button:hover {
                background-color: #985f28; /* Brownish */
                box-shadow: 0 4px 23px 14px rgba(152, 95, 40, 0.8);
            }

            .top-section {
                background-color: #F2E3CC;
                height: 70px;
                display: flex;
                align-items: center;
                justify-content: space-between;
                padding: 0 20px;
            }

            .logo img {
                height: 50px;
                max-width: 100%; /* Ensure logo image is responsive */
            }

            .search-bar {
                flex-grow: 1;
                display: flex;
                align-items: center;
            }

            .search-bar input {
                width: 70%; /* Full width on smaller screens */
                padding: 15px;
                border: none;
                border-radius: 4px;
                margin-left: 15%; /* No left margin on smaller screens */
            }

            .search-bar img {
                height: 25px;
                cursor: pointer;
                padding-left: 5px;
            }

            .top-icons {
                display: flex;
                align-items: center;
            }

            .top-icons img {
                margin: 0 5px; /* Reduced margin for smaller screens */
                height: 30px; /* Reduced height for smaller screens */
                max-width: 100%; /* Ensure icon images are responsive */
            }

            nav {
                background-color:  #F2E3CC;
                overflow: hidden;
            }

            nav a {
                float: left;
                display: block;
                color: #5C3D2E; /* Chocolate Brown */
                text-align: center;
                padding: 20px;
                text-decoration: none;
                font-weight: bold;
                font-size: 16px;
                transition: background-color 0.3s; /* Added transition for smooth hover effect */
            }

            nav a:hover {
                background-color: #985f28; /* Cherry Red */
                color: #FFF; /* White text on hover */
            }

            @media screen and (max-width: 600px) {
                .container {
                    margin: 0 20px; /* Adjusted space for smaller screens */
                }

                .single-item {
                    flex-direction: column; /* Stack items vertically on smaller screens */
                }

                .single-item img {
                    margin-right: 0; /* No right margin on smaller screens */
                    margin-bottom: 20px; /* Add space between image and text on smaller screens */
                }
                .search-bar input {
                    width: 80%; /* Adjusted width for smaller screens */
                }

                .top-icons img {
                    height: 25px; /* Further reduced height for smaller screens */
                }

                nav a {
                    padding: 10px; /* Further reduced padding for smaller screens */
                    font-size: 14px; /* Further reduced font size for smaller screens */
                }
                nav a:hover {
                    background-color: #985f28; /* Cherry Red */
                }
            }
            @media screen and (max-width: 400px) {
                .top-icons img {
                    display: none; /* Hide icons on even smaller screens */
                }
            }
            @media screen and (min-width: 601px) {
                nav a.icon {
                    display: none;
                }

                nav a {
                    display: block;
                }

                nav .dropdown {
                    display: none;
                }
            }
        </style>
    </head>
    <body>

        <div class="container">

            <!--    <div class="top-section">
                    <a href="#" class="logo"><img src="img/Screenshot (99).png"></a>
                    <div class="search-bar">
                        <input type="text" placeholder="Search...">
                        <img src="img/search.png" alt="Search" onclick="performSearch()">
                    </div>
                    <div class="top-icons">
                        <img src="img/cart.png" id="cart-icon" onclick="addToCart()">
                        <span id="cart-count" class="cart-count">0</span>
                        <img src="img/profile-user.png">
                    </div>
                </div>
            
                <nav>
                    <a href="#">Menu</a>
                    <a href="#">Cookies</a>
                    <a href="#">Cakes</a>
                    <a href="#">Cupcakes</a>
                    <a href="#">Fresh Bread</a>
                    <a href="#">Pastries</a>
                    <a href="#">Pies</a>
                    <a href="#">Brownies</a>
                    <a href="#">Contact Us</a> 
                    <a href="javascript:void(0);" class="icon" onclick="myFunction()">&#9776;</a>
                </nav>-->


            <div class="single-item">
                <%

                    Item item = (Item) session.getAttribute("item");
                    
                    if(item.getItem_id()!=0){

                    Blob imageBlob = item.getPic();

               
                        byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                        String base64Image = java.util.Base64.getEncoder().encodeToString(imageData);

                        // Assuming the image is a PNG for this example, adjust as needed
                        String imgSrc = "data:image/png;base64, " + base64Image;
                %>
                <img src="<%=imgSrc%>" alt="Your Item Image">
 
                <div class="item-details">
                    <h2><%=item.getItem_title()%></h2>

                    <div class="info-box">
                        <p>Item Description: <%=item.getItem_description()%></p>
                    </div>

                    <div class="info-box">
                        <p>Enter  Warnings:<input type="text" name="warning"></p>
                    </div>

                    <div class="info-box">
                        <p>Nutrient Information:<%=item.getItem_nutrients()%>.</p>
                    </div>
                    <%

                        List<Ingridient> ingridients = item.getIngridients();

                        if (ingridients.isEmpty()) {
                    %>
                    <div class="info-box">
                        <p>Ingredients: Empty!</p>
                    </div>
                    <%} else {%>
                    <%  for (int i = 0; i < ingridients.size(); i++) {
                    %>
                    <div class="info-box">
                        <p>Ingredients: <%=ingridients.get(i)%></p>
                    </div>
                    <%}%>
                    <%}%>

                    <div class="info-box">
                        <p>Price :R<%=item.getItem_price()%></p>
                    </div>

                    <button onclick="addToCart()" class="add-to-cart-button">Add to Cart</button>
                </div>
                    <%}else{%>
                    <p>No Item found !</p>
                    <%}%>
                    
            </div>
        </div>

        <script>
            function addToCart() {
                // Replace this with your actual logic to add the item to the cart
                alert('Item added to cart!');

            }
            //navbar and top section
            function myFunction() {
                var x = document.querySelector("nav");
                if (x.className === "") {
                    x.className = "responsive";
                } else {
                    x.className = "";
                }
            }

            // adding to cart
            let cartCount = 0;

            function addToCart() {
                // Increment the cart count
                cartCount++;

                // Update the cart count element
                document.getElementById('cart-count').innerText = cartCount;
            }

            function performSearch() {
                // Your search functionality goes here
                alert('Performing search...');



            }

        </script>

    </body>
</html>




