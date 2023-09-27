/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Set;
import exceptions.DAOException;
import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;

/**
 * This is the interface that is on charge of all the treatment of the data
 * 
 * @author Javier, Imanol, Fran
 */
public interface Dao {
    //All the create related methods
    /**
     * This method is intended to save a UnidadDidactica
     * 
     * @param ud The UnidadDidactica to be saved
     * @throws DAOException 
     */
    public void crearUnidadDidactica(UnidadDidactica ud) throws DAOException;
    
    /**
     * This method should save a Convocatoria
     * 
     * @param conv The Convocatoria to be saved
     * @throws DAOException 
     */
    public void crearConvocatoria(ConvocatoriaExamen conv)throws DAOException;
    
    /**
     * This method shall save a Enunciado
     * 
     * @param enunciado The Enunciado to be saved
     * @throws DAOException 
     */
    public void crearEnunciado(Enunciado enunciado)throws DAOException;
    
    
    //All the linking related methods
    /**
     * This method is meant to links the UnidadesDidacticas 
     * to the last Enunciado created
     * 
     * @param uds The ids of the UnidadesDidacticas to be bind
     * @throws DAOException 
     */
    public void vincularUDsEnunciado(Set <Integer> uds) throws DAOException;
    
    /**
     * This method should save a Convocatoria that has been 
     * assigned an Enunciado
     * 
     * @param conv The Convocatoria with the Enunciado linked to it
     * @throws DAOException 
     */
    public void vincularConvEnunciado(ConvocatoriaExamen conv) throws DAOException;
    
    
    //All the searching methods
    /**
     * This method should look for the Enunciado depending on the parameters recieved
     * if the idE is not null it should look for the Enunciados with the desired id,
     * otherwise it should look for the Enunciados that have the specified UnidadDidactica
     * bind to it
     * 
     * @param idU The id of the Convocatoria to search 
     * @param idE The id of the Enunciado to search (If null it will look by the idC)
     * @return The Enunciados that fullfilled the requirements
     * @throws DAOException 
     */
    public Set<Enunciado> buscarEnunciado(Integer idU,Integer idE) throws DAOException;
    
    /**
     * This method is intended to look for the Convocatorias with the desired
     * idE bind to them, if idE is null it will look for the Convocatoria 
     * that has the same convocatoria thas has been sent
     * 
     * @param convocatoria The convocatoria to search
     * @param idE The id of the Enunciado to search (If null it will look by the convocatoria)
     * @return The Convocatorias that matched
     * @throws DAOException 
     */
    public Set<ConvocatoriaExamen> buscarConvocatoria(String convocatoria,Integer idE) throws DAOException;
    
    /**
     * This method shall look for a UnidadDidactica with the desired id
     * 
     * @param id The id to search
     * @return The UnidadDidactica that has the desired id
     * @throws DAOException 
     */
    public UnidadDidactica buscarUnidad(Integer id) throws DAOException;
}