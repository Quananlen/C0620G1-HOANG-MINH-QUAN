import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void handleRequest() throws IOException, ClassNotFoundException {
        Request request = makeRequest();
        String action = request.getAction();
        String keyword = request.keyword;

        switch (action) {
            case "lookup":
                System.out.println(Service.getInstance().lookup(keyword));
                handleRequest();
                break;
            case "define":
                Service.getInstance().define(request.getParams(), request.getKeyword());
                handleRequest();
                break;
            case "drop":
                System.out.println(Service.getInstance().drop(keyword));
                handleRequest();
                break;
            case "export":
                System.out.println(Service.getInstance().export(keyword));
                break;
        }
    }

    public static Request makeRequest() {
        final String ACTION = "^(lookup|define|drop|export)$";
        final String DEFINE = "^(--adj|-a|--noun|-n|--verb|-v|--syn|-s)$";
        Scanner scanner = new Scanner(System.in);
        String action;
        String[] arr;
        do {
            System.out.print("Action: ");
            action = scanner.nextLine();
            arr = action.split(" ");
        } while (!arr[0].matches(ACTION));
        if (arr[0].equals("define")) {
            if (arr[1].matches(DEFINE)) return new Request(arr[0], arr[1], arr[2]);
            else return makeRequest();
        }
        return new Request(arr[0],arr[1]);
    }
}
