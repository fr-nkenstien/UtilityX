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
        String s = strategy.getResultantText();
        String[] splited = s.split("\n");
        for (String s1 : splited) {
            System.out.println("-->" + s1);
        }
        //        System.out.println(s);

        //        for (int i = 1; i <= reader.getNumberOfPages(); i++) {
        //        }
        //        /** The resulting text file. */
        //        String destination = "C:\\Users\\Vineet\\Downloads\\oc\\tmp\\out\\MongoDB in Action.txt";

        //        new PDFExtractor().parsePdf(source, destination);
    }

    public void countWords(String text) {
        String[] splitter;
        int[] counter;

        // replace any grammatical characters and split the String into an array
        splitter = text.replaceAll("[.,?!:;/]", "").split(" ");
        String temp = "";
        // intialize an int array to hold count of each word
        counter = new int[splitter.length];

        // loop through the sentence
        for (int i = 0; i < splitter.length; i++) {

            // hold current word in the sentence in temp variable
            temp = splitter[i];

            // inner loop to compare current word with those in the sentence
            // incrementing the counter of the adjacent int array for each match
            for (int k = 0; k < splitter.length; k++) {

                if (temp.equalsIgnoreCase(splitter[k])) {
                    counter[k]++;
                }
            }
        }

    }
}
