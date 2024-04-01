/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.entities;

import java.util.Date;

/**
 *
 * @author Mario
 */
public class Factura {
    private Long id;
    private Date fecha;
    private Cliente cliente;
    private Double gravado;
    private Double gravado0;
    private Double gravado10;
    private Double gravado27;
    private Double exento;
    private Double noGravado;
    private Double impuesto;
    private Double iva;
    private Double iva0;
    private Double iva10;
    private Double iva27;
    private Double total;
    private Boolean anulado;
    private Boolean fabricacion;

    public Factura() {
    }

    public Factura(Long id, Date fecha, Cliente cliente, Double gravado, Double gravado0, Double gravado10, Double gravado27, Double exento, Double noGravado, Double impuesto, Double iva, Double iva0, Double iva10, Double iva27, Double total, Boolean anulado, Boolean fabricacion) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.gravado = gravado;
        this.gravado0 = gravado0;
        this.gravado10 = gravado10;
        this.gravado27 = gravado27;
        this.exento = exento;
        this.noGravado = noGravado;
        this.impuesto = impuesto;
        this.iva = iva;
        this.iva0 = iva0;
        this.iva10 = iva10;
        this.iva27 = iva27;
        this.total = total;
        this.anulado = anulado;
        this.fabricacion = fabricacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getGravado0() {
        return gravado0;
    }

    public void setGravado0(Double gravado0) {
        this.gravado0 = gravado0;
    }

    public Double getGravado10() {
        return gravado10;
    }

    public void setGravado10(Double gravado10) {
        this.gravado10 = gravado10;
    }

    public Double getGravado27() {
        return gravado27;
    }

    public void setGravado27(Double gravado27) {
        this.gravado27 = gravado27;
    }

    public Double getExento() {
        return exento;
    }

    public void setExento(Double exento) {
        this.exento = exento;
    }

    public Double getNoGravado() {
        return noGravado;
    }

    public void setNoGravado(Double noGravado) {
        this.noGravado = noGravado;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getIva0() {
        return iva0;
    }

    public void setIva0(Double iva0) {
        this.iva0 = iva0;
    }

    public Double getIva10() {
        return iva10;
    }

    public void setIva10(Double iva10) {
        this.iva10 = iva10;
    }

    public Double getIva27() {
        return iva27;
    }

    public void setIva27(Double iva27) {
        this.iva27 = iva27;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public Boolean getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(Boolean fabricacion) {
        this.fabricacion = fabricacion;
    }
}