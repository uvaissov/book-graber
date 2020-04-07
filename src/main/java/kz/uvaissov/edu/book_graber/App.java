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
    	
    	int pageCount = 142;
    	
    	App app = new App();
    	app.copy(pageCount);
    	app.createPdf(pageCount);
    }
    
    private void copy(int pageCount) {
    	for(int i = 1; i <= pageCount; i++ ) {
    		System.out.println(i);
    		try {
				FileUtils.copyURLToFile(new URL(String.format("http://special-edu.kz/TEXTBOOKS/3RAZDEL/book/1.3/files/mobile/%d.jpg", i)), new File(String.format("d:/storage/book/%d.jpg", i)));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
    
    private void createPdf(int pageCount) {
    	Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream("d:/storage/book/ImageDemo.pdf"));
            doc.open();
            
            int indentation = 0;
            
            for(int i = 1; i <= pageCount; i++) {
            
	            // Creating image by file name
	            String filename = String.format("d:/storage/book/%d.jpg", i);
	            Image image = Image.getInstance(filename);
	            float scaler = ((doc.getPageSize().getWidth() - doc.leftMargin()
	                    - doc.rightMargin() - indentation) / image.getWidth()) * 100;
	            image.scalePercent(scaler);
	            doc.add(image);
	
	            // The following line to prevent the "Server returned 
	            // HTTP response code: 403" error.
	            //System.setProperty("http.agent", "Chrome");
	
	            // Creating image from a URL
	            //String url = "https://kodejava.org/wp-content/uploads/2017/01/kodejava.png";
	            //image = Image.getInstance(url);
	            //doc.add(image);
            }
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            doc.close();
        }
    }
}
