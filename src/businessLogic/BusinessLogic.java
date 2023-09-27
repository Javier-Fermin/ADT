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
 *
 * @author javie
 */
public class BusinessLogic {
    private View view;
    private Dao daoDB, daoFile;
    
    public BusinessLogic(View view, Dao daoF, Dao daoDB) {
        this.daoDB = daoDB;
        this.daoFile = daoF;
        this.view = view;
    }
    
    public void menu(){
        Boolean salir=false;
        while (!salir){
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
    
    public void vincularEnunciadoConv(){
        try {
            ConvocatoriaExamen conv = daoFile.buscarConvocatoria(view.buscarConvocatoria(),null).iterator().next();
            conv.setIdEnunciado(view.buscarEnunciado());
            daoFile.vincularConvEnunciado(conv);
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
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
    
    public void consultarEnunciados(){
        try {
            view.mostrarEnunciado(daoDB.buscarEnunciado(view.buscarUnidad(), null));;
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    public void consultarConvocatorias(){
        try {
            Set<ConvocatoriaExamen> conv = new HashSet<ConvocatoriaExamen>();
            conv = daoFile.buscarConvocatoria(null,view.buscarEnunciado());
            view.mostrarConvocatoria(conv);
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    public void crearUnidadDidactica(){
        try {
            daoDB.crearUnidadDidactica(view.crearUnidadDidactica());
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    public void crearConvocatoria(){
        try {
            daoFile.crearConvocatoria(view.crearConvocatoria());
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    public void crearEnunciado(){
        try {
            Enunciado enun = view.crearEnunciado();
            daoDB.crearEnunciado(enun);
            Boolean salir=false;
            Set<Integer> ids = new HashSet<Integer>();
            while (!salir){
                ids.add(view.buscarUnidad());
                salir = Util.esBoolean("Desea dejar de añadir unidades didacticas al enunciado?");
            }
            daoDB.vincularUDsEnunciado(ids);
            ConvocatoriaExamen conv = daoFile.buscarConvocatoria(view.buscarConvocatoria(),null).iterator().next();
            conv.setIdEnunciado(enun.getId());
            daoFile.vincularConvEnunciado(conv);
        } catch (DAOException ex) {
            view.mostrarException(ex.getMessage());
        }
    }
    
    
}
