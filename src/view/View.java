/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Set;

import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;

/**
 *
 * @author javie
 */
public interface View {
    public Integer menu();
    
    public UnidadDidactica crearUnidadDidactica();
    public ConvocatoriaExamen crearConvocatoria();
    public Enunciado crearEnunciado();
    
    public void mostrarEnunciado(Set<Enunciado> enunciados);
    public void mostrarConvocatoria(Set<ConvocatoriaExamen> convs);
    
    public Integer buscarEnunciado();
    public String buscarConvocatoria();
    public Integer buscarUnidad();
    
    public void mostrarException(String exMessage);
}
