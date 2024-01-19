/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.Processor;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.bakery.Controller.ProcessRequest;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.Person;
import za.ac.bakery.service.Service;

/**
 *
 * @author Train
 */
public class OrderProcessor extends ProcessRequest {

    private Dbmanager db;
    private Connection con;
    private List<Person> customers;
    private Service service;

    public OrderProcessor(String url, String username, String password) {
        service = new Service(url, username, password);
    }

    @Override
    public void Request(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        String act = request.getParameter("act");
        
        act = act.toLowerCase();
        
        switch(act){
        
            case "getOrder":
                break;
            case "getListOfOrder":
                break;
        }
        
        
        
        
        
    }

}
