<%-- 
    Document   : addItem
    Created on : Jan 25, 2024, 9:13:27 AM
    Author     : Train
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
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
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                margin-top: 5%;
            }

            label {
                display: block;
                margin-bottom: 8px;
            }

            select, input {
                width: 100%;
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border: none;
                border-radius: 4px;
                background-color: #eee;
            }

            button {
                background-color: #D91E36; /* Cherry Red */
                color: #FFF;
                padding: 15px 30px;
                border: none;
                border-radius: 5px;
                font-size: 18px;
                cursor: pointer;
            }
            .error {
                color: red;
            </style>
        </head>
        <body>
            <form onsubmit="return validateForm();" action="AdminController" method="post" enctype="multipart/form-data" >


                <label for="add_item"><h1>ADD ITEM</h1></label>
                <br>
                <label for="item_title">Title </label>
                <input type="text" id="item_title" name="item_title" required>

                <label for="item_description">Description </label>
                <input type="text" id="item_description" name="item_description" required>

                <label for="item_nutrients">Nutrients </label>
                <input type="text" id="item_nutrients" name="item_nutrients" required>

                <label for="Catergory">Catergory</label>
                <select id="Catergory" name="item_category">
                    <option value=1>Cookies</option>
                    <option value=2>Cake</option>
                    <option value=3>Bread</option>
                </select>

                <label for="price">Price </label>
                <input type="number" id="item_price" name="item_price" required>


                <label for="add_recipe"><h1> ADD RECIPE </h1></label>


                <label for="ingredients">Ingredients:</label>
                <select id="ingredients" name="ingredients[]" size="1" multiple required>
                    <option value="Flour">Flour</option>
                    <option value="Sugar">Sugar</option>
                    <option value="Eggs">Eggs</option>
                </select><br>


                <label for="ingredientSizes">Ingredient Sizes:</label>
                <select id="ingredientSizes" name="ingredientSizes[]" size="1" multiple required>
                    <option value="1 cup">1 cup</option>
                    <option value="2 cups">2 cups</option>
                    <option value="3">3</option>
                </select><br>
                
                <input type="submit" value="select" name="select" />
                
                

                <label> ITEM PICTURE </label>
                <input type="file" name="item_pic" id="image" accept="image/*" required>

                <input type="hidden" name="act" value="additem"/>

                <button type="submit">ADD ITEM</button>

                <<script ></script>
                
            </form>
        </body>
    </html>
