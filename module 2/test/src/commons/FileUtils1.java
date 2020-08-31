package commons;

import java.io.*;

public class FileUtils1<E> {
    public E readFileCSV(String sourceFile){
        E result = null;
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            result = (E) objectInputStream.readObject();
//            System.out.println("Read file successfully");
        } catch (FileNotFoundException e) {
            FileOutputStream newFile = new FileOutputStream(sourceFile);
//            System.err.println("New file was created");
        } catch (EOFException e) {
//            System.err.println("File is empty");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public void writeFileCVS(String destFile, E object) throws FileNotFoundException, IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(destFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        } finally {
//            System.out.println("Write file successfully");
        }
    }

}