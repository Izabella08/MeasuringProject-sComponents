package model;

import java.io.*;

public class GenerateTXT {

    /**
     * Method to generate a .txt file
     */
    public void generateTXT(){
        File file = new File("writeOut.txt");
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
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
    }
}
