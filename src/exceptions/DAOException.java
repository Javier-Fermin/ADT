/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 * This is the Exception that is used along the program to manage all 
 * the exceptions that could occur during the execution of the app
 * 
 * @author Fran
 */
public class DAOException extends Exception{

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }
    
}
