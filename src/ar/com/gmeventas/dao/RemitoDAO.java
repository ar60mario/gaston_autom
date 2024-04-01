/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.Cliente;
import ar.com.gmeventas.entities.Remito;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcela
 */
public class RemitoDAO extends GenericDAO{
    public List<Remito> getFacturasEntreFechas(Date fd, Date fa) {
        List<Remito> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<Remito>) 
                session.createCriteria(Remito.class)
                        .add(Restrictions.between("fecha", fd, fa))
                      //  .add(Restrictions.eq("panificado", false))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public List<Remito> getFacturasPanificadosEntreFechas(Date fd, Date fa) {
        List<Remito> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<Remito>) 
                session.createCriteria(Remito.class)
                        .add(Restrictions.between("fecha", fd, fa))
                        .add(Restrictions.eq("numeroSucursal", 7))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public List<Remito> getFacturasCigarrillosEntreFechas(Date fd, Date fa) {
        List<Remito> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<Remito>) 
                session.createCriteria(Remito.class)
                        .add(Restrictions.between("fecha", fd, fa))
                        .add(Restrictions.eq("numeroSucursal", 6))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public List<Remito> getFacturasByCodigoAndFechas(Cliente cliente, Date fd, Date fa) {
        List<Remito> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<Remito>) 
                session.createCriteria(Remito.class)
                        .add(Restrictions.between("fecha", fd, fa))
                        .add(Restrictions.eq("cliente", cliente))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public Remito getByLetraNumero(String letra,Integer sucursal, Integer numero) {
        Remito factura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Remito iv ");
        sb.append("where iv.letra = '" + letra + "' and iv.numeroSucursal = '" 
                + sucursal + "' and iv.numeroFactura = '" + numero +"' ");
        Query query = session.createQuery(sb.toString());
        factura = (Remito) query.uniqueResult();
        return factura;
    }
}
