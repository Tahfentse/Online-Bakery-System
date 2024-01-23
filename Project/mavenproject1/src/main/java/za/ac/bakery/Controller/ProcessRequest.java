/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Train
 */
public abstract class ProcessRequest {
    
    public abstract void Request(HttpServletRequest request, HttpServletResponse response, HttpSession session);

    public void response(HttpServletRequest request, HttpServletResponse response, String path) {

        try {
            request.getRequestDispatcher(path).forward(request, response);
        } catch (ServletException ex) {
            System.err.println("Error : " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error : " + ex.getMessage());
        }

    }
}
