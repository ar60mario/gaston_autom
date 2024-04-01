/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.bo;

import ar.com.gmeventas.dao.ProductoTopDAO;
import ar.com.gmeventas.entities.ProductoTop;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class ProductoTopBO {

    private final ProductoTopDAO dao = new ProductoTopDAO();
    private static final Logger logger = Logger.getLogger("ProductoTopBO");

    public void saveProductoTop(ProductoTop producto) throws Exception {
        try {
            dao.save(producto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void updateProductoTop(ProductoTop producto) throws Exception {
        try {
            dao.update(producto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<ProductoTop> getAllProductoTopActivos() throws Exception {
        List<ProductoTop> productos = null;
        try {
            productos = dao.getAllProductoTopActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<ProductoTop> getAllProductoTopActivos2() throws Exception {
        List<ProductoTop> productos = null;
        try {
            productos = dao.getAllProductoTopActivos2();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<ProductoTop> getAllProductoPanificadoTopActivos() throws Exception {
        List<ProductoTop> productos = null;
        try {
            productos = dao.getAllProductoPanificadoTopActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<ProductoTop> getAllProductoTopInactivos() throws Exception {
        List<ProductoTop> productos = null;
        try {
            productos = dao.getAllProductoTopInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public ProductoTop getProductoTopByCodigo(Integer codigo) throws Exception {
        ProductoTop prod = null;
        try {
            prod = dao.getProductoTopByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return prod;
    }
    
    public ProductoTop getProductoTopByOrder(Integer order) throws Exception {
        ProductoTop prod = null;
        try {
            prod = dao.getProductoTopByOrder(order);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return prod;
    }
    //
    public ProductoTop getProductoTopPanificadoByOrder(Integer order) throws Exception {
        ProductoTop prod = null;
        try {
            prod = dao.getProductoTopPanificadoByOrder(order);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return prod;
    }
    /*
    
    private final ClienteDAO dao = new ClienteDAO();
    
    private static final Logger logger = Logger.getLogger("ClienteBO");
    
    public List<Cliente> getAllClientes() throws Exception{
        List<Cliente> listClientes = null;
        
        try{
            listClientes = dao.getAll(Cliente.class);			
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listClientes;
    }

    public Cliente saveCliente(Cliente cliente) throws Exception{
        // Primero guardo la dirección del cliente.
        DomicilioBO domicilioBO = new DomicilioBO();
        Domicilio domicilioCliente = cliente.getDomicilio();
	domicilioCliente = domicilioBO.saveDomicilio(domicilioCliente);
        cliente.setDomicilio(domicilioCliente);
        
        try{
          dao.save(cliente);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return cliente;
    }

    public void updateCliente(Cliente cliente) throws Exception {
        
        // Primero guardo la dirección del administrador.
        DomicilioBO domicilioBO = new DomicilioBO();        
        Domicilio domicilioCliente = cliente.getDomicilio();
        domicilioCliente = domicilioBO.updateDomicilio(domicilioCliente);
        cliente.setDomicilio(domicilioCliente);
              
        try{
            cliente = (Cliente) dao.update(cliente);        
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        
    }
    
    public List<Cliente> getClienteByPagina(int paginaActual) throws Exception{
        
        List<Cliente> listadoClientes = null;
        int start = 0;
        if(paginaActual > 1){
            start = ((paginaActual - 1) * Constantes.MAX_RESULTS) + 1;            
        }
        
        try{
            listadoClientes = dao.getAll(Cliente.class, start);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        
        return listadoClientes;
        
    }

    public int getClientesCount() throws Exception {
        
        int cantidad = 0;
        
        try{
            cantidad = dao.getCount(Cliente.class);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        
        return cantidad;
        
    }

    public void deleteCliente(Cliente cliente) throws Exception {
        
        try{
          dao.delete(cliente);
          
        }
        catch(HibernateException ex){
           
            throw new Exception (ex);
        }
    }
    
    public Cliente getClienteByCuit(String cuit) throws Exception {
        Cliente cliente = null;
        try{
            cliente = dao.getByCuit(cuit);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return cliente;
    }
    
    public Cliente getClienteByCodigo(String codigo) throws Exception {
        Cliente cliente = null;
        try{
            cliente = dao.getByCodigo(codigo);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return cliente;
    }
    
    public List<Cliente> getClientesOrdenado() throws Exception{
        
        List<Cliente> listadoClientes = null;
        try{
            listadoClientes = dao.getAllClientesOrdenado();
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listadoClientes;
        
    }
    
    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
        List<Cliente> clientes = null;
        try{
            clientes = dao.getClientesByFiltro(filtro);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public void saveListaClientes(List<Cliente> listaClientes) throws Exception {
        DomicilioBO db = new DomicilioBO();
        
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
