
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>To Pie Four Bakery</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #FEF7E4; /* Vanilla Cream */
        }

        .container {
            margin: 0 100px; /* 100px space from both left and right */
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
        
        
        /*Body*/
        .welcome-section {
            background: url('img/home.png') left/auto 100% no-repeat; 
            padding: 10% 0; /* Adjusted padding for responsiveness */
            text-align: center;
            color: #edba85;
            height: 200px;
        }

        .welcome-section h1 {
            font-size: 4vw; /* Responsive font size based on viewport width */
            margin-bottom: 20px;
            font-weight: bold;
        }

        .welcome-section p {
            font-size: 2vw; /* Responsive font size based on viewport width */
            margin-bottom: 40px;
            font-weight: bold;
        }
        
        /* Styles for the image slider */
        .slider-container {
            position: relative;
        }

        .slider {
            display: flex;
            overflow: hidden;
            width: 100%;
        }

        .slide {
            width: 100%;
            flex-shrink: 0;
        }

        .slider img {
            width: 100%;
            height: auto;
        }

        .slider-nav {
            position: absolute;
            top: 50%;
            width: 100%;
            display: flex;
            justify-content: space-between;
            transform: translateY(-50%);
        }

        .slider-nav div {
            font-size: 24px;
            cursor: pointer;
            color: #5C3D2E; /* Chocolate Brown */
        }

        .contact-section {
            background-color: #F2E3CC; /* Golden Yellow */
            padding: 60px 0;
            text-align: center;
        }

        .contact-section h2 {
            font-size: 30px;
            margin-bottom: 20px;
            color: #5C3D2E; /* Chocolate Brown */
        }

        .contact-section p {
            font-size: 18px;
            margin-bottom: 40px;
            color: #5C3D2E; /* Chocolate Brown */
        }

        .contact-button {
            background-color: #D91E36; /* Cherry Red */
            color: #FFF;
            padding: 15px 30px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
        }
        
        /* Styles for the footer */
        .footer {
            background-color: #F2E3CC; /* Golden Yellow */
            color: #5C3D2E; /* Chocolate Brown */
            padding: 25px 0;
        }

        .footer-content {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }

        .footer-section {
            flex: 1;
            text-align: center;
        }

        .footer-section h3 {
            font-size: 20px;
            margin-bottom: 10px;
        }

        .footer-section p {
            font-size: 16px;
            margin-bottom: 15px;
        }

        .footer-section img {
            width: 25px;
            margin: 5px;
        }

        .copyright {
            text-align: center;
            margin-top: 20px;
        }
        
        
        /* Styles for the featured section */
        
        

        @media screen and (max-width: 600px) {
            .container {
                margin: 0 20px; /* Adjusted space for smaller screens */
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
            
            
            /*featured products*/
             
            
            
            
            
/*            .featured-product {
                width: 100%;
            }*/
            .footer-section {
                flex: 1 0 100%;
            }
            
            
        }

        @media screen and (max-width: 400px) {
            .top-icons img {
                display: none; /* Hide icons on even smaller screens */
            }
        }

        @media screen and (max-width: 600px) {
            nav a:not(:first-child) {
                display: none;
            }

            nav a.icon {
                float: right;
                display: block;
            }

            nav.responsive {
                position: relative;
            }

            nav.responsive a.icon {
                position: absolute;
                right: 0;
                top: 0;
            }

            nav.responsive a {
                float: none;
                display: block;
                text-align: left;
                color: #5C3D2E; /* Chocolate Brown */
            }

            nav.responsive .dropdown {
                display: block;
                position: static;
            }
            
            .welcome-section {
                background-size: cover; /* Ensure the background image covers the container */
            }

            .welcome-section h1 {
                font-size: 8vw; /* Adjusted font size for smaller screens */
                margin-bottom: 10px;
            }

            .welcome-section p {
                font-size: 4vw; /* Adjusted font size for smaller screens */
                margin-bottom: 20px;
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
    
    <style>
        /* Add any additional styling here */
        .featured-products {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
            max-width: 100%; /* Adjust max-width based on your design */
            margin: 0 auto;
            padding: 10px;
        }

        .category {
            width: 25%; /* Adjust width based on your design */
            margin-bottom: 20px;
            overflow: hidden;
        }

        .category img {
            width: 300px;
            height: 300px;
            object-fit: cover; /* Ensure the image covers the entire box */
            border-radius: 8px; /* Optional: add border radius for rounded corners */
        }

        .category h3 {
            margin-top: 10px;
            text-align: center;
        }
        .featured-section {
            text-align: center;
            margin-bottom: 30px;
        }

        .featured-section h2 {
            font-size: 50px;
            color: #5C3D2E; /* Chocolate Brown */
            margin-bottom: 10px;
        }

        .all-products-btn {
            background-color: #D91E36; /* Cherry Red */
            color: #FFF;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .add-to-cart-btn{
            background-color: #D91E36; /* Cherry Red */
            color: #FFF;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
    
</head>
<body>

<div class="container">
    <div class="top-section">
        <a href="home.jsp" class="logo"><img src="img/Screenshot (99).png"></a>
        <div class="search-bar">
            <input type="text" placeholder="Search...">
            <img src="img/search.png" alt="Search" onclick="performSearch()">
        </div>
        <div class="top-icons">
            <a href="cart.jsp" class="logo"><img src="img/cart.png" id="cart-icon" ><!--onclick="addToCart()"-->
            <span id="cart-count" class="cart-count">0</span>
             <a href="sign_in_and_out.jsp" class="profile"><img src="img/profile-user.png">
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
    </nav>
    
    
    
        <div class="welcome-section">
            <h1>Welcome to To Pie Four Bakery</h1>
            <p>Indulge your senses in our delicious and freshly baked treats. From cookies to cakes, we have it all!</p>
        </div>
    
        
    
        <div class="featured-section">
                <h2>Featured Products</h2>
                <button class="all-products-btn">All Products</button>
            </div>
        <div class="featured-products">
            
            <div class="category">
                <img src="img/cupcake (8).png" alt="Category 1">
                    <h3>Cupcakes 1</h3>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>

                <!-- Category 2 -->
                <div class="category">
                    <img src="img/cupcake (6).png" alt="Category 2">
                    <h3>Cookies2</h3>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>

                <!-- Category 3 -->
                <div class="category">
                    <img src="img/cupcake (3).png" alt="Category 3">
                    <h3>Brownies</h3>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>

                <!-- Category 4 -->
                <div class="category">
                    <img src="img/cupcake (5).png" alt="Category 4">
                    <h3>Pies</h3>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>

                <!-- Category 5 -->
                <div class="category">
                    <img src="img/cupcake (1).png" alt="Category 5">
                    <h3>Fresh Bread</h3>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>

                <!-- Category 6 -->
                <div class="category">
                    <img src="img/cupcake (2).png" alt="Category 6">
                    <h3>Pies</h3>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>

                <!-- Category 7 -->
                <div class="category">
                    <img src="img/cupcake (1).png" alt="Category 7">
                    <h3>Donut</h3>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>
                <div class="category">
                    <img src="img/cupcake (1).png" alt="Category 7">
                    <h3>Donut</h3>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>
            
        
        </div>
    
    
       
    
        

   
    
    <div class="footer">
        <div class="footer-content">
            <div class="footer-section contact-info">
                <h3>Contact Us</h3>
                <p>Email: info@topiefourbakery.com</p>
                <p>Phone: +1 (123) 456-7890</p>
            </div>

            <div class="footer-section social-media">
                <h3>Follow Us</h3>
                <a href="#" target="_blank"><img src="img/facebook.png" alt="Facebook"></a>
                <a href="#" target="_blank"><img src="img/twitter.png" alt="Twitter"></a>
                <a href="#" target="_blank"><img src="img/instagram.png" alt="Instagram"></a>
            </div>
        </div>

        <div class="footer-section copyright">
            <p>&copy; 2024 To Pie Four Bakery. All rights reserved.</p>
        </div>
    </div>
    
    
    
</div>

<script>
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

