/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Set;
import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;

/**
 *
 * @author javie
 */
public interface Dao {
    public void crearUnidadDidactica(UnidadDidactica ud);
    public void crearConvocatoria(ConvocatoriaExamen conv);
    public void crearEnunciado(Enunciado enunciado);
    public void vincularUDsEnunciado(Set <UnidadDidactica> uds);
    public void vincularConvEnunciado(ConvocatoriaExamen conv);
    
    public ArrayList<Enunciado> buscarEnunciado(Integer id);
    public ConvocatoriaExamen buscarConvocatoria(String convocatoria);
    public UnidadDidactica buscarUnidad(Integer id);
}