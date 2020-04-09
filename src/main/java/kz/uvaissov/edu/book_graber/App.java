package kz.uvaissov.edu.book_graber;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
//    	GraberPdfFromUrl app = new GraberPdfFromUrl();
//    	app.copy(142);
//    	app.createPdf(142);
    	
    	
    	UnlockPdf unlockPdf = new UnlockPdf();
    	
    	try {
			unlockPdf.manipulatePdf("D:\\storage\\book\\сауат ашу дәптері 2-бөлім №1 жұмыс дәптері.pdf");
		} catch (IOException | DocumentException e) {
			e.printStackTrace();
		}
    	
    }
    
    
}
