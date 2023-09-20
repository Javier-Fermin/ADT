/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author javie
 */
public class ConvocatoriaExamen {
    private String convocatoria;
    private String descipcion;
    private LocalDate fecha;
    private String curso;
    private Integer idEnunciado;

    public String getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(String convocatoria) {
        this.convocatoria = convocatoria;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getIdEnunciado() {
        return idEnunciado;
    }

    public void setIdEnunciado(Integer idEnunciado) {
        this.idEnunciado = idEnunciado;
    }

    public ConvocatoriaExamen(String convocatoria, String descipcion, LocalDate fecha, String curso, Integer idEnunciado) {
        this.convocatoria = convocatoria;
        this.descipcion = descipcion;
        this.fecha = fecha;
        this.curso = curso;
        this.idEnunciado = idEnunciado;
    }
}
