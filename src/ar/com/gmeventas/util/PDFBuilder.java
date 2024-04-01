/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.gmeventas.util;

import ar.com.gmeventas.entities.IvaVentas;
import ar.com.gmeventas.entities.Remito;
import ar.com.gmeventas.entities.RenglonFactura;
import ar.com.gmeventas.entities.RenglonRemito;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.WebColors;
import java.awt.Font;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Math.rint;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author mcvalls
 */
public class PDFBuilder {

    private final BaseColor FONDO_BLANCO = WebColors.getRGBColor("#FFFFFF");
    private final BaseColor NEGRO = WebColors.getRGBColor("#000000");

    private DecimalFormat dfs = new DecimalFormat("0000");
    private DecimalFormat dfn = new DecimalFormat("00000000");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat dfc = new DecimalFormat("#0");
    private DecimalFormat df_ali = new DecimalFormat("#0.0");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");

    private final int BOLD = Font.BOLD;
    private final int PLAIN = Font.PLAIN;

    public File armarFacturaA(IvaVentas iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String fileNameFormatted = getFileNameFormatted(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);
        
        String nr0 = dfn.format(iv.getNumeroFactura());

        FileOutputStream ficheroPdf = new FileOutputStream("c:/facturas_sys/" + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();
        //JOptionPane.showMessageDialog(null, "El archivo esta GRABADO");

        // INICIO ENCABEZADO FACTURA
        String cod;
        if (iv.getLetra().equals("A")) {
            cod = "001";
        } else {
            cod = "006";
        }
        String fex = sdf.format(iv.getFecha());
        String nro = iv.getLetra() + " "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("FADALTI ADRIEL CARLOS", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph(iv.getLetra(), FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Fadalti Adriel Carlos", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: POTOSÍ 1566", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1678 - CASEROS", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("Ing.Brutos Nro.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 01/01/2013", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = iv.getCliente().getRazonSocial();
        String direcc = iv.getCliente().getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("Condición Venta: CONTADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 6;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[6];
        anchos[0] = 20;
        anchos[1] = 30;
        anchos[2] = 280;
        anchos[3] = 90;
        anchos[4] = 90;
        anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(6);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CANT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("UNITARIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            String c_ntd = String.valueOf(re.getCantidad());
            String prec = df.format(re.getTotal() / re.getCantidad());
            String tota = df.format(re.getTotal());
            String impu = df.format(re.getImpuesto());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(c_ntd, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 0; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        PdfPTable tpieFc = new PdfPTable(4);
        tpieFc.setWidthPercentage(100);

        PdfPTable pieFc = new PdfPTable(4);
        pieFc.setWidthPercentage(100);

        PdfPTable cpieFc = new PdfPTable(2);
        cpieFc.setWidthPercentage(100);

        PdfPTable dpieFc = new PdfPTable(2);
        dpieFc.setWidthPercentage(100);

        String totFc = df.format(iv.getTotal());
        String tot_iva = df.format(iv.getIva());
        String sub_tot = df.format(iv.getGravado());
        String impu = "";
        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        if (iv.getImpuesto() > 0.00) {
            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
        }

        String tpd = iv.getCliente().getTipo();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }
        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }

        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell tpieFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc2 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc3 = new PdfPCell(new Paragraph("IVA 21%", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc4 = new PdfPCell(new Paragraph("TOTAL FC", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));

        tpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        tpieFc.addCell(tpieFc1).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc2).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc3).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc4).setBorder(PdfPCell.NO_BORDER);

        pdf.add(tpieFc);

        PdfPCell pieFc1 = new PdfPCell(new Paragraph(sub_tot, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(tot_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(totFc, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);

        pdf.add(pieFc);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        PdfPCell cpieFc1 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell cpieFc2 = new PdfPCell(new Paragraph("CAE nro.:  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        cpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        cpieFc.addCell(cpieFc1).setBorder(PdfPCell.NO_BORDER);
        cpieFc.addCell(cpieFc2).setBorder(PdfPCell.NO_BORDER);

        pdf.add(cpieFc);

        com.itextpdf.text.Font font = FontFactory.getFont("C:/ventas/PF_I2OF5_TXT.ttf",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
        BaseFont baseFont = font.getBaseFont();
        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);

        PdfPCell dpieFc1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell dpieFc2 = new PdfPCell(new Paragraph(txtCadenaRP, nf));

        dpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        dpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        dpieFc.addCell(dpieFc1).setBorder(PdfPCell.NO_BORDER);
        dpieFc.addCell(dpieFc2).setBorder(PdfPCell.NO_BORDER);

        pdf.add(dpieFc);
        
        Image imagen = Image.getInstance("c://ventas//qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://ventas//qr//afip.png");
        imagen.setAbsolutePosition(20f, 80f);
        img2.setAbsolutePosition(180f, 130f);
        pdf.add(imagen);
        pdf.add(img2);

        pdf.close();
        
        return new File("c:/facturas_sys/" + fileNameFormatted + ".pdf");
        
//        return new File(fileNameFormatted);
    }

    public File armarFacturaPanificadosA(IvaVentas iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String fileNameFormatted = getFileNameFormatted(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream("c:/facturas_sys/" + fileNameFormatted + ".pdf");

        String nr0 = dfn.format(iv.getNumeroFactura());

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();
        //JOptionPane.showMessageDialog(null, "El archivo esta GRABADO");

        // INICIO ENCABEZADO FACTURA
        String cod;
        if (iv.getLetra().equals("A")) {
            cod = "001";
        } else {
            cod = "006";
        }
        String fex = sdf.format(iv.getFecha());
        String nro = iv.getLetra() + " "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("FADALTI ADRIEL CARLOS", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph(iv.getLetra(), FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Fadalti Adriel Carlos", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: POTOSÍ 1566", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1678 - CASEROS", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("Ing.Brutos Nro.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 01/01/2013", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = iv.getCliente().getRazonSocial();
        String direcc = iv.getCliente().getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("Condición Venta: CONTADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        Integer col = 6;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[6];
        anchos[0] = 20;
        anchos[1] = 30;
        anchos[2] = 280;
        anchos[3] = 90;
        anchos[4] = 90;
        anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(6);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CANT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("UNITARIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("% IVA", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            String c_ntd = String.valueOf(re.getCantidad());
            String prec = df.format(re.getTotal() / re.getCantidad());
            String tota = df.format(re.getTotal());
            String alic = df_ali.format(re.getProducto().getAlicuotaIva().getAlicuota());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(c_ntd, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(alic, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 0; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(nro_lin, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        PdfPTable tpieFc = new PdfPTable(5);
        tpieFc.setWidthPercentage(100);

        PdfPTable pieFc = new PdfPTable(5);
        pieFc.setWidthPercentage(100);

        PdfPTable cpieFc = new PdfPTable(2);
        cpieFc.setWidthPercentage(100);

        PdfPTable dpieFc = new PdfPTable(2);
        dpieFc.setWidthPercentage(100);

        String totFc = df.format(iv.getTotal());
        String tot_iva = df.format(iv.getIva());
        String tot_iva_10 = df.format(iv.getIva10_5());
        String tot_iva_27 = df.format(iv.getIva27());
        String sub_tot = df.format(iv.getGravado() + iv.getGravado0() + iv.getGravado10_5() + iv.getGravado27());
        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
//        if (iv.getImpuesto() > 0.00) {
//            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
//        }

        String tpd = iv.getCliente().getTipo();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }
        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }

        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell tpieFc1 = new PdfPCell(new Paragraph("SUBTOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc2 = new PdfPCell(new Paragraph("IVA 10.5%", FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc3 = new PdfPCell(new Paragraph("IVA 21%", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc4 = new PdfPCell(new Paragraph("IVA 27%", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell tpieFc5 = new PdfPCell(new Paragraph("TOTAL FC", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));

        tpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        tpieFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        tpieFc.addCell(tpieFc1).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc2).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc3).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc4).setBorder(PdfPCell.NO_BORDER);
        tpieFc.addCell(tpieFc5).setBorder(PdfPCell.NO_BORDER);

        pdf.add(tpieFc);

        PdfPCell pieFc1 = new PdfPCell(new Paragraph(sub_tot, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph(tot_iva_10, FontFactory.getFont("arial", 10, Font.PLAIN, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(tot_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(tot_iva_27, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph(totFc, FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);

        pdf.add(pieFc);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));

        PdfPCell cpieFc1 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell cpieFc2 = new PdfPCell(new Paragraph("CAE nro.:  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        cpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        cpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        cpieFc.addCell(cpieFc1).setBorder(PdfPCell.NO_BORDER);
        cpieFc.addCell(cpieFc2).setBorder(PdfPCell.NO_BORDER);

        pdf.add(cpieFc);

        com.itextpdf.text.Font font = FontFactory.getFont("C:/ventas/PF_I2OF5_TXT.ttf",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
        BaseFont baseFont = font.getBaseFont();
        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);

        PdfPCell dpieFc1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell dpieFc2 = new PdfPCell(new Paragraph(txtCadenaRP, nf));

        dpieFc1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        dpieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        dpieFc.addCell(dpieFc1).setBorder(PdfPCell.NO_BORDER);
        dpieFc.addCell(dpieFc2).setBorder(PdfPCell.NO_BORDER);

        pdf.add(dpieFc);

        Image imagen = Image.getInstance("c://ventas//qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://ventas//qr//afip.png");
        imagen.setAbsolutePosition(20f, 100f);
        img2.setAbsolutePosition(180f, 160f);
        pdf.add(imagen);
        pdf.add(img2);

        pdf.close();
        return new File("c:/facturas_sys/" + fileNameFormatted + ".pdf");
    }

    public File armarFacturaB(IvaVentas iv, List<RenglonFactura> rf) throws FileNotFoundException, DocumentException, Exception {
        String fileNameFormatted = getFileNameFormatted(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        String nr0 = dfn.format(iv.getNumeroFactura());

        FileOutputStream ficheroPdf = new FileOutputStream("c:/ventas/facturas/" + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();
        //JOptionPane.showMessageDialog(null, "El archivo esta GRABADO");

        // INICIO ENCABEZADO FACTURA
        String cod;
        if (iv.getLetra().equals("A")) {
            cod = "001";
        } else {
            cod = "006";
        }
        String fex = sdf.format(iv.getFecha());
        String nro = iv.getLetra() + " "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("SANTORO GASTON MATEO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph(iv.getLetra(), FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("FACTURA", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Santoro Gaston Mateo", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: Salcedo 1778", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1712 - CASTELAR", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 20-33951840-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("Ing.Brutos Nro.: 20-33951840-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 08/2017", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = iv.getCliente().getRazonSocial();
        String direcc = iv.getCliente().getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph("Condición Venta: CONTADO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        Integer col = 6;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[6];
        anchos[0] = 20;
        anchos[1] = 30;
        anchos[2] = 280;
        anchos[3] = 90;
        anchos[4] = 90;
        anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(6);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CANT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("UNITARIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("IMPUESTO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonFactura re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            String c_ntd = String.valueOf(re.getCantidad());
            String prec = df.format(re.getTotal() / re.getCantidad());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getImpuesto());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(c_ntd, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tablaProd);
//            
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        //pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);

        String totFc = df.format(iv.getTotal());
        String impu = "";
        String f_venc_cae = sdf.format(iv.getFechaCae());
        String cae_nro = dfc.format(iv.getCae());
        if (iv.getImpuesto() > 0.00) {
            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
        }

        String tpd = iv.getCliente().getTipo();
        String vto = sdf2.format(iv.getFechaCae());
        String cuit1;
        tpd = "80";
        if (tpd.equals("96")) {
            cuit1 = cui.trim();
            tpd = "96";
        } else {
            cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        }
        int x = 0;
        if (tpd.equals("96")) {
            String s = "0000000000" + cuit1;
            int lar = s.length();
            cuit1 = s.substring(lar - 11, lar);
        }

        Integer suma1 = 0;
        Integer suma2 = 0;
        String sucu = dfs.format(iv.getNumeroSucursal());
        String cae = iv.getCae().toString();
        int largo = cae.length();
        String txtCadenaRP = "";
        if (largo > 8) {
            String cadena = cuit1 + "0" + tpd + sucu + cae + vto;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);

            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
        }
        txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;

        PdfPCell pieFc1 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Total Factura:  " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph("Fecha Vencimiento CAE:  " + f_venc_cae, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc5 = new PdfPCell(new Paragraph("CAE nro.:  " + cae_nro, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        Image imagen = Image.getInstance("c://ventas//qr//CodigoQR" + nr0 + ".png");
        Image img2 = Image.getInstance("c://ventas//qr//afip.png");

        com.itextpdf.text.Font font = FontFactory.getFont("C:/ventas/PF_I2OF5_TXT.ttf",
                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
        BaseFont baseFont = font.getBaseFont();
        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));

        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        imagen.setAbsolutePosition(10f, 50f);
        img2.setAbsolutePosition(230f, 140f);
        pdf.add(imagen);
        pdf.add(img2);

        
        pdf.close();
        return new File("c:/ventas/facturas/" + fileNameFormatted + ".pdf");
    }

    public File armarRemito(Remito iv, List<RenglonRemito> rf) throws FileNotFoundException, DocumentException, Exception {
        String fileNameFormatted = getFileNameFormatted2(iv);
        Document pdf = new Document();
        Rectangle hojaA4 = new Rectangle((float) 690, (float) 990);//890
        pdf.setPageSize(hojaA4);
        pdf.setMargins(10, 50, 30, 30);
        pdf.setMarginMirroringTopBottom(true);

        FileOutputStream ficheroPdf = new FileOutputStream("c:/facturas_sys/" + fileNameFormatted + ".pdf");

        PdfWriter writer = PdfWriter.getInstance(pdf, ficheroPdf);
        writer.setInitialLeading(20);

        // ABRO EL DOCUMENTO
        pdf.open();
        //JOptionPane.showMessageDialog(null, "El archivo esta GRABADO");

        // INICIO ENCABEZADO FACTURA
        String cod = "091";
//        if (iv.getLetra().equals("A")) {
//            cod = "001";
//        } else {
//            cod = "006";
//        }
        String fex = sdf.format(iv.getFecha());
        String nro = iv.getLetra() + " "
                + dfs.format(iv.getNumeroSucursal()) + "-"
                + dfn.format(iv.getNumeroFactura());
        PdfPTable encabezado = new PdfPTable(3);
        encabezado.setWidthPercentage(100);
        PdfPCell celdaEncabezado1 = new PdfPCell(new Paragraph("FADALTI ADRIEL CARLOS", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado2 = new PdfPCell(new Paragraph("R", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado3 = new PdfPCell(new Paragraph("REMITO", FontFactory.getFont("arial", 9, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado4 = new PdfPCell(new Paragraph("Razón Social: Fadalti Adriel Carlos", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado5 = new PdfPCell(new Paragraph("Cod.: " + cod, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado6 = new PdfPCell(new Paragraph("Número: " + nro, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado7 = new PdfPCell(new Paragraph("Dirección: POTOSÍ 1566", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado8 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado9 = new PdfPCell(new Paragraph("Fecha: " + fex, FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado10 = new PdfPCell(new Paragraph("CP. 1678 - CASEROS", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado11 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado12 = new PdfPCell(new Paragraph("C.U.I.T.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado13 = new PdfPCell(new Paragraph("BUENOS AIRES", FontFactory.getFont("arial", 8, Font.BOLD, NEGRO)));
        PdfPCell celdaEncabezado14 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado15 = new PdfPCell(new Paragraph("Ing.Brutos Nro.: 23-32956044-9", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado16 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado17 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaEncabezado18 = new PdfPCell(new Paragraph("Inicio Actividad: 01/01/2013", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

        celdaEncabezado1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado5.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado7.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado8.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado9.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado10.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado11.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado12.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado13.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado14.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaEncabezado15.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado16.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado17.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaEncabezado18.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        encabezado.addCell(celdaEncabezado1).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado2).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado3).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado4).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado5).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado6).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado7).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado8).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado9).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado10).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado11).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado12).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado13).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado14).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado15).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado16).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado17).setBorder(PdfPCell.NO_BORDER);
        encabezado.addCell(celdaEncabezado18).setBorder(PdfPCell.NO_BORDER);

        pdf.add(encabezado);
        // FIN ENCABEZADO

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));

        String nombre = iv.getCliente().getRazonSocial();
        String direcc = iv.getCliente().getDomicilio().getCalle();
        if (iv.getCliente().getDomicilio().getNumero() != null) {
            direcc += " " + iv.getCliente().getDomicilio().getNumero();
        }
        if (iv.getCliente().getDomicilio().getLocalidad() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getLocalidad();
        }
        if (iv.getCliente().getDomicilio().getProvincia() != null) {
            direcc += " - " + iv.getCliente().getDomicilio().getProvincia();
        }
        String cod_cli = iv.getCliente().getCodigo();
        String cui = iv.getCliente().getCuit();
        String cat_iva;
        if (iv.getCliente().getCategoriaDeIva().equals(1)) {
            cat_iva = "Responsable Inscripto";
        } else {
            if (iv.getCliente().getCategoriaDeIva().equals(2)) {
                cat_iva = "Responsable Monotributo";
            } else {
                if (iv.getCliente().getCategoriaDeIva().equals(3)) {
                    cat_iva = "Responsable Exento";
                } else {
                    cat_iva = "Consumidor Final";
                }
            }
        }
        PdfPTable client = new PdfPTable(2);
        client.setWidthPercentage(100);
        PdfPCell celdaClient1 = new PdfPCell(new Paragraph("Razón Social: " + nombre, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient2 = new PdfPCell(new Paragraph("Cliente nro.: " + cod_cli, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient3 = new PdfPCell(new Paragraph("Dirección: " + direcc, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient4 = new PdfPCell(new Paragraph("Inscripción nro.: " + cat_iva, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient5 = new PdfPCell(new Paragraph("C.U.I.T. nro.: " + cui, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaClient6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaClient1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaClient5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        celdaClient6.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

        client.addCell(celdaClient1).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient2).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient3).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient4).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient5).setBorder(PdfPCell.NO_BORDER);
        client.addCell(celdaClient6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(client);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 6, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        Integer col = 6;
//        if(iv.getCliente().getCategoriaDeIva().equals(1)){
//            col = 7;
//        }
        PdfPTable detalle = new PdfPTable(col);
        detalle.setWidthPercentage(100);

        float[] anchos = new float[6];
        anchos[0] = 20;
        anchos[1] = 30;
        anchos[2] = 280;
        anchos[3] = 90;
        anchos[4] = 90;
        anchos[5] = 90;

        PdfPTable tablaDetalle = new PdfPTable(6);
        tablaDetalle.setWidthPercentage(100);
        tablaDetalle.setWidths(anchos);

        PdfPCell celdaTitulos1 = new PdfPCell(new Paragraph("IT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos2 = new PdfPCell(new Paragraph("CANT", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos3 = new PdfPCell(new Paragraph("DETALLE", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos4 = new PdfPCell(new Paragraph("UNITARIO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos5 = new PdfPCell(new Paragraph("TOTAL", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell celdaTitulos6 = new PdfPCell(new Paragraph("SUGERIDO", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

        celdaTitulos1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        celdaTitulos4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        celdaTitulos6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

        tablaDetalle.addCell(celdaTitulos1).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos2).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos3).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos4).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos5).setBorder(PdfPCell.NO_BORDER);
        tablaDetalle.addCell(celdaTitulos6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(tablaDetalle);

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        int coun = 0;
        for (RenglonRemito re : rf) {
            PdfPTable tablaProd = new PdfPTable(6);
            tablaProd.setWidthPercentage(100);
            tablaProd.setWidths(anchos);
            coun += 1;
            String c_nt = String.valueOf(coun);
            String c_ntd = String.valueOf(re.getCantidad());
            String prec = df.format(re.getTotal() / re.getCantidad());
            String tota = df.format(re.getTotal());
            String suge = df.format(re.getSugerido());
            PdfPCell tablaProd1 = new PdfPCell(new Paragraph(c_nt, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd2 = new PdfPCell(new Paragraph(c_ntd, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd3 = new PdfPCell(new Paragraph(" " + re.getDescripcion(), FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd4 = new PdfPCell(new Paragraph(prec, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd5 = new PdfPCell(new Paragraph(tota, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tablaProd6 = new PdfPCell(new Paragraph(suge, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));

            tablaProd1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
            tablaProd4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tablaProd6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tablaProd.addCell(tablaProd1).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd2).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd3).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd4).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd5).setBorder(PdfPCell.NO_BORDER);
            tablaProd.addCell(tablaProd6).setBorder(PdfPCell.NO_BORDER);

            pdf.add(tablaProd);
//            
        }
        for (int i = 1; i < 41 - coun; i++) {
            PdfPTable tblProd = new PdfPTable(6);
            tblProd.setWidthPercentage(100);
            tblProd.setWidths(anchos);
            String nro_lin = String.valueOf(i + coun);
            PdfPCell tP1 = new PdfPCell(new Paragraph(nro_lin, FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP2 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            PdfPCell tP6 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 8, Font.PLAIN, NEGRO)));
            tP1.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP2.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP3.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP4.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP5.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tP6.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
            tblProd.addCell(tP1).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP2).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP3).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP4).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP5).setBorder(PdfPCell.NO_BORDER);
            tblProd.addCell(tP6).setBorder(PdfPCell.NO_BORDER);
            pdf.add(tblProd);
//
//            pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        }

        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 8, PLAIN, FONDO_BLANCO)));
        pdf.add(new Paragraph("ESPACIO EN BLANCO", FontFactory.getFont("arial", 5, PLAIN, FONDO_BLANCO)));

        PdfPTable pieFc = new PdfPTable(2);
        pieFc.setWidthPercentage(100);

        String totFc = df.format(iv.getTotal());
        String impu = "";
//        String f_venc_cae = sdf.format(iv.getFechaCae());
//        String cae_nro = dfc.format(iv.getCae());
        if (iv.getImpuesto() > 0.00) {
            impu = "Total Impuesto: " + df.format(iv.getImpuesto());
        }
        PdfPCell pieFc1 = new PdfPCell(new Paragraph(impu, FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc2 = new PdfPCell(new Paragraph("Total Remito:  " + totFc, FontFactory.getFont("arial", 10, Font.BOLD, NEGRO)));
        PdfPCell pieFc3 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
        PdfPCell pieFc4 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));
//        PdfPCell pieFc5 = new PdfPCell(new Paragraph(" ", FontFactory.getFont("arial", 9, Font.PLAIN, NEGRO)));

//        com.itextpdf.text.Font font = FontFactory.getFont("C:/windows/fonts/PF_I2OF5_TXT.ttf",
//                BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 0.8f, com.itextpdf.text.Font.NORMAL, BaseColor.BLACK);
//        BaseFont baseFont = font.getBaseFont();
//        com.itextpdf.text.Font nf = new com.itextpdf.text.Font(baseFont, 15);
//        PdfPCell pieFc6 = new PdfPCell(new Paragraph(txtCadenaRP, nf));
        pieFc1.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        pieFc3.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
        pieFc4.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc5.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
//        pieFc6.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        pieFc.addCell(pieFc1).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc2).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc3).setBorder(PdfPCell.NO_BORDER);
        pieFc.addCell(pieFc4).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc5).setBorder(PdfPCell.NO_BORDER);
//        pieFc.addCell(pieFc6).setBorder(PdfPCell.NO_BORDER);
        pdf.add(pieFc);

        pdf.close();
        return new File("c:/facturas_sys/" + fileNameFormatted + ".pdf");
        //return new File(ficheroPdf);
    }

    private String getFileNameFormatted(IvaVentas cons) {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String filename = "Fc_R_Social_"
                + cons.getCliente().getRazonSocial()
                + cons.getLetra()
                + dfn.format(cons.getNumeroFactura())
                + "_" + sdf.format(cons.getFecha());
        return filename;
    }

    private String getFileNameFormatted2(Remito cons) {

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        String filename = "Remito_R_Social_"
                + cons.getCliente().getRazonSocial()
                + cons.getLetra() + dfs.format(cons.getNumeroSucursal())
                + dfn.format(cons.getNumeroFactura())
                + "_" + sdf.format(cons.getFecha());
        return filename;
    }
}
