<%-- 
    Document   : viewAllCustomers
    Created on : Feb 9, 2024, 2:17:42 PM
    Author     : Train
--%>

<%@page import="za.ac.bakery.model.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LIST OF CUSTOMERS</h1>

        <%
            List<Customer> customers = (List<Customer>) session.getAttribute("customers");

            if (!customers.isEmpty()) {
        %>
        <table style="background-color: #ffcc99; padding: 10px; border-collapse: collapse;">
            <thead>
                <tr>
                    <th><strong>Name</strong></th>
                    <th><strong>Surname</strong></th>
                    <th><strong>Email</strong></th>
                    <th><strong>Contact No</strong></th>
                    <th><strong>Title</strong></th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < customers.size(); i++) {
                        Customer customer = customers.get(i);
                %>
                <tr>
                    <td><%= customer.getName()%></td>
                    <td><%= customer.getSurname()%></td>
                    <td><%= customer.getEmail()%></td>
                    <td><%= customer.getContact_no()%></td>
                    <td><%= customer.getTitle()%></td>
                </tr>
                <% }%>


                <% } else {%>

                <tr>
                    <td>NO CUSTOMER YET!</td>
                </tr>

                <%}%>


            </tbody>
        </table>

    </body>
</html>
