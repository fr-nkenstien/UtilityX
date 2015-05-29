package com.crackhillcode.opensource.cryptox.processor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

import javax.swing.JTextArea;

public class Encrypt {

    static String pwd = "";

    private static String compressPassword(String pass) {
        char[] tmp = new char[8];
        if (pass.length() > 8) {
            for (int i = 0; i < pass.toCharArray().length; i++) {
                tmp[i % 7] += pass.toCharArray()[i];
            }
            pass = new String(tmp);
        }
        return pass;
    }

    public void beginEncrypt(String in, String pass, String outputPath,
                             JTextArea console) throws Exception {
        try {
            pass = compressPassword(pass);
            processEncrypt(in, outputPath, (pass), console);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String encryptName(String str) {
        String encrypted = "";
        int keyLength = pwd.length();
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);

            if (Character.isUpperCase(c)) {
                // 26 letters of the alphabet so mod by 26
                c = c + (keyLength % 26);
                if (c > 'Z')
                    c = c - 26;
            } else if (Character.isLowerCase(c)) {
                c = c + (keyLength % 26);
                if (c > 'z')
                    c = c - 26;
            }
            encrypted += (char)c;
        }
        return encrypted;
    }

    private void encrypt(File fileIn, File fileOut, String pass,
                         JTextArea console) throws Exception {

        fileIn.setReadable(true);
        fileOut.setWritable(true);
        fileOut.setReadable(true);
        FileInputStream fis = new FileInputStream(fileIn);
        FileOutputStream fos = new FileOutputStream(fileOut);
        byte k[] = pass.getBytes();
        final String algo = "DES/ECB/PKCS5Padding";
        SecretKeySpec key = new SecretKeySpec(k, algo.split("/")[0]);
        Cipher encrypt = Cipher.getInstance(algo);
        encrypt.init(Cipher.ENCRYPT_MODE, key);
        CipherOutputStream cout = new CipherOutputStream(fos, encrypt);

        byte[] buf = new byte[1024];
        int read;
        while ((read = fis.read(buf)) != -1) {
            cout.write(buf, 0, read);
            //            System.out.print(".");
            console.setText(console.getText() + ".");

        }
        console.setText(console.getText() + "." + fileOut.getName() +
                        " encrypted!\n");

        fis.close();
        cout.flush();
        cout.close();
    }

    private void processEncrypt(String in, String out, String pass,
                                JTextArea console) throws IOException {

        File fin = new File(in);
        File fout = new File(out);
        fout.setWritable(true);
        fout.setReadable(true);
        fin.setReadable(true);

        if (fin.getName().startsWith(".")) {
            return;
        }

        if (!fout.exists() && fin.isDirectory() &&
            !fin.getName().equals("Encrypt")) {
            fout.mkdirs();
            fout.setWritable(true);
        } else if (!fin.isDirectory()) {
            try {
                encrypt(fin, new File(out), pass, console);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (fin.isDirectory() && !fin.getName().equals("Encrypt")) {
            for (int i = 0; i < fin.list().length; i++) {
                processEncrypt(in + "/" + fin.list()[i],
                               out + "/" + encryptName(fin.list()[i]), pass,
                               console);
            }
        }
    }

}
