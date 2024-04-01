/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.bo;

import ar.com.gmeventas.dao.RemitoDAO;
import ar.com.gmeventas.entities.Cliente;
import ar.com.gmeventas.entities.Remito;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcela
 */
public class RemitoBO {

    private final RemitoDAO dao = new RemitoDAO();

    private static final Logger logger = Logger.getLogger("IvaVentasBO");

    public Remito saveIvaVentas(Remito ivaVentas) throws Exception {
        try {
            ivaVentas = (Remito) dao.save(ivaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<Remito> getAllIvaVentas() throws Exception {

        List<Remito> listIvaVentas = null;

        try {
            listIvaVentas = dao.getAll(Remito.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;

    }

    public List<Remito> getAllIvaVentasByCodigoYFecha() throws Exception {
        List<Remito> listIvaVentas = null;

        try {
            listIvaVentas = dao.getAll(Remito.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;
    }

    public List<Remito> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<Remito> fact = null;
        try {
            fact = (List<Remito>) dao.getFacturasEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    //getFacturasPanificadosEntreFechas
    public List<Remito> getFacturasPanificadosEntreFechas(Date fd, Date fa) throws Exception {
        List<Remito> fact = null;
        try {
            fact = (List<Remito>) dao.getFacturasPanificadosEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    //
    public List<Remito> getFacturasCigarrillosEntreFechas(Date fd, Date fa) throws Exception {
        List<Remito> fact = null;
        try {
            fact = (List<Remito>) dao.getFacturasCigarrillosEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<Remito> getFacturasByCodigoAndFechas(Cliente cliente, Date fd, Date fa) throws Exception {
        List<Remito> fact = null;
        try {
            fact = (List<Remito>) dao.getFacturasByCodigoAndFechas(cliente, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    //
    public void saveListaFacturas(List<Remito> facturas) throws Exception {
        if(facturas != null && !facturas.isEmpty()){
            for(Remito iv: facturas){
                try{
                    dao.save(iv);
                }catch(HibernateException ex){
                    throw new Exception("Ha ocurrido un problema intentando guardar Factura.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }
    
    public Remito getFacturaByNumero(String letra, Integer sucursal, Integer numero) throws Exception {
        Remito ivaVentas = null;
        try {
            ivaVentas = (Remito) dao.getByLetraNumero(letra,sucursal,numero);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }
}
