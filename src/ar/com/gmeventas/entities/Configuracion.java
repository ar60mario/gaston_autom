package ar.com.gmeventas.entities;

import java.util.Date;

public class Configuracion {

    private Long id;
    private Float iva;
    private Integer sucursalA;
    private Integer numeroFacturaA;
    private Integer sucursalB;
    private Integer numeroFacturaB;
    private Integer numeroRecibo;
    private Integer numeroPedido;
    private Integer numeroRemito;
    private Float ivaPan;
    private Date ultimaFecha;
    private Date ultimaFechaPanificados;

    public Configuracion() {
    }

    public Configuracion(Long id, Float iva, Integer sucursalA, Integer numeroFacturaA, Integer sucursalB, Integer numeroFacturaB, Integer numeroRecibo, Integer numeroPedido, Float ivaPan, Date ultimaFecha, Date ultimaFechaPanificados, Integer numeroRemito) {
        this.id = id;
        this.iva = iva;
        this.sucursalA = sucursalA;
        this.numeroFacturaA = numeroFacturaA;
        this.sucursalB = sucursalB;
        this.numeroFacturaB = numeroFacturaB;
        this.numeroRecibo = numeroRecibo;
        this.numeroPedido = numeroPedido;
        this.ivaPan = ivaPan;
        this.ultimaFecha = ultimaFecha;
        this.ultimaFechaPanificados = ultimaFechaPanificados;
        this.numeroRemito = numeroRemito;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        this.iva = iva;
    }

    public Integer getSucursalA() {
        return sucursalA;
    }

    public void setSucursalA(Integer sucursalA) {
        this.sucursalA = sucursalA;
    }

    public Integer getNumeroFacturaA() {
        return numeroFacturaA;
    }

    public void setNumeroFacturaA(Integer numeroFacturaA) {
        this.numeroFacturaA = numeroFacturaA;
    }

    public Integer getSucursalB() {
        return sucursalB;
    }

    public void setSucursalB(Integer sucursalB) {
        this.sucursalB = sucursalB;
    }

    public Integer getNumeroFacturaB() {
        return numeroFacturaB;
    }

    public void setNumeroFacturaB(Integer numeroFacturaB) {
        this.numeroFacturaB = numeroFacturaB;
    }

    public Integer getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(Integer numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Float getIvaPan() {
        return ivaPan;
    }

    public void setIvaPan(Float ivaPan) {
        this.ivaPan = ivaPan;
    }
    
    public Date getUltimaFecha() {
        return ultimaFecha;
    }

    public void setUltimaFecha(Date ultimaFecha) {
        this.ultimaFecha = ultimaFecha;
    }
    
    public Date getUltimaFechaPanificados() {
        return ultimaFechaPanificados;
    }

    public void setUltimaFechaPanificados(Date ultimaFechaPanificados) {
        this.ultimaFechaPanificados = ultimaFechaPanificados;
    }
    
    public Integer getNumeroRemito() {
        return numeroRemito;
    }

    public void setNumeroRemito(Integer numeroRemito) {
        this.numeroRemito = numeroRemito;
    }
}
