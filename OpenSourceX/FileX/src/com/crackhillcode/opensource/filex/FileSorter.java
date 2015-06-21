package com.crackhillcode.opensource.filex;


import java.io.File;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

import org.blinkenlights.jid3.ID3Tag;
import org.blinkenlights.jid3.MP3File;
import org.blinkenlights.jid3.MediaFile;
import org.blinkenlights.jid3.v2.ID3V2_3_0Tag;

public class FileSorter {
    private Date getLastModified(File file) {
        return new Date(file.lastModified());
    }

    private String convert(Date file) throws ParseException {
        return new SimpleDateFormat("yyyy-MM").format(file.getTime());
    }

    /**acasd.
     * @param args asca
     */
    public static void main(String[] args) {
        FileSorter p = new FileSorter();
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the folder path that you want sorted: ");
        String filePath = in.nextLine();
        System.out.println("Please enter what kind of sorting you want??");
        System.out.println("   1. Month Sorting");
        System.out.println("   2. Alphabetic Sorting");
        System.out.println("   3. Music Album Sorting");
        System.out.println("   5. Extention Sorting");
        try {
            int s = Integer.parseInt(in.nextLine());
            switch (s) {
            case 1:
                p.startSort(filePath);
                break;
            case 2:
                p.alphaSort(filePath);
                break;
            case 3:
                p.startMusicSort(filePath);
                break;
            case 5:
                p.extnSort(filePath);
                break;
            default:
                System.out.println("Invalid Option");
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**ascas.
     * @param path asa
     * @return awd
     */
    public String getRange(String path) {
        String ret_String = "";
        for (int i = 97; i <= 122; i++) {
            if ((int) path.toLowerCase().charAt(0) >= i && (int) path.toLowerCase().charAt(0) <= (i + 3)) {
                ret_String = ((char) i + "-" + ((char) (i + 3)));
                break;
            } else if ((int) path.toLowerCase().charAt(0) >= 32 && (int) path.toLowerCase().charAt(0) <= 64) {
                ret_String = ("#0-9");
                break;
            } else {
                i += 3;
            }
        }
        return ret_String;
    }

    /**ascas.
     * @param filePath as
     * @throws Exception asc
     * @throws ParseException asacs
     */
    public void startSort(String filePath) throws Exception, ParseException {

        File dir = new File(filePath);
        File folder = null;
        String newFilePath = null;
        TreeSet<String> ts = new TreeSet<String>();

        if (dir.isDirectory()) {

            for (File file : dir.listFiles()) {
                newFilePath = convert(getLastModified(file));
                ts.add(newFilePath);
            }

            for (String o : ts) {
                folder = new File(filePath + "\\" + o);
                folder.mkdirs();

                for (File file : dir.listFiles()) {
                    newFilePath = convert(getLastModified(file));
                    if (newFilePath.equals(o)) {
                        if (file.isFile()) {
                            file.renameTo(new File(filePath + "\\" + o + "\\" + file.getName()));
                        }
                    }
                }
            }
        }
    }

    /**ascas.
     * @param filePath asc
     * @throws Exception a
     * @throws ParseException asc
     */
    public void alphaSort(String filePath) throws Exception, ParseException {

        File dir = new File(filePath);
        File folder = null;
        String newFilePath = null;
        TreeSet<String> ts = new TreeSet<String>();

        if (dir.isDirectory()) {

            for (File file : dir.listFiles()) {
                newFilePath = getRange(file.getName());
                ts.add(newFilePath);
            }

            for (String o : ts) {
                folder = new File(filePath + "\\" + o);
                folder.mkdirs();

                for (File file : dir.listFiles()) {
                    newFilePath = getRange(file.getName());
                    if (newFilePath.equals(o)) {
                        if (file.isFile()) {
                            file.renameTo(new File(filePath + "\\" + o + "\\" + file.getName()));
                        }
                    }
                }
            }
        }
    }

    public void extnSort(String filePath) throws Exception, ParseException {

        File dir = new File(filePath);
        File folder = null;
        String newFilePath = null;
        TreeSet<String> ts = new TreeSet<String>();

        if (dir.isDirectory()) {

            for (File file : dir.listFiles()) {
                if (file.getName().lastIndexOf(".") > 0) {
                    newFilePath =
                        (file.getName().substring(file.getName().lastIndexOf(".") + 1,
                                                  file.getName().length())).toLowerCase();
                } else {
                    continue;
                }
                ts.add(newFilePath);
            }

            for (String o : ts) {
                folder = new File(filePath + "\\" + o);
                folder.mkdirs();

                for (File file : dir.listFiles()) {
                    if (file.getName().lastIndexOf(".") > 0) {
                        newFilePath =
                            (file.getName().substring(file.getName().lastIndexOf(".") + 1,
                                                      file.getName().length())).toLowerCase();
                    } else {
                        continue;
                    }

                    if (newFilePath.equals(o)) {
                        if (file.isFile()) {
                            file.renameTo(new File(filePath + "\\" + o + "\\" + file.getName()));
                        }
                    }
                }
            }
        }
    }

    /**ascas.
     * @param filePath asc
     * @throws Exception asdas
     * @throws ParseException aas
     */
    public void startMusicSort(String filePath) throws Exception, ParseException {

        File dir = new File(filePath);
        File folder = null;
        String newFilePath = null;
        TreeSet<String> ts = new TreeSet<String>();

        if (dir.isDirectory()) {

            for (File file : dir.listFiles()) {
                newFilePath = (getAlbumName(file));
                ts.add(newFilePath);
            }

            for (String o : ts) {
                folder = new File(filePath + "\\" + o);
                folder.mkdirs();

                for (File file : dir.listFiles()) {
                    newFilePath = (getAlbumName(file));
                    if (newFilePath.equals(o)) {
                        if (file.isFile()) {
                            file.renameTo(new File(filePath + "\\" + o + "\\" + file.getName()));
                        }
                    }
                }
            }
        }
    }

    private String getAlbumName(File oSourceFile) {
        MediaFile oMediaFile = new MP3File(oSourceFile);
        ID3Tag[] aoID3Tag;
        try {
            aoID3Tag = oMediaFile.getTags();
            for (int i = 0; i < aoID3Tag.length; i++) {
                if (aoID3Tag[i] instanceof ID3V2_3_0Tag) {
                    ID3V2_3_0Tag oID3V2_3_0Tag = (ID3V2_3_0Tag) aoID3Tag[i];
                    try {
                        return ("".equals(oID3V2_3_0Tag.getAlbum().trim()) ? "Misc" :
                                oID3V2_3_0Tag.getAlbum().replaceAll("\"", "")); // reads TYER frame
                    } catch (Exception e) {
                        e.getStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return "Misc";
    }

    /**ascas.
     * @return ascas.
     */
    public String toString() {
        return super.toString();
    }

    public static String lcs(String a, String b) {
        int[][] lengths = new int[a.length() + 1][b.length() + 1];

        // row 0 and column 0 are initialized to 0 already

        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                else
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);

        // read the substring out from the matrix
        StringBuffer sb = new StringBuffer();
        for (int x = a.length(), y = b.length(); x != 0 && y != 0;) {
            if (lengths[x][y] == lengths[x - 1][y])
                x--;
            else if (lengths[x][y] == lengths[x][y - 1])
                y--;
            else {
                assert a.charAt(x - 1) == b.charAt(y - 1);
                sb.append(a.charAt(x - 1));
                x--;
                y--;
            }
        }

        return sb.reverse().toString();
    }
}
