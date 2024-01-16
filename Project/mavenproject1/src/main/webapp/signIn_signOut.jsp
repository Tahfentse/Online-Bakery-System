<%-- 
    Document   : signIn_signOut
    Created on : Jan 16, 2024, 11:55:13 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Sign In/Up</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'>
  <link rel="stylesheet" href="./style.css">

</head>
<style>
        * {
	box-sizing: border-box;
        }

        body {
                background: #f6f5f7;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                font-family: 'Montserrat', sans-serif;
                height: 100vh;
                margin: -20px 0 50px;
        }

        h1 {
                font-weight: bold;
                margin: 0;
        }

        h2 {
                text-align: center;
        }


        span {
                font-size: 12px;
        }

        a {
                color: #333;
                font-size: 14px;
                text-decoration: none;
                margin: 15px 0;
        }

        button {
                border-radius: 20px;
                border: 1px solid #FF4B2B;
                background-color: #FF4B2B;
                color: #FFFFFF;
                font-size: 12px;
                font-weight: bold;
                padding: 12px 45px;
                letter-spacing: 1px;
                text-transform: uppercase;
                transition: transform 80ms ease-in;
        }

        button:active {
                transform: scale(0.95);
        }

        button:focus {
                outline: none;
        }

        button.ghost {
                background-color: transparent;
                border-color: #FFFFFF;
        }

        form {
                background-color: #FFFFFF;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                padding: 0 50px;
                height: 100%;
                text-align: center;
        }

        input {
                background-color: #eee;
                border: none;
                padding: 12px 15px;
                margin: 8px 0;
                width: 100%;
        }

        .p {
                background-color: #eee;
                border: none;
                padding: 12px 15px;
                margin: 8px 0;
                width: 100%;
        }

        .container {
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 14px 28px rgba(0,0,0,0.25), 
                                0 10px 10px rgba(0,0,0,0.22);
                position: relative;
                overflow: hidden;
                width: 768px;
                max-width: 100%;
                min-height: 750px;
        }

        .form-container {
                position: absolute;
                top: 0;
                height: 100%;
                transition: all 0.6s ease-in-out;
        }

        .sign-in-container {
                left: 0;
                width: 50%;
                z-index: 2;
        }

        .container.right-panel-active .sign-in-container {
                transform: translateX(100%);
        }

        .sign-up-container {
                left: 0;
                width: 50%;
                opacity: 0;
                z-index: 1;
        }

        .container.right-panel-active .sign-up-container {
                transform: translateX(100%);
                opacity: 1;
                z-index: 5;
                animation: show 0.6s;
        }

        @keyframes show {
                0%, 49.99% {
                        opacity: 0;
                        z-index: 1;
                }

                50%, 100% {
                        opacity: 1;
                        z-index: 5;
                }
        }

        .overlay-container {
                position: absolute;
                top: 0;
                left: 50%;
                width: 50%;
                height: 100%;
                overflow: hidden;
                transition: transform 0.6s ease-in-out;
                z-index: 100;
        }

        .container.right-panel-active .overlay-container{
                transform: translateX(-100%);
        }

        .overlay {
                background: #FF416C;
                background: -webkit-linear-gradient(to right, #FF4B2B, #FF416C);
                background: linear-gradient(to right, #FF4B2B, #FF416C);
                background-repeat: no-repeat;
                background-size: cover;
                background-position: 0 0;
                color: #FFFFFF;
                position: relative;
                left: -100%;
                height: 100%;
                width: 200%;
                transform: translateX(0);
                transition: transform 0.6s ease-in-out;
        }

        .container.right-panel-active .overlay {
                transform: translateX(50%);
        }

        .overlay-panel {
                position: absolute;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                padding: 0 40px;
                text-align: center;
                top: 0;
                height: 100%;
                width: 50%;
                transform: translateX(0);
                transition: transform 0.6s ease-in-out;
        }

        .overlay-left {
                transform: translateX(-20%);
        }

        .container.right-panel-active .overlay-left {
                transform: translateX(0);
        }

        .overlay-right {
                right: 0;
                transform: translateX(0);
        }

        .container.right-panel-active .overlay-right {
                transform: translateX(20%);
        }

        .social-container {
                margin: 20px 0;
        }

        .social-container a {
                border: 1px solid #DDDDDD;
                border-radius: 50%;
                display: inline-flex;
                justify-content: center;
                align-items: center;
                margin: 0 5px;
                height: 40px;
                width: 40px;
        }
    </style>
<body>

<div class="container" id="container">
	<div class="form-container sign-up-container">
		<form action="#">
			<h1>Create Account</h1>
			
			
                        <p>Title <select name ="" size='1'>
                            <option value='1'>Mr</option>
                            <option value='2'>Ms</option>
                            <option value='3'>Miss</option>
                            <option value='4'>Mrs</option>
                            <option value='5'>Dr</option>
                        </select>
                        </p>
			<input type="text" placeholder="Name" />
			<input type="text" placeholder="Surname" />
                        <input type="text" placeholder="ID/Passport" />
			<input type="text" placeholder="Contact No" />
                        <input type="email" placeholder="Email" />
			<input type="text" placeholder="Address" />
			<input type="password" placeholder="Password" />
			<input type="password" placeholder="Confirm Password" />
			<button>Sign Up</button>
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

    <script>
        const signUpButton = document.getElementById('signUp');
        const signInButton = document.getElementById('signIn');
        const container = document.getElementById('container');

        signUpButton.addEventListener('click', () => {
                container.classList.add("right-panel-active");
        });

        signInButton.addEventListener('click', () => {
                container.classList.remove("right-panel-active");
        });
    </script>

</body>
</html>
