/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.services;

import ar.com.gmeventas.bo.RenglonRemitoBO;
import ar.com.gmeventas.entities.Remito;
import ar.com.gmeventas.entities.RenglonRemito;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RenglonRemitoService {
    
    
    public void saveRenglon(RenglonRemito renglon) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            RenglonRemitoBO bo = new RenglonRemitoBO();
            bo.saveRenglon(renglon);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }
    
    public List<RenglonRemito> getAllRenglonFacturaFromIvaVentas(Remito idIvaVentas) throws Exception {
        List<RenglonRemito> renglonFactura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonFactura = new RenglonRemitoBO().getAllRenglonFacturaFromIvaVentas(idIvaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonFactura;
    }
}
