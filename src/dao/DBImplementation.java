/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConvocatoriaExamen;
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
     * @param UnidadDidactica ud
     */
    @Override
    public void crearUnidadDidactica(UnidadDidactica ud) {
        con = openConnection();

        try {
            ptmt = con.prepareStatement("INSERT INTO UnidadDidactica(acronimo,titulo,evaluacion,descripcion_UD) VALUES (?,?,?,?);");

            ptmt.setString(1, ud.getAcronimo());
            ptmt.setString(2, ud.getTitulo());
            ptmt.setString(3, ud.getEvaluacion());
            ptmt.setString(4, ud.getDescripcion());

            ptmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ptmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
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
    public void crearEnunciado(Enunciado enunciado, Integer idUD) {
        /*
        El metodo deberia recoger un ArrayList de Integers que contenga las ids de las UDs a las que pertenece. O crear un metodo asignarUD.
         */
        
        con = openConnection();
        
        try {
            ptmt = con.prepareStatement("INSERT INTO Enunciado(descripcion_Enunciado, nivel, disponible, ruta) VALUES(?,?,?,?);");
            
            ptmt.setString(1, enunciado.getDescripcion());
            ptmt.setString(2, enunciado.getNivel().name());
            ptmt.setBoolean(3, enunciado.getDisponible());
            ptmt.setString(4, enunciado.getRuta());
            
            ptmt.executeUpdate();
            
            ptmt = con.prepareStatement("SELECT id_Enunciado from Enunciado where ruta = '?'");
            ptmt.setString(1, enunciado.getRuta());
            rset=ptmt.executeQuery();
            while(rset.next()){
                if(rset.getInt(1)!=0){
                    enunciado.setId(rset.getInt(1));
                }
            }
            
            if(!enunciado.getId().equals(null)){
                ptmt = con.prepareStatement("INSERT INTO Enunciado_UD VALUES (?,?)");
                ptmt.setInt(1, enunciado.getId());
                ptmt.setInt(2, idUD);
            
                ptmt.executeUpdate();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ptmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBImplementation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        closeConnection(con);
    }

    @Override
    public Enunciado buscarEnunciado(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConvocatoriaExamen buscarConvocatoria(String convocatoria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UnidadDidactica buscarUnidad(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * *
     * openConnection method that uses a Connection object to access the
     * examendb database and creates a connection between the programm and the
     * database
     *
     * @return Connection conn
     */
    public Connection openConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ResourceBundle.getBundle("resources.Properties").getString("URL"), ResourceBundle.getBundle("resources.Properties").getString("USER"), ResourceBundle.getBundle("resources.Properties").getString("PASSWORD"));
        } catch (SQLException e) {
            e.printStackTrace();
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
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
