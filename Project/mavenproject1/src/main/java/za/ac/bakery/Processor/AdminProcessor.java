/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.Processor;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import za.ac.bakery.Controller.ProcessRequest;
import za.ac.bakery.daoImpl.AdminDaoImpl;
import za.ac.bakery.daoImpl.CustomerDaoImpl;
import za.ac.bakery.databaseManager.Dbmanager;
import za.ac.bakery.model.Ingridient;
import za.ac.bakery.model.Item;
import za.ac.bakery.model.Person;

import za.ac.bakery.service.CustomerService;
import za.ac.bakery.serviceImpl.AdminServiceImpl;

/**
 *
 * @author Train
 */
public class AdminProcessor extends ProcessRequest {

    private Dbmanager db;
    private Connection con;
    private List<Person> customers;
    private AdminServiceImpl service;

    public AdminProcessor(String url, String username, String password) {
        service = new AdminServiceImpl(url, username, password);
    }

    @Override
    public void Request(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        String act = request.getParameter("");
        act = act.toLowerCase();

        switch (act) {
            case "createadmin":
                break;

            case "getadmin":
                break;

            case "updateAdmin":
                break;

            case "deleteadmin":
                break;

            case "additem":
                break;

            case "getItem":
                break;

            case "listofitem":
                break;

            case "deleteItem":
                break;

            case "addSpecialToItem":
                break;
        }
    }

}
