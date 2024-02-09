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
        <title>Order Review - Takealot</title>
        <style>
            /* CSS to style the layout */
            .container {
                display: flex;
                justify-content: center; /* Centering the container */
                align-items: flex-start; /* Aligning items to the top */
            }
            .section {
                flex: 1;
                margin-right: 20px;
            }
            .delivery-info {
                flex: 1; /* Take remaining space */
                max-width: 400px; /* Limit width if needed */
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Takealot Logo</h1>
            <nav>
                <!-- Navigation links -->
            </nav>
            <div>
                <!-- User account options -->
            </div>
        </header>
        <main>
            <%

                Customer customer = (Customer) session.getAttribute("customer");
                Double amount = (Double) session.getAttribute("amount");
                int numberOfItems = (Integer) session.getAttribute("totalQuantity");
                Address address = customer.getAddress();
                LocalDateTime date = LocalDateTime.now().plusDays(3);

                // Format the date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd - MMMM - yyyy");
                String formattedDate = date.format(formatter);
            %>
            <div class="container">
                <section id="delivery-info" class="section delivery-info">
                    <h2>Review your order</h2>
                    <div id="delivery-address">
                        <%
                        if (customer != null && !customer.getId_Number().equalsIgnoreCase("0")){
                        %>
                        <h1>RESIDENTIAL</h1>
                        <p>Street name : <%= address.getStreet_name()%></p>
                        <p>Suburb : <%= address.getSuburb()%></p>
                        <p>Postal code : <%= address.getPostal_code()%></p>
                    </div>
                    <%}else{ %>
                    
                    <p>NO CUSTOMER!</p>
                    <%}%>
                    <div id="delivery-by">
                        <%= formattedDate%>
                        <p>Standard Delivery - Free</p>
                    </div>
                    <div id="payment-method">
                        <p>EFT With MasterCard</p>
                    </div>
                </section>
                <section id="order-summary" class="section">
                    <h2>Order Summary</h2>
                    <p>Number of Items: <%= numberOfItems%></p>
                    <p>Delivery: R26.50</p>
                    <p><input type="checkbox" name="donate"/>Donate R5 to Reefentse Children's Charity</p>

                    <p>TO PAY: <%= amount%></p>
                    <button onclick="redirectToCheckout()">PAY NOW</button>

                </section>
            </div>
        </main>
                    
<script>
function redirectToCheckout() {
    // Redirect to checkout.jsp
    window.location.href = "checkout.jsp";
}
</script>
    </body>
</html>
