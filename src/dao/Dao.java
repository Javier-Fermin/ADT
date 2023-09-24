/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.ConvocatoriaExamenExistsException;
import exceptions.ConvocatoriaExamenNotFoundException;
import exceptions.EnunciadoExistsException;
import exceptions.EnunciadoNotFoundException;
import exceptions.UDExistsException;
import exceptions.UDNotFoundException;
import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;

/**
 *
 * @author javie
 */
public interface Dao {
    public void crearUnidadDidactica(UnidadDidactica ud) throws UDExistsException;
    public void crearConvocatoria(ConvocatoriaExamen conv) throws ConvocatoriaExamenExistsException;
    public void crearEnunciado(Enunciado enunciado, Integer idUD) throws EnunciadoExistsException;
    
    public Enunciado buscarEnunciado(Integer id) throws EnunciadoNotFoundException;
    public ConvocatoriaExamen buscarConvocatoria(String convocatoria) throws ConvocatoriaExamenNotFoundException;
    public UnidadDidactica buscarUnidad(Integer id) throws UDNotFoundException;
}