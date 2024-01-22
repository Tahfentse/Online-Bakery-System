<%-- 
    Document   : sign_in_and_out
    Created on : Jan 19, 2024, 2:30:11 PM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Sign in/up Form</title>
        <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'><link rel="stylesheet" href="./style.css">

    </head>
    <body>
        <!-- partial:index.partial.html -->
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="CustomerController" method="Post">
                    <h1>Create Account</h1>


                    <p>Title <select name ="title" size='1'>
                            <option value='1'>Mr</option>
                            <option value='2'>Ms</option>
                            <option value='3'>Miss</option>
                            <option value='4'>Mrs</option>
                            <option value='5'>Dr</option>
                        </select>
                    </p>
                    <input type="text" name="id" placeholder="ID/Passport" />
                    <input type="text" name="name" placeholder="Name" />
                    <input type="text" name="surname" placeholder="Surname" />
                    <input type="text" name="contactno" placeholder="Contact No" />
                    <input type="email" name="email" placeholder="Email" />
                    <input type="password" name="password" placeholder="Password" />
                    <input type="password" name="verifypassword" placeholder="Confirm Password" />
                    <button>Sign Up</button>
                    <input text="hidden" value="signup" name="act">
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="#">
                    <h1>Sign in</h1>
                    <input type="email" placeholder="Email" />
                    <input type="password" placeholder="Password" />
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
                        <button class="ghost" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- partial -->
        <script  src="./script.js"></script>

    </body>
</html>
