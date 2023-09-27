/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Set;

import model.ConvocatoriaExamen;
import model.Dificultad;
import model.Enunciado;
import model.UnidadDidactica;
import resources.Util;

/**
 * This is a view implementation
 * 
 * @author Javier, Imanol
 */
public class ViewImplementation implements View {

    /**
     * This method gets data from the user to then create an UnidadDidactica
     * and return it
     * 
     * @return the UnidadDidactica with the user data
     */
    @Override
    public UnidadDidactica crearUnidadDidactica() {
        UnidadDidactica ud = new UnidadDidactica(null, null, null, null);
        System.out.println("Introduzca el acronimo");
        ud.setAcronimo(Util.introducirCadena());
        System.out.println("Introduzca el titulo");
        ud.setTitulo(Util.introducirCadena());
        System.out.println("Introduzca la evaluación");
        ud.setEvaluacion(Util.introducirCadena());
        System.out.println("Introduzca la descripción");
        ud.setDescripcion(Util.introducirCadena());
        return ud;
    }

    /**
     * This method gets data from the user to then create an Convocatoria
     * and return it
     * 
     * @return the Convocatoria with the user data
     */
    @Override
    public ConvocatoriaExamen crearConvocatoria() {
        ConvocatoriaExamen conv = new ConvocatoriaExamen(null, null, null, null, null);
        System.out.println("Introduzca la convocatoria");
        conv.setConvocatoria(Util.introducirCadena());
        System.out.println("Introduzca la descripción");
        conv.setDescipcion(Util.introducirCadena());
        System.out.println("Introduzca la Fecha");
        conv.setFecha(Util.leerFechaAMD());
        System.out.println("Introduzca el curso");
        conv.setCurso(Util.introducirCadena());
        return conv;
    }

    /**
     * This method gets data from the user to then create an Enunciado
     * and return it
     * 
     * @return the Enunciado with the user data
     */
    @Override
    public Enunciado crearEnunciado() {
        Enunciado enun = new Enunciado(null, null, null, null);
        System.out.println("Introduzca la descripción");
        enun.setDescripcion(Util.introducirCadena());
        System.out.println("Introduzca la dificultad (ALTA, MEDIA, BAJA)");
        enun.setNivel(Dificultad.valueOf(Util.introducirCadena()));
        enun.setDisponible(Util.esBoolean("Esta disponible el enunciado?"));
        System.out.println("Introduzca el ruta");
        enun.setRuta(Util.introducirCadena());
        return enun;
    }

    /**
     * This method shows the data of the Enunciados recieved
     * 
     * @param enunciados the Enunciados to be shown
     */
    @Override
    public void mostrarEnunciado(Set<Enunciado> enunciados) {
        for (Enunciado enunciado : enunciados) {
            System.out.println("ID");
            System.out.println(enunciado.getId());
            System.out.println("Descripcion");
            System.out.println(enunciado.getDescripcion());
            System.out.println("Nivel");
            System.out.println(enunciado.getNivel());
            System.out.println("Disponible");
            System.out.println(enunciado.getDisponible());
            System.out.println("Ruta");
            System.out.println(enunciado.getRuta());
        }
    }

    /**
     * This method shows the data of the Convocatorias recieved
     * 
     * @param convs the Convocatorias to be shown
     */
    @Override
    public void mostrarConvocatoria(Set<ConvocatoriaExamen> convs) {
        for(ConvocatoriaExamen conv:convs){
            System.out.println("Convocatoria");
            System.out.println(conv.getConvocatoria());
            System.out.println("Descripcion");
            System.out.println(conv.getDescipcion());
            System.out.println("Fecha");
            System.out.println(conv.getFecha());
            System.out.println("Curso");
            System.out.println(conv.getCurso());
        }
    }

    /**
     * This method is in charge of asking the user for an id of an Enunciado
     * and then it is returned
     * 
     * @return the desired id
     */
    @Override
    public Integer buscarEnunciado() {
        System.out.println("Introduzca el id del enunciado que desee buscar");
        return Util.leerInt();
    }
    
    /**
     * This method is in charge of asking the user for an convocatoria 
     * of a Convocatoria and then it is returned
     * 
     * @return the desired convocatoria
     */
    @Override
    public String buscarConvocatoria() {
        System.out.println("Introduzca el nombre de la convocatoria que desee buscar");
        return Util.introducirCadena();
    }

    /**
     * This method is in charge of asking the user for an id of a UnidadDidactica
     * and then it is returned
     * 
     * @return the desired id
     */
    @Override
    public Integer buscarUnidad() {
        System.out.println("Introduzca el id de la unidad que desea buscar:");
        return Util.leerInt();
    }

    /**
     * This method shows the user a menu and then returns the user option
     * 
     * @return the selected option
     */
    @Override
    public Integer menu() {
        System.out.println("\n\t1. Crear UD."
                + "\n\t2. Crear Convocatoria."
                + "\n\t3. Crear Enunciado."
                + "\n\t4. Consultar Enunciados."
                + "\n\t5. Consultar Convocatoria."
                + "\n\t6. Visualizar Enunciado."
                + "\n\t7. Vincular un enunciado a una convocatoria"
                + "\n\t8. Exit.");
        return Util.leerInt("Introduce un número del 1 al 8: ", 1, 8);
    }

    /**
     * This methods shows the user an exception message
     * 
     * @param exMessage the message to be shown
     */
    @Override
    public void mostrarException(String exMessage) {
        System.out.println(exMessage);
    }
}
