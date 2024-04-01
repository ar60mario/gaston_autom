/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.services;

import ar.com.gmeventas.bo.RemitoBO;
import ar.com.gmeventas.bo.RenglonRemitoBO;
import ar.com.gmeventas.entities.Cliente;
import ar.com.gmeventas.entities.Remito;
import ar.com.gmeventas.entities.RenglonRemito;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcela
 */
public class RemitoService {
    
    public Remito saveIvaVentas(Remito ivaVentas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new RemitoBO().saveIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public void saveRemito(Remito iv, List<RenglonRemito> rf) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        RemitoBO ivaBO = new RemitoBO();
        Remito ivaVentas = ivaBO.saveIvaVentas(iv);
        Boolean bolean = true;
        for (RenglonRemito renglon : rf) {
            renglon.setRemito(ivaVentas);
            try {
                RenglonRemitoBO bo = new RenglonRemitoBO();
                bo.saveRenglon(renglon);
            } catch (Exception ex) {
                bolean = false;
                tx.rollback();
                throw new Exception(ex);
            }
        }
        if (bolean) {
            tx.commit();
        }
    }
    
    public List<Remito> getAllIvaVentas() throws Exception {
        List<Remito> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new RemitoBO().getAllIvaVentas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<Remito> getAllIvaVentasByCodigoYFecha(Cliente cliente,Date fechaDe,Date fechaA) throws Exception {
        List<Remito> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new RemitoBO().getFacturasByCodigoAndFechas(cliente, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<Remito> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<Remito> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new RemitoBO().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    //getFacturasCigarrillosEntreFechas
    public List<Remito> getFacturasCigarrillosEntreFechas(Date fd, Date fa) throws Exception {
        List<Remito> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new RemitoBO().getFacturasCigarrillosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    //
    public List<Remito> getFacturasPanificadosEntreFechas(Date fd, Date fa) throws Exception {
        List<Remito> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new RemitoBO().getFacturasPanificadosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public void saveListaFacturas(List<Remito> facturas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RemitoBO().saveListaFacturas(facturas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public Remito getFacturaByNumero(String letra,Integer sucursal, Integer numero) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Remito ivaVentas = null;
        try {
            ivaVentas = new RemitoBO().getFacturaByNumero(letra,sucursal,numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
}
