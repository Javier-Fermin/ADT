/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Set;
import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;

/**
 * This is the interface that is on charge of all the user interface (View)
 * 
 * @author Javier, Imanol, Fran
 */
public interface View { 
    //All create related methods
    /**
     * This method ask the user the data for a UnidadDidactica
     * 
     * @return the UnidadDidactica with the users values
     */
    public UnidadDidactica crearUnidadDidactica();
    
    /**
     * This method ask the user the data for a Convocatoria
     * 
     * @return the Convocatoria with the users values
     */
    public ConvocatoriaExamen crearConvocatoria();
    
    /**
     * This method ask the user the data for a Enunciado
     * 
     * @return the Enunciado with the users values
     */
    public Enunciado crearEnunciado();
    
    
    //All show related methods
    /**
     * This method recieves a Set of Enunciados and shows it
     * 
     * @param enunciados the Enunciados to show
     */
    public void mostrarEnunciado(Set<Enunciado> enunciados);
    
    /**
     * This method recieves a Set of Convocatorias and shows it
     * 
     * @param convs the Convocatorias to be shown
     */
    public void mostrarConvocatoria(Set<ConvocatoriaExamen> convs);
    
    
    //All search related methods
    /**
     * This method asks the user for a Enunciado id and returns it
     * 
     * @return the desired id
     */
    public Integer buscarEnunciado();
    
    /**
     * This method asks the user for a Convocatoria convocatoria and returns it
     * 
     * @return the desired convocatoria
     */
    public String buscarConvocatoria();
    
    /**
     * This method asks the user for a UnidadDidactica id and returns it
     * 
     * @return the desired id 
     */
    public Integer buscarUnidad();
    
    //Other methods
    /**
     * This method shows a Menu and returns the users option
     * 
     * @return the selected option
     */
    public Integer menu();
    
    /**
     * Shows an exception message
     * 
     * @param exMessage the message to show
     */
    public void mostrarException(String exMessage);
}
