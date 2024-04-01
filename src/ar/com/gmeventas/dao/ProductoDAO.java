/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.Producto;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class ProductoDAO extends GenericDAO {

    public Producto getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        criteria.add(Restrictions.eq("panificado", false));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }
    
    public List<Producto> getAllCigarrillos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", false));
        criteria.add(Restrictions.eq("panificado", false));
        List<Producto> productos = (List<Producto>) criteria.list();
        return productos;
    }
    
    public Producto getPanificadoByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        criteria.add(Restrictions.eq("panificado", true));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }
    
    public Producto getByCodigoV(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        criteria.add(Restrictions.gt("stockMinimo", 0F));
        //criteria.add(Restrictions.eq("impuesto", 0F));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }
    
    public Producto getByCodigoPanificadoV(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        //criteria.add(Restrictions.eq("panificado", true));
        //criteria.add(Restrictions.gt("stockMinimo", 0F));
        //criteria.add(Restrictions.eq("impuesto", 0F));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }
    
    public Producto getByCodigoC(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        criteria.add(Restrictions.gt("stockMinimo", 0F));
        //criteria.add(Restrictions.gt("impuesto", 0F));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }

    public List<Producto> getAllProductosOrdenado(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        sb.append("where prod.panificado != true ");
        if (!filtro.equals("*")) {
            sb.append("and prod.detalle like :filtro ");
        }
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getAllOrdByCodigo(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        if (!filtro.equals("*")) {
            sb.append("where prod.detalle like :filtro ");
        }
        sb.append("order by prod.codigo asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getAllOrdByRubro(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        if (!filtro.equals("*")) {
            sb.append("where prod.detalle like :filtro ");
        }
        sb.append("order by prod.rubro, prod.subRubro  asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosByFiltro(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        sb.append("where prod.detalle like :filtro ");
        sb.append("and prod.panificado = false ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        productos = (List<Producto>) query.list();
        return productos;
    }
    
    public List<Producto> getProductosPanificadosByFiltro(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        sb.append("where prod.detalle like :filtro ");
        sb.append("and prod.panificado = true ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosSinCodigoBarras(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod where ");
        if (!filtro.equals("*")) {
            sb.append("prod.detalle like :filtro and ");
        }
        sb.append(" prod.codigoBarras = '0' ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getAllProductosEnCero(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod where ");
        if (!filtro.equals("*")) {
            sb.append("prod.detalle like :filtro and ");
        }
        sb.append("prod.precio = 0.0 ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.TRUE));
        criteria.addOrder(Order.asc("detalle"));

        return (List<Producto>) criteria.list();
    }

    public Producto getByCodigoBarras(Long codigoBarras) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigoBarras", codigoBarras));
        criteria.add(Restrictions.eq("panificado", false));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }
    
    public Producto getPanificadoByCodigoBarras(Long codigoBarras) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigoBarras", codigoBarras));
        criteria.add(Restrictions.eq("panificado", true));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }
    
    public Integer getUltimoCodigo() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.addOrder(Order.desc("codigo"));
        List<Producto> p = (List<Producto>) criteria.list();
        Integer c = p.get(0).getCodigo();
        return c;
    }
    
    public List<Producto> getProductosEntreCodigos(Integer de, Integer a) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod where ");
        sb.append("prod.codigo >= :de and ");
        sb.append("prod.codigo <= :a ");
        sb.append("order by prod.codigo asc");

        Query query = session.createQuery(sb.toString());
        query.setParameter("de", de);
        query.setParameter("a", a);
        productos = (List<Producto>) query.list();
        return productos;
    }
    
}
