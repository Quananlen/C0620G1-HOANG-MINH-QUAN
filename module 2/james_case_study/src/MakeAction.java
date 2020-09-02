import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MakeAction {
    static Map<String, Command> listCommand = new LinkedHashMap<>();

    static {
        listCommand.put("lookup", new Command() {
            @Override
            public String doService(String params, String keyword) throws IOException, ClassNotFoundException {
                return Service.getInstance().lookup(keyword);
            }
        });
        listCommand.put("define", new Command() {
            @Override
            public String doService(String params, String keyword) throws IOException, ClassNotFoundException {
                return Service.getInstance().define(params, keyword);
            }
        });
        listCommand.put("drop", new Command() {
            @Override
            public String doService(String params, String keyword) throws IOException, ClassNotFoundException {
                return Service.getInstance().drop(keyword);
            }
        });
        listCommand.put("export", new Command() {
            @Override
            public String doService(String params, String keyword) throws IOException, ClassNotFoundException {
                return Service.getInstance().export(keyword);
            }
        });
    }

    public String action(String action, String params, String keyword) throws IOException, ClassNotFoundException {
        Command command = listCommand.get(action);
        return command.doService(params, keyword);
    }
}
