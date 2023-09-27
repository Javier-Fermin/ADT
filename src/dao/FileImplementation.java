/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exceptions.DAOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;
import resources.MyObjectOutputStream;
import resources.Util;

/**
 *
 * @author imanol
 */
public class FileImplementation implements Dao {
    File fich = new File("Convocatorias.dat");

    @Override
    public void crearUnidadDidactica(UnidadDidactica ud) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    /*
     * Recibe una convocatoria y la guarda en un fichero
     * @param ConvocatoriaExamen conv
     */
    @Override
    public void crearConvocatoria(ConvocatoriaExamen conv) throws DAOException{
        if (!fich.exists()) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
                    oos.writeObject(conv);
                    oos.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                throw new DAOException(e.getMessage());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                throw new DAOException(e.getMessage());
            }
        } else {
            try {
                MyObjectOutputStream oos = new MyObjectOutputStream(new FileOutputStream(fich, false));
                oos.writeObject(conv);
                oos.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                throw new DAOException(e.getMessage());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                throw new DAOException(e.getMessage());
            }
        }
    }

    @Override
    public void crearEnunciado(Enunciado enunciado) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Set<Enunciado> buscarEnunciado(Integer id,Integer idE) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    /*
     * Recibe un id de enunciado y devuelve todas las convocatorias asociadas a esa unidad
     * @param Integer convocatoria
     * @return ArrayList<ConvocatoriaExamen> convocatorias
     */
    @Override
    public Set<ConvocatoriaExamen> buscarConvocatoria(String convocatoria,Integer idE) throws DAOException{
        Set<ConvocatoriaExamen> convocatorias = new HashSet<ConvocatoriaExamen>();
        if(idE==null){
            if(fich.exists()){
                Integer num = Util.calculoFichero(fich);
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
                    for (int i = 0; i < num; i++) {
                        ConvocatoriaExamen aux = (ConvocatoriaExamen) ois.readObject();
                        if(aux.getConvocatoria().equalsIgnoreCase(convocatoria)){
                            convocatorias.add(aux);
                        }
                    }
                    ois.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    throw new DAOException(e.getMessage());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    throw new DAOException(e.getMessage());
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    throw new DAOException(e.getMessage());
                }
            }else{
               throw new DAOException("El fichero no existe."); 
            }
        }else{
            if(fich.exists()){
                Integer num = Util.calculoFichero(fich);
                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
                    for (int i = 0; i < num; i++) {
                        ConvocatoriaExamen aux = (ConvocatoriaExamen) ois.readObject();
                        if(aux.getIdEnunciado().equals(idE)){
                            convocatorias.add(aux);
                        }
                    }
                    ois.close();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    throw new DAOException(e.getMessage());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    throw new DAOException(e.getMessage());
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    throw new DAOException(e.getMessage());
                }
            }else{
               throw new DAOException("El fichero no existe."); 
            }
        }
        return convocatorias;
    }

    @Override
    public UnidadDidactica buscarUnidad(Integer id) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void vincularUDsEnunciado(Set<Integer> uds) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
     * Vincula convocatorias con enunciados
     * @param onvocatoriaExamen conv
     */
    @Override
    public void vincularConvEnunciado(ConvocatoriaExamen conv) throws DAOException{
        File fichAux = new File("fichAux.dat");
        if(fich.exists()){
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichAux));
                for (int i = 0; i < Util.calculoFichero(fich); i++) {
                    ConvocatoriaExamen aux = (ConvocatoriaExamen) ois.readObject();
                    if(aux.getConvocatoria().equalsIgnoreCase(conv.getConvocatoria())){
                        aux = conv;
                    }
                    oos.writeObject(aux);
                }
                oos.close();
                ois.close();
                fich.delete();
                fichAux.renameTo(fich);   
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                throw new DAOException(e.getMessage());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                throw new DAOException(e.getMessage());
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                throw new DAOException(e.getMessage());
            }
        }
    }

}