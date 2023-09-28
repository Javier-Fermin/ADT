/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import model.ConvocatoriaExamen;
import model.Dificultad;
import model.Enunciado;
import model.UnidadDidactica;

/**
 * The DB implementation of the Dao 
 * 
 * @author Javier, Imanol, Fran
 */
public class DBImplementation implements Dao {

    /*    Attributes    */
    private Connection con;
    private PreparedStatement ptmt;
    private ResultSet rset;

    /*    Methods    */
    /**
     * *
     * crearUnidadDidactica: Metodo que recoge un objeto UnidadDidactica y lo
     * guarda en la base de datos
     *
     * @param  ud
     * @throws exceptions.DAOException
     */
    @Override
    public void crearUnidadDidactica(UnidadDidactica ud) throws DAOException{
        con = openConnection();

        try {
            ptmt = con.prepareStatement("INSERT INTO UnidadDidactica(acronimo,titulo,evaluacion,descripcion_UD) VALUES (?,?,?,?);");

            ptmt.setString(1, ud.getAcronimo());
            ptmt.setString(2, ud.getTitulo());
            ptmt.setString(3, ud.getEvaluacion());
            ptmt.setString(4, ud.getDescripcion());

            ptmt.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        } finally {
            try {
                ptmt.clearParameters();
                ptmt.close();
            } catch (SQLException ex) {
               throw new DAOException(ex.getMessage());
            }
        }
        closeConnection(con);
        
    }

    @Override
    public void crearConvocatoria(ConvocatoriaExamen conv) throws DAOException{
        /*
        Este metodo es vacio, ya que no se guardan convocatorias en la BD
         */
        throw new DAOException("Not supported yet.");
    }

    /**
     * Recibe un objeto de tipo enunciado y loguarda en la DB
     * @param enunciado
     * @throws DAOException 
     * 
     */
    @Override
    public Enunciado crearEnunciado(Enunciado enunciado) throws DAOException{
        /*
        El metodo deberia recoger un ArrayList de Integers que contenga las ids de las UDs a las que pertenece. O crear un metodo asignarUD.
         */

        con = openConnection();

        try {

            /*
                Almacenamos el enunciado sin id en la bd. Cuando se almacena, se le asigna su id
             */
            ptmt = con.prepareStatement("INSERT INTO Enunciado(descripcion_Enunciado, nivel, disponible, ruta) VALUES(?,?,?,?);");

            ptmt.setString(1, enunciado.getDescripcion());
            ptmt.setString(2, enunciado.getNivel().name());
            ptmt.setBoolean(3, enunciado.getDisponible());
            ptmt.setString(4, enunciado.getRuta());

            ptmt.executeUpdate();
            
            ptmt = con.prepareStatement("SELECT max(id_Enunciado) FROM Enunciado;");
            rset = ptmt.executeQuery();
            while(rset.next()){
                enunciado.setId(rset.getInt("max(id_Enunciado)"));
            }
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        } finally {
            try {
                ptmt.close();
            } catch (SQLException ex) {
                throw new DAOException(ex.getMessage());
            }
        }
        closeConnection(con);
        return enunciado;
        

    }

    /**
     * buscarEnunciado: Metodo que recoge de la base de datos los atributos de
     * un enunciado usando como clave de busqueda su id o bien la id de 
     * UnidadDidactica. Los Enunciados que cumplan los requisitos de busqueda
     * son posteriormente devueltos en un Set.
     *
     * @param idU id de la UnidadDidactica
     * @param idE id del Enunciado
     * @return Enunciado enunciado
     * @throws exceptions.DAOException
     */
    @Override
    public Set<Enunciado> buscarEnunciado(Integer idU,Integer idE) throws DAOException{
        Set<Enunciado> enunciados=new HashSet<Enunciado>();
        Enunciado enunciado = null;
        con = openConnection();

        try {
            /*
                Recogemos el enunciado por su id
             */
            if (idE==null){
                ptmt = con.prepareStatement("SELECT * FROM enunciado WHERE id_Enunciado in (SELECT id_Enunciado FROM enunciado_ud WHERE id_ud=?);");
                ptmt.setInt(1, idU);
            }else{
                ptmt = con.prepareStatement("SELECT * FROM enunciado WHERE id_Enunciado=?;");
                ptmt.setInt(1, idE);
            }
            
            rset = ptmt.executeQuery();

            while (rset.next()) {
                enunciado = new Enunciado(null, null, null, null);
                enunciado.setId(rset.getInt("id_Enunciado"));
                enunciado.setDescripcion(rset.getString("descripcion_Enunciado"));
                enunciado.setNivel(Dificultad.valueOf(rset.getString("nivel")));
                enunciado.setDisponible(rset.getBoolean("disponible"));
                enunciado.setRuta(rset.getString("ruta"));
                enunciados.add(enunciado);
            }

        } catch (SQLException ex) {
             throw new DAOException(ex.getMessage());
        } finally {
            try {
                rset.close();
                ptmt.close();
            } catch (SQLException ex) {
                throw new DAOException(ex.getMessage());
            }
        }
        closeConnection(con);
        
        return enunciados;
    }

    @Override
    public Set<ConvocatoriaExamen> buscarConvocatoria(String convocatoria,Integer idE) throws DAOException{
        throw new DAOException("Not supported yet.");
    }

    
    /**
     * buscarUnidad: Metodo que recoge de la base de datos los atributos de
     * una unidad didactica usando como clave de busqueda su id. Estos atributos se
     * guardan en un objeto UnidadDidactica que mas tarde sera devuelto por el metodo
     *
     * @param id
     * @return UnidadDidactica ud
     * @throws exceptions.DAOException
     */
    @Override
    public UnidadDidactica buscarUnidad(Integer id) throws DAOException{
        UnidadDidactica ud = null;

        con = openConnection();

        try {

            /*
                Recogemos el enunciado por su id
             */
            ptmt = con.prepareStatement("SELECT * from UnidadDidactica where id_UD =?;");
            ptmt.setInt(1, id);
            rset = ptmt.executeQuery();

            while (rset.next()) {
                ud = new UnidadDidactica(null, null, null, null);
                ud.setId(rset.getInt("id_UD"));
                ud.setAcronimo(rset.getString("acronimo"));
                ud.setTitulo(rset.getString("titulo"));
                ud.setEvaluacion(rset.getString("evaluacion"));
                ud.setDescripcion(rset.getString("descripcion_UD"));
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        } finally {
            try {
                rset.close();
                ptmt.close();
            } catch (SQLException ex) {
                throw new DAOException(ex.getMessage());
            }
        }
        closeConnection(con);
        
        return ud; 
                
    }

    /**
     * *
     * openConnection method that uses a Connection object to access the
     * examendb database and creates a connection between the programm and the
     * database
     *
     * @return Connection conn
     * @throws exceptions.DAOException
     */
    public Connection openConnection() throws DAOException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ResourceBundle.getBundle("resources.Properties").getString("URL"), ResourceBundle.getBundle("resources.Properties").getString("USER"), ResourceBundle.getBundle("resources.Properties").getString("PASSWORD"));
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        return conn;
    }

    /**
     * *
     * closeConnection method that recieves a Connection object and uses it to
     * access the examendb database and close the connection between the program
     * and the database
     *
     * @param conn
     * @throws exceptions.DAOException
     */
    public void closeConnection(Connection conn) throws DAOException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }
    }

    /**
     * Vincula unidades con enunciados en la base de datos en una tabla de relacion N:M
     * @param uds The ids of the UnidadesDidacticas to link with the last Enunciado
     * @throws DAOException 
     */
    @Override
    public void vincularUDsEnunciado(Set<Integer> uds) throws DAOException {
        con = openConnection();
        try {
            Integer eId = null;
            ptmt = con.prepareStatement("SELECT * from Enunciado where id_Enunciado =(SELECT max(id_Enunciado) FROM Enunciado);");
            rset = ptmt.executeQuery();
            while (rset.next()) {
                eId = rset.getInt("id_Enunciado");
            }
            for (Integer i : uds) {
                ptmt = con.prepareStatement("INSERT INTO Enunciado_UD VALUES (?,?)");
                ptmt.setInt(1, eId);
                ptmt.setInt(2, i);

                ptmt.executeUpdate();
            }
            rset.close();
            ptmt.close();
            closeConnection(con);
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        }
        
    }

    @Override
    public void vincularConvEnunciado(ConvocatoriaExamen conv) throws DAOException{
        throw new DAOException("Not supported yet.");
    }

    @Override
    public void checkConvocatorias() throws DAOException {
        throw new DAOException("Not supported yet.");
    }

    @Override
    public void checkUnidadesDidacticas() throws DAOException {
        con = openConnection();
        try {
            ptmt = con.prepareStatement("SELECT * from UnidadDidactica;");
            rset = ptmt.executeQuery();
            if (!rset.isBeforeFirst() ) {
                rset.close();
                ptmt.close();
                closeConnection(con);
                throw new DAOException("No hay ninguna Unidad Didactica, introduzca una"); 
            }
            rset.close();
            ptmt.close();
            closeConnection(con);
        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        }    
    }

}
