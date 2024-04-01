/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.Factura;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class FcDAO extends GenericDAO {
    
    public List<Factura> getFacturasEntreFechas(Date fd, Date fa) {
        List<Factura> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<Factura>) 
                session.createCriteria(Factura.class)
                        .add(Restrictions.between("fecha", fd, fa))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public List<Factura> getAllFacturasActivas() {
        List<Factura> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<Factura>) 
                session.createCriteria(Factura.class)
                        .add(Restrictions.eq("anulado", false))
                        .list();
        return fact;
    }
    /*
    public IvaVentas getFacturaByLetraNumero(String letra, Integer numero){
        IvaVentas factura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        factura = (IvaVentas)
                session.createCriteria(IvaVentas.class)
                .add(Restrictions.and(Restrictions.eq("letra", letra)
                        ,Restrictions.eq("numeroFactura", numero)))
                .uniqueResult();
        return factura;
    }*/
}
