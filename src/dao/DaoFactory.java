/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 * This is a factory for the Dao related objects
 * 
 * @author Javier, Imanol, Fran
 */
public class DaoFactory {
    /**
     * This method returns a dao implementation depending
     * on the received String
     * 
     * @param access The string that specify if the implementation 
     * should be one or another (Currently supported only File and DB)
     * @return The implementation
     */
    public static Dao getDao(String access){
        if (access.equalsIgnoreCase("DB")){
            return new DBImplementation();
        }else{
            return new FileImplementation();
        }
    }
}
