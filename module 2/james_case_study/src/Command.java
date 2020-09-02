import java.io.IOException;

public interface Command {
    String doService(String keyword, String params) throws IOException, ClassNotFoundException;
}
