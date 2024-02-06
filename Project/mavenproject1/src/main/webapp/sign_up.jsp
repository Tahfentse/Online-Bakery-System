<%-- 
    Document   : Sign Up
    Created on : Jan 22, 2024, 11:28:11 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up</title>
        <link rel="website icon" type="png" href="img/logo.png">
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
                margin-top: 5%;
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

            select, input{
                width: 100%;
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border: none;
                border-radius: 4px;
                background-color: #eee;
                color: #5C3D2E
            }
            
            select .option {
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

            .error {
                color: red;
            </style>

            <script>
                function validateForm() {
                    var title = document.getElementById('title').value;
                    var name = document.getElementById('name').value;
                    var surname = document.getElementById('surname').value;
                    var idNumber = document.getElementById('idNumber').value;
                    var phoneNumber = document.getElementById('phoneNumber').value;
                    var email = document.getElementById('email').value;
                    var password = document.getElementById('password').value;
                    var confirmPassword = document.getElementById('confirmPassword').value;
                    // Check if any of the input values contain only white spaces
                    if (/^\s*$/.test(title) || /^\s*$/.test(name) || /^\s*$/.test(surname) || /^\s*$/.test(idNumber) ||
                            /^\s*$/.test(phoneNumber) || /^\s*$/.test(email) || /^\s*$/.test(password) || /^\s*$/.test(confirmPassword)) {
                        alert('Please enter valid values for all fields.');
                        return false;
                    }
                    // Check if the password and confirm password match
                    if (password !== confirmPassword) {
                        alert('Password and Confirm Password do not match.');
                        return false;
                    }
                    // If all inputs are valid, you can submit the form
                    return true;
                }
            </script>

        <body>
            <form onsubmit="return validateForm();" action="CustomerController"method="Post">


                <label for="customer_info"><h2>CUSTOMER INFO</h2></label>
                <br>
                <label for="title">Title:</label>
                <select id="title" name="title">
                    <option value="Mr.">Mr.</option>
                    <option value="Mrs.">Mrs.</option>
                    <option value="Miss">Miss</option>
                    <option value="Dr">Dr</option>
                </select>

                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="surname">Surname:</label>
                <input type="text" id="surname" name="surname" required>

                <label for="idNumber">ID Number:</label>
                <input type="text" id="idNumber" name="idPassport" required>

                <label for="phoneNumber">Telephone Number (Mobile):</label>
                <input type="tel" id="phoneNumber" name="contactNo" required>

                <label for="email">E-mail address:</label>
                <input type="email" id="email" name="email" required>


                <label for="address_info"><h1>Address Info</h1></label>

                <br>
                <label for="street_name">Street Name:</label>
                <input type="text" id="street_name" name="street_name" required="">

                <label for="suburb">Suburb:</label>
                <input type="text" id="suburb" name="suburb" required=""/>

                <label for="postal_code">Postal code:</label>
                <input type="type" id="postal_code" name="postal_code" required=""/>

                <br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>

                <label for="confirmPassword">Confirm Password:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>

                <input type="hidden" name="act" value="signup"/>

                <button type="submit">Sign Up</button>

                <p>Have an account ? <a href="sign_in.jsp">SIGN IN</a></p>

            </form>
        </body>

    </html>

</html>

