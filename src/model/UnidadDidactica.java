/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 * This class is for the UnidadesDidacticas
 * 
 * @author Javier, Imanol, Fran
 */
public class UnidadDidactica implements Serializable{
    private Integer id;
    private String acronimo;
    private String titulo;
    private String evaluacion;
    private String descripcion;
    
    /**
     * Getter for the id
     * 
     * @return the id attribute
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Setter for the id
     * 
     * @param id the id attribute
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for the acronimo
     * 
     * @return the acronimo attribute
     */
    public String getAcronimo() {
        return acronimo;
    }

    /**
     * Setter for the acronimo
     * 
     * @param acronimo the acronimo attribute
     */
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    /**
     * Getter for the titulo
     * 
     * @return the titulo attribute
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter for the titulo
     * 
     * @param titulo the titulo attribute
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter for the evaluacion
     * 
     * @return the evaluacion attribute
     */
    public String getEvaluacion() {
        return evaluacion;
    }

    /**
     * Setter for the evaluacion
     * 
     * @param evaluacion the evaluacion attribute
     */
    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }

    /**
     * Getter for the descripcion
     * 
     * @return the descripcion attribute
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Setter for the descripcion
     * 
     * @param descripcion the descripcion attribute
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * A custom constructor
     * 
     * @param acronimo
     * @param titulo
     * @param evaluacion
     * @param descripcion 
     */
    public UnidadDidactica(String acronimo, String titulo, String evaluacion, String descripcion) {
        this.acronimo = acronimo;
        this.titulo = titulo;
        this.evaluacion = evaluacion;
        this.descripcion = descripcion;
    }
}
