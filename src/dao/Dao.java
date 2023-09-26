/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Set;
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
    public void crearConvocatoria(ConvocatoriaExamen conv)throws DAOException;
    public void crearEnunciado(Enunciado enunciado)throws DAOException;
    public void vincularUDsEnunciado(Set <UnidadDidactica> uds) throws DAOException;
    public void vincularConvEnunciado(ConvocatoriaExamen conv) throws DAOException;
    
    public ArrayList<Enunciado> buscarEnunciado(Integer id) throws DAOException;
    public ArrayList<ConvocatoriaExamen> buscarConvocatoria(Integer convocatoria) throws DAOException;
    public UnidadDidactica buscarUnidad(Integer id) throws DAOException;
}