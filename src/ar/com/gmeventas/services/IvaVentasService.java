/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.services;

import ar.com.gmeventas.bo.IvaVentasBO;
import ar.com.gmeventas.entities.Cliente;
import ar.com.gmeventas.entities.IvaVentas;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcela
 */
public class IvaVentasService {
    
    public IvaVentas saveIvaVentas(IvaVentas ivaVentas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().saveIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentas> getAllIvaVentas() throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getAllIvaVentas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<IvaVentas> getAllIvaVentasByCodigoYFecha(Cliente cliente,Date fechaDe,Date fechaA) throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getFacturasByCodigoAndFechas(cliente, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    //getFacturasCigarrillosEntreFechas
    public List<IvaVentas> getFacturasCigarrillosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFacturasCigarrillosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    //
    public List<IvaVentas> getFacturasPanificadosEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFacturasPanificadosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public void saveListaFacturas(List<IvaVentas> facturas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new IvaVentasBO().saveListaFacturas(facturas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public IvaVentas getFacturaByNumero(String letra,Integer sucursal, Integer numero) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = new IvaVentasBO().getFacturaByNumero(letra,sucursal,numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
}
