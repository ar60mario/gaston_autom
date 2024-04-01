/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.bo;

import ar.com.gmeventas.dao.RenglonFcDAO;
import ar.com.gmeventas.entities.Factura;
import ar.com.gmeventas.entities.RenglonFc;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RenglonFcBO {

    private final RenglonFcDAO dao = new RenglonFcDAO();

    private static final Logger logger = Logger.getLogger("RenglonFcBO");

    public void saveRenglon(RenglonFc renglonFc) throws Exception {
        try {
            dao.save(renglonFc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void deleteRenglon(RenglonFc renglonFc) throws Exception {
        try {
            dao.delete(renglonFc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public void updateRenglon(RenglonFc renglonFc) throws Exception {
        try {
            dao.update(renglonFc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<RenglonFc> getAllrenglones() throws Exception {
        List<RenglonFc> renglones = null;
        try {
            renglones = dao.getAll(RenglonFc.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonFc> getAllrenglonesActivos() throws Exception {
        List<RenglonFc> renglones = null;
        try {
            renglones = dao.getAllRenglonesActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonFc> getRenglonesByFc(Factura f) throws Exception {
        List<RenglonFc> renglones = null;
        try {
            renglones = dao.getRenglonesByFactura(f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglones;
    }
    /*
    public List<RenglonFactura> getAllRenglonFacturaFromIvaVentas(IvaVentas idIvaVentas) throws Exception {
        List<RenglonFactura> listRenglonFactura = null;
        try {
            listRenglonFactura = dao.getRenglonFacturaFromIvaVentas(idIvaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonFactura;
    }
    
     public void saveFacturaYRenglones(IvaVentas iv, List<RenglonFactura> rf) throws Exception {
     dao.save(iv)
     if(listaClientes != null && !listaClientes.isEmpty()){
     for(Cliente cliente : listaClientes){
     Domicilio domicilio = cliente.getDomicilio();
     try{
     domicilio = db.saveDomicilio(domicilio);
     cliente.setDomicilio(domicilio);
     dao.save(cliente);
     }catch(HibernateException ex){
     throw new Exception("Ha ocurrido un problema intentando guardar el Cliente.\nPor favor intente nuevamente mas tarde.");
     }
     }
     }
     }
     */
}
