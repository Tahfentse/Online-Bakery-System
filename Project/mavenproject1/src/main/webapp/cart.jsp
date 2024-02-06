<%-- 
    Document   : cart_test
    Created on : Feb 2, 2024, 8:35:42 AM
    Author     : Train
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="za.ac.bakery.model.OrderItemCart"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page import="za.ac.bakery.service.CartService"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
</head>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #FEF7E4;
        }

        h1 {
            text-align: center;
            color: #5C3D2E;
            font-size: 30px;
            margin-top: 10px;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #F2E3CC;
        }

        th,
        td {
            padding: 15px;
            text-align: left;
            color: #5C3D2E;
            font-size: 25px;
        }

        th {
            background-color: #F2E3CC;
            color: #FFF;
        }

        tfoot td {
            font-weight: bold;
            background-color: #F2E3CC;
            color: #5C3D2E;
        }

        .checkout-button,
        .remove-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #8B4513; /* Brown color */
            color: #FFF;
            text-decoration: none;
            text-align: center;
            border-radius: 5px;
            cursor: pointer;
            font-size: 20px;
            margin-top: 10px;
        }

        .checkout-button {
            margin-left: 20px;
        }

        .adjust-button
         {
            display: inline-block;
            padding: 10px 20px;
            background-color: #8B4513; /* Brown color */
            color: #FFF;
            text-decoration: none;
            text-align: center;
            cursor: pointer;
            font-size: 20px;
            margin-top: 10px;
        }

        @media (max-width: 600px) {
            table {
                width: 70%;
            }

            th,
            td {
                font-size: 15px; /* Adjust the font size for smaller text */
            }
            
            .adjust-button,
            .remove-button{
                width: 30%;
                margin: 5px 0;
            }

            .checkout-button
            {
                width: 20%;
                padding: 8px 15px; /* Adjust the padding for smaller buttons */
                font-size: 14px; /* Adjust the font size for smaller text */
                margin: 10px 0;
            }

            .checkout-button {
                margin-left: 0;
            }
        }
        

       
    </style>
<body>

<h1>Your Cart</h1>

    <%
    Map<Integer, OrderItemCart> cartItems = (Map<Integer, OrderItemCart>) session.getAttribute("cartItems");
    double totalAmount = (Double) session.getAttribute("totalAmount");

    if (cartItems != null && !cartItems.isEmpty()) {
    %>
    <table border="1" class="cart-table">
        <thead>
            <tr>
                <th>Item Title</th>
                <th>Item Price</th>
                <th>Quantity</th>
                <th>Remove</th>
                <th>Subtotal Price</th>
            </tr>
        </thead>
        <tbody>
            <%
            for (Map.Entry<Integer, OrderItemCart> entry : cartItems.entrySet()) {
                OrderItemCart orderItemCart = entry.getValue();
                Item item = orderItemCart.getItem();
                double subtotal = item.getItem_price() * orderItemCart.getOrderitem_qty();
            %>
            <tr>
                <td><%= item.getItem_title() %></td>
                <td><%= item.getItem_price() %></td>
                <td>
                    <form onsubmit="adjustQuantity(event, '<%= item.getItem_id() %>', <%= item.getItem_price() %>, <%= subtotal %>); return false;">
                        <button class="adjust-button" type="button"
                            onclick="adjustQuantityAction('<%= item.getItem_id() %>', 'increase', <%= item.getItem_price() %>);">+</button>
                        <span name="quantity" id="quantity_<%= item.getItem_id() %>"><%= orderItemCart.getOrderitem_qty() %></span>
                        <button class="adjust-button" type="button"
                            onclick="adjustQuantityAction('<%= item.getItem_id() %>', 'decrease', <%= item.getItem_price() %>);">-</button>
                    </form>
                </td>
                <td>
                    <button class="remove-button"  type="button"
                        onclick="removeItem('<%= item.getItem_id() %>', <%= item.getItem_price() %>);">Remove</button>
                </td>
                <td name="subtotal" id="subtotal_<%= item.getItem_id() %>"><%= subtotal %></td>
            </tr>
            <%
            }
            %>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="4">Total Amount:</td>
                <td><span name="totalAmount" id="totalAmount"><%= totalAmount %></span></td>
            </tr>
            <tr>
                <td colspan="5">
                    <a href="javascript:void(0);" class="checkout-button" onclick="checkout()">Checkout</a>
                </td>
            </tr>
        </tfoot>
    </table>

    <%
    } else {
        out.println("<p>Your cart is empty.</p>");
    }
    %>

    <script>
    function adjustQuantityAction(itemId, action, itemPrice) {
        var quantitySpan = document.getElementById("quantity_" + itemId);
        var currentQuantity = parseInt(quantitySpan.innerText);
        var subtotalCell = document.getElementById("subtotal_" + itemId);
        var currentSubtotal = parseFloat(subtotalCell.innerText);

        if (action === 'increase') {
            currentQuantity += 1;
        } else if (action === 'decrease' && currentQuantity > 1) {
            currentQuantity -= 1;
        }

        quantitySpan.innerText = currentQuantity;

        // Update Subtotal
        var newSubtotal = currentQuantity * itemPrice;
        subtotalCell.innerText = newSubtotal.toFixed(2);

        // Update Total Amount
        updateTotalAmount();
    }

    function removeItem(itemId, itemPrice) {
        var quantitySpan = document.getElementById("quantity_" + itemId);
        var currentQuantity = parseInt(quantitySpan.innerText);
        var subtotalCell = document.getElementById("subtotal_" + itemId);

        // Remove the entire row from the table
        var row = quantitySpan.closest('tr');
        row.remove();

        // Update Total Amount after removing the item
        updateTotalAmount();
    }

    function updateTotalAmount() {
        var totalAmountElement = document.getElementById("totalAmount");
        var subtotals = document.querySelectorAll("[id^='subtotal_']");
        var totalAmount = 0;

        subtotals.forEach(function(subtotal) {
            totalAmount += parseFloat(subtotal.innerText);
        });

        totalAmountElement.innerText = totalAmount.toFixed(2);
    }

    function adjustQuantity(event, itemId, itemPrice, currentSubtotal) {
        event.preventDefault();
    }
    
    function checkout() {
    
        var totalAmountElement = document.getElementById("totalAmount");
        var totalAmount = parseFloat(totalAmountElement.innerText);

        if (totalAmount === 0) {
           
            alert("Your cart is empty. Cannot proceed to checkout.");
        } else {
            
                window.location.href = 'checkout.jsp'; // Replace 'checkout.jsp' with the actual path to your JSP page
            }
        }
    
</script>

    

</body>
</html>