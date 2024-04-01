/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.entities;

/**
 *
 * @author Mario
 */
public class ConfiguracionTop {
    private Integer id;
    private Integer orderMaximo;
    private Double importeMaximo;
    private Double importeMaximoPanificados;

    public ConfiguracionTop() {
    }

    public ConfiguracionTop(Integer id, Integer orderMaximo, Double importeMaximo, Double importeMaximoPanificados) {
        this.id = id;
        this.orderMaximo = orderMaximo;
        this.importeMaximo = importeMaximo;
        this.importeMaximoPanificados = importeMaximoPanificados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderMaximo() {
        return orderMaximo;
    }

    public void setOrderMaximo(Integer orderMaximo) {
        this.orderMaximo = orderMaximo;
    }

    public Double getImporteMaximo() {
        return importeMaximo;
    }

    public void setImporteMaximo(Double importeMaximo) {
        this.importeMaximo = importeMaximo;
    }
    
    public Double getImporteMaximoPanificados() {
        return importeMaximoPanificados;
    }

    public void setImporteMaximoPanificados(Double importeMaximoPanificados) {
        this.importeMaximoPanificados = importeMaximoPanificados;
    }
}
