package com.crackhillcode.opensource.cryptox.ui;


import com.crackhillcode.opensource.cryptox.processor.Decrypt;
import com.crackhillcode.opensource.cryptox.processor.Encrypt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


public class CryptoUX extends JFrame {
    @SuppressWarnings("compatibility:7696932706601614127")
    private static final long serialVersionUID = -5773170802368842809L;
    private BorderLayout layoutMain = new BorderLayout();
    private JPanel panelCenter = new JPanel();
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menuFile = new JMenu();
    private JMenuItem menuFileExit = new JMenuItem();
    private JMenu menuHelp = new JMenu();
    private JMenuItem menuHelpAbout = new JMenuItem();
    private JLabel statusBar = new JLabel();
    private ImageIcon imageOpen =
        new ImageIcon(CryptoUX.class.getResource("openfile.gif"));
    private ImageIcon imageClose =
        new ImageIcon(CryptoUX.class.getResource("closefile.gif"));
    private ImageIcon imageHelp =
        new ImageIcon(CryptoUX.class.getResource("help.gif"));
    private JLabel jLabel1 = new JLabel();
    private JTextField sourcePath = new JTextField();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JTextField destinationPath = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private JButton jButton3 = new JButton();
    private JTextArea console = new JTextArea();

    public CryptoUX() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAndShowGUI() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    CryptoUX mf = new CryptoUX();
                    mf.createAndShowGUI();
                }
            });
    }

    private void jbInit() throws Exception {
        this.setJMenuBar(menuBar);
        this.getContentPane().setLayout(layoutMain);
        panelCenter.setLayout(null);
        panelCenter.setBounds(new Rectangle(0, 0, 1000, 1000));
        this.setSize(new Dimension(1000, 1000));
        this.setTitle("CryptoX");

        this.setBounds(new Rectangle(10, 10, 1000, 1000));
        layoutMain.setHgap(5);
        layoutMain.setVgap(5);
        menuFile.setText("File");
        menuFileExit.setText("Exit");
        menuFileExit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    fileExit_ActionPerformed(ae);
                }
            });
        menuHelp.setText("Help");
        menuHelpAbout.setText("About");
        menuHelpAbout.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    helpAbout_ActionPerformed(ae);
                }
            });
        statusBar.setText("Encryption/Decryption Utility");
        jLabel1.setText("Source Path");
        jLabel1.setBounds(new Rectangle(70, 15, 95, 20));
        sourcePath.setBounds(new Rectangle(175, 15, 245, 20));
        jLabel2.setText("Destination Path");
        jLabel2.setBounds(new Rectangle(70, 50, 100, 20));
        jLabel3.setText("Password");
        jLabel3.setBounds(new Rectangle(70, 90, 65, 20));
        destinationPath.setBounds(new Rectangle(175, 50, 245, 20));
        password.setBounds(new Rectangle(175, 90, 245, 20));
        jButton1.setText("Encrypt");
        jButton1.setBounds(new Rectangle(70, 135, 165, 35));
        jButton1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton1_actionPerformed(e);
                }
            });
        jButton2.setText("Decrypt");
        jButton2.setBounds(new Rectangle(270, 135, 165, 35));
        jButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton2_actionPerformed(e);
                }
            });
        jButton3.setText("Reset");
        jButton3.setBounds(new Rectangle(455, 135, 165, 35));
        jButton3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButton3_actionPerformed(e);
                }
            });
        console.setBounds(new Rectangle(75, 190, 550, 310));
        console.setFocusable(false);
        console.setEditable(false);
        console.setAutoscrolls(true);
        console.setLineWrap(true);
        menuFile.add(menuFileExit);
        menuBar.add(menuFile);
        menuHelp.add(menuHelpAbout);
        menuBar.add(menuHelp);
        this.getContentPane().add(statusBar, BorderLayout.SOUTH);
        panelCenter.add(console, null);
        panelCenter.add(jButton3, null);
        panelCenter.add(jButton2, null);
        panelCenter.add(jButton1, null);
        panelCenter.add(password, null);
        panelCenter.add(destinationPath, null);
        panelCenter.add(jLabel3, null);
        panelCenter.add(jLabel2, null);
        panelCenter.add(sourcePath, null);
        panelCenter.add(jLabel1, null);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);
    }

    void fileExit_ActionPerformed(ActionEvent e) {
        System.out.println(e);
        System.exit(0);
    }

    void helpAbout_ActionPerformed(ActionEvent e) {
        System.out.println(e);
        JOptionPane.showMessageDialog(this, new CryptoUX_AboutBoxPanel1(),
                                      "About", JOptionPane.PLAIN_MESSAGE);
    }

    public void setLayoutMain(BorderLayout layoutMain) {
        this.layoutMain = layoutMain;
    }

    public BorderLayout getLayoutMain() {
        return layoutMain;
    }

    public void setPanelCenter(JPanel panelCenter) {
        this.panelCenter = panelCenter;
    }

    public JPanel getPanelCenter() {
        return panelCenter;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    //    public JMenuBar getMenuBar() {
    //        return menuBar;
    //    }

    public void setMenuFile(JMenu menuFile) {
        this.menuFile = menuFile;
    }

    public JMenu getMenuFile() {
        return menuFile;
    }

    public void setMenuFileExit(JMenuItem menuFileExit) {
        this.menuFileExit = menuFileExit;
    }

    public JMenuItem getMenuFileExit() {
        return menuFileExit;
    }

    public void setMenuHelp(JMenu menuHelp) {
        this.menuHelp = menuHelp;
    }

    public JMenu getMenuHelp() {
        return menuHelp;
    }

    public void setMenuHelpAbout(JMenuItem menuHelpAbout) {
        this.menuHelpAbout = menuHelpAbout;
    }

    public JMenuItem getMenuHelpAbout() {
        return menuHelpAbout;
    }

    public void setStatusBar(JLabel statusBar) {
        this.statusBar = statusBar;
    }

    public JLabel getStatusBar() {
        return statusBar;
    }

    public void setImageOpen(ImageIcon imageOpen) {
        this.imageOpen = imageOpen;
    }

    public ImageIcon getImageOpen() {
        return imageOpen;
    }

    public void setImageClose(ImageIcon imageClose) {
        this.imageClose = imageClose;
    }

    public ImageIcon getImageClose() {
        return imageClose;
    }

    public void setImageHelp(ImageIcon imageHelp) {
        this.imageHelp = imageHelp;
    }

    public ImageIcon getImageHelp() {
        return imageHelp;
    }

    //    public void setJPanel1(JPanel jPanel1) {
    //        this.jPanel1 = jPanel1;
    //    }
    //
    //    public JPanel getJPanel1() {
    //        return jPanel1;
    //    }

    private void jButton1_actionPerformed(ActionEvent e) {
        if (validateData()) {
            String in = sourcePath.getText();
            String outputPath = destinationPath.getText();
            String pwd = new String(password.getPassword());
            try {
                console.setText("Begin Encryption\n");

                (new Encrypt()).beginEncrypt(in, (pwd), outputPath, console);
                console.setText(console.getText() + "Encryption Complete");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private boolean validateData() {
        File source = new File(sourcePath.getText());
        File dest = new File(destinationPath.getText());
        boolean retVal = true;
        console.setText("");

        if (sourcePath.getText() == null || sourcePath.getText().isEmpty()) {
            Border border = BorderFactory.createLineBorder(Color.red);
            sourcePath.setBorder(border);
            console.setText(console.getText() +
                            "Source path cannot be empty\n");
            retVal = false;
        }

        if (destinationPath.getText() == null ||
            destinationPath.getText().isEmpty()) {
            Border border = BorderFactory.createLineBorder(Color.red);
            destinationPath.setBorder(border);
            console.setText(console.getText() +
                            "Destination path cannot be empty\n");
            retVal = false;
        }
        if (sourcePath.getText().equalsIgnoreCase(destinationPath.getText()) ||
            destinationPath.getText().toLowerCase().startsWith(sourcePath.getText().toLowerCase())) {
            Border border = BorderFactory.createLineBorder(Color.red);
            sourcePath.setBorder(border);
            destinationPath.setBorder(border);
            console.setText(console.getText() +
                            "Destionation path cannot be equal to source or inside source path\n");

            retVal = false;
        }
        if (!source.exists() || !source.isDirectory()) {
            Border border = BorderFactory.createLineBorder(Color.red);
            sourcePath.setBorder(border);
            console.setText(console.getText() +
                            "Source path must be a directory\n");
            retVal = false;
        } else {
            sourcePath.setBorder(null);
        }
        if (!dest.exists() || !dest.isDirectory()) {
            Border border = BorderFactory.createLineBorder(Color.red);
            destinationPath.setBorder(border);
            console.setText(console.getText() +
                            "Destination path must be a directory\n");
            retVal = false;
        } else {
            destinationPath.setBorder(null);
        }

        if (password.getPassword() == null ||
            password.getPassword().length < 8) {
            Border border = BorderFactory.createLineBorder(Color.red);
            console.setText(console.getText() +
                            "Password is mandatory and must be at least of 8 characters\n");

            password.setBorder(border);
            retVal = false;
        }
        if (retVal) {
            password.setBorder(null);
            sourcePath.setBorder(null);
            destinationPath.setBorder(null);
        }
        return retVal;
    }

    private void jButton2_actionPerformed(ActionEvent e) {
        if (validateData()) {
            String in = sourcePath.getText();
            String outputPath = destinationPath.getText();
            String pwd = new String(password.getPassword());
            try {
                console.setText("Begin Decryption\n");
                (new Decrypt()).beginDecrypt(in, (pwd), outputPath, console);
                console.setText(console.getText() + "Decryption Complete");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private void jButton3_actionPerformed(ActionEvent e) {
        sourcePath.setText("");
        destinationPath.setText("");
        password.setText("");
    }

}
