<%@page import="java.util.List"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Your Cart</title>
        <style>
            /* Your CSS styles */
        </style>
    </head>
   <body>
<h1>Your Cart</h1>
<%
List<Item> items = (List<Item>) session.getAttribute("items");
if (items != null && !items.isEmpty()) {
    double totalAmount = 0.0; // Initialize totalAmount
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
        for (Item item : items) {
            double subtotal = item.getItem_price() * item.getQty(); // Calculate subtotal using the qty attribute
            totalAmount += subtotal; // Add subtotal to totalAmount
        %>
            <td><%= item.getItem_title()%></td>
            <td><%= item.getItem_price()%></td>
            <td>
                <form onsubmit="adjustQuantity(event, '<%= item.getItem_id()%>', <%= item.getItem_price()%>, <%= subtotal%>); return false;">
                    <button class="adjust-button" type="button"
                            onclick="adjustQuantityAction('<%= item.getItem_id()%>', 'increase', <%= item.getItem_price()%>);">+</button>
                    <span name="quantity" id="quantity_<%= item.getItem_id()%>"><%= item.getQty()%></span>
                    <button class="adjust-button" type="button"
                            onclick="adjustQuantityAction('<%= item.getItem_id()%>', 'decrease', <%= item.getItem_price()%>);">-</button>
                </form>
            </td>
            <td>
                
                <form action="AddToCart" method="get">
                    <input type="hidden" name="itemId" value="<%= item.getItem_id() %>"/>
                    <input type="hidden" name="act" value="removeitem" />
                    <button type="submit">Remove</button> 
                </form>
                    
            </td>
            <td name="subtotal" id="subtotal_<%= item.getItem_id()%>"><%= subtotal%></td>
        </tr>
        <%
        }
        %>
    </tbody>
    <tfoot>
        <tr>
            <td colspan="4">Total Amount:</td>
            <td><span name="totalAmount" id="totalAmount"><%= totalAmount%></span></td>
        </tr>
        <tr>
            <td colspan="5">
                <a href="javascript:void(0);" class="checkout-button" onclick="checkout()">Checkout</a>
            </td>
        </tr>
    </tfoot>
</table>
<%} else {    out.println("<p>Your cart is empty.</p>");}%>
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
    quantitySpan.innerText = currentQuantity; // This line updates the displayed quantity
    var newSubtotal = currentQuantity * itemPrice;
    subtotalCell.innerText = newSubtotal.toFixed(2);
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
        window.location.href = 'checkout.jsp';
    }
}

function removeItem(itemId, itemPrice) {
        // Remove item from the DOM
        var row = document.getElementById("subtotal_" + itemId).parentNode;
        row.parentNode.removeChild(row);

        // Update Total Amount
        updateTotalAmount();

        // Optionally, you might want to send a request to the server to remove the item from the session/cart
        // You can use AJAX for this purpose
    }
</script>
</body>

</html>