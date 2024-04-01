/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.gmeventas.services;

import ar.com.gmeventas.bo.AlicuotaIvaBO;
import ar.com.gmeventas.entities.AlicuotaIva;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrador
 */
public class AlicuotaIvaService {

    public List<AlicuotaIva> getAllAlicuotaIva() throws Exception {
        List<AlicuotaIva> alicuotaIva = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            AlicuotaIvaBO bo = new AlicuotaIvaBO();
            alicuotaIva = bo.getAllAlicuotaIva();
            tx.commit();
        }
        catch(Exception ex){
           tx.rollback();
            throw new Exception(ex);   
        }
        return alicuotaIva;
    }
    
    public void saveAlicuotaIva(AlicuotaIva alicuotaIva)  throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new AlicuotaIvaBO().saveAlicuotaIva(alicuotaIva);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void updateAlicuotaIva(AlicuotaIva alicuotaIva) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            new AlicuotaIvaBO().updateAlicuotaIva(alicuotaIva);
            tx.commit();
        }
        catch(HibernateException ex){
            tx.rollback();
            throw new HibernateException (ex);
        }
    }

    public void deleteAlicuotaIva(AlicuotaIva alicuotaIva) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            new AlicuotaIvaBO().deleteAlicuotaIva(alicuotaIva);
            tx.commit();
        }
        catch (Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }
    
    public AlicuotaIva getAlicuotaIvaByCodigo(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        AlicuotaIva alicuotaIva = null;
        try {
            alicuotaIva = new AlicuotaIvaBO().getAlicuotaIvaByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return alicuotaIva;
    }
}
