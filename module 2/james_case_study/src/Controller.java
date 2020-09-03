import java.io.IOException;
import java.util.Scanner;

public class Controller {

    public static void handleRequest2() throws IOException, ClassNotFoundException {
        Request request = makeRequest();
        String action = request.getAction();
        String params = request.getParams();
        String keyword = request.getKeyword();
        MakeAction makeAction = new MakeAction();
        String result = makeAction.action(action, params, keyword);
        System.out.println(result);
        handleRequest2();
    }

    public static void handleRequest() throws IOException, ClassNotFoundException {
        Request request = makeRequest();
        String action = request.getAction();
        String keyword = request.getKeyword();

        switch (action) {
            case "lookup":
                System.out.println(Service.getInstance().lookup(keyword));
                break;
            case "define":
                System.out.println(Service.getInstance().define(request.getParams(), request.getKeyword()));
                break;
            case "drop":
                System.out.println(Service.getInstance().drop(keyword));
                break;
            case "export":
                System.out.println(Service.getInstance().export(keyword));
                break;
        }

        handleRequest();
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
            if (arr[0].matches(ACTION)) break;
            else System.out.println("Invalid Action!");
        } while (true);

        if (arr[0].equals("define")) {
            if (arr[1].matches(DEFINE)) return new Request(arr[0], arr[1], arr[2]);
            else {
                System.out.println("Invalid word class!");
                return makeRequest();
            }
        }
        return new Request(arr[0],arr[1]);
    }
}
