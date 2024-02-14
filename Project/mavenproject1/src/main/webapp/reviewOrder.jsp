<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="za.ac.bakery.model.Customer"%>
<%@page import="za.ac.bakery.model.Address"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Checkout</title>
        <link rel="website icon" type="png" href="img/logo.png">
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #FEF7E4;
                color: #5C3D2E;
            }
            .container {
                max-width: 600px;
                margin: auto;
            }
            .address-section, .order-summary {
                border: 1px solid #ccc;
                padding: 20px;
                margin-bottom: 20px;
                box-shadow: 0px 0px 1px 0px rgba(0, 0, 0, 0.75);
                border-radius: 10px;
                overflow: hidden;
                border: none;
            }

            .address-section:hover{
                box-shadow: 0 0 10px rgba(152, 95, 40, 0.5);
            }

            .order-summary:hover{
                box-shadow: 0 0 10px rgba(152, 95, 40, 0.5);
            }

            button {
                background-color: #5C3D2E;
                font: inherit;
                font-size: 18px;
                padding: 0.5rem 1.5rem;
                border: none;
                color: white;
                box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.7);
                transition: box-shadow 0.3s ease;
                border-radius: 10px;
                cursor: pointer;
                margin-right: 22px;
                text-decoration: none;
                display: inline-block;
            }

            button:hover {
                background-color: #985f28;
                box-shadow: 0 4px 23px 14px rgba(152, 95, 40, 0.8);
            }
            .space{
                min-height: 5vh;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <%

                Customer customer = (Customer) session.getAttribute("customer");
                Double amount = (Double) session.getAttribute("amount");
                Double deliveryfee = (Double) session.getAttribute("Delivery");
                int numberOfItems = (Integer) session.getAttribute("totalQuantity");
                Address address = customer.getAddress();
                LocalDateTime date = LocalDateTime.now().plusDays(3);

                // Format the date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd - MMMM - yyyy");
                String formattedDate = date.format(formatter);
            %>

            <h1>Review your order</h1>
            <div class="space"></div

            <section id="delivery-info" class="section delivery-info">
                <div id="delivery-address" style="background-color:#F2E3CC; padding:10px;border-radius: 10px;">
                    <%
                        if (customer != null && !customer.getId_Number().equalsIgnoreCase("0")) {
                    %>                  
                        <p><strong>Street name : <%= address.getStreet_name()%></strong></p>
                        <p>Suburb : <%= address.getSuburb()%></p>
                        <p>Postal code : <%= address.getPostal_code()%></p>                                
                    </div>
                    <br>
                    <button type="button">Change Delivery Address</button>               
                <%} else { %>

                <p>NO CUSTOMER!</p>
                <%}%>
<!--                <div id="delivery-by">
                    <%= formattedDate%>
                    <p>Standard Delivery - Free</p>
                </div>
                <div id="payment-method">
                    <p>EFT With MasterCard</p>
                </div>-->

            <!-- Order Summary Section -->
            <div id="order-summary" class="order-summary">
                <h2>Order Summary</h2>
                <div id="delivery-by">
                    <p>Date: <%= formattedDate%></p>
                </div>
                <p>Number of Items: <%= numberOfItems%></p>
                <p>Delivery: R<%=deliveryfee%></p>
                <hr>
                <p>TO PAY: <%= amount + deliveryfee%></p>
                <button onclick="redirectToCheckout()">Checkout</button>

                🛡️ Secure Checkout
            </div>
        </div>

        <script>
            function redirectToCheckout() {
                // Redirect to checkout.jsp
                window.location.href = "checkout.jsp";
            }
        </script>
    </body>
</html>
