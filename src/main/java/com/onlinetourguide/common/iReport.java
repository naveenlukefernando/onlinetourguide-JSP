package com.onlinetourguide.common;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;

public class iReport {

    private String path = "C:\\Users\\Luke\\IdeaProjects\\onlinetourguide-JSP\\src\\main\\webapp\\reports\\";
    private String filename = path+"example"+1+".pdf";


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) {

        iReport report = new iReport();

        Document document = new Document();

        try {
            PdfWriter.getInstance(document,new FileOutputStream(report.getFilename()));

            document.open();

            Paragraph paragraph = new Paragraph("This is paragraph");
            document.add(paragraph);

            document.close();
            System.out.println("Done !");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
