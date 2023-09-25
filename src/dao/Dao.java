/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.DAOException;
import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;

/**
 *
 * @author javie
 */
public interface Dao {
    public void crearUnidadDidactica(UnidadDidactica ud) throws DAOException;
    public void crearConvocatoria(ConvocatoriaExamen conv) throws DAOException;
    public void crearEnunciado(Enunciado enunciado, Integer idUD) throws DAOException;
    
    public Enunciado buscarEnunciado(Integer id) throws DAOException;
    public ConvocatoriaExamen buscarConvocatoria(String convocatoria) throws DAOException;
    public UnidadDidactica buscarUnidad(Integer id) throws DAOException;
}