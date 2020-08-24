package bai_tap;

import java.io.*;

public class CopyBinaryFile {
    public static void main(String[] args) throws IOException {
        File sourceBT = new File("sourceBT.txt");
        File destBT = new File("destBT.txt");

        copyBinaryFile(sourceBT, destBT);
    }

    public static void copyBinaryFile(File source, File dest) throws IOException {
        FileInputStream is = new FileInputStream(source);
        FileOutputStream os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    }
}
