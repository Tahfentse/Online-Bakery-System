<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Recipe</title>
</head>
<body>

    <h2>Add Recipe</h2>

    <form action="AddRecipeServlet" method="post">
        <label for="name">Recipe Name:</label>
        <input type="text" id="name" name="name" required><br>

        <!-- Use separate text areas for ingredients and sizes -->
        <label for="ingredients">Ingredients:</label>
        <textarea id="ingredients" name="ingredients" rows="4" cols="50" required></textarea><br>

        <label for="ingredientSizes">Ingredient Sizes:</label>
        <textarea id="ingredientSizes" name="ingredientSizes" rows="4" cols="50" required></textarea><br>

        <label for="instructions">Instructions:</label>
        <textarea id="instructions" name="instructions" rows="4" cols="50" required></textarea><br>

        <input type="submit" value="Add Recipe">
    </form>

</body>
</html>
