package presentation;

import com.itextpdf.text.DocumentException;
import dbConnection.ConnectionFactory;
import demos.TestsForRecursion;
import demos.TestsForTimer;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

/**
 * Here we have called the methods we want to measure for 10 times
 * to find the minim, maximum and average execution time for them
 */
public class MyFrame10 extends JFrame {

    JButton readDB;
    Connection connection;
    JButton fibo;
    JButton txt;
    JButton pdf;
    JButton csv;
    JButton gauss;

    public MyFrame10(){
        connection = ConnectionFactory.getConnection();

        this.setSize(700,470);
        this.setTitle("MEASURING EXECUTION");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        //setez backgoundul frame-ului
        this.getContentPane().setBackground(new Color(11,11,11));

        JLabel title = new JLabel("CHOOSE WHAT YOU WANT TO MEASURE:");
        title.setBounds(140,20,400,50);
        title.setForeground(new Color(200,200,200));
        title.setBackground(new Color(255,157,203));
        title.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,15));
        title.setVisible(true);
        this.add(title);

        //Button for readind from database
        readDB=new JButton("READ DB");
        readDB.setBackground(Color.WHITE);
        readDB.setBounds(100,100,170,30);
        readDB.addActionListener(e -> {
            if (e.getSource() == readDB){
                TestsForTimer readFromDB = new TestsForTimer();
                readFromDB.readDB();
            }
        });
        this.add(readDB);

        //Button for creating a .txt file
        txt = new JButton("WRITE INTO .TXT");
        txt.setBackground(Color.WHITE);
        txt.setBounds(100,160,170,30);
        txt.addActionListener(e -> {
            if (e.getSource() == txt){
                TestsForTimer genTXT = new TestsForTimer();
                try {
                    genTXT.generateTXT();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        this.add(txt);

        //Button for creating a .pdf file
        pdf = new JButton("WRITE INTO .PDF");
        pdf.setBackground(Color.WHITE);
        pdf.setBounds(100,220,170,30);
        pdf.addActionListener(e -> {
            if (e.getSource() == pdf){
                TestsForTimer genPDF = new TestsForTimer();
                try {
                    genPDF.generatePDF();
                } catch (FileNotFoundException | DocumentException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        });
        this.add(pdf);

        //Button for reading form a .csv file
        csv = new JButton("READ FROM .CSV");
        csv.setBackground(Color.WHITE);
        csv.setBounds(100,280,170,30);
        csv.addActionListener(e -> {
            if (e.getSource() == csv){
                TestsForTimer testCSV = new TestsForTimer();
                try {
                    testCSV.readFromCSV();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        this.add(csv);

        //Button to find usage for Fibonacci method
        fibo = new JButton("FIBONACCI");
        fibo.setBackground(Color.WHITE);
        fibo.setBounds(380,100,170,30);
        fibo.addActionListener(e -> {
            if(e.getSource() == fibo){
                TestsForRecursion testFibonacci = new TestsForRecursion();
                testFibonacci.initialize("fibonnaci");
            }
        });
        this.add(fibo);

        //Button to find usage for Gauss Sum
        gauss = new JButton("GAUSS SUM");
        gauss.setBackground(Color.WHITE);
        gauss.setBounds(380,160,170,30);
        gauss.addActionListener(e -> {
            if(e.getSource() == gauss){
                TestsForRecursion testGauss = new TestsForRecursion();
                testGauss.initialize("gaussSum");
            }
        });
        this.add(gauss);

        this.setVisible(true);
    }
}
