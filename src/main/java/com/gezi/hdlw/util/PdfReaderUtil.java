package com.gezi.hdlw.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
@Service
public class PdfReaderUtil {   
	 public static String pdfToString(File file) {
		 
			String content = null;
			InputStream input = null;
			PDDocument document = null;
			try {
				input = new FileInputStream(file);
				boolean sort = false;
				// 开始提取页数
				int startPage = 1;
				// 结束提取页数
				int endPage = Integer.MAX_VALUE;
				document = PDDocument.load(input);
				PDFTextStripper pts = new PDFTextStripper();
				pts.setSortByPosition(sort);
				endPage = document.getNumberOfPages();
				//System.out.println("Total Page: " + endPage);
				pts.setStartPage(startPage);
				pts.setEndPage(endPage);
				content = pts.getText(document);
				return content;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPasswordException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
			return "";
		}

}