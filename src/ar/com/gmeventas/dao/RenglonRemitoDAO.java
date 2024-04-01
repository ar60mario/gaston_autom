/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.dao;

import ar.com.gmeventas.entities.Remito;
import ar.com.gmeventas.entities.RenglonRemito;
import ar.com.gmeventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Mario
 */
public class RenglonRemitoDAO extends GenericDAO{
    
    
    public List<RenglonRemito> getRenglonFacturaFromIvaVentas(Remito idIva) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        List<RenglonRemito> renglones = null;
        StringBuffer sb = new StringBuffer();
        sb.append("from RenglonRemito rf ");
        sb.append("where rf.ivaVentas = :idIva ");
//        sb.append("and rf.fechaPeriodo = :anio ");
//        sb.append("order by ic.fechaPeriodo asc");
        
        Query query = session.createQuery(sb.toString());
        query.setParameter("idIva",  idIva );
//        query.setParameter("anio", anio);
        
        renglones = (List<RenglonRemito>) query.list();
                
        return renglones;
    }
    
}
