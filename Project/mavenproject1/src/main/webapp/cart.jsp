<%-- 
    Document   : cart
    Created on : Jan 19, 2024, 1:48:53 PM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Cart View</title>
   <link rel="website icon" type="png" href="img/logo.png">
  <style>
   
  </style>
</head>
 <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #FEF7E4; 
    }

    h1 {
      text-align: center;
      color: #5C3D2E; 
    }

    table {
      width: 80%;
      margin: 20px auto;
      border-collapse: collapse;
      background-color:  #F2E3CC; 
    }

    th, td {
      padding: 15px;
      text-align: left;
      border-bottom: 1px solid #5C3D2E; 
      color: #5C3D2E; 
    }

    th {
      background-color:  #F2E3CC; 
      color: #FFF; 
    }

    tfoot td {
      font-weight: bold;
      background-color:  #F2E3CC; 
      color: #5C3D2E; 
    }
    
    .checkout-button {
      display: block;
      margin: 20px auto;
      padding: 10px 20px;
      width: 200px; /* Set initial width */
      background-color: #DC143C; /* Cherry Red color */
      color: #FFF;
      text-decoration: none;
      text-align: center;
      border-radius: 5px;
    }

    /* Media query for screens with a max width of 600px */
    @media (max-width: 600px) {
      table {
        width: 90%; /* Set table width to 100% on smaller screens */
      }

      .checkout-button {
        width: 30%; /* Set button width to 100% on smaller screens */
      }
    }
  </style>
<body>
  <h1>Cart View</h1>
  
  <table>
    <thead>
      <tr>
        <th>Item</th>
        <th>Price</th>
        <th>Quantity</th>
      </tr>
    </thead>
    <tbody>
 
    </tbody>
    <tfoot>
      <tr>
        <td colspan="2">Total:</td>
        <td></td>
      </tr>
    </tfoot>
  </table>
  
  <a href="#" class="checkout-button">Checkout</a>
  
  
</body>
</html>
