import com.opencsv.CSVWriter;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Service {

    private static final Service instance = new Service();

    private Service() {
    }

    public static Service getInstance() {
        return instance;
    }

    public String define(String type, String word) throws IOException, ClassNotFoundException {
        if (lookup(word).equals("not exist")) {
            System.out.println("@" + word + " is not existed in database, created new one!");
            EntitiesFactory factory = new EntitiesFactory();
            IEntities entities = factory.createEntities(type, word);
            TreeMap<String, IEntities> list = readTXT();
            list.put(entities.getWord(), entities);
            writeTXT(list);
            return "Saved!";
        } else {
            return "@" + word + " is already existed, cant define!";
        }
    }

    public String lookup(String word) throws IOException, ClassNotFoundException {
        TreeMap<String, IEntities> list = readTXT();
        if (list.get(word) != null) {
            return list.get(word).display();
        }
        return "not exist";
    }

    public void writeTXT(TreeMap<String, IEntities> list) throws IOException {
        File file = new File("Dictionary.txt");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream writer = new ObjectOutputStream(fos);
        writer.writeObject(list);
    }

    public String export(String path) throws IOException, ClassNotFoundException {
        TreeMap<String, IEntities> list = readTXT();
        //remove key with null value
        list.values().removeIf(Objects::isNull);
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        CSVWriter writer = new CSVWriter(fileWriter);
        for (Map.Entry<String, IEntities> entry : list.entrySet()) {
            String[] array = {entry.getValue().display()};
            writer.writeNext(array);
        }
        writer.close();
        return "Exporting 10%..20%..30%..40%..50%..60%..70%..80%..90%..Done!";
    }

    public TreeMap<String, IEntities> readTXT() throws IOException, ClassNotFoundException {
        File file = new File("Dictionary.txt");
        if (file.length() != 0) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream reader = new ObjectInputStream(fis);
            return (TreeMap<String, IEntities>) reader.readObject();
        } else new FileOutputStream(file);
        return new TreeMap<>();
    }

    public String drop(String word) throws IOException, ClassNotFoundException {
        TreeMap<String, IEntities> list = getInstance().readTXT();
        if (list.get(word) != null) {
            list.put(word, null);
            getInstance().writeTXT(list);
            return "@" + word + " dropped!";
        }
        return "@" + word + "not exist, cant drop";
    }
}
