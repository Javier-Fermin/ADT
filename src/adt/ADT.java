/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import businessLogic.BusinessLogic;
import dao.DaoFactory;
import view.ViewFactory;

/**
 * This is the main application for the ADT challenge 0
 * 
 * @author Javier, Imanol, Fran
 */
public class ADT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BusinessLogic bl = new BusinessLogic(ViewFactory.getView(), DaoFactory.getDao("File"), DaoFactory.getDao("DB"));
        bl.menu();
    }
    
}
