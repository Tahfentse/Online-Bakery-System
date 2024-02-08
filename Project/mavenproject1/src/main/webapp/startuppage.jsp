<%@page import="za.ac.bakery.model.Catergory"%>
<%@page import="java.sql.Blob"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>2Pie4 Bakery</title>
    <link rel="website icon" type="png" href="img/logo.png">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="style.css">
</head>
<style>
    .cart-popup {
        display: none;
        position: fixed;
        bottom: 10px;
        right: 10px;
        background-color: #ffffff;
        border: 1px solid #ccc;
        padding: 10px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        z-index: 999;
    }
</style>
<body>

    <!-- Header SECTION -->
    <%@ include file="header.jsp" %>
    <!--End Header SECTION -->

    <!-- Welcome SECTION -->   
    <div class="welcome-section" id="home">
        <div class="container">
            <h1>Welcome to 2Pie4 Bakery</h1>
            <p>Indulge your senses in our delicious and freshly baked treats. From cookies to cakes, we have it all!</p>
        </div>
    </div> 
    <!--End Welcome SECTION -->   

    <!-- Category SECTION -->
    <section class="category" id="category">

        <form action="StoreController.do" method="POST">

            <% List<Catergory> categories = (List<Catergory>) session.getAttribute("categories");

                if (categories != null && !categories.isEmpty()) {
            %>
            <h1 class="title">Our <span>Categories</span></h1>
            <div class="mobile-toggle"></div>
            <div class="hero">
                <div class="swiper">
                    <div class="swiper-wrapper">


                        <% for (Catergory category : categories) {

                                Blob imageBlob = category.getCatergory_pic();

                                byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                                String base64Image = java.util.Base64.getEncoder().encodeToString(imageData);

                                // Assuming the image is a PNG for this example, adjust as needed
                                String imgSrc = "data:image/png;base64, " + base64Image;
                        %>



                        <div class="swiper-slide">

                            <div class="hero__slide">
                                <div class="hero__slide__txt">
                                    <%= category.getCatergory_title()%>
                                </div>
                                <div class="hero__slide__img">
                                    <input type="hidden" name="catergoryid" value="<%=category.getCatergory()%>" >

                                    <input type="hidden"  name="catergorytitle" value="<%=category.getCatergory_title()%>" >
                                    <a href="/mavenproject1/StoreController.do?action=POST&catergoryid=<%=category.getCatergory()%>&act=viewcatergory&catergorytitle=<%=category.getCatergory_title()%>">
                                        <img src="<%= imgSrc%>" alt="<%= category.getCatergory_title()%>">
                                    </a>
                                    <input type="hidden"  name="act" value="viewcatergory">
                                </div>
                            </div>
                        </div>

                        <%

                            } %>


                    </div>
                    <div class="swiper-pagination"></div>
                </div>

                <script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
                <script src="./app/js/app.js"></script>
            </div>

            <%
            } else {
                // Handle the case where there are no categories
            %>
            <p>No categories available.</p>
            <%
                }
            %>
        </form>
    </section>
    <!--End Category SECTION -->

    <!-- Products SECTION -->
    <section class="products" id="products">

        <h1 class="title"> our <span>products</span> <a href="/mavenproject1/StoreController.do?action=POST&act=viewall">view all </a> </h1>
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
                    <a href="/mavenproject1/AdminController.do?action=GET&act=viewItem&itemid=<%=item.getItem_id()%>" class="fas fa-eye"></a>
                </div>
                <div class="img">
                    <img decoding="async" src="<%=imgSrc%>" alt="">
                </div>
                <div class="content">
                    <h3><%=item.getItem_title()%></h3>
                    <div class="price">R<%=item.getItem_price()%></div>
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
    <!--End Products SECTION -->

    <!-- About SECTION -->
    <section class="about" id="about">
        <h1 class="title"> About <span>Us</span><a href="#"></a></h1>
        <div class="about">
            <div class="about__img">
                <img src="./img/cupcake (8).png" alt="">
            </div>
            <div class="about__info">
                <h2 class="about__info__title">2Pie4<span class="txt-main">Bakery</span></h2>                                        					
                <p class="about__info__description">
                    At 2π4 Bakery, we are passionate about creating delicious and delightful treats
                    that match your taste buds to haven. Our journey began in 2019 when our founder, Mrs Pat Cake.,
                    decided to turn her love for baking into a business.
                </p >
                <p class="about__info__description">
                    Since then, we have been dedicated to crafting high-quality pie, cakes, cookies, and
                    other sweet treats using the finest ingredients. Our commitment to excellence and creativity
                    has made us a beloved bakery in the community.
                </p>
            </div>
        </div>
    </section>
    <!--End About SECTION -->

    <!--Review SECTION -->
    <section class="review" id="reviews">
        <h1 class="title"> Customer <span>Reviews</span></h1>
        <div class="review">
            <div class="box">
                <div class="user">
                    <img decoding="async" src="img/pic-4.png" alt="">
                    <div class="info">
                        <h3>mary bey</h3>
                    </div>
                </div>
                <p>I've been a regular customer for years, the customer service is as excellent as the pastries section is impressive.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
            </div>
            <div class="box">
                <div class="user">
                    <img decoding="async" src="img/pic-1.png" alt="">
                    <div class="info">
                        <h3>edward Riches</h3>
                    </div>
                </div>
                <p>Their bread is amazing, especially the oat one. The aroma in the bakery is heavenly.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
            </div>
            <div class="box">
                <div class="user">
                    <img decoding="async" src="img/pic-2.png" alt="">
                    <div class="info">
                        <h3>kate barkers</h3>
                    </div>
                </div>
                <p>Great bakery! I love their pastries and cakes. The quality is always top-notch.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                </div>
            </div>
            <div class="box">
                <div class="user">
                    <img decoding="async" src="img/pic-6.png" alt="">
                    <div class="info">
                        <h3>lisa Song</h3>
                    </div>
                </div>
                <p>Their cupcakes are to die for! Always fresh,tasty and beautifully decorated.</p>
                <div class="stars">
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="fas fa-star"></i>
                    <i class="far fa-star"></i>
                </div>
            </div>    
    </section>
    <!--End Review SECTION -->
    <div class="space"></div>   

    <!--Footer SECTION -->
    <%@ include file="footer.jsp" %>
    <!--End Footer SECTION -->

    <script>
        let search = document.querySelector('.search');
        document.querySelector('#search').onclick = () => {
            search.classList.toggle('active');
        };

        var cartBtn = document.getElementById('cart-btn');
        cartBtn.addEventListener('click', function () {
            window.location.href = "cart.jsp";
        });







    </script>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const cartIcon = document.getElementById('cart-icon');
            const cartCount = document.getElementById('cart-count');
            const cartPopup = document.getElementById('cart-popup');

            let itemCount = 0;

            // Function to increment cart count
            function incrementCart() {
                itemCount++;
                cartCount.innerText = itemCount;
            }

            // Function to decrement cart count
            function decrementCart() {
                if (itemCount > 0) {
                    itemCount--;
                    cartCount.innerText = itemCount;
                }
            }

            // Show cart popup when icon is clicked
            cartIcon.addEventListener('click', function (event) {
                event.preventDefault();
                cartPopup.style.display = 'block';
                // You can fetch and display cart items here
            });

            // Hide cart popup when user clicks outside of it
            document.addEventListener('click', function (event) {
                if (!cartPopup.contains(event.target) && event.target !== cartIcon) {
                    cartPopup.style.display = 'none';
                }
            });

            // Example of adding an item to the cart
            const addToCartButton = document.querySelector('.icons a');
            addToCartButton.addEventListener('click', function (event) {
                event.preventDefault();
                incrementCart();
                // You can add logic here to fetch and add item to the cart
            });

            // Example of removing an item from the cart
            // Assuming you have a remove button for each item in the cart
            document.addEventListener('click', function (event) {
                if (event.target.classList.contains('remove-item')) {
                    decrementCart();
                    // You can add logic here to remove item from the cart
                }
            });
        });
    </script>

    <script src="main.js" defer data-deferred="1"></script> </body>
</html>
