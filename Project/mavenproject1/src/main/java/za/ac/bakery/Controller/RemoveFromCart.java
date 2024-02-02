
package za.ac.bakery.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.OrderItemCart;
import za.ac.bakery.serviceImpl.AdminServiceImpl;
import za.ac.bakery.serviceImpl.CartServiceImpl;
import za.ac.bakery.service.CartService;
import za.ac.bakery.serviceImpl.StoreServiceImpl;


@WebServlet(name = "RemoveToCart", urlPatterns = {"/RemoveToCart"})
public class RemoveFromCart extends HttpServlet {

  
    private final CartServiceImpl cartservice;
    private final StoreServiceImpl admindao;
    
    public RemoveFromCart() {
         this.cartservice = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
         this.admindao = new StoreServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");

        } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int itemId = Integer.parseInt(request.getParameter("itemId"));

            HttpSession session = request.getSession(true);

            CartService userCart = (CartService) session.getAttribute("userCart");

            if (userCart == null) {
                userCart = new CartServiceImpl("jdbc:mysql://localhost:3306/bakery-systemdb", "root", "root");
                session.setAttribute("userCart", userCart);
            }

            
            Item item = admindao.getItem(itemId);

            boolean removedFromCart = cartservice.removeFromCart(item);

            if (removedFromCart) {
                response.getWriter().println("Item removed from cart successfully");
            } else {
                response.getWriter().println("Failed to remove item from cart. Item may not be in the cart.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Invalid item ID. Please provide a valid numeric item ID.");
        } catch (IOException e) {
            response.getWriter().println("An error occurred while processing your request.");
            
        }
    }
}