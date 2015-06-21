package com.crackhillcode.opensource.filex;

import java.io.File;

public class TxNameCorrection {
    public TxNameCorrection() {
        super();
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\Vineet\\Downloads\\torrentz\\test"; ///"C:\\Users\\Vineet\\Downloads\\pricing\\t";//
        File f = new File(path);
        if (f.exists()) {
            File[] files = f.listFiles();
            for (File file : files) {
                String fileName = file.getAbsolutePath();
                String ext = fileName.substring(fileName.lastIndexOf("."));
                fileName = fileName.substring(0, fileName.lastIndexOf(".")).replaceAll("\\.", " ");
                fileName = fileName.replaceAll("\\[(.*?)\\]", "");
                fileName = fileName.replaceAll("(?<=20).*", "");
                fileName = fileName.replaceAll("(?<=HDTV).*", "");
                if (fileName.endsWith(" 20")) {
                    fileName = fileName.replaceAll(" 20", "");
                }
                fileName = (fileName + ext).replaceFirst("20\\.", ".");
                System.out.println("File: " + fileName);
                file.renameTo(new File(fileName));
            }
        } else {

            System.out.println("File does not exists");
        }

    }

}
