package edu.escuelaing.arep.app.calculator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

import edu.escuelaing.arep.app.resources.*;

/**
 * Class that solves the mean and standard deviation.
 * @author Maria Hernandez
 */
public class App {

    /**
     * Method that reads the file with the data
     * @param args
     */
    public static void main ( String[] args ) {
        try {
            String dataFrame;
            LinkedList data;

            BufferedReader scanner = new BufferedReader(new FileReader("data.txt"));
            double number;

            while ((dataFrame = scanner.readLine()) != null) {
                String[] list = dataFrame.split(" ");
                data = new LinkedList();
                for (String elemento: list) {
                    number = Double.parseDouble(elemento);
                    data.insertTail(number);
                }
                printAnswer (data);
            }
            scanner.close();
        }catch (Exception  e){
            System.out.println("Archivo no encontrado");
        }
    }

    /**
     * Method that prints the Mean and Standard deviation of the data's calculate
     * @param data
     */
    public static void printAnswer (LinkedList data){
        Calculator results = new Calculator();
        double mean = results.mean(data);
        double std = results.standardDev(data);
        System.out.println("Mean: " + mean + " Std. Dev: "+ std);
    }
}