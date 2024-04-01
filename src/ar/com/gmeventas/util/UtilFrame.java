/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.util;

import ar.com.gmeventas.entities.Cliente;
import ar.com.gmeventas.entities.IvaVentas;
import ar.com.gmeventas.entities.Titular;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Mario
 */
public class UtilFrame {
    
    private final int qr_TamAncho = 200;
    private final int qr_TamAlto = 200;
    private final String qr_formato = "png";
    private final String qr_ruta = "c:/ventas/qr/codigoQR";
    private final String qr_extension = ".png";
    private static final String qr_url = "https://www.afip.gob.ar/fe/qr/?p=";
    private static final String qr_version = "1";
    private final static SimpleDateFormat qr_sdf = new SimpleDateFormat("yyyy/MM/dd");
    private static String qr_fecha;
    private final String qr_cuit_emisor = "20339518409"; //SANTORO GASTON MATEO
    private final String qr_ptoVta = "2";
    private final String qr_tipoCmpbte = "6"; // ver estructuras
    private String qr_nroCmpbte;
    private String qr_importe;
    private final String qr_moneda="PES";
    private final String qr_cotiz="1";
    private String qr_tipoDocReceptor;
    private String qr_nroDocReceptor;
    private final String qr_tipoCodAutoriz="E";
    private String qr_codigoAutoriz;
    
    
    public static String fecha(String fe) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int largo = fe.length();
        String fe1 = fe;
        String str = sdf.format(new Date());
        if (fe.equals("")) {
            fe = sdf.format(new Date());
        } else {
            if (largo == 2) {
                fe = fe1 + str.substring(2, 10);
            } else {
                if (largo == 5) {
                    fe = fe1 + str.substring(5, 10);
                }
            }
        }
        return fe;
    }
    
    public static String crearQr(Titular titular, Cliente cliente, IvaVentas iv) {
        String data = qr_url
               + "{\"ver\":" + qr_version;
//        99
        qr_fecha = qr_sdf.format(iv.getFecha());
        /*
        
                + ",\"fecha\":\"" + fecha_qr + "\""
                + ",\"cuit\":" + cuit_qr
                + ",\"ptoVta\":" + puntoVenta_qr
                + ",\"tipoCmp\":" + tipoComprobante_qr
                + ",\"nroCmp\":" + numeroComprobante_qr
                + ",\"importe\":" + importe_qr
                + ",\"moneda\":\"" + moneda_qr + "\""
                + ",\"ctz\":" + cotiz_qr
                + ",\"tipoDocRec\":" + tipoDoc_qr
                + ",\"nroDocRec\":" + numeroDoc_qr
                + ",\"tipoCodAut\":\"" + tipoCodigoAutoriz_qr + "\""
                + ",\"codAut\":" + nroCae_qr + "}";
        */
        
        /*
        private final String qr_url = "https://www.afip.gob.ar/fe/qr/";
    private final String qr_version = "1";
    private final SimpleDateFormat qr_sdf = new SimpleDateFormat("yyyy/MM/dd");
    private final String qr_cuit_emisor = "20339518409"; //SANTORO GASTON MATEO
    private final String qr_ptoVta = "2";
    private final String qr_tipoCmpbte = "6"; // ver estructuras
    private String qr_nroCmpbte;
    private String qr_importe;
    private final String qr_moneda="PES";
    private final String qr_cotiz="1";
    private String qr_tipoDocReceptor;
    private String qr_nroDocReceptor;
    private final String qr_tipoCodAutoriz="E";
    private String qr_codigoAutoriz;
        */
        return data;
    }
}
