/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.gmeventas.bo;

import ar.com.gmeventas.dao.ConfiguracionTopDAO;
import ar.com.gmeventas.entities.ConfiguracionTop;
import ar.com.gmeventas.util.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ConfiguracionTopBO {

    private final ConfiguracionTopDAO dao = new ConfiguracionTopDAO();

//    public Configuracion getFacturas() throws Exception{
//        Configuracion facturas = dao.getFacturas();
//        return facturas;
//    }
    public ConfiguracionTop getConfigTopById(Integer id) throws Exception {
        ConfiguracionTop config = null;
        try {
            config = (ConfiguracionTop) dao.getConfigTopById(ConfiguracionTop.class, id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return config;
    }

    public void updateConfigTop(ConfiguracionTop config) throws Exception {

        try {
            config = (ConfiguracionTop) dao.update(config);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public ConfiguracionTop saveConfigTop(ConfiguracionTop configuracion) throws Exception {
        try {
            dao.save(configuracion);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return configuracion;
    }
}
