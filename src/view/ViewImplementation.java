/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.ConvocatoriaExamen;
import model.Dificultad;
import model.Enunciado;
import model.UnidadDidactica;
import resources.Util;


/**
 *
 * @author javie
 */
public class ViewImplementation implements View{

    @Override
    public UnidadDidactica crearUnidadDidactica() {
        UnidadDidactica ud = new UnidadDidactica(null,null,null,null);
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

    @Override
    public ConvocatoriaExamen crearConvocatoria() {
        ConvocatoriaExamen conv = new ConvocatoriaExamen(null,null,null,null,null);
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

    @Override
    public Enunciado crearEnunciado() {
        Enunciado enun = new Enunciado(null,null,null,null);
        System.out.println("Introduzca la descripción");
        enun.setDescripcion(Util.introducirCadena());
        System.out.println("Introduzca la descripción");
        enun.setNivel(Dificultad.valueOf(Util.introducirCadena()));
        enun.setDisponible(Util.esBoolean("Esta disponible el enunciado?"));
        System.out.println("Introduzca el ruta");
        enun.setRuta(Util.introducirCadena());
        return enun;
    }

    @Override
    public void mostrarEnunciado(Enunciado enunciado) {
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

    @Override
    public void mostrarConvocatoria(ConvocatoriaExamen conv) {
        System.out.println("Convocatoria");
        System.out.println(conv.getConvocatoria());
        System.out.println("Descripcion");
        System.out.println(conv.getDescipcion());
        System.out.println("Fecha");
        System.out.println(conv.getFecha());
        System.out.println("Curso");
        System.out.println(conv.getCurso());
    }
    
    @Override
    public Integer buscarEnunciado(){
        System.out.println("Introduzca el id delenuncaido que desee busacar");
        return Util.leerInt();
    }

    @Override
    public String buscarConvocatoria(){
        System.out.println("Introduzca el nombre de la convocatoria que desee buscar");
        return Util.introducirCadena();
    }

    @Override
    public Integer buscarUnidad(){
        System.out.println("Introduzca el id de la unidad que desea buscar:");
        return Util.leerInt();
    }

    @Override
    public Integer menu() {
        System.out.println("\n\t1. Crear UD."
                + "\n\t2. Crear Convocatoria."
                + "\n\t3. Crear Enunciado."
                + "\n\t4. Consultar Enunciados."//QUE TENGAN UNA UD EN CONCRETO
                + "\n\t5. Consultar Convocatoria."//SEGUN UN ENUNCIADO
                + "\n\t6. Visualizar Enunciado."//DOCUMENTO
                + "\n\t7. Exit.");
        return Util.leerInt("Introduce un número del 1 al 7: ", 1, 7);
    }
}
