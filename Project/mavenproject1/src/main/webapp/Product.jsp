<%-- 
    Document   : Product
    Created on : Jan 22, 2024, 9:03:50 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
         <link rel="website icon" type="png" href="img/logo.png">
    </head>
    <body>


        <div class="container">
            <div class="add-product-form">
                <h3>Add Product</h3>
                <form id="product-form" onsubmit="submitForm(event)" action="" method="POST">
                    <label>Product Name</label>
                    <input type="text" id="product-name" placeholder="Product Name" required name="productName">
                    <label>Product Image</label>
                    <input type="file" id="product-image" accept="image/*" required name="image">
                    <input type="hidden" id="product-image" name="action" value="add">
                    <label>Product Price</label>
                    <input type="text" id="product-price" value="0.00"  placeholder="Product Price" min="1" required name="price">
                    <label>Product Description</label>
                    <textarea id="Product Nutrient" placeholder="Product Description" required name="productDes"></textarea>
                    <label>Product Nutrient</label>
                    <textarea id="product-NutrientInfo" placeholder="Product Nutrient" required name="productNu"></textarea>
                    <label>Product Warnings</label>
                    <textarea id="product-warnings" placeholder="Product Warnings" required name="productWa"></textarea>
                    <label>Select Category</label>
                    <select name="categoryId">
                        
                    </select>
                    <label>Select Recipe</label>
                    <select name="recipeId">
                        
                      
                    </select>

                    <button type="submit">Add</button>
                </form>
            </div>
           
        </div>




        <script>
            window.addEventListener('DOMContentLoaded', (event) => {
                var numberInput = document.getElementById("numberInput").value;
                var formattedNumber = parseFloat(numberInput).toFixed(2);
                document.getElementById("result").value = formattedNumber;
            });

      

    </script>

</body>
</html>
