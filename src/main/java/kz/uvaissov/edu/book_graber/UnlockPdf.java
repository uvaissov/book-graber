package kz.uvaissov.edu.book_graber;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class UnlockPdf {
	public void manipulatePdf(String src) throws IOException, DocumentException {
		File file = new File(src);
	    PdfReader.unethicalreading = true;
	    PdfReader reader = new PdfReader(src);
	    String destPath = FilenameUtils.getFullPath(file.getAbsolutePath()) + FilenameUtils.getBaseName(file.getPath())+"-unlock."+FilenameUtils.getExtension(file.getPath());
	    File dest = new File(destPath);
	    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
	    stamper.close();
	    reader.close();
	}
}
