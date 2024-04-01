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
public class RenglonRemito {

    private Long id;
    private Integer itemNro;
    private Producto producto;
    private String descripcion;
    private Double gravado;
    private Double gravado10_5;
    private Double gravado0;
    private Double gravado27;
    private Float cantidad;
    private Double exento;
    private Double noGravado;
    private Double impuesto;
    private Double descuento;
    private Double iva;
    private Double iva10_5;
    private Double iva0;
    private Double iva27;
    private Double total;
    private Remito remito;
    private Double sugerido;
    private Double costoG;
    private Double costoI;
    private Boolean fabricacion;

    public RenglonRemito() {
    }

    public RenglonRemito(Long id, Integer itemNro, Producto producto, String descripcion, Double gravado, Double gravado10_5, Double gravado0, Double gravado27, Float cantidad, Double exento, Double noGravado, Double impuesto, Double descuento, Double iva, Double iva10_5, Double iva0, Double iva27, Double total, Remito remito, Double sugerido, Double costoG, Double costoI, Boolean fabricacion) {
        this.id = id;
        this.itemNro = itemNro;
        this.producto = producto;
        this.descripcion = descripcion;
        this.gravado = gravado;
        this.gravado10_5 = gravado10_5;
        this.gravado0 = gravado0;
        this.gravado27 = gravado27;
        this.cantidad = cantidad;
        this.exento = exento;
        this.noGravado = noGravado;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.iva = iva;
        this.iva10_5 = iva10_5;
        this.iva0 = iva0;
        this.iva27 = iva27;
        this.total = total;
        this.remito = remito;
        this.sugerido = sugerido;
        this.costoG = costoG;
        this.costoI = costoI;
        this.fabricacion = fabricacion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Remito getRemito() {
        return remito;
    }

    public void setRemito(Remito remito) {
        this.remito = remito;
    }

    public Double getSugerido() {
        return sugerido;
    }

    public void setSugerido(Double sugerido) {
        this.sugerido = sugerido;
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
