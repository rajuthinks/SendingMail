
package com.maps.sendmail;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

/**
 *
 * @author KOTARAJA
 */
public class PDFMetadata {

    public static void main(String[] args) throws IOException, DocumentException, ParseException {

        PDDocument dDocument = PDDocument.load(new File("C:\\Users\\kotaraja\\Desktop\\testPDF\\HelloWorldModifiedlates.pdf"));
        PDDocumentInformation dDocumentInformation = dDocument.getDocumentInformation();

        Calendar c = dDocumentInformation.getCreationDate();
        Date d = c.getTime();
        System.out.println("PDFcreation date is:::" + d);

//  PdfReader pdfReader =new PdfReader("C:\\Users\\kotaraja\\Desktop\\testPDF\\chapter5.pdf");
//
//    PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("C:\\Users\\kotaraja\\Desktop\\testPDF\\HelloWorldModifiedlates.pdf"));
//    Map info = pdfReader.getInfo();
//
//    info.put("CreationDate", new PdfDate().toString());
//    pdfStamper.setMoreInfo((HashMap<String, String>) info);
//    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//    XmpWriter xmp = new XmpWriter(baos, info);
//    xmp.close();
//    pdfStamper.setXmpMetadata(baos.toByteArray());
//    pdfStamper.close();
//    pdfReader.close();

        // System.out.println("creation date is"+i);
//       	DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
//	Date date = new Date();
//	String i=dateFormat.format(date); //2016/11/16 12:08:43

        long millis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(millis);
        System.out.println(date);
        Calendar calr = Calendar.getInstance();
        Calendar calp = Calendar.getInstance();
        Date now = calp.getTime();
        calr.setTime(d);
            
        if (d.getDate() - now.getDate() == 0) {
            
            
            JavaMail_Sender sender=new JavaMail_Sender();
        sender.sendingMail("rajuthinks@gmail.com", "Introduction","The fiile date is matched to cuttent date");
            
            System.out.println("ok matched");
        } else {
                        JavaMail_Sender sender=new JavaMail_Sender();
        sender.sendingMail("rajuthinks@gmail.com", "Introduction","The file date not is not matched to cuttent date.Thanking You");
            System.out.println("error");
        }

    }
    

}
