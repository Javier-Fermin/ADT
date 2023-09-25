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
import java.util.ResourceBundle;
import model.ConvocatoriaExamen;
import model.Dificultad;
import model.Enunciado;
import model.UnidadDidactica;

/**
 *
 * @author javie
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
    public void crearConvocatoria(ConvocatoriaExamen conv) {
        /*
        Este metodo es vacio, ya que no se guardan convocatorias en la BD
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearEnunciado(Enunciado enunciado, Integer idUD) throws DAOException{
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

            /*
                Recogemos el id del enunciado que se acaba de almacenar. Al ser el ultimo en ser agregado, su id sera la mas alta
             */
            ptmt = con.prepareStatement("SELECT * from Enunciado where id_Enunciado =(SELECT max(id) FROM Enunciado);");
            rset = ptmt.executeQuery();
            while (rset.next()) {
                enunciado.setId(rset.getInt("id_Enunciado"));
            }

            /*
                Tras comprobar que se ha recogido el id, se guarda el id del enunciado y de la ud en la tabla relacion
             */
            if (!enunciado.getId().equals(null)) {
                ptmt = con.prepareStatement("INSERT INTO Enunciado_UD VALUES (?,?)");
                ptmt.setInt(1, enunciado.getId());
                ptmt.setInt(2, idUD);

                ptmt.executeUpdate();
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
        

    }

    /**
     * buscarEnunciado: Metodo que recoge de la base de datos los atributos de
     * un enunciado usando como clave de busqueda su id. Estos atributos se
     * guardan en un objeto Enunciado que mas tarde sera devuelto por el metodo
     *
     * @param id
     * @return Enunciado enunciado
     */
    @Override
    public Enunciado buscarEnunciado(Integer id) throws DAOException{
        Enunciado enunciado = null;
        con = openConnection();

        try {

            /*
                Recogemos el enunciado por su id
             */
            ptmt = con.prepareStatement("SELECT * from Enunciado where id_Enunciado =?;");
            ptmt.setInt(1, id);
            rset = ptmt.executeQuery();

            while (rset.next()) {
                enunciado = new Enunciado(null, null, null, null);
                enunciado.setId(rset.getInt("id_Enunciado"));
                enunciado.setDescripcion(rset.getString("descripcion_Enunciado"));
                enunciado.setNivel(Dificultad.valueOf(rset.getString("nivel")));
                enunciado.setDisponible(rset.getBoolean("disponible"));
                enunciado.setRuta(rset.getString("ruta"));
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
        
        return enunciado;
        
    }

    @Override
    public ConvocatoriaExamen buscarConvocatoria(String convocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * buscarUnidad: Metodo que recoge de la base de datos los atributos de
     * una unidad didactica usando como clave de busqueda su id. Estos atributos se
     * guardan en un objeto UnidadDidactica que mas tarde sera devuelto por el metodo
     *
     * @param id
     * @return UnidadDidactica ud
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
                ud.setAcronimo(rset.getString("nivel"));
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

}
