<%@page import="java.util.Base64"%>
<%@page import="za.ac.bakery.model.ShoppingCart"%>
<%@page import="java.util.Map"%>
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
        <link rel="stylesheet" type="text/css" href="css/cart_style.css">
        <link rel="website icon" type="png" href="img/logo.png">
        <title>Shopping Cart</title>
    </head>
    <% Customer customer = (Customer) session.getAttribute("customer"); %>
    <body>


        <header class="header">
            <h2 class="header-title">Your Cart</h2>
        </header>
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
                        <%
                            Map<Integer, ShoppingCart> cartItems = (Map<Integer, ShoppingCart>) session.getAttribute("cartItems");
                            Double totalAmountObj = (Double) session.getAttribute("totalAmount");
                            String error = (String) session.getAttribute("error");
                            double deliveryfee = 50;
                            double subtotal = 0;
                            int totalQuantity = 0;

                            if (cartItems != null && !cartItems.isEmpty()) {
                                double totalAmount = (totalAmountObj != null) ? totalAmountObj : 0.0;

                                for (Map.Entry<Integer, ShoppingCart> entry : cartItems.entrySet()) {
                                    int itemId = entry.getKey();
                                    ShoppingCart cartItem = entry.getValue();
                                    Item item = cartItem.getItem();
                                    int quantity = cartItem.getQuantity();
                                    double itemPrice = item.getItem_price() * quantity;
                                    subtotal += itemPrice;
                                    totalQuantity += quantity;

                                    // Convert byte array to Base64 encoded string
                                    byte[] itemPicBytes = item.getPic() != null ? item.getPic().getBytes(1, (int) item.getPic().length()) : null;
                                    String base64Image = itemPicBytes != null ? Base64.getEncoder().encodeToString(itemPicBytes) : "";
                        %>
                        <tr>
                            <td>
                                <form action="RemoveFromCartServlet" method="post">
                                    <input type="hidden" name="itemId" value="<%= itemId%>">
                                    <input type="hidden" name="qty" value="<%= quantity%>">
                                    <button type="submit" class="button-image">
                                        <img class="button-image" src="img/x-img.png" alt="x sign to remove the product from the cart">
                                    </button>
                                </form>
                            </td>

                            <td><img class="image" src="data:image/jpeg;base64, <%= base64Image%>" alt="Item Picture" width="60px" height="60px"></td>
                            <td><%= item.getItem_title()%></td>
                            <td><%= String.format("%.2f", item.getItem_price())%></td>
                            <td>
                                <div class="section-table__counter">
                                    <form action="RemoveFromCartServlet" method="post">
                                        <input type="hidden" name="itemId" value="<%= itemId%>">
                                        <input type="hidden" name="qty" value="<%= quantity%>">
                                        <button type="submit" class="square">-</button>
                                    </form>
                                    <div class="square" id="quantity_<%= itemId%>"><%= quantity%></div>
                                    <form action="CartServlet" method="get">
                                        <input type="hidden" name="itemId" value="<%= itemId%>">
                                        <input type="hidden" name="qty" value="<%= quantity%>">
                                        <button type="submit" class="square"">+</button>
                                    </form>
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
                            <th>R <%= deliveryfee%></th> 
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
                            <td id="subtotal">R <%= String.format("%.2f", subtotal)%></td> 
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
