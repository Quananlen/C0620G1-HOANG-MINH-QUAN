package bai_tap;

import java.io.*;
import java.util.*;

public class ReadFileCSV {
    public static void main(String[] args) {
        File csvNations = new File("csvNations.csv");
        try {
            readAndDisplay(csvNations);
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            System.err.println("No country to display");
        }

    }

    public static void readAndDisplay(File csvFile) throws IOException {
        List<String> nationList = new ArrayList<>();
        FileReader fileReader = new FileReader(csvFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] arrToken = line.split(",");
            nationList.add(arrToken[arrToken.length - 1]);
        }
        System.out.println(nationList);
        bufferedReader.close();
        fileReader.close();
    }
}
