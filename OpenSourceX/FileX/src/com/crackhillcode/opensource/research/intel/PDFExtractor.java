package com.crackhillcode.opensource.research.intel;


import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PDFExtractor {

    public PDFExtractor() {
        super();
    }

    /**
     * Parses a PDF to a plain text file.
     * @param pdf the original PDF
     * @param txt the resulting text
     * @throws IOException
     */
    synchronized public static void parsePdf(String pdf, String txt) throws IOException {
        PdfReader reader = new PdfReader(pdf);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        PrintWriter out = new PrintWriter(new FileOutputStream(txt));
        TextExtractionStrategy strategy;
        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            out.println(strategy.getResultantText());
        }
        out.flush();
        out.close();
        reader.close();
    }

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        /** The original PDF that will be parsed. */
        String source = "C:\\Users\\Vineet\\Downloads\\oc\\tmp\\MongoDB in Action.pdf";
        PdfReader reader;
        reader = new PdfReader(source);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        TextExtractionStrategy strategy;
        strategy = parser.processContent(100, new SimpleTextExtractionStrategy());
        String s=strategy.getResultantText();
        String[] splited=s.split("\n");
        for (String s1 : splited) {
            System.out.println("-->"+s1);
       }
    }
}
