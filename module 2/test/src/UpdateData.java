import java.util.List;

public class UpdateData {
    public static List<Villa> update() throws Exception {
        return updateVillaFile();
    }

    public static List<Villa> updateVillaFile() {
        String villaPath = "src/Villa.csv";
        commons.FileUtils1<List<Villa>> fileUtils = new commons.FileUtils1<>();
        return fileUtils.readFileCSV(villaPath);
    }
}
