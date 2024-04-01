/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.services;

import ar.com.gmeventas.bo.FcBO;
import ar.com.gmeventas.entities.Factura;
import ar.com.gmeventas.entities.RenglonFc;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class FcService {

    public void saveFactura(Factura fc, List<RenglonFc> rf) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FcBO fBo = new FcBO();
        try {
            fBo.saveFacturaCompleta(fc, rf);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void deleteFactura(Factura fc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FcBO fBo = new FcBO();
        try {
            fBo.deleteFactura(fc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void updateFactura(Factura fc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FcBO fBo = new FcBO();
        try {
            fBo.updateFactura(fc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Factura> getAllFacturas() throws Exception {
        List<Factura> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FcBO fBo = new FcBO();
        try {
            facturas = fBo.getAllFacturas();
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    
    public List<Factura> getAllFacturasActivas() throws Exception {
        List<Factura> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        FcBO fBo = new FcBO();
        try {
            facturas = fBo.getAllFacturasActivas();
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
    /*   
    public void saveNotaCredito(IvaVentas iv, List<RenglonNotaCredito> rf) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentasBO ivaBO = new IvaVentasBO();
        IvaVentas ivaVentas = ivaBO.saveIvaVentas(iv);
        Boolean bolean = true;
        for (RenglonNotaCredito renglon : rf) {
            renglon.setIvaVentas(ivaVentas);
            try {
                RenglonNotaCreditoBO bo = new RenglonNotaCreditoBO();
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
    
     */
}
