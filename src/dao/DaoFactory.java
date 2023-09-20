/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author javie
 */
public class DaoFactory {
    public static Dao getDao(String access){
        if (access.equalsIgnoreCase("DB")){
            return new DBImplementation();
        }else{
            return new FileImplementation();
        }
    }
}
