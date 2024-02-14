
<%@page import="za.ac.bakery.model.ShoppingCart"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page import="java.util.Base64"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart View</title>
    </head>
   <body>
    <h1>Your Cart</h1>

    <table border="1">
        <thead>
            <tr>
                <th>Remove</th>
                <th>Item Picture</th>
                <th>Item Title</th>
                <th>Item Price</th>
                <th>Qty</th>
           
                
            </tr>
        </thead>
        <tbody>
            <%
            Map<Integer, ShoppingCart> cartItems = (Map<Integer, ShoppingCart>) session.getAttribute("cartItems");
            Double totalAmountObj = (Double) session.getAttribute("totalAmount");
            String error = (String) session.getAttribute("error");

            if (cartItems != null && !cartItems.isEmpty()) {
                double totalAmount = (totalAmountObj != null) ? totalAmountObj : 0.0;

                for (Map.Entry<Integer, ShoppingCart> entry : cartItems.entrySet()) {
                    int itemId = entry.getKey();
                    ShoppingCart cartItem = entry.getValue();
                    Item item = cartItem.getItem();
                    int quantity = cartItem.getQuantity();
                    double subtotal = item.getItem_price() * quantity;
                    
                    // Convert byte array to Base64 encoded string
                    byte[] itemPicBytes = item.getPic()!= null ? item.getPic().getBytes(1, (int)item.getPic().length()) : null;
                    String base64Image = itemPicBytes != null ? Base64.getEncoder().encodeToString(itemPicBytes) : "";
            %>
                    <tr>
                        <td>
                            <form action="RemoveFromCartServlet" method="post">
                                <input type="hidden" name="itemId" value="<%= itemId %>">
                                <input type="hidden" name="qty" value="<%= quantity %>">
                                <button type="submit" class="button-image">
                                        <img class="button-image" src="img/x-img.png" alt="x sign to remove the product from the cart">
                                    </button>
                            </form>
                        </td>
                        <td><img class="image" src="data:image/jpeg;base64, <%= base64Image %>" alt="Item Picture" width="60px" height="60px"></td>
                        <td><%= item.getItem_title() %></td>
                        <td><%= String.format("%.2f",item.getItem_price()) %></td>
                        <td>
                        <div class="section-table__counter">
                            <button class="square" onclick="updateQuantity(<%= itemId%>, <%= item.getItem_price()%>, 'decrease')">-</button>
                            <div class="square" id="quantity_<%= itemId%>"><%= quantity%></div>
                            <button class="square" onclick="updateQuantity(<%= itemId%>, <%= item.getItem_price()%>, 'increase')">+</button>
                        </div>
                    </td>
                       
                        
                    </tr>
            <% }
            %>
        </tbody>
<!--        <tfoot>
            <tr>
                <td colspan="4">Total Amount:</td>
                <td><span name="totalAmount" id="totalAmount"><%= totalAmount %></span></td>
                <td></td>
            </tr>
            <tr>
                <td colspan="6">
                    <a href="javascript:void(0);" class="checkout-button" onclick="checkout()">Checkout</a>
                </td>
            </tr>
        </tfoot>-->
        
    </table>
                <% } else { %>
            <tr>
                <td colspan="6">Your cart is empty.</td>
            </tr>
        <% } %>

    <!-- Display error messages if any -->
    <% if (error != null && !error.isEmpty()) { %>
        <p>Error: <%= error %></p>
    <% } %>
</body>
</html>
