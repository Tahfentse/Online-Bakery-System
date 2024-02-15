        modified:   Project/mavenproject1/src/main/java/za/ac/bakery/Controller/CartController.java
        modified:   Project/mavenproject1/src/main/java/za/ac/bakery/Controller/CartServlet.java
        modified:   Project/mavenproject1/src/main/java/za/ac/bakery/Controller/CustomerController.java
        modified:   Project/mavenproject1/src/main/java/za/ac/bakery/Controller/StoreController.java
        modified:   Project/mavenproject1/src/main/webapp/checkout.jsp
        modified:   Project/mavenproject1/src/main/webapp/reviewOrder.jsp
        modified:   Project/mavenproject1/src/main/webapp/viewCustomer.jsp

<%-- 
    Document   : viewCustomer
    Created on : Feb 8, 2024, 3:12:43 PM
    Author     : Train
--%>

<%@page import="za.ac.bakery.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <script src="https://kit.fontawesome.com/ad78bb0d17.js" crossorigin="anonymous"></script>
            <link href="css/viewprofilecss.css" rel="stylesheet" type="text/css"/>
    </head>
     <body>
            <%
                Customer customer = (Customer) session.getAttribute("customer");
                
            String name = customer.getName();
            String surname = customer.getSurname();
            String phone = customer.getContact_no();
            String email = customer.getEmail();
            String idNumber = customer.getId_Number();
            String password = customer.getPassword();
        %>
        <div class="container"> 
            <div class="forms">
                <div class="form login">
                    <span class="title"> Profile</span>
                    <form action="CustomerController" method="POST">
                        <div class="input-field">
                        <input type="text" name="idNumber" value="<%=idNumber%>" required/>
                        <i class="fa-solid fa-graduation-cap"></i>
                        </div>
                        <div class="input-field">
                        <input type="text" name="name" value="<%=name%>" required/>
                        <i class="fas fa-user" ></i>
                        </div>
                        <div class="input-field">
                        <input type="text" name="surname" value="<%=surname%>" required/>
                        <i class="fas fa-user" ></i>
                        </div>
                        <div class="input-field">
                        <input type="email" name="email" value="<%=email%>" required/>
                        <i class="fa-solid fa-envelope"></i>
                        </div>
                        <div class="input-field">
                        <input type="text" name="phone" value="<%=phone%>" required/>
                        <i class="fa-solid fa-phone-flip"></i>
                        </div>
                        <div class="input-field">
                        <input type="password" name="password" value="<%=password%>" required/>
                        </div>
                        
                        <input type="hidden" name="act" value="editcustomer">
      
                        <input type="submit" value="Edit" />
                        
                        <a><a href="startuppage.jsp" target="target">Retrun to Store!</a>
                        </div>
                        
                    </form> 
                    
                </div>
                
            </div>
            
        </div>
    </body>
</html>
