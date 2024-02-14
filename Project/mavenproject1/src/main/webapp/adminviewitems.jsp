<%-- 
    Document   : adminviewitems
    Created on : Feb 12, 2024, 11:45:50 AM
    Author     : Train
--%>

<%@page import="java.sql.Blob"%>
<%@page import="za.ac.bakery.model.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>2Pie4 Bakery</title>
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="stylesheet" href="adminstyle.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="shortcut icon" href="./images/logo.png" type="image/x-icon">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">

    </head>

    <body>
        <div class="container">
            <!--=============== aside start ===============-->
            <aside>
                <div class="logo">
                    <a href="startuppage.jsp#home" class="logo"> 2<i class="fas fa-chart-pie"></i> 4</a>
                </div>
                <!-- sidebar -->
                <div class="sidebar">
                    <a href="adminviewitems.jsp#home">
                        <span><i class="uil uil-apps"></i></span>
                        <h3>Dashboard</h3>
                    </a>

                    <a href="viewAllCustomers.jsp">
                        <span><i class="uil uil-user"></i></span>
                        <h3>Customers</h3>
                    </a>

                    <a href="viewAllOrders.jsp">
                        <span><i class="uil uil-shopping-cart-alt"></i></span>
                        <h3>Orders</h3>
                    </a>
                    <a href="#">
                        <span><i class="uil uil-analytics"></i></span>
                        <h3>Analytics</h3>
                    </a>
                    <a href="adminviewitems.jsp">
                        <span><i class="uil uil-ankh"></i></span>
                        <h3>Products</h3>
                    </a>
                    <a href="#">
                        <span><i class="uil uil-exclamation-triangle"></i></span>
                        <h3>Reports</h3>
                    </a>
                    <a href="#">
                        <span><i class="uil uil-setting"></i></span>
                        <h3>Settings</h3>
                    </a>
                    <a href="addItem.jsp">
                        <span><i class="uil uil-plus"></i></span>
                        <h3>Add Product</h3>
                    </a>
                    <!-- logout -->
                    <a href="s">

                        <span><i class="uil uil-signout"></i></span>
                        <h3>Logout</h3>
                    </a>
                </div>
            </aside>
            <!--=============== aside end ===============-->

            <!--=============== main start ===============-->
            <main>

                <!--===== insights end =====-->


                <!--===== recent orders start =====-->
                <div class="recent-orders">

                    <section class="products" style="   width: 10%;
                             height: 10%;">
                        <h1 class="title"><span>Products</span></h1>

                        <div class="box-container" style="
                             width: 10%;
                             height: 10%;
                             ">

                            <%
                                List<Item> items = (List<Item>) session.getAttribute("items");

                                for (Item item : items) {
                                    Blob imageBlob = item.getPic();
                                    byte[] imageData = imageBlob.getBytes(1, (int) imageBlob.length());
                                    String base64Image = java.util.Base64.getEncoder().encodeToString(imageData);
                                    String imgSrc = "data:image/png;base64, " + base64Image;
                            %>
                            <div class="box">
                                <div class="icons">

                                    <a href="/mavenproject1/AddToCart?action=GET&quantity=1&itemId=<%=item.getItem_id()%>" class="fas fa-shopping-cart" name="itemId"></a>
                                    <a href="/mavenproject1/StoreController.do?action=GET&act=viewItem&itemid=<%=item.getItem_id()%>" class="fas fa-eye"></a>

                                </div>
                                <div class="img">
                                    <img decoding="async" src="<%= imgSrc%>" alt="Item Image" style="height: 60px;
                                         width: 60px;
                                         ">
                                </div>
                                <div class="content">
                                    <h3><%=item.getItem_title()%></h3>
                                    <div class="price">R<%= item.getItem_price()%></div>
                                    <div class="stars">
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="fas fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </section>
                </div>
                <!--===== recent orders end =====-->
            </main>
            <!--=============== main end ===============-->


            <!--=============== right start ===============-->
            <div class="right">
                <!--===== admin profile start =====-->
                <div class="admin-profile">
                    <div class="info">
                        <p>Hello, <strong>Brad Pitt</strong></p>
                        <small class="text-muted">Admin</small>
                    </div>

                    <div class="profile-photo">
                        <img src="./images/profile-1.jpg" />
                    </div>
                </div>

                    <div class="item add-product" id="add-product">
                        <div>
                            <span><i class="uil uil-plus" class="button"></i></span>
                            <h3>Add Product</h3>
                        </div>
                    </div>
                </div>
                <!--=============== right end ===============-->
            </div>
        </div>
    </body>
    <script >
        document.getElementById("add-product").addEventListener("click", function () {
            window.location.href = "addItem.jsp";
        });

        document.getElementById("view-customer").addEventListener("click", function () {
            window.location.href = "/mavenproject1/AddToCart?action=GET&act=viewallcustomer";
        });




    </script>

</html>
