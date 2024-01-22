<%-- 
    Document   : AddAddress
    Created on : Jan 22, 2024, 8:57:48 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Address</title>
    </head>
    <body>
        <div class="container">
            <form class="address-form" action="controller" method="POST">
               

                <label for="houseNumber">House Number:</label>
                <input type="number" id="houseNumber" name="houseNumber" required>
                <br><br>

                <label for="streetName">Street Name:</label>
                <input type="text" id="streetName" name="streetName" required>
                <br><br>

                <label for="town">Town:</label>
                <input type="text" id="town" name="town" required>
                <br><br>

                <label for="postalCode">Postal Code:</label>
                <input type="text" id="postalCode" name="postalCode" required>
                <br><br>

                <button type="submit"> Add Address</button>

            </form>
           
        </div>
    </body>

</html>

