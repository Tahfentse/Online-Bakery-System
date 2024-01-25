<%-- 
    Document   : Login
    Created on : Jan 22, 2024, 11:51:12 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <link rel="website icon" type="png" href="img/logo.png">
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
            var password = document.getElementById('password').value;
            var email = document.getElementById('email').value;


            // Check if any of the input values contain only white spaces
            if (/^\s*$/.test(password) || /^\s*$/.test(email)) {
                alert('Please enter valid values for all fields.');
                return false;
            }

            // If all inputs are valid, you can submit the form
            return true;
        }
    </script>

    <body>

        <form onsubmit="return validateForm();" action="CustomerController" method="Post" >

            <h2>Sign In</h2>
            <label for="email">E-mail address</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required />   
            <input type="hidden" name="act" value="signin"/>

            <button type="submit">Login</button>

            <p>Don't have an account ? <a href="sign_up.jsp">SIGN UP</a></p>

        </form>
    </body>
</html>
