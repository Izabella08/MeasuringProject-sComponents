package demos;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import dao.ProductDAO;
import myLibrary.MyTimer;
import model.ProductDB;
import model.ProductCSV;

import java.io.*;
import java.util.ArrayList;

public class TestsForTimer {

    /**
     * Method to dispay the minimum, maximum and average execution time
     * for reading for 10 times form the database
     */
    public void readDB(){
        long average=0, min=100000, max=0;
        ArrayList<Long> times=new ArrayList<Long>();
        for(int i=0;i<10;i++) {
            ProductDAO p = new ProductDAO();
            MyTimer.timeIt();
            for (ProductDB pr : p.listAllProducts()) {
                String addId = String.valueOf(pr.getProductId());
                String addName = String.valueOf(pr.getProductName());
                String addPrice = String.valueOf(pr.getProductPrice());
                System.out.println("ID: " + addId + " Name: " + addName + " Price: " + addPrice);
            }
            times.add(MyTimer.timeUp());
        }

        for(long item:times){
            average += item;
            if(item < min){
                min = item;
            }
            if(item > max){
                max = item;
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Minimum time for reading form DB: "+min+ " ms" + "\nMaximum time for reading from DB: "+max+ " ms" + "\nAverage time for reading from DB: "+average/10.0f + " ms");
        System.out.println("----------------------------------------------------------------------------------------------------");

    }

    /**
     * Method to dispay the minimum, maximum and average execution time
     * for creating 10 .txt files
     * @throws IOException
     */
    public void generateTXT() throws IOException {
        long average=0, min=100000, max=0;
        ArrayList<Long> times=new ArrayList<Long>();
        File f;
        for(int i=0; i < 10; i++) {
            MyTimer.timeIt();
            f = new File("out" + i + ".txt");
            f.createNewFile();
            try (Writer writer = new BufferedWriter(new FileWriter(f))) {
                String contents = "The Technical University of Cluj-Napoca, an “Advanced Research and Education University” as awarded with the Order of the Ministry of National Education no 5262/September 5th 2011, is today a tertiary educational institution having both tradition and national and international recognition."
                        + System.getProperty("line.separator") + "The Technical University of Cluj-Napoca comprises twelve faculties in the two academic centres, Cluj-Napoca and Baia Mare, as well as in locations, such as Alba-Iulia, Bistrita, Satu Mare and Zalau. The educational offer, aligned to the Bologna system, includes bachelor's, master's and doctoral programs, as well as continuous training programs."
                        + System.getProperty("line.separator") + "The fields of study have a wide range, from engineering to architecture, fundamental sciences, socio-human sciences and arts. Also, within the Technical University, the Department for Continuing Education, Distance Learning and with Reduced Frequency organizes and conducts continuous education activities and programs, postgraduate courses, continuous professional development programs or courses or based on occupational standards."
                        + System.getProperty("line.separator") + "The Technical University of Cluj-Napoca is concerned with the international exchange of scientific values, and this trend is found in the over 400 inter-university collaboration agreements or in the large number of student mobilities. Opening up towards the European and world space of education and research through a steady process of internationalization is one of the major objectives of the university."
                        + System.getProperty("line.separator") + "Research is, along with education, the main priority of the Technical University of Cluj-Napoca. In all faculties of the university there are research structures, from collectives, groups and laboratories, to research centers and platforms.  The performance anchored in the  socio-economic environment, the international visibility and cooperation as well as the scientific novelty and interdisciplinarity are some of the characteristics of the research environment of the Technical University of Cluj-Napoca."
                        + System.getProperty("line.separator") + "Open research directions are oriented towards global priorities and perspectives: from the Information and communications technology to Renewable Energy and Ecology; from superconductivity, spintronics and nanomaterials, to management and robotics; from mechatronics and electrical engineering, to the automobile and the home of the future, or to urbanism and society.";
                writer.write(contents);
            } catch (IOException e) {
                e.printStackTrace();
            }
            times.add(MyTimer.timeUp());
        }

        for(long item:times){
            average += item;
            if(item < min){
                min = item;
            }
            if(item > max){
                max = item;
            }
        }
        System.out.println("Minimum time for creating a .txt: "+min+ " ms" +"\nMaximum time for creating a .txt: "+max+ " ms" + "\nAverage time for creating a .txt: "+average/10.0f + " ms");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    /**
     * Method to dispay the minimum, maximum and average execution time
     * for creating 10 .pdf files
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public void generatePDF() throws FileNotFoundException, DocumentException {
        long average=0, min=100000, max=0;
        ArrayList<Long> times=new ArrayList<Long>();
        Document document;
        for(int i=0; i < 10; i++) {
            MyTimer.timeIt();
            document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("D:\\AN3\\an3_sem1\\SSC PROIECT\\out" + i + ".pdf "));
            document.open();
            StringBuilder sb = new StringBuilder();
            sb.append("The Technical University of Cluj-Napoca, an “Advanced Research and Education University” as awarded with the Order of the Ministry of National Education no 5262/September 5th 2011, is today a tertiary educational institution having both tradition and national and international recognition.\n" +
                    "\n" +
                    "The Technical University of Cluj-Napoca comprises twelve faculties in the two academic centres, Cluj-Napoca and Baia Mare, as well as in locations, such as Alba-Iulia, Bistrita, Satu Mare and Zalau. The educational offer, aligned to the Bologna system, includes bachelor's, master's and doctoral programs, as well as continuous training programs.\n" +
                    "\n" +
                    "The fields of study have a wide range, from engineering to architecture, fundamental sciences, socio-human sciences and arts. Also, within the Technical University, the Department for Continuing Education, Distance Learning and with Reduced Frequency organizes and conducts continuous education activities and programs, postgraduate courses, continuous professional development programs or courses or based on occupational standards.\n" +
                    "\n" +
                    "The Technical University of Cluj-Napoca is concerned with the international exchange of scientific values, and this trend is found in the over 400 inter-university collaboration agreements or in the large number of student mobilities. Opening up towards the European and world space of education and research through a steady process of internationalization is one of the major objectives of the university.\n" +
                    "\n" +
                    "Research is, along with education, the main priority of the Technical University of Cluj-Napoca. In all faculties of the university there are research structures, from collectives, groups and laboratories, to research centers and platforms.  The performance anchored in the  socio-economic environment, the international visibility and cooperation as well as the scientific novelty and interdisciplinarity are some of the characteristics of the research environment of the Technical University of Cluj-Napoca.\n" +
                    "\n" +
                    "Open research directions are oriented towards global priorities and perspectives: from the Information and communications technology to Renewable Energy and Ecology; from superconductivity, spintronics and nanomaterials, to management and robotics; from mechatronics and electrical engineering, to the automobile and the home of the future, or to urbanism and society.");
            Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.DARK_GRAY);
            Chunk chunk = new Chunk(sb.toString(), font);
            document.add(new Paragraph(chunk));
            times.add(MyTimer.timeUp());
            document.close();
        }

        for(long item:times){
            average += item;
            if(item < min){
                min = item;
            }
            if(item > max){
                max = item;
            }
        }
        System.out.println("Minimum time for creating a .pdf: "+min+ " ms" + "\nMaximum time for creating a .pdf: "+max+ " ms" + "\nAverage time for creating a .pdf: "+average/10.0f + " ms");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    /**
     * Method to dispay the minimum, maximum and average execution time
     * for reading for 10 times from a .csv file
     * @throws IOException
     */
    public void readFromCSV() throws IOException {
        long average=0, min=100000, max=0;
        ArrayList<Long> times=new ArrayList<Long>();
        for(int i=0; i < 10; i++) {
            MyTimer.timeIt();
            ProductCSV products = new ProductCSV();
            products.readCsvFile();
            times.add(MyTimer.timeUp());
        }
        for(long item:times){
            average += item;
            if(item < min){
                min = item;
            }
            if(item > max){
                max = item;
            }
        }
        System.out.println("Minimum time for reading from a .csv file: "+min+ " ms"+"\nMaximum time for reading from a .csv file: "+max+ " ms" + "\nAverage time for reading from a .csv file: "+average/10.0f + " ms");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

}
