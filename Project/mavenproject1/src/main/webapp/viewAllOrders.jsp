<%@page import="za.ac.bakery.model.Order"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>List Orders</title>
        <style>
            table {
                width: 50%;
                margin: 0 auto; /* Centers the table horizontally */
                border-collapse: collapse;
            }

            th, td {
                border: 1px solid black;
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h1>List Orders</h1>
        <%
            List<Order> orders = (List<Order>) session.getAttribute("orders");
            if (orders != null && !orders.isEmpty()) {
        %>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Order Name</th>
                    <th>Timestamp</th>
                </tr>
            </thead>
            <tbody>
                <% for (Order order : orders) {%>
                <tr>
                    <td><%= order.getOrderId()%></td>
                    <td><%= order.getOrderName()%></td>
                    <td><%= order.getTimestamp()%></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <% } else { %>
        <p>No orders available</p>
        <% }%>
    </body>
</html>
