/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.gmeventas.entities;

/**
 *
 * @author Mar y Mar Informatica
 */
public class RenglonFc {
    private Long id;
    private Integer itemNro;
    private Producto producto;
    private Double gravado;
    private Double gravado10_5;
    private Double gravado0;
    private Double gravado27;
    private Double noGravado;
    private Float cantidad;
    private Double exento;
    private Double impuesto;
    private Double descuento;
    private Double iva;
    private Double iva10_5;
    private Double iva0;
    private Double iva27;
    private Double total;
    private Factura factura;
    private Double sugerido;
    private Boolean anulado;
    private Double costoG;
    private Double costoI;
    private Boolean fabricacion;

    public RenglonFc() {
    }

    public RenglonFc(Long id, Integer itemNro, Producto producto, Double gravado, Double gravado10_5, Double gravado0, Double gravado27, Double noGravado, Float cantidad, Double exento, Double impuesto, Double descuento, Double iva, Double iva10_5, Double iva0, Double iva27, Double total, Factura factura, Double sugerido, Boolean anulado, Double costoG, Double costoI, Boolean fabricacion) {
        this.id = id;
        this.itemNro = itemNro;
        this.producto = producto;
        this.gravado = gravado;
        this.gravado10_5 = gravado10_5;
        this.gravado0 = gravado0;
        this.gravado27 = gravado27;
        this.noGravado = noGravado;
        this.cantidad = cantidad;
        this.exento = exento;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.iva = iva;
        this.iva10_5 = iva10_5;
        this.iva0 = iva0;
        this.iva27 = iva27;
        this.total = total;
        this.factura = factura;
        this.sugerido = sugerido;
        this.anulado = anulado;
        this.costoG = costoG;
        this.costoI = costoI;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemNro() {
        return itemNro;
    }

    public void setItemNro(Integer itemNro) {
        this.itemNro = itemNro;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getGravado() {
        return gravado;
    }

    public void setGravado(Double gravado) {
        this.gravado = gravado;
    }

    public Double getGravado10_5() {
        return gravado10_5;
    }

    public void setGravado10_5(Double gravado10_5) {
        this.gravado10_5 = gravado10_5;
    }

    public Double getGravado0() {
        return gravado0;
    }

    public void setGravado0(Double gravado0) {
        this.gravado0 = gravado0;
    }

    public Double getGravado27() {
        return gravado27;
    }

    public void setGravado27(Double gravado27) {
        this.gravado27 = gravado27;
    }

    public Double getNoGravado() {
        return noGravado;
    }

    public void setNoGravado(Double noGravado) {
        this.noGravado = noGravado;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Double getExento() {
        return exento;
    }

    public void setExento(Double exento) {
        this.exento = exento;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getIva10_5() {
        return iva10_5;
    }

    public void setIva10_5(Double iva10_5) {
        this.iva10_5 = iva10_5;
    }

    public Double getIva0() {
        return iva0;
    }

    public void setIva0(Double iva0) {
        this.iva0 = iva0;
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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Double getSugerido() {
        return sugerido;
    }

    public void setSugerido(Double sugerido) {
        this.sugerido = sugerido;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }

    public Double getCostoG() {
        return costoG;
    }

    public void setCostoG(Double costoG) {
        this.costoG = costoG;
    }

    public Double getCostoI() {
        return costoI;
    }

    public void setCostoI(Double costoI) {
        this.costoI = costoI;
    }
    
    public Boolean getFabricacion() {
        return fabricacion;
    }

    public void setFabricacion(Boolean fabricacion) {
        this.fabricacion = fabricacion;
    }
}