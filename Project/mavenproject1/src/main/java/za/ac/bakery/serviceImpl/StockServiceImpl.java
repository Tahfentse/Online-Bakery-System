/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.bakery.serviceImpl;

import za.ac.bakery.daoImpl.StockDaoImpl;

/**
 *
 * @author Train
 */
public class StockServiceImpl {

    private StockDaoImpl stockdao;

    public StockServiceImpl(String url, String username, String password) {

        this.stockdao = new StockDaoImpl(url, username, password);
    }

}
