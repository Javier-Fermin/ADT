/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

import model.ConvocatoriaExamen;
import model.Enunciado;
import model.UnidadDidactica;

/**
 *
 * @author javie
 */
public class DBImplementation implements Dao{

    @Override
    public void crearUnidadDidactica(UnidadDidactica ud) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearUnidadDidactica'");
    }

    @Override
    public void crearConvocatoria(ConvocatoriaExamen conv) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearConvocatoria'");
    }

    @Override
    public void crearEnunciado(Enunciado enunciado, Integer idUD) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearEnunciado'");
    }

    @Override
    public ArrayList<Enunciado> buscarEnunciado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarEnunciado'");
    }

    @Override
    public ArrayList<ConvocatoriaExamen> buscarConvocatoria() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarConvocatoria'");
    }

    @Override
    public ArrayList<UnidadDidactica> buscarUnidad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarUnidad'");
    }

}
