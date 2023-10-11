/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 * This class is for the Enunciados
 * 
 * @author Javier, Imanol, Fran
 */
public class Enunciado implements Serializable{
    private Integer id;
    private String descripcion;
    private Dificultad nivel;
    private Boolean disponible;
    private String ruta;
    
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
     * Getter for the nivel
     * 
     * @return the nivel attribute
     */
    public Dificultad getNivel() {
        return nivel;
    }

    /**
     * Setter for the nivel
     * 
     * @param nivel the nivel attribute
     */
    public void setNivel(Dificultad nivel) {
        this.nivel = nivel;
    }

    /**
     * Getter for the disponible
     * 
     * @return the disponible attribute
     */
    public Boolean getDisponible() {
        return disponible;
    }

    /**
     * Setter for the disponible
     * 
     * @param disponible the disponible attribute
     */
    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
    
    /**
     * Getter for the ruta
     * 
     * @return the ruta attribute
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * Setter for the ruta
     * 
     * @param ruta the ruta attribute
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * A custom constructor
     * 
     * @param descripcion
     * @param nivel
     * @param disponible
     * @param ruta 
     */
    public Enunciado(String descripcion, Dificultad nivel, Boolean disponible, String ruta) {
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.disponible = disponible;
        this.ruta = ruta;
    }
}
