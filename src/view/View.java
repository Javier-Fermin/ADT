/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;

/**
 *
 * @author javie
 */
public interface View {
    public UnidadDidactica crearUnidadDidactica();
    public ConvocatoriaExamen crearConvocatoria();
    public Enunciado crearEnunciado();
    
    public void mostrarEnunciado(Enunciado enunciado);
    public void mostrarConvocatoria(ConvocatoriaExamen conv);
}
