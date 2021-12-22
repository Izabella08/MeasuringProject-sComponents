package model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import measurements.MyTimer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class GeneratePDF {

    public Document document;

    /**
     * Method to generate a .pdf file
     * @throws DocumentException
     * @throws FileNotFoundException
     */
    public void generatePDF() throws DocumentException, FileNotFoundException {
        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("D:\\AN3\\an3_sem1\\SSC PROIECT\\writeOut.pdf "));
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
        document.close();
    }

}
