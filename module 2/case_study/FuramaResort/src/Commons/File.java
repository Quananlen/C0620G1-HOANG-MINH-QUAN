package Commons;

import java.io.*;
import java.util.ArrayList;

public class File {
    public static void writeCSV(String[] array, String csv) throws IOException {
        try (FileWriter writer = new FileWriter(csv, true)) {
            for (int i = 0; i < array.length; i++) {
                writer.append(array[i]);
                if (i != array.length - 1) writer.append(SourcePath.COMMA);
                else writer.append(SourcePath.LINE_BREAKER);
            }
        }
    }

    public static ArrayList readArray(String source) throws IOException, ClassNotFoundException {
        java.io.File file = new java.io.File(source);
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream;
        if (file.length() != 0) {
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList) objectInputStream.readObject();
        }
        return null;
    }

    public static void writeArray(ArrayList arr, String dest) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(dest);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(arr);
        }
    }
}
