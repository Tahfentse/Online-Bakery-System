<%-- 
    Document   : Add Address
    Created on : Jan 22, 2024, 11:46:33 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Address</title>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #FEF7E4; /* Vanilla Cream */
            margin: 0;
            padding: 0;
            text-align: center;
            padding: 50px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #FEF7E4;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 10%;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        select, input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: none;
            border-radius: 4px;
            background-color: #eee;
        }

        button {
            background-color: #D91E36; /* Cherry Red */
            color: #FFF;
            padding: 15px 30px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
        }
    </style>
   <script>
        function validateForm() {
            var streetName = document.getElementById('street_name').value;
            var suburb = document.getElementById('suburb').value;
            var postalCode = document.getElementById('postal_code').value;

            // Check if any of the input values contain only white spaces
            if (/^\s*$/.test(streetName) || /^\s*$/.test(suburb) || /^\s*$/.test(postalCode)) {
                alert('Please enter valid values for all fields.');
                return false;
            }

            // If all inputs are valid, you can submit the form
            return true;
        }
    </script>

<body>
    <form onsubmit="return validateForm();">
        <h2>Enter Address Details</h2>
        <label for="email">Street Name:</label>
        <input type="text" id="street_name" name="street_name" required>
        <label for="email">Suburb:</label>
        <input type="text" id="suburb" name="suburb" required>
        <label for="email">Postal Code:</label>
        <input type="text" id="postal_code" name="postal_code" required>
        
        <button type="submit">Finish</button>
    </form>
</body>
</html>
