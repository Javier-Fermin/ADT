/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dao.Dao;
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
    
    public void crearUnidadDidactica(){
        daoDB.crearUnidadDidactica(view.crearUnidadDidactica());
    }
    
    public void crearConvocatoria(){
        daoDB.crearConvocatoria(view.crearConvocatoria());
    }
    
    public void crearEnunciado(){
        daoDB.crearEnunciado(view.crearEnunciado());
    }
}
