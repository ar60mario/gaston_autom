/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.gmeventas.bo;

import ar.com.gmeventas.dao.AlicuotaIvaDAO;
import ar.com.gmeventas.entities.AlicuotaIva;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Administrador
 */
public class AlicuotaIvaBO {
    AlicuotaIvaDAO dao = new AlicuotaIvaDAO();

public List<AlicuotaIva> getAllAlicuotaIva() throws Exception {
        List<AlicuotaIva> alicuotaIva = new ArrayList();
        try{
            alicuotaIva = dao.getAll(AlicuotaIva.class);
        }
        catch(HibernateException ex){
            throw new Exception(ex);
        }
        return alicuotaIva;
    }

    public AlicuotaIva guardarAlicuotaIva(AlicuotaIva alicuotaIva) throws Exception {
        try{
            alicuotaIva = (AlicuotaIva) dao.save(alicuotaIva);
        }
        catch(HibernateException ex){
            throw new Exception();
        }
        return alicuotaIva;
    }

    public AlicuotaIva saveAlicuotaIva(AlicuotaIva alicuotaIva) throws Exception{
        
        try{
            alicuotaIva = (AlicuotaIva) dao.save(alicuotaIva);
        }catch (HibernateException ex){
            throw new Exception(ex);
        }
        return alicuotaIva;
    }

    public void updateAlicuotaIva(AlicuotaIva alicuotaIva) throws HibernateException{
        try{
            dao.update(alicuotaIva);
        } catch(HibernateException ex){
            throw new HibernateException (ex);
        }
    }

    public void deleteAlicuotaIva(AlicuotaIva alicuotaIva) throws Exception{
        try{ 
            dao.delete(alicuotaIva);
        } catch(HibernateException ex){
            throw new HibernateException (ex);    
        }
    }
    
    public AlicuotaIva getAlicuotaIvaByCodigo(Integer codigo) throws Exception {
        AlicuotaIva alicuotaIva = null;
        try{
            alicuotaIva = dao.getByCodigo(codigo);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return alicuotaIva;
    }
}
