package model;

import com.opencsv.CSVReader;

import java.io.*;

public class ProductCSV {
    public String title;
    public float rating;
    public Integer calories;
    public Integer protein;
    public Integer fat;
    public Integer sodium;
    public Integer price;

    public ProductCSV(String title, float rating, Integer calories, Integer protein, Integer fat, Integer sodium, Integer price) {
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public ProductCSV() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getSodium() {
        return sodium;
    }

    public void setSodium(Integer sodium) {
        this.sodium = sodium;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * Method to read from a .csv file
     * @throws IOException
     */
    public void readCsvFile() throws IOException {
        //Instantiating the CSVReader class
        CSVReader reader = new CSVReader(new FileReader("D:\\AN3\\an3_sem1\\SSC PROIECT\\products.csv"));
        //Reading the contents of the csv file
        StringBuffer buffer = new StringBuffer();
        String line[];
        while ((line = reader.readNext()) != null) {
            for(int i = 0; i<line.length; i++) {
                System.out.print(line[i]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "ProductCSV{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }
}
