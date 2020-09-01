import com.opencsv.CSVWriter;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String[]> list = new ArrayList<>();
        Fox fox1 = new Fox(1, "AAA");
        Fox fox2 = new Fox(2, "BBB");

        list.add(fox1.toString().split(","));
        list.add(fox2.toString().split(","));

        FileWriter fileWriter = new FileWriter("fox.csv");
        CSVWriter csvWriter = new CSVWriter(fileWriter);
        csvWriter.writeAll(list);

        csvWriter.close();

        TreeMap<Integer, Fox> map = new TreeMap<>();
        map.put(1, fox1);
        map.put(2, fox2);
        System.out.println(map.get(3));
        FileOutputStream file = new FileOutputStream("Fox.txt");
        ObjectOutputStream writer = new ObjectOutputStream(file);
        writer.writeObject(map);
    }
}
