/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This is a class for the Convocatorias
 * 
 * @author Javier, Imanol, Fran
 */
public class ConvocatoriaExamen implements Serializable{
    private String convocatoria;
    private String descipcion;
    private LocalDate fecha;
    private String curso;
    private Integer idEnunciado;

    /**
     * Getter for the convocatoria
     * 
     * @return the convocatoria attribute
     */
    public String getConvocatoria() {
        return convocatoria;
    }

    /**
     * Setter for the convocatoria
     * 
     * @param convocatoria the convocatoria attribute
     */
    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    /**
     * Getter for the descripcion
     * 
     * @return the descripcion attribute
     */
    public String getDescipcion() {
        return descipcion;
    }

    /**
     * Setter for the descipcion
     * 
     * @param descipcion the descipcion attribute
     */
    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    /**
     * Getter for the fecha
     * 
     * @return the fecha attribute
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Setter for the fecha
     * 
     * @param fecha the fecha attribute
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Getter for the curso
     * 
     * @return the curso attribute
     */
    public String getCurso() {
        return curso;
    }
    
    /**
     * Setter for the curso
     * 
     * @param curso the curso attribute
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    
    /**
     * Getter for the idEnunciado
     * 
     * @return the idEnunciado attribute
     */
    public Integer getIdEnunciado() {
        return idEnunciado;
    }

    /**
     * Setter for the idEnunciado
     * 
     * @param idEnunciado the idEnunciado attribute
     */
    public void setIdEnunciado(Integer idEnunciado) {
        this.idEnunciado = idEnunciado;
    }

    /**
     * A custom constructor
     * 
     * @param convocatoria
     * @param descipcion
     * @param fecha
     * @param curso
     * @param idEnunciado 
     */
    public ConvocatoriaExamen(String convocatoria, String descipcion, LocalDate fecha, String curso, Integer idEnunciado) {
        this.convocatoria = convocatoria;
        this.descipcion = descipcion;
        this.fecha = fecha;
        this.curso = curso;
        this.idEnunciado = idEnunciado;
    }
}
