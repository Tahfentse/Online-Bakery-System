<%@page import="za.ac.bakery.model.Ingridient"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.bakery.model.Order"%>
<%@ page import="org.jfree.chart.*" %>
<%@ page import="org.jfree.data.time.*" %>
<%@ page import="org.jfree.data.xy.*" %>
<%@ page import="java.util.*" %>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : analytics
    Created on : Feb 13, 2024, 2:03:21 PM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>2Pie4 Bakery</title>
        <link rel="stylesheet" href="adminstyle.css">
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="website icon" type="png" href="img/logo.png">
        <link rel="shortcut icon" href="./images/logo.png" type="image/x-icon">

    </head>
    <body>
        <h1> Analytics </h1>

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
                <a href="analytics.jsp">
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
        <main>

<%
    List<Order> orders = new ArrayList<>(); // Your list of orders
    
    Order o = new Order();
       Order n = new Order();

       orders.add(o);
       orders.add(n);
    // Create time series for the orders
    TimeSeries seriesWeek = new TimeSeries("Weekly Orders");
    TimeSeries seriesMonth = new TimeSeries("Monthly Orders");

    // Sort the orders by timestamp
    orders.sort(Comparator.comparing(Order::getTimestamp));

    // Variables to keep track of the current week and month
    Week currentWeek = new Week(orders.get(0).getTimestamp());
    Month currentMonth = new Month(orders.get(0).getTimestamp());

    int ordersThisWeek = 0;
    int ordersThisMonth = 0;

    // Iterate over the orders
    for (Order order : orders) {
        Week orderWeek = new Week(order.getTimestamp());
        Month orderMonth = new Month(order.getTimestamp());

        // If the order is from a new week, add the data point for the last week
        if (!orderWeek.equals(currentWeek)) {
            seriesWeek.add(currentWeek, ordersThisWeek);
            currentWeek = orderWeek;
            ordersThisWeek = 0;
        }

        // If the order is from a new month, add the data point for the last month
        if (!orderMonth.equals(currentMonth)) {
            seriesMonth.add(currentMonth, ordersThisMonth);
            currentMonth = orderMonth;
            ordersThisMonth = 0;
        }

        // Count the order
        ordersThisWeek++;
        ordersThisMonth++;
    }

    // Add the last week and month
    seriesWeek.add(currentWeek, ordersThisWeek);
    seriesMonth.add(currentMonth, ordersThisMonth);

    // Create a dataset and add the series to it
    TimeSeriesCollection dataset = new TimeSeriesCollection();
    dataset.addSeries(seriesWeek);
    dataset.addSeries(seriesMonth);

    // Create a chart and display it
    JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Order Graph", "Time", "Number of Orders", dataset);
    ChartFrame frame = new ChartFrame("Order Graph", chart);
    frame.pack();
    frame.setVisible(true);
%>

        </main>


    </body>
</html>
