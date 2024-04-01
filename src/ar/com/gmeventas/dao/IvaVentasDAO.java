/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.Cliente;
import ar.com.gmeventas.entities.IvaVentas;
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
public class IvaVentasDAO extends GenericDAO{
    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) 
                session.createCriteria(IvaVentas.class)
                        .add(Restrictions.between("fecha", fd, fa))
                      //  .add(Restrictions.eq("panificado", false))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public List<IvaVentas> getFacturasPanificadosEntreFechas(Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) 
                session.createCriteria(IvaVentas.class)
                        .add(Restrictions.between("fecha", fd, fa))
                        .add(Restrictions.eq("numeroSucursal", 7))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public List<IvaVentas> getFacturasCigarrillosEntreFechas(Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) 
                session.createCriteria(IvaVentas.class)
                        .add(Restrictions.between("fecha", fd, fa))
                        .add(Restrictions.eq("numeroSucursal", 6))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public List<IvaVentas> getFacturasByCodigoAndFechas(Cliente cliente, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) 
                session.createCriteria(IvaVentas.class)
                        .add(Restrictions.between("fecha", fd, fa))
                        .add(Restrictions.eq("cliente", cliente))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return fact;
    }
    
    public IvaVentas getByLetraNumero(String letra,Integer sucursal, Integer numero) {
        IvaVentas factura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from IvaVentas iv ");
        sb.append("where iv.letra = '" + letra + "' and iv.numeroSucursal = '" 
                + sucursal + "' and iv.numeroFactura = '" + numero +"' ");
        Query query = session.createQuery(sb.toString());
        factura = (IvaVentas) query.uniqueResult();
        return factura;
    }
}
