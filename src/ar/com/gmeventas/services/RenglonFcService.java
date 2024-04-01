/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.services;

import ar.com.gmeventas.bo.RenglonFcBO;
import ar.com.gmeventas.entities.Factura;
import ar.com.gmeventas.entities.RenglonFc;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RenglonFcService {
    
    
    public void saveRenglon(RenglonFc renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            RenglonFcBO bo = new RenglonFcBO();
            bo.saveRenglon(renglon);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }
    
    public void deleteRenglon(RenglonFc renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            RenglonFcBO bo = new RenglonFcBO();
            bo.deleteRenglon(renglon);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }
    
    public List<RenglonFc> getAllrenglones() throws Exception {
        List<RenglonFc> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            renglones = new RenglonFcBO().getAllrenglones();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
        return renglones;
    }
    
    public List<RenglonFc> getAllRenglonesActivos() throws Exception {
        List<RenglonFc> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            renglones = new RenglonFcBO().getAllrenglonesActivos();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
        return renglones;
    }
    
    public List<RenglonFc> getRenglonesByFc(Factura f) throws Exception {
        List<RenglonFc> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            renglones = new RenglonFcBO().getRenglonesByFc(f);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
        return renglones;
    }
    
    public void updateRenglon(RenglonFc renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            RenglonFcBO bo = new RenglonFcBO();
            bo.updateRenglon(renglon);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }
    /*
    public List<RenglonFactura> getAllRenglonFacturaFromIvaVentas(IvaVentas idIvaVentas) throws Exception {
        List<RenglonFactura> renglonFactura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonFactura = new RenglonFacturaBO().getAllRenglonFacturaFromIvaVentas(idIvaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonFactura;
    }

    public List<RenglonNotaCredito> getAllRenglonNotaCreditoFromIvaVentas(IvaVentas idIvaVentas) throws Exception {
        List<RenglonNotaCredito> renglonNc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonNc = new RenglonNotaCreditoBO().getAllRenglonNotaCreditoFromIvaVentas(idIvaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonNc;
    }
*/
}
