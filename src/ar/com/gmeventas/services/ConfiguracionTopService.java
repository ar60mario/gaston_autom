package ar.com.gmeventas.services;

import ar.com.gmeventas.bo.ConfiguracionTopBO;
import ar.com.gmeventas.entities.ConfiguracionTop;
import ar.com.gmeventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConfiguracionTopService {
    
    public ConfiguracionTop getConfigTopById(Integer id) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ConfiguracionTop config = null;
        try {
            config = new ConfiguracionTopBO().getConfigTopById(id);
            tx.commit();
        }catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    return config;
    }
    
    public void saveConfigTop(ConfiguracionTop conf) throws Exception{
        
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ConfiguracionTopBO().saveConfigTop(conf);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    

    public void updateConfigTop(ConfiguracionTop config) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ConfiguracionTopBO().updateConfigTop(config);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
}
