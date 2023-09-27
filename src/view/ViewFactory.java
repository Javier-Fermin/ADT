/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 * This is a factory for the View related objects
 * 
 * @author Javier, Imanol, Fran
 */
public class ViewFactory {
    /**
     * This method returns a view implementation
     * 
     * @return The implementation
     */
    public static View getView(){
        return new ViewImplementation();
    }
}
