<%@page import="za.ac.bakery.model.Customer"%>
<%@page import="java.sql.Blob"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1, maximum-scale=1,user-scalable=0">
        <meta name="description" content="Shopping cart view">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/cart_normalize.css">
        <link rel="stylesheet" type="text/css" href="css/cart_style.css">
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">

        <title>Shopping Cart</title>
    </head>

    <body>
        <!-- Header SECTION -->
        <%@ include file="header.jsp" %>
        <!--End Header SECTION -->
        <div class="space"></div>

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
        <div class="space"></div>


        <% List<Item> items = (List<Item>) session.getAttribute("items");

            if (!items.isEmpty()) {

        %>
        <main class="main">


            <section class="section">
                <table class="section-table">
                    <thead class="section-table__thead">
                        <tr>
                            <th>Remove Item</th>
                            <th>Item Image</th>
                            <th>Item Name</th>
                            <th>Item Price</th>
                            <th>Qty</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%                            session.setAttribute("item", items);
                            double subtotal = 0.00;
                            int totalQuantity = 0;

                            // Initialize subtotal
                            for (Item item : items) {
                                int itemId = item.getItem_id();
                                String itemTitle = item.getItem_title();
                                int qty = item.getQty();
                                totalQuantity += qty; // Increment total quantity
                                double itemPrice = item.getItem_price() * qty; // Multiply item price by quantity
                                subtotal += itemPrice; // Add item total to subtotal

                                Blob imageBlob = item.getPic();

                                byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                                String base64Image = java.util.Base64.getEncoder().encodeToString(imageData);

                                // Assuming the image is a PNG for this example, adjust as needed
                                String imgSrc = "data:image/png;base64," + base64Image;
                        %>
                        <tr>
                            <td>
                                <form action="AddToCart" method="GET">
                                    <input type="hidden" name="itemId" value="<%= itemId%>">
                                    <input type="hidden" name="act" value="removeitem">
                                    <button type="submit" class="button-image">
                                        <img class="button-image" src="img/x-img.png" alt="x sign to remove the product from the cart">
                                    </button>
                                </form>
                            </td>
                    <script>
                        document.getElementById("button-image").addEventListener("click", function () {
                            // Convert the array to a comma-separated string
                            var itemIdsString = cartItems.join(",");
                            // Redirect to the servlet with the item IDs as a query parameter
                            window.location.href = "/mavenproject1/AddToCart?action=GET&act=removeitem&itemId=" + <%= itemId%>;
                        });
                    </script>
                    <td>
                        <img class="image" src="<%= imgSrc%>" alt="<%= itemTitle%>" width="60px" height="60px">
                    </td>
                    <td><%= itemTitle%></td>
                    <td>R <%= String.format("%.2f", itemPrice)%></td> <!-- Display total item price -->
                    <td>
                        <div class="section-table__counter">
                            <button class="square" onclick="updateQuantity(<%= itemId%>, <%= item.getItem_price()%>, 'decrease')">-</button>
                            <div class="square" id="quantity_<%= itemId%>"><%= qty%></div>
                            <button class="square" onclick="updateQuantity(<%= itemId%>, <%= item.getItem_price()%>, 'increase')">+</button>
                        </div>
                    </td>
                    </tr>
                    <%
                        }

                    %>
                    </tbody>
                </table>
                <div class="section-footer">
                    <a href="/mavenproject1/StoreController.do?act=viewall" class="button">Back To Shopping</a>
                </div>
            </section>
            <aside class="aside">
                <table class="aside-table">
                    <thead class="aside-table__thead">
                        <tr>
                            <th>SHIPPING</th>
                            <th>R23.80</th> <!-- This value should be dynamically calculated -->
                        </tr>
                    </thead>
                </table>
                <table class="aside-table">
                    <thead class="aside-table__thead">
                        <tr>
                            <th colspan="2">CART TOTALS</th>
                        </tr>
                    </thead>
                    <tbody class="aside-table__tbody">
                        <tr>
                            <td>Subtotal</td>
                            <td id="subtotal">R <%= String.format("%.2f", subtotal)%></td> <!-- Display initial subtotal -->
                        </tr>
                        <tr>
                            <td>Total Quantity</td>
                            <td><%= totalQuantity%></td> <!-- Display total quantity -->
                        </tr>
                        <tr>
                            <td>Grand total</td>
                            <td id="grandTotal">R <%= String.format("%.2f", subtotal + 23.80)%></td> <!-- Display initial grand total -->
                        </tr>
                        <%
                            session.setAttribute("amount", subtotal);
                            session.setAttribute("totalQuantity", totalQuantity); // Set total quantity in session
                        %>
                        <tr>
                            <td colspan="2">
                                <a id="checkout" class="button" onclick="proceedToCheckout()">Proceed to checkout</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </aside>
        </main>

        <%} else {%>

        <div style="

             display: flex;
             align-content: center;
             align-items: center;
             text-align: center

             ">
            <p> Cart Empty! </p>

        </div>

        <%}%>   
        <footer class="footer">
        </footer>


        <script>
            function proceedToCheckout() {
                // Redirect to the servlet to handle the checkout process
                window.location.href = "CheckoutServlet";
            }

            function updateQuantity(itemId, price, operation) {
                let quantityElement = document.getElementById("quantity_" + itemId);
                let quantity = parseInt(quantityElement.innerText);
                let subtotalElement = document.getElementById("subtotal");
                let grandTotalElement = document.getElementById("grandTotal");
                let subtotal = parseFloat(subtotalElement.innerText.substring(1)); // Remove the 'R' sign
                let grandTotal = parseFloat(grandTotalElement.innerText.substring(1)); // Remove the 'R' sign

                if (operation === 'increase') {
                    quantity++;
                    subtotal += price;
                    grandTotal += price;
                } else if (operation === 'decrease' && quantity > 1) {
                    quantity--;
                    subtotal -= price;
                    grandTotal -= price;
                }

                quantityElement.innerText = quantity;
                subtotalElement.innerText = "R " + subtotal.toFixed(2);
                grandTotalElement.innerText = "R " + grandTotal.toFixed(2);
            }
        </script>
    </body>
</html>
