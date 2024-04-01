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
public class Compra {
    private Long id;
    private String proveedor;
    private String comprobante;
    private Date fecha;
    private Producto producto;
    private Float cantidad;
    private Double nuevoPrecio;
    private Float nuevoImpuesto;

    public Compra() {
    }

    public Compra(Long id, String proveedor, String comprobante, Date fecha, Producto producto, Float cantidad, Double nuevoPrecio, Float nuevoImpuesto) {
        this.id = id;
        this.proveedor = proveedor;
        this.comprobante = comprobante;
        this.fecha = fecha;
        this.producto = producto;
        this.cantidad = cantidad;
        this.nuevoPrecio = nuevoPrecio;
        this.nuevoImpuesto = nuevoImpuesto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Double getNuevoPrecio() {
        return nuevoPrecio;
    }

    public void setNuevoPrecio(Double nuevoPrecio) {
        this.nuevoPrecio = nuevoPrecio;
    }

    public Float getNuevoImpuesto() {
        return nuevoImpuesto;
    }

    public void setNuevoImpuesto(Float nuevoImpuesto) {
        this.nuevoImpuesto = nuevoImpuesto;
    }

}