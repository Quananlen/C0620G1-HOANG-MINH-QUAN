package bai_tap;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyBinaryFile {
    public static void main(String[] args) throws IOException {
        File sourceBT = new File("sourceBT.txt");
        File destBT = new File("destBT.txt");

        copyBinaryFile(sourceBT, destBT);

        Path sourcePath = Paths.get("sourceBT.txt");
        countBytes(sourcePath);
    }

    public static void copyBinaryFile(File source, File dest) throws IOException {
        FileInputStream is = new FileInputStream(source);
        FileOutputStream os = new FileOutputStream(dest);
        // 1st
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        // 2nd
        Path sourcePath = Paths.get(source.getPath());
        byte[] data = Files.readAllBytes(sourcePath);
        for (byte item : data) {
            os.write(item);
        }
    }
    public static void countBytes(Path source) throws IOException {
        byte[] data = Files.readAllBytes(source);
        for (byte item : data) {
            System.out.println(item);
        }
    }
}
