<%-- 
    Document   : adminpage
    Created on : Feb 8, 2024, 1:51:02 PM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>2Pie4 Bakery</title>
        <link rel="stylesheet" href="adminstyle.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="shortcut icon" href="./images/logo.png" type="image/x-icon">
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
                    <a href="#">
                        <span><i class="uil uil-apps"></i></span>
                        <h3>Dashboard</h3>
                    </a>
                    <a href="#">
                        <span><i class="uil uil-user"></i></span>
                        <h3>Customers</h3>
                    </a>
                    <a href="#">
                        <span><i class="uil uil-shopping-cart-alt"></i></span>
                        <h3>Orders</h3>
                    </a>
                    <a href="#">
                        <span><i class="uil uil-analytics"></i></span>
                        <h3>Analytics</h3>
                    </a>
                    <a href="#">
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
                    <a href="#">
                        <span><i class="uil uil-plus"></i></span>
                        <h3>Add Product</h3>
                    </a>
                    <!-- logout -->
                    <a href="#">
                        <span><i class="uil uil-signout"></i></span>
                        <h3>Logout</h3>
                    </a>
                </div>
            </aside>
            <!--=============== aside end ===============-->

            <!--=============== main start ===============-->
            <main>
                <h1>Dashboard</h1>
                <!--===== insights start =====-->
                <div class="insights">
                    <!-- sales -->
                    <div class="sales">
                        <span><i class="uil uil-chart-line"></i></span>

                        <div class="middle">
                            <div class="left">
                                <h3>Total Sales</h3>
                                <h1>$44,589</h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle cx="38" cy="38" r="36"></circle>
                                </svg>
                                <div class="number">90%</div>
                            </div>
                        </div>

                        <small class="text-muted">Last 24 Hours</small>
                    </div>
                    <!-- expenses -->
                    <div class="expenses">
                        <span><i class="uil uil-chart-growth-alt"></i></span>

                        <div class="middle">
                            <div class="left">
                                <h3>Total Expense</h3>
                                <h1>$22,321</h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle cx="38" cy="38" r="36"></circle>
                                </svg>
                                <div class="number">75%</div>
                            </div>
                        </div>

                        <small class="text-muted">Last 24 Hours</small>
                    </div>
                    <!-- income -->
                    <div class="income">
                        <span><i class="uil uil-arrow-growth"></i></span>

                        <div class="middle">
                            <div class="left">
                                <h3>Total Income</h3>
                                <h1>$20,021</h1>
                            </div>
                            <div class="progress">
                                <svg>
                                <circle cx="38" cy="38" r="36"></circle>
                                </svg>
                                <div class="number">60%</div>
                            </div>
                        </div>

                        <small class="text-muted">Last 24 Hours</small>
                    </div>
                </div>
                <!--===== insights end =====-->


                <!--===== recent orders start =====-->
                <div class="recent-orders">
                    <h2>Recent Orders</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Product ID</th>
                                <th>Payment</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Due</td>
                                <td class="danger">Pending</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Due</td>
                                <td class="danger">Pending</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Due</td>
                                <td class="danger">Pending</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Paid</td>
                                <td class="success">Shipped</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Due</td>
                                <td class="danger">Pending</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Due</td>
                                <td class="danger">Pending</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Due</td>
                                <td class="warning">Processing</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Due</td>
                                <td class="danger">Pending</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Due</td>
                                <td class="danger">Pending</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Paid</td>
                                <td class="success">Shipped</td>
                            </tr>
                            <tr>
                                <td>Sony DSLR Camera</td>
                                <td>524589</td>
                                <td>Paid</td>
                                <td class="success">Shipped</td>
                            </tr>
                        </tbody>
                    </table>
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

                <!--===== analytics start =====-->
                <div class="analytics">
                    <h2>Analytics</h2>

                    <div class="item online">
                        <div class="icon">
                            <span><i class="uil uil-shopping-bag"></i></span>
                        </div>
                        <div class="right">
                            <div class="info">
                                <h3>ONLINE ORDERS</h3>
                                <small class="text-muted">Last 24 Hours</small>
                            </div>
                            <h5 class="success">+25%</h5>
                            <h3>1250</h3>
                        </div>
                    </div>

                    <div class="item customers">
                        <div class="icon">
                            <span><i class="uil uil-user"></i></span>
                        </div>
                        <div class="right">
                            <div class="info">
                                <h3>NEW CUSTOMERS</h3>
                                <small class="text-muted">Last 24 Hours</small>
                            </div>
                            <h5 class="success">+30%</h5>
                            <h3>350</h3>
                        </div>
                    </div>

                    <div class="item add-product">
                        <div>
                            <span><i class="uil uil-plus"></i></span>
                            <h3>Add Product</h3>
                        </div>
                    </div>
                </div>
                <!--=============== right end ===============-->
            </div>
            </div>
    </body>

</html>
