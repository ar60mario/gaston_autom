/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.ConfiguracionTop;
import ar.com.gmeventas.util.HibernateUtils;
//import org.hibernate.classic.Session;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author Mar y Mar Informatica
 */
public class ConfiguracionTopDAO extends GenericDAO{
    
//    public Configuracion getFacturas() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Configuracion.class);
//        Configuracion facturas = (Configuracion) criteria;
//        return facturas;
//    }
    
    public Object getConfigTopById(Class clase, Integer id) throws HibernateException{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Object obj = session.createCriteria(clase)
                            .add(Restrictions.eq("id", id))
                                .uniqueResult();
        return obj;        
    }
    /*
    Update
    */

/*
    public Cliente getByCodigo(String codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        
        Cliente cliente = (Cliente) criteria.uniqueResult();
        return cliente;
    }
    
    public List<Cliente> getAllClientesOrdenado() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Cliente>) criteria.list();
    }
    
    public List<Cliente> getClientesByFiltro(String filtro) {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
        StringBuffer sb = new StringBuffer();
        sb.append("from Cliente clie ");
        sb.append("where clie.razonSocial like :filtro ");
        sb.append("order by clie.razonSocial asc");
        
        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%"+filtro+"%");
        
        clientes = (List<Cliente>) query.list();
                
        return clientes;
    }
}
    */
}
