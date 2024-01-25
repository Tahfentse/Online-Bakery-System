/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Train
 */
public class AddRecipeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String ingredientSizes = request.getParameter("ingredientSizes");
        String instructions = request.getParameter("instructions");

        // Print out the association for demonstration purposes
        String[] ingredientArray = ingredients.split(", ");
        String[] sizeArray = ingredientSizes.split(", ");

        System.out.println("Recipe Name: " + name);
        for (int i = 0; i < ingredientArray.length; i++) {
            String ingredient = ingredientArray[i].trim();
            String size = sizeArray.length > i ? sizeArray[i].trim() : "N/A";
            System.out.println("Ingredient: " + ingredient + ", Size: " + size);
        }
        System.out.println("Instructions: " + instructions);

        response.sendRedirect("success.jsp");
    }

}
