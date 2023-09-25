/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
    public void crearUnidadDidactica(UnidadDidactica ud) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void crearConvocatoria(ConvocatoriaExamen conv) {
        if (!fich.exists()) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich));
                    oos.writeObject(conv);
                    oos.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            try {
                MyObjectOutputStream oos = new MyObjectOutputStream(new FileOutputStream(fich, false));
                oos.writeObject(conv);
                oos.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    @Override
    public void crearEnunciado(Enunciado enunciado) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public ArrayList<Enunciado> buscarEnunciado(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public ArrayList<ConvocatoriaExamen> buscarConvocatoria(Integer convocatoria) {
        ArrayList<ConvocatoriaExamen> convocatorias = null;
        if(fich.exists()){
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
                for (int i = 0; i < Util.calculoFichero(fich); i++) {
                    ConvocatoriaExamen aux = (ConvocatoriaExamen) ois.readObject();
                    if(aux.getIdEnunciado() == convocatoria){
                        convocatorias.add(aux);
                    }
                }
                ois.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            
        }
        return convocatorias;
    }

    @Override
    public UnidadDidactica buscarUnidad(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void vincularUDsEnunciado(Set<UnidadDidactica> uds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vincularConvEnunciado(ConvocatoriaExamen conv) {
        File fichAux = new File("fichAux.dat");
        if(fich.exists()){
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichAux));
                for (int i = 0; i < Util.calculoFichero(fich); i++) {
                    ConvocatoriaExamen aux = (ConvocatoriaExamen) ois.readObject();
                    if(!aux.getConvocatoria().equalsIgnoreCase(conv.getConvocatoria())){
                        conv = aux;
                    }
                    oos.writeObject(conv);
                }
                oos.close();
                ois.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}