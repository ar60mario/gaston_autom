/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.ProductoTop;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class ProductoTopDAO extends GenericDAO {
    
    public List<ProductoTop> getAllProductoTopActivos(){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ProductoTop.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("panificado", false));
        List<ProductoTop> productos = criteria.list();
        return productos;
    }
    
    public List<ProductoTop> getAllProductoTopActivos2(){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ProductoTop.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.gt("stock", 0F));
        criteria.add(Restrictions.eq("panificado", false));
        List<ProductoTop> productos = criteria.list();
        return productos;
    }
    
    public List<ProductoTop> getAllProductoPanificadoTopActivos(){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ProductoTop.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("panificado", true));
        List<ProductoTop> productos = null;
        productos = criteria.list();
        return productos;
    }
    
    public List<ProductoTop> getAllProductoTopInactivos(){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ProductoTop.class);
        criteria.add(Restrictions.eq("activo", false));
        List<ProductoTop> productos = null;
        productos = criteria.list();
        return productos;
    }
    
    public ProductoTop getProductoTopByCodigo(Integer codigo){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ProductoTop.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        ProductoTop prod = (ProductoTop) criteria.uniqueResult();
        return prod;
    }
    
    public ProductoTop getProductoTopByOrder(Integer order){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ProductoTop.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("panificado", false));
        criteria.add(Restrictions.eq("orden", order));
        ProductoTop prod = (ProductoTop) criteria.uniqueResult();
//        Integer codigo = prod.getCodigo();
//        Producto p = null;
//        try {
//            p = new ProductoService().getProductoByCodigo(codigo);
//        } catch (Exception ex) {
//            Logger.getLogger(ProductoTopDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if(p.getStock() < 1){
//            prod = null;
//        }
        return prod;
    }
    
    public ProductoTop getProductoTopPanificadoByOrder(Integer order){
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ProductoTop.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.eq("panificado", true));
        criteria.add(Restrictions.eq("orden", order));
        ProductoTop prod = (ProductoTop) criteria.uniqueResult();
        return prod;
    }
    /*
    public Cliente getByCuit(String cuit) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("cuit", cuit));
        Cliente cliente = (Cliente) criteria.uniqueResult();
        return cliente;
    }

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
    */
}
