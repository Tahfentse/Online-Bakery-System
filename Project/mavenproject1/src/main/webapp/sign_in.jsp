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
            border-radius: 10px;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.7);
            margin-top: 10%;
        }
        form:hover{
            box-shadow: 0 0 10px rgba(152, 95, 40, 0.5);
        }

        form h2 {
            font-size: 2rem;
            color: #5C3D2E  /*Chocolate Brown */;
        }
        
        a{
            color: #5C3D2E
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #5C3D2E;
        }

        select,
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
            border: none;
            border-radius: 4px;
            background-color: #eee;
            color: #5C3D2E
        }

        button {
            background-color: #5C3D2E;
            color: #FFF;
            padding: 15px 30px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
            transition: box-shadow 0.3s ease;
            box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.7);
        }
        button:hover{
            background-color: #985f28;
            box-shadow: 0 4px 23px 14px rgba(152, 95, 40, 0.8);
        }

        #forgotPasswordForm {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            /*background: #fff;*/
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            z-index: 1000;
        }
    </style>

    <script>
        function validateLoginForm() {
            var password = document.getElementById('password').value;
            var email = document.getElementById('email').value;
            // Check if any of the input values contain only white spaces
            if (/^\s*$/.test(password) || /^\s*$/.test(email)) {
                alert('Please enter valid values for all fields.');
                return false;
            }
            // If all inputs are valid, you can submit the login form
            return true;
        }

        function validateForgotPasswordForm() {
            var forgotEmail = document.getElementById('forgotEmail').value;
            // Check if the input value contains only white spaces
            if (/^\s*$/.test(forgotEmail)) {
                alert('Please enter a valid email address.');
                return false;
            }
            // If the input is valid, you can submit the forgot password form
            return true;
        }

        function submitLoginForm() {
            if (validateLoginForm()) {
                // Reset fields of the forgot password form
                document.getElementById('forgotEmail').value = '';
                return true;
            }
            return false;
        }

        function submitForgotPasswordForm() {
            if (validateForgotPasswordForm()) {
                // Reset fields of the login form
                document.getElementById('email').value = '';
                document.getElementById('password').value = '';
                return true;
            }
            return false;
        }

        function showForgotPasswordForm() {
            // Hide login form, show forgot password form
            document.getElementById('loginForm').style.display = 'none';
            document.getElementById('forgotPasswordForm').style.display = 'block';
            return false; // Prevent form submission
        }

        function showLoginForm() {
            // Hide forgot password form, show login form
            document.getElementById('forgotPasswordForm').style.display = 'none';
            document.getElementById('loginForm').style.display = 'block';
            return false; // Prevent form submission
        }
    </script>

    <body>

        <form onsubmit="return submitLoginForm();" id="loginForm" action="StoreController.do" method="Get">
            <h2>Sign In</h2>
            <label for="email">E-mail address:</label>
            <input autocorrect="on" autocapitalize="none" autocomplete="off" type="email" id="email" name="email" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required />
            <input type="hidden" name="act" value="signin" />
            <button type="submit" onclick="validateLoginForm();">LOGIN</button>

            <p>Don't have an account ? <a href="sign_up.jsp">SIGN UP</a></p>

            <button  type="button" onclick="showForgotPasswordForm();">Forgot Password?</button>

        </form>

        <div id="forgotPasswordForm">
            
            <form onsubmit="return submitForgotPasswordForm();" action="StoreController.do" method="get">
                <h2>Forgot Password</h2>
                <label for="forgotEmail">Enter your E-mail address</label>
                <input type="email" id="forgotEmail" name="email" required>
                <input type="hidden" name="act" value="forgotpassword" />
                <button type="submit">Submit</button>
            </form>
            <button onclick="showLoginForm()">Cancel</button>
        </div>

    </body>

</html>
