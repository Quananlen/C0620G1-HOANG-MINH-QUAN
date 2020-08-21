package bai_tap;

import java.io.*;

public class CopyFileText {
    public static void main(String[] args) throws IOException {
        FileWriter source = new FileWriter("SourceFile.txt");
        source.write("This is a source file!");
        source.write("This is another line.");
        source.close();

        File inFile = new File("SourceFile.txt");
        FileReader fileReader = new FileReader(inFile);
        BufferedReader reader = new BufferedReader(fileReader);

        FileWriter target = new FileWriter("TargetFile.txt");

        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            target.write(line);
            count += line.length();
        }
        System.out.println("Character amount: " + count);

        reader.close();
        target.close();
    }
}
