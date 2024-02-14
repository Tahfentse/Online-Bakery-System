<%-- 
    Document   : sibu_cart
    Created on : Feb 12, 2024, 10:50:49 AM
    Author     : Train
--%>

<%@page import="java.util.Base64"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page import="za.ac.bakery.model.ShoppingCart"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="za.ac.bakery.service.S_CartService"%>
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
        <title>Shopping Cart</title>
    </head>
    <style>
        .error-message{
            color:red;
        }

    </style>
    <body>
        <h1>Hello World!</h1>
    <body>
    <header class="header">
        <h2 class="header-title">Shopping Cart</h2>
        <nav>
            <button class="button">
                Proceed to checkout
            </button>
        </nav>
    </header>
    <main class="main">
        <section class="section">
            <table class="section-table">
                <thead class="section-table__thead">
                    <tr>
                        <th></th>
                        <th></th>
                        <th>Product Name</th>
                        <th>Unit Price</th>
                        <th>Qty</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <% 
                            String error = (String) session.getAttribute("error");
                            
                            session.removeAttribute("error");// Remove error attribute from session to avoid displaying it again on next request
                            
                        S_CartService userCart = (S_CartService) session.getAttribute("userCart");
                        double subtotal = 0.00;
                        int totalQuantity = 0;
                        double deliveryfee = 50;
                        if (userCart != null) {
                            Map<Integer, Double> cartItems = userCart.getCart();
                            
                            for (Entry<Integer, ShoppingCart> entry : cartItems.entrySet()) {
                                ShoppingCart cartItem = entry.getValue();
                                Item item = cartItem.getItem();
                                
                                // Convert BLOB data to Base64 string
                                String base64Image = "";
                                if (item.getPic() != null) {
                                    InputStream inputStream = item.getPic().getBinaryStream();
                                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                                    byte[] buffer = new byte[4096];
                                    int bytesRead = -1;
                                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                                        outputStream.write(buffer, 0, bytesRead);
                                    }
                                    byte[] imageBytes = outputStream.toByteArray();
                                    base64Image = Base64.getEncoder().encodeToString(imageBytes);
                                    inputStream.close();
                                    outputStream.close();
                                }
                    %>
                     
                    <tr>
                        <td>
                            <button class="button-image"><img class="image" src="img/x-img.png" alt="x sign to remove the product from the cart"></button>
                        </td>
                        <td><img class="image" src="data:image/jpeg;base64,<%= base64Image %>" alt="Product Image"></td>
                        <td><%= item.getItem_title() %></td>
                        <td>$<%= item.getItem_price() %></td>
                        <td>
                            <div class="section-table__counter">
                                <button class="square">-</button>
                                <div class="square"><%= cartItem.getQuantity() %></div>
                                <button class="square">+</button>
                                
                            </div>
                        </td>
                    </tr>
                    <% 
                            }
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
                            <th>R <%= deliveryfee%></th> <!-- This value should be dynamically calculated -->
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
                            <td>Total Cart Quantity</td>
                            <td><%= totalQuantity%></td> <!-- Display total quantity -->
                        </tr>
                        <tr>
                            <td>Grand total</td>
                            <td id="grandTotal">R <%= String.format("%.2f", subtotal + deliveryfee)%></td> <!-- Display initial grand total -->
                        </tr>
                        <%
                            session.setAttribute("amount", subtotal);
                            session.setAttribute("totalQuantity", totalQuantity); // Set total quantity in session
                            session.setAttribute("Delivery", deliveryfee); // Set total quantity in session
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
        <footer class="footer">
        </footer>
                        
        <% if (error != null && !error.isEmpty()) { %>
                            <div class="error-message" color="red">
                                <%= error %>
                            </div>
        <% } %>  
                       
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
