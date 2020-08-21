package bai_tap;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        FileWriter source = new FileWriter("SourceFile.txt");
        source.write("This is a source file!");
        source.close();

        File inFile = new File("SourceFile.txt");
        FileReader fileReader = new FileReader(inFile);
        BufferedReader reader = new BufferedReader(fileReader);

        FileWriter target = new FileWriter("TargetFile.txt");

        String line;
        while ((line = reader.readLine()) != null) {
            target.write(line);
        }

        reader.close();
        target.close();
    }
}
