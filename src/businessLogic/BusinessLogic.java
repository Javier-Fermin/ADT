/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dao.Dao;
import exceptions.DAOException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConvocatoriaExamen;
import model.Enunciado;
import resources.Util;
import view.View;

/**
 * This is the controller class of the application it is on charge of communicating both the view and the dao
 * 
 * @author Javier
 */
public class BusinessLogic {
    private View view;
    private Dao daoDB, daoFile;
    
    public BusinessLogic(View view, Dao daoF, Dao daoDB) {
        this.daoDB = daoDB;
        this.daoFile = daoF;
        this.view = view;
    }
    
    /**
     * This method shows the menu and executes the respective function depending
     * on the option selected by the user
     */
    public void menu(){
        Boolean salir=false;
        while (!salir){
            //Here we call the view mthod that shows up the menu and then we do
            //the selected option
            switch (view.menu()){
                case 1:
                    crearUnidadDidactica();
                    break;
                case 2:
                    crearConvocatoria();
                    break;
                case 3:
                    crearEnunciado();
                    break;
                case 4:
                    consultarEnunciados();
                    break;
                case 5:
                    consultarConvocatorias();
                    break;
                case 6:
                    openDoc();
                    break;
                case 7:
                    vincularEnunciadoConv();
                    break;
                case 8:
                    salir=true;
                break;
            }
        }
    }
    
    /**
     * This method binds an Enunciado with a Convocatoria
     */
    public void vincularEnunciadoConv(){
        try {
            //We get the Convocatoria (In case of getting more than one match we use the one that was found first)
            ConvocatoriaExamen conv = daoFile.buscarConvocatoria(view.buscarConvocatoria(),null).iterator().next();
            //Now we ask for the desired Enunciado to bind
            conv.setIdEnunciado(view.buscarEnunciado());
            //And finally we save the changes
            daoFile.vincularConvEnunciado(conv);
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    /**
     * The method openDoc opens a Enunciado depending on the route that the Enunciado has
     */
    public void openDoc(){
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(new File(""));
            } catch (IOException ex) {
                Logger.getLogger(BusinessLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("not supported");
        }
    }
    
    /**
     * This method is on charge of showing  all the Enunciados that got the desired Unidad
     */
    public void consultarEnunciados(){
        try {
            //We ask for an UnidadDidactica and then we look for the Enunciados
            //that got it and finally we show the Enunciados we got
            view.mostrarEnunciado(daoDB.buscarEnunciado(view.buscarUnidad(), null));;
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    /**
     * This method shows all the Convocatorias with a specific Enunciado
     */
    public void consultarConvocatorias(){
        try {
            Set<ConvocatoriaExamen> conv = new HashSet<ConvocatoriaExamen>();
            //We ask for the id of the desired Enuncidao, then we look for
            //a Convocatoria that has that id assigned
            conv = daoFile.buscarConvocatoria(null,view.buscarEnunciado());
            view.mostrarConvocatoria(conv);
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    /**
     * This method create an UnidadDidactica
     */
    public void crearUnidadDidactica(){
        try {
            //We ask for the UnidadDidactica and once we got it we save it
            daoDB.crearUnidadDidactica(view.crearUnidadDidactica());
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    /**
     * The method crearConvocatoria creates a Convocatoria
     */
    public void crearConvocatoria(){
        try {
            //We ask for the Convocatoria and once we got it we save it
            daoFile.crearConvocatoria(view.crearConvocatoria());
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    /**
     * This method creates an Enunciado it aslo links the desired UnidadesDidacticas to the Enunciado as well as a Convocatoria
     */
    public void crearEnunciado(){
        try {
            //First we create the Enunciado
            Enunciado enun = view.crearEnunciado();
            daoDB.crearEnunciado(enun);
            Boolean salir=false;
            //Then we start gathering the UnidadesDidacticas to then assing them to the Enunciado
            Set<Integer> ids = new HashSet<Integer>();
            while (!salir){
                ids.add(view.buscarUnidad());
                salir = Util.esBoolean("Desea dejar de añadir unidades didacticas al enunciado?");
            }
            daoDB.vincularUDsEnunciado(ids);
            //And finally we link the Enunciado to the Convocatoria
            ConvocatoriaExamen conv = daoFile.buscarConvocatoria(view.buscarConvocatoria(),null).iterator().next();
            conv.setIdEnunciado(enun.getId());
            daoFile.vincularConvEnunciado(conv);
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    
}
