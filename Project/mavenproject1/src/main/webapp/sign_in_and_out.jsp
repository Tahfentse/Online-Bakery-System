<%-- 
    Document   : sign_in_and_out
    Created on : Jan 19, 2024, 2:30:11 PM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Sign in/up Form</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
        <link rel="stylesheet" href="./style.css">
    </head>
    <body>
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form id="signupForm" action="CustomerController" method="Post">
                    <h1>Create Account</h1>
                    <p>Title 
                        <select name="title" size='1'>
                            <option value='1'>Mr</option>
                            <option value='2'>Ms</option>
                            <option value='3'>Miss</option>
                            <option value='4'>Mrs</option>
                            <option value='5'>Dr</option>
                        </select>
                    </p>
                    <input type="text" name="idPassport" id="idPassport" placeholder="ID/Passport" />
                    <input type="text" name="name" id="name" placeholder="Name" />
                    <input type="text" name="surname" id="surname" placeholder="Surname" />
                    <input type="text" name="contactNo" id="contactNo" placeholder="Contact No"/>
                    <input type="email" name="email" id="email" placeholder="Email" />
                    <input type="password" name="password" id="password" placeholder="Password" />
                    <input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" />
                    <input type="hidden" name="act" value="signup"/>
                    <button type="submit" onclick="validateForm()">Sign Up</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="CustomerController" method="Post">
                    <h1>Sign in</h1>
                    <input type="email" placeholder="Email" />
                    <input type="password" placeholder="Password" />
                    <input type="hidden" name="act" value="login"/>
                    <a href="#">Forgot your password?</a>
                    <button>Sign In</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back!</h1>
                        <p>To keep connected with us please login with your personal info</p>
                        <button class="ghost" id="signIn">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Enter your personal details and start journey with us</p>
                        <button class="ghost" id="signUp" onclick="validateLoginForm()">Sign Up</button>

                    </div>
                </div>
            </div>
        </div>
        <script src="./script.js"></script>
        <script>
                            function validateForm() {
                                var idPassport = document.getElementById('idPassport').value;
                                var name = document.getElementById('name').value;
                                var surname = document.getElementById('surname').value;
                                var contactNo = document.getElementById('contactNo').value;
                                var address = document.getElementById('address').value;
                                var email = document.getElementById('email').value;
                                var password = document.getElementById('password').value;
                                var confirmPassword = document.getElementById('confirmPassword').value;

                                // Check if any of the fields are empty
                                if (!idPassport || !name || !surname || !contactNo || !address || !email || !password || !confirmPassword) {
                                    alert('Please fill in all the fields');
                                    return;
                                }

                                // Simple email validation
                                var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                                if (!emailRegex.test(email)) {
                                    alert('Please enter a valid email address eg user2gmail.com');
                                    return;
                                }

                                // Check if password and confirm password match
                                if (password !== confirmPassword) {
                                    alert('Password and Confirm Password do not match');
                                    return;
                                }

                                // Additional form validation logic can be added here

                                // If all validations pass, you can submit the form
                                document.getElementById('signupForm').submit();
                            }

                            function validateLoginForm() {
                                var loginEmail = document.getElementById('loginEmail').value;
                                var loginPassword = document.getElementById('loginPassword').value;

                                // Check if any of the login fields are empty
                                if (!loginEmail || !loginPassword) {
                                    alert('Please fill in both Email and Password fields');
                                    return;
                                }

                                // Additional login form validation logic can be added here

                                // If all validations pass, you can submit the form
                                document.getElementById('loginForm').submit();
                            }
        </script>
    </body>
</html>
