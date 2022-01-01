package presentation;

import com.itextpdf.text.DocumentException;
import dao.ProductDAO;
import dbConnection.ConnectionFactory;
import myLibrary.MyTimer;
import myLibrary.RecursionCounter;
import model.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainFrame extends JFrame{

    JButton readDBButton;
    Connection connection;
    JButton fibonacciButton;
    JButton selectionSortButton;
    JButton bubbleSortButton;
    JButton writeDBButton;
    JButton generateTXTFileButton;
    JButton generatePDFFileButton;
    JButton readCSVFileButton;
    JButton insertionSortButton;
    JButton quickSortButton;
    JTextField fibonacciText;
    JLabel valueForFibonacciLabel;
    JTextField selectionSortText;
    JLabel splitArraySelectionSort;
    JTextField bubbleSortText;
    JLabel splitArrayBubbleSort;
    JTextField insertionSortText;
    JLabel splitArrayInsertionSort;
    JTextField quickSortText;
    JLabel splitArrayQuickSort;
    JTextField barChart3Text;
    JLabel splitArrayForBarChart;
    JButton barChart1;
    ProductDAO pr = new ProductDAO();
    JTextField idTextField;
    JTextField priceTextField;
    JTextField nameTextField;
    JButton barChart2;
    JButton barChart3;
    JTextField barChart2StartText;
    JTextField barChart2StopText;
    JTextField idTextField2;
    JTextField priceTextField2;
    JTextField nameTextField2;

    public MainFrame(){
        connection = ConnectionFactory.getConnection();

        this.setSize(1550,650);
        this.setTitle("MEASURING EXECUTION");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        //setez backgoundul frame-ului
        this.getContentPane().setBackground(new Color(11,11,11));

        JLabel title = new JLabel("MEASURING THE EXECUTION TIME AND THE NUMBER OF EXECUTIONS");
        title.setBounds(270,0,720,120);
        title.setForeground(new Color(200,200,200));
        title.setBackground(new Color(255,157,203));
        title.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,17));
        title.setVisible(true);
        this.add(title);

        JLabel execTime = new JLabel("Measure execution");
        execTime.setBounds(100, 100, 200, 20);
        execTime.setForeground(new Color(200,200,200));
        execTime.setBackground(new Color(255,157,203));
        execTime.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,15));
        execTime.setVisible(true);
        this.add(execTime);

        JLabel execTime2 = new JLabel("time for:");
        execTime2.setBounds(135, 125,200, 20);
        execTime2.setForeground(new Color(200,200,200));
        execTime2.setBackground(new Color(255,157,203));
        execTime2.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,15));
        execTime2.setVisible(true);
        this.add(execTime2);

        JLabel nrExec = new JLabel("Measure the number");
        nrExec.setBounds(900, 100, 200, 20);
        nrExec.setForeground(new Color(200,200,200));
        nrExec.setBackground(new Color(255,157,203));
        nrExec.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,15));
        nrExec.setVisible(true);
        this.add(nrExec);

        JLabel nrExec2 = new JLabel("of executions for:");
        nrExec2.setBounds(935, 125,200, 20);
        nrExec2.setForeground(new Color(200,200,200));
        nrExec2.setBackground(new Color(255,157,203));
        nrExec2.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,15));
        nrExec2.setVisible(true);
        this.add(nrExec2);

        JLabel generateResults1 = new JLabel("View results:");
        generateResults1.setBounds(100, 450,200, 20);
        generateResults1.setForeground(new Color(200,200,200));
        generateResults1.setBackground(new Color(255,157,203));
        generateResults1.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,15));
        generateResults1.setVisible(true);
        this.add(generateResults1);

        JLabel generateResults2 = new JLabel("View results:");
        generateResults2.setBounds(900, 450,200, 20);
        generateResults2.setForeground(new Color(200,200,200));
        generateResults2.setBackground(new Color(255,157,203));
        generateResults2.setFont(new Font("Gill Sans Ultra Bold",Font.BOLD,15));
        generateResults2.setVisible(true);
        this.add(generateResults2);

        // Button for readind from database
        readDBButton =new JButton("READ DB");
        readDBButton.setBackground(Color.WHITE);
        readDBButton.setBounds(100,160,170,30);
        readDBButton.addActionListener(e -> {
            if (e.getSource() == readDBButton){
                //Find out the execution time for reading form db
                ProductDAO p = new ProductDAO();
                MyTimer.timeIt("Reading from db takes: ");
                for (ProductDB pr : p.listAllProducts()) {
                    String addId = String.valueOf(pr.getProductId());
                    String addName = String.valueOf(pr.getProductName());
                    String addPrice = String.valueOf(pr.getProductPrice());
                    System.out.println("ID: " + addId + " Name: " + addName + " Price: " + addPrice);
                }
                System.out.println("----------------------------------------------------------------------------------------------------");
                MyTimer.timeUp();
            }
        });
        this.add(readDBButton);

        //TextFields to insert a product into the db
        idTextField = new JTextField("enter product id", 10);
        idTextField.setBounds(320, 220, 130, 30);
        this.add(idTextField);

        nameTextField = new JTextField("enter product name", 10);
        nameTextField.setBounds(460, 220, 130, 30);
        this.add(nameTextField);

        priceTextField = new JTextField("enter product price", 10);
        priceTextField.setBounds(600, 220, 130, 30);
        this.add(priceTextField);

        //Button for writing in the database
        writeDBButton =new JButton("WRITE DB");
        writeDBButton.setBackground(Color.WHITE);
        writeDBButton.setBounds(100,220,170,30);
        writeDBButton.addActionListener(e -> {
            if (e.getSource() == writeDBButton){
                //Find out the execution time for writing into db
                MyTimer.timeIt("Writing into db takes: ");
                ProductDB p = new ProductDB(Integer.parseInt(idTextField.getText()), nameTextField.getText(), Integer.parseInt(priceTextField.getText()));
                try {
                    pr.insertProduct(p);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                MyTimer.timeUp();
            }
        });
        this.add(writeDBButton);

        //Button for creating a .txt file
        generateTXTFileButton = new JButton("WRITE INTO .TXT");
        generateTXTFileButton.setBackground(Color.WHITE);
        generateTXTFileButton.setBounds(100,280,170,30);
        generateTXTFileButton.addActionListener(e -> {
            if (e.getSource() == generateTXTFileButton){
                //Find out the execution time for generation a .txt file
                MyTimer.timeIt("Generating a .txt file takes: ");
                GenerateTXT genTXT = new GenerateTXT();
                genTXT.generateTXT();
                MyTimer.timeUp();
            }
        });
        this.add(generateTXTFileButton);

        //Button for creating a .pdf file
        generatePDFFileButton = new JButton("WRITE INTO .PDF");
        generatePDFFileButton.setBackground(Color.WHITE);
        generatePDFFileButton.setBounds(100,340,170,30);
        generatePDFFileButton.addActionListener(e -> {
            if (e.getSource() == generatePDFFileButton){
                //Find out the execution time for generating a .pdf file
                MyTimer.timeIt("Generating a .pdf file takes: ");
                GeneratePDF genPDF = new GeneratePDF();
                try {
                    genPDF.generatePDF();
                } catch (DocumentException | FileNotFoundException documentException) {
                    documentException.printStackTrace();
                }
                MyTimer.timeUp();
            }
        });
        this.add(generatePDFFileButton);

        //Button for reading form a .csv file
        readCSVFileButton = new JButton("READ FROM .CSV");
        readCSVFileButton.setBackground(Color.WHITE);
        readCSVFileButton.setBounds(100,400,170,30);
        readCSVFileButton.addActionListener(e -> {
            //Find out the execution time for reading from a .csv file
            MyTimer.timeIt("Reading from a .csv file takes: ");
            ProductCSV products = new ProductCSV();
            try {
                products.readCsvFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            MyTimer.timeUp();
        });
        this.add(readCSVFileButton);

        //TextFields to insert a product into the db
        idTextField2 = new JTextField("enter product id", 10);
        idTextField2.setBounds(320, 480, 130, 30);
        this.add(idTextField2);

        nameTextField2 = new JTextField("enter product name", 10);
        nameTextField2.setBounds(460, 480, 130, 30);
        this.add(nameTextField2);

        priceTextField2 = new JTextField("enter product price", 10);
        priceTextField2.setBounds(600, 480, 130, 30);
        this.add(priceTextField2);

        //Button for generating a bar chart
        barChart1 = new JButton("GENERATE CHART");
        barChart1.setBackground(Color.WHITE);
        barChart1.setBounds(100,480,170,30);
        barChart1.addActionListener(e -> {
            if (e.getSource() == barChart1){
                JFrame frameForBarChart = new JFrame();

                ProductDAO productToInsert = new ProductDAO();

                var dataset = new DefaultCategoryDataset();

                //Find out the execution time for reading form db
                ProductDAO p = new ProductDAO();
                MyTimer.timeIt("Reading from db takes: ");
                for (ProductDB pr : p.listAllProducts()) {
                    String addId = String.valueOf(pr.getProductId());
                    String addName = String.valueOf(pr.getProductName());
                    String addPrice = String.valueOf(pr.getProductPrice());
                    System.out.println("ID: " + addId + " Name: " + addName + " Price: " + addPrice);
                }
                dataset.setValue(MyTimer.timeUp(), "Execution time", "READ DB");

                //Find out the execution time for writing into db
                MyTimer.timeIt("Writing into db takes: ");
                ProductDB prodToInsert = new ProductDB(Integer.parseInt(idTextField2.getText()), nameTextField2.getText(), Integer.parseInt(priceTextField2.getText()));
                try {
                    productToInsert.insertProduct(prodToInsert);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                dataset.setValue(MyTimer.timeUp(), "Execution time", "WRITE DB");

                //Find out the execution time for generation a .txt file
                MyTimer.timeIt("Generating a .txt file takes: ");
                GenerateTXT genTXT = new GenerateTXT();
                genTXT.generateTXT();
                dataset.setValue(MyTimer.timeUp(), "Execution time", "WRITE INTO .TXT");

                //Find out the execution time for generating a .pdf file
                MyTimer.timeIt("Generating a .pdf file takes: ");
                GeneratePDF genPDF = new GeneratePDF();
                try {
                    genPDF.generatePDF();
                } catch (DocumentException documentException) {
                    documentException.printStackTrace();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                dataset.setValue(MyTimer.timeUp(), "Execution time", "WRITE INTO .PDF");

                //Find out the execution time for reading from a .csv file
                MyTimer.timeIt("Reading from a .csv file takes: ");
                ProductCSV products = new ProductCSV();
                try {
                    products.readCsvFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                dataset.setValue(MyTimer.timeUp(), "Execution time", "READ FROM .CSV");

                JFreeChart barChart = ChartFactory.createBarChart(
                        "Measuring execution time",
                        "",
                        "execution time measured in ms",
                        dataset,
                        PlotOrientation.VERTICAL,
                        false, true, false);

                ChartPanel chartPanel = new ChartPanel(barChart);
                chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
                chartPanel.setBackground(Color.white);
                frameForBarChart.getContentPane().add(chartPanel);
                frameForBarChart.pack();
                frameForBarChart.setTitle("Results");
                frameForBarChart.setLocationRelativeTo(null);
                frameForBarChart.setVisible(true);
            }
        });
        this.add(barChart1);

        //Text field for Fibonacci
        fibonacciText=new JTextField("enter a value", 10);
        fibonacciText.setBounds(1120,160,100,30);
        this.add(fibonacciText);

        //Label for Fibonacci
        valueForFibonacciLabel = new JLabel("Recomanded value: <=43");
        valueForFibonacciLabel.setBounds(1225,160,250,40);
        valueForFibonacciLabel.setFont(new Font("Aerial",Font.BOLD,10));
        valueForFibonacciLabel.setForeground(Color.WHITE);
        this.add(valueForFibonacciLabel);

        //Button to find the execution time and the usage for Fibonacci method
        fibonacciButton = new JButton("FIBONACCI");
        fibonacciButton.setBackground(Color.WHITE);
        fibonacciButton.setBounds(900,160,170,30);
        fibonacciButton.addActionListener(e -> {
            if(e.getSource() == fibonacciButton){
                //Find out the execution time for Fibonacci
                RecursionCounter counter=new RecursionCounter();
                Integer getFibonacciText = Integer.parseInt(fibonacciText.getText());
                MyTimer.timeIt("Time taken for Fibonacci=" + getFibonacciText );
                Fibonacci resultFibonacci = new Fibonacci();
                resultFibonacci.fibonacci(getFibonacciText, counter);  //RECOMANDED VALUE: <=43
                MyTimer.timeUp();
                System.out.println("Number of executions for Fibonacci=" + getFibonacciText + ": " + counter.usagetimes("fibonacci"));
            }
        });
        this.add(fibonacciButton);

        //Text field to enter a starting value for fibonacci series
        barChart2StartText=new JTextField("enter a starting value", 10);
        barChart2StartText.setBounds(1120,480,120,30);
        this.add(barChart2StartText);

        //Text field to enter a stop value for fibonacci series
        barChart2StopText=new JTextField("enter an ending value", 10);
        barChart2StopText.setBounds(1250,480,120,30);
        this.add(barChart2StopText);

        //Button for generating a bar chart for fibonacci 10-20
        barChart2 = new JButton("FIBONACCI");
        barChart2.setBackground(Color.WHITE);
        barChart2.setBounds(900,480,170,30);
        barChart2.addActionListener(e->{
            if(e.getSource() == barChart2){
                JFrame frameForBarChart = new JFrame();

                Integer getStartingPoint = Integer.parseInt(barChart2StartText.getText());
                Integer getEndingPoint = Integer.parseInt(barChart2StopText.getText());

                ArrayList<Integer> times=new ArrayList<Integer>();
                for(int i = getStartingPoint; i < getEndingPoint + 1; i++){
                    RecursionCounter counter=new RecursionCounter();
                    Fibonacci resultFibonacci = new Fibonacci();
                    resultFibonacci.fibonacci(i, counter);
                    System.out.println("Number of executions for Fibonacci=" + i + ": " + counter.usagetimes("fibonacci"));
                    times.add(counter.usagetimes("fibonacci"));
                }

                var dataset = new DefaultCategoryDataset();

                int len = getEndingPoint - getStartingPoint + 1;

                for(int i = 0; i < len; i++){
                    int fibonacciValue = getStartingPoint + i;
                    dataset.setValue(times.get(i), "Number of executions", "F="+fibonacciValue);
                }

                JFreeChart barChart = ChartFactory.createBarChart(
                        "Fibonacci Series",
                        "",
                        "number of recusive calls",
                        dataset,
                        PlotOrientation.VERTICAL,
                        false, true, false);

                ChartPanel chartPanel = new ChartPanel(barChart);
                chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
                chartPanel.setBackground(Color.white);
                frameForBarChart.getContentPane().add(chartPanel);
                frameForBarChart.pack();
                frameForBarChart.setTitle("Results for Fibonacci Series");
                frameForBarChart.setLocationRelativeTo(null);
                frameForBarChart.setVisible(true);
            }
        });
        this.add(barChart2);

        //Text field for Selection sort
        selectionSortText=new JTextField("enter an array", 10);
        selectionSortText.setBounds(1120,220,170,30);
        this.add(selectionSortText);

        //Label for selection sort
        splitArraySelectionSort = new JLabel("Divide the values using commas!");
        splitArraySelectionSort.setBounds(1295,220,250,40);
        splitArraySelectionSort.setFont(new Font("Aerial",Font.BOLD,10));
        splitArraySelectionSort.setForeground(Color.WHITE);
        this.add(splitArraySelectionSort);

        //Button to find the execution time and the usage for selection sort
        selectionSortButton = new JButton("SELECTION SORT");
        selectionSortButton.setBackground(Color.WHITE);
        selectionSortButton.setBounds(900,220,170,30);
        selectionSortButton.addActionListener(e -> {
            if(e.getSource() == selectionSortButton){
                //Find out the execution time for sorting an array
                RecursionCounter counter=new RecursionCounter();
                String getArray = selectionSortText.getText();
                String[] arrSplit = getArray.split(", ");
                int[] arr = new int[arrSplit.length];
                for (int i=0; i < arrSplit.length; i++)
                {
                    arr[i] = Integer.parseInt(arrSplit[i]);
                }
                MyTimer.timeIt("Time taken to sort an array using resursive selection sort");
                //Find out how many times the recursive function is recalled
                RecursiveSelectionSort selectionSort;
                selectionSort = new RecursiveSelectionSort();
                selectionSort.recurSelectionSort(arr, arr.length, 0, counter);
                MyTimer.timeUp();
                System.out.println("Number of executions for Recursive Selection Sort: " + counter.usagetimes("recurSelectionSort"));
            }
        });
        this.add(selectionSortButton);

        //Text field for Bubble sort
        bubbleSortText=new JTextField("enter an array", 10);
        bubbleSortText.setBounds(1120,280,170,30);
        this.add(bubbleSortText);

        //Label for bubble sort
        splitArrayBubbleSort = new JLabel("Divide the values using commas!");
        splitArrayBubbleSort.setBounds(1295,280,250,40);
        splitArrayBubbleSort.setFont(new Font("Aerial",Font.BOLD,10));
        splitArrayBubbleSort.setForeground(Color.WHITE);
        this.add(splitArrayBubbleSort);

        //Button to find the execution time and the usage for bubble sort
        bubbleSortButton = new JButton("BUBBLE SORT");
        bubbleSortButton.setBackground(Color.WHITE);
        bubbleSortButton.setBounds(900,280,170,30);
        bubbleSortButton.addActionListener(e -> {
            if(e.getSource() == bubbleSortButton){
                //Find out the execution time for sorting an array
                RecursionCounter counter=new RecursionCounter();
                String getArray = bubbleSortText.getText();
                String[] arrSplit = getArray.split(", ");
                int[] arr = new int[arrSplit.length];
                for (int i=0; i < arrSplit.length; i++)
                {
                    arr[i] = Integer.parseInt(arrSplit[i]);
                }
                MyTimer.timeIt("Time taken to sort an array using resursive bubble sort");
                //Find out how many times the recursive function is recalled
                RecursiveBubbleSort bubbleSortResult = new RecursiveBubbleSort();
                bubbleSortResult.bubbleSort(arr, arr.length, counter);
                MyTimer.timeUp();
                System.out.println("Number of executions for Recursive Bubble Sort: " + counter.usagetimes("bubbleSort"));
            }
        });
        this.add(bubbleSortButton);

        //Text field for Insertion sort
        insertionSortText=new JTextField("enter an array", 10);
        insertionSortText.setBounds(1120,340,170,30);
        this.add(insertionSortText);

        //Label for Insertion sort
        splitArrayInsertionSort = new JLabel("Divide the values using commas!");
        splitArrayInsertionSort.setBounds(1295,340,250,40);
        splitArrayInsertionSort.setFont(new Font("Aerial",Font.BOLD,10));
        splitArrayInsertionSort.setForeground(Color.WHITE);
        this.add(splitArrayInsertionSort);

        //Button to find the execution time and the usage for insertion sort
        insertionSortButton = new JButton("INSERTION SORT");
        insertionSortButton.setBackground(Color.WHITE);
        insertionSortButton.setBounds(900,340,170,30);
        insertionSortButton.addActionListener(e -> {
            if(e.getSource() == insertionSortButton){
                //Find out the execution time for sorting an array
                RecursionCounter counter=new RecursionCounter();
                String getArray = insertionSortText.getText();
                String[] arrSplit = getArray.split(", ");
                int[] arr = new int[arrSplit.length];
                for (int i=0; i < arrSplit.length; i++)
                {
                    arr[i] = Integer.parseInt(arrSplit[i]);
                }
                MyTimer.timeIt("Time taken to sort an array using resursive insertion sort");
                //Find out how many times the recursive function is recalled
                RecursiveInsertionSort insertionSortResult = new RecursiveInsertionSort();
                insertionSortResult.insertionSort(arr, arr.length, counter);
                MyTimer.timeUp();
                System.out.println("Number of executions for Recursive Insertion Sort: " + counter.usagetimes("insertionSort"));
            }
        });
        this.add(insertionSortButton);

        //Text field for Quick sort
        quickSortText=new JTextField("enter an array", 10);
        quickSortText.setBounds(1120,400,170,30);
        this.add(quickSortText);

        //Label for Quick sort
        splitArrayQuickSort = new JLabel("Divide the values using commas!");
        splitArrayQuickSort.setBounds(1295,400,250,40);
        splitArrayQuickSort.setFont(new Font("Aerial",Font.BOLD,10));
        splitArrayQuickSort.setForeground(Color.WHITE);
        this.add(splitArrayQuickSort);

        //Button to find the execution time and the usage for quick sort
        quickSortButton = new JButton("QUICK SORT");
        quickSortButton.setBackground(Color.WHITE);
        quickSortButton.setBounds(900,400,170,30);
        quickSortButton.addActionListener(e -> {
            if(e.getSource() == quickSortButton){
                //Find out the execution time for sorting an array
                RecursionCounter counter=new RecursionCounter();
                String getArray = quickSortText.getText();
                String[] arrSplit = getArray.split(", ");
                int arr[] = new int[arrSplit.length];
                for (int i=0; i < arrSplit.length; i++)
                {
                    arr[i] = Integer.parseInt(arrSplit[i]);
                }
                MyTimer.timeIt("Time taken to sort an array using resursive quick sort");
                //Find out how many times the recursive function is recalled
                RecursiveQuickSort quickSortResult = new RecursiveQuickSort();
                quickSortResult.quickSort(arr,0, arr.length-1, counter);
                MyTimer.timeUp();
                System.out.println("Number of executions for Recursive Quick Sort: " + counter.usagetimes("quickSort"));
            }
        });
        this.add(quickSortButton);

        //Text field for all sorting methods to generate bar chart
        barChart3Text=new JTextField("enter an array", 10);
        barChart3Text.setBounds(1120,540,170,30);
        this.add(barChart3Text);

        //Label for all sorting methods to generate bar chart
        splitArrayForBarChart = new JLabel("Divide the values using commas!");
        splitArrayForBarChart.setBounds(1295,540,250,40);
        splitArrayForBarChart.setFont(new Font("Aerial",Font.BOLD,10));
        splitArrayForBarChart.setForeground(Color.WHITE);
        this.add(splitArrayForBarChart);

        //Button for generating a bar chart for sorting methods
        barChart3 = new JButton("SORTING METHODS");
        barChart3.setBackground(Color.WHITE);
        barChart3.setBounds(900,540,170,30);
        barChart3.addActionListener(e -> {
            if(e.getSource() == barChart3){
                JFrame frameForBarChart = new JFrame("Bar Chart");

                var dataset = new DefaultCategoryDataset();

                String getArray = barChart3Text.getText();
                String[] arrSplit = getArray.split(", ");
                int arr[] = new int[arrSplit.length];
                for (int i=0; i < arrSplit.length; i++)
                {
                    arr[i] = Integer.parseInt(arrSplit[i]);
                }

                //Selection sort
                RecursionCounter counterSelectionSort=new RecursionCounter();
                RecursiveSelectionSort selectionSort = new RecursiveSelectionSort();
                selectionSort.recurSelectionSort(arr, arr.length, 0, counterSelectionSort);
                System.out.println("Number of executions for Recursive Selection Sort: " + counterSelectionSort.usagetimes("recurSelectionSort"));
                dataset.setValue(counterSelectionSort.usagetimes("recurSelectionSort"), "Number of executions", "Selection Sort");

                //Bubble sort
                RecursionCounter counterBubbleSort = new RecursionCounter();
                RecursiveBubbleSort bubbleSort = new RecursiveBubbleSort();
                bubbleSort.bubbleSort(arr, arr.length, counterBubbleSort);
                System.out.println("Number of executions for Recursive Bubble Sort: " + counterBubbleSort.usagetimes("bubbleSort"));
                dataset.setValue(counterBubbleSort.usagetimes("bubbleSort"), "Number of executions", "Bubble Sort");

                //insertion sort
                RecursionCounter counterInsertionSort = new RecursionCounter();
                RecursiveInsertionSort insertionSort = new RecursiveInsertionSort();
                insertionSort.insertionSort(arr, arr.length, counterInsertionSort);
                System.out.println("Number of executions for Recursive Insertion Sort: " + counterInsertionSort.usagetimes("insertionSort"));
                dataset.setValue(counterInsertionSort.usagetimes("insertionSort"), "Number of executions", "Insertion Sort");

                //Quick sort
                RecursionCounter counterQuickSort = new RecursionCounter();
                RecursiveQuickSort quickSort = new RecursiveQuickSort();
                quickSort.quickSort(arr,0, arr.length-1, counterQuickSort);
                System.out.println("Number of executions for Recursive Quick Sort: " + counterQuickSort.usagetimes("quickSort"));
                dataset.setValue(counterQuickSort.usagetimes("quickSort"), "Number of executions", "Quick Sort");

                JFreeChart barChart = ChartFactory.createBarChart(
                        "Sorting methods",
                        "",
                        "number of recusive calls",
                        dataset,
                        PlotOrientation.VERTICAL,
                        false, true, false);

                ChartPanel chartPanel = new ChartPanel(barChart);
                chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
                chartPanel.setBackground(Color.white);
                frameForBarChart.getContentPane().add(chartPanel);
                frameForBarChart.pack();
                frameForBarChart.setTitle("Results for Sorting Methods");
                frameForBarChart.setLocationRelativeTo(null);
                frameForBarChart.setVisible(true);
            }
        });
        this.add(barChart3);

        this.setVisible(true);
    }
}
